package org.sohagroup.bsi.smsservice.aop.logging;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.ext.logging.AbstractLoggingInterceptor;
import org.apache.cxf.ext.logging.event.LogEvent;
import org.apache.cxf.ext.logging.event.LogEventSender;
import org.apache.cxf.ext.logging.event.PrintWriterEventSender;
import org.apache.cxf.ext.logging.slf4j.Slf4jVerboseEventSender;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

import static org.sohagroup.bsi.smsservice.config.Constants.UUID_IDENTIFIER;

/**
 * @author iman
 * @package org.sohagroup.bsi.smsservice.aop.logging
 * @project sms-service
 * @date 1/29/22
 * @time 5:46 PM
 * @since 1.0
 */
public class CxfLogOutInterceptor extends AbstractLoggingInterceptor {
    private static Logger s_logger = LogManager.getLogger(CxfLogOutInterceptor.class);

    public CxfLogOutInterceptor() {
        this(new Slf4jVerboseEventSender());
    }

    public CxfLogOutInterceptor(PrintWriter writer) {
        this(new PrintWriterEventSender(writer));
    }

    public CxfLogOutInterceptor(LogEventSender sender) {
        super(Phase.PRE_STREAM, sender);
        addBefore(StaxOutInterceptor.class.getName());
    }


    public void handleMessage(Message message) throws Fault {
        if (isLoggingDisabledNow(message)) {
            return;
        }
        createExchangeId(message);
        final OutputStream os = message.getContent(OutputStream.class);
        if (os != null) {
            LoggingCallback callback = new LoggingCallback(sender, message, os, limit);
            message.setContent(OutputStream.class, createCachingOut(message, os, callback));
        } else {
            final Writer iowriter = message.getContent(Writer.class);
            if (iowriter != null) {
                message.setContent(Writer.class, new LogEventSendingWriter(sender, message, iowriter, limit));
            }
        }
    }

    private OutputStream createCachingOut(Message message, final OutputStream os, CachedOutputStreamCallback callback) {
        final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(os);
        if (threshold > 0) {
            newOut.setThreshold(threshold);
        }
        if (limit > 0) {
            // make the limit for the cache greater than the limit for the truncated payload in the log event,
            // this is necessary for finding out that the payload was truncated
            //(see boolean isTruncated = cos.size() > limit && limit != -1;)  in method copyPayload
            newOut.setCacheLimit(getCacheLimit());
        }
        newOut.registerCallback(callback);
        return newOut;
    }

    private int getCacheLimit() {
        if (limit == Integer.MAX_VALUE) {
            return limit;
        }
        return limit + 1;
    }

    private class LogEventSendingWriter extends FilterWriter {

        StringWriter out2;
        int count;
        Message message;
        final int lim;
        private LogEventSender sender;

        LogEventSendingWriter(LogEventSender sender, Message message, Writer writer, int limit) {
            super(writer);
            this.sender = sender;
            this.message = message;
            if (!(writer instanceof StringWriter)) {
                out2 = new StringWriter();
            }
            lim = limit == -1 ? Integer.MAX_VALUE : limit;
        }

        public void write(int c) throws IOException {
            super.write(c);
            if (out2 != null && count < lim) {
                out2.write(c);
            }
            count++;
        }

        public void write(char[] cbuf, int off, int len) throws IOException {
            super.write(cbuf, off, len);
            if (out2 != null && count < lim) {
                out2.write(cbuf, off, len);
            }
            count += len;
        }

        public void write(String str, int off, int len) throws IOException {
            super.write(str, off, len);
            if (out2 != null && count < lim) {
                out2.write(str, off, len);
            }
            count += len;
        }

        public void close() throws IOException {
            final LogEvent event = eventMapper.map(message);
            StringWriter w2 = out2;
            if (w2 == null) {
                w2 = (StringWriter) out;
            }

            String payload = shouldLogContent(event) ? getPayload(event, w2) : CONTENT_SUPPRESSED;
            event.setPayload(payload);
            sender.send(event);
            message.setContent(Writer.class, out);
            super.close();
        }

        private String getPayload(final LogEvent event, StringWriter w2) {
            StringBuilder payload = new StringBuilder();
            writePayload(payload, w2, event);
            return payload.toString();
        }

        private void writePayload(StringBuilder builder, StringWriter stringWriter, LogEvent event) {
            StringBuffer buffer = stringWriter.getBuffer();
            if (buffer.length() > lim) {
                builder.append(buffer.subSequence(0, lim));
                event.setTruncated(true);
            } else {
                builder.append(buffer);
                event.setTruncated(false);
            }
        }
    }

    public class LoggingCallback implements CachedOutputStreamCallback {

        private final Message message;
        private final OutputStream origStream;
        private final int lim;
        private LogEventSender sender;

        public LoggingCallback(final LogEventSender sender, final Message msg, final OutputStream os, int limit) {
            this.sender = sender;
            this.message = msg;
            this.origStream = os;
            this.lim = limit == -1 ? Integer.MAX_VALUE : limit;
        }

        public void onFlush(CachedOutputStream cos) {

        }

        public void onClose(CachedOutputStream cos) {
            final LogEvent event = eventMapper.map(message);
            if (shouldLogContent(event)) {
                copyPayload(cos, event);
            } else {
                event.setPayload(CONTENT_SUPPRESSED);
            }

            sender.send(event);
            try {
                // empty out the cache
                cos.lockOutputStream();
                cos.resetOut(null, false);
            } catch (Exception ex) {
                // ignore
            }
            message.setContent(OutputStream.class, origStream);
        }

        private void copyPayload(CachedOutputStream cos, final LogEvent event) {
            try {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String uuid = request.getHeader(UUID_IDENTIFIER);
                String encoding = (String) message.get(Message.ENCODING);
                StringBuilder payload = new StringBuilder();
                writePayload(payload, cos, encoding, event.getContentType());
                StringBuilder payloadwithUUID = new StringBuilder().append(payload.toString()).append("\nuuid: ").append(uuid);
                event.setPayload(payloadwithUUID.toString());
                boolean isTruncated = cos.size() > limit && limit != -1;
                event.setTruncated(isTruncated);
            } catch (Exception ex) {
                // ignore
            }
        }

        protected void writePayload(StringBuilder builder, CachedOutputStream cos, String encoding, String contentType)
            throws Exception {
            if (StringUtils.isEmpty(encoding)) {
                cos.writeCacheTo(builder, Long.MAX_VALUE);
            } else {
                cos.writeCacheTo(builder, encoding, Long.MAX_VALUE);
            }
        }
    }
}
