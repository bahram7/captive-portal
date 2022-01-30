package org.sohagroup.bsi.smsservice.aop.logging;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.ext.logging.AbstractLoggingInterceptor;
import org.apache.cxf.ext.logging.WireTapIn;
import org.apache.cxf.ext.logging.event.LogEvent;
import org.apache.cxf.ext.logging.event.LogEventSender;
import org.apache.cxf.ext.logging.event.PrintWriterEventSender;
import org.apache.cxf.ext.logging.slf4j.Slf4jVerboseEventSender;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedWriter;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

import static org.sohagroup.bsi.smsservice.config.Constants.UUID_IDENTIFIER;

/**
 * @author iman
 * @package org.sohagroup.bsi.smsservice.aop.logging
 * @project sms-service
 * @date 1/29/22
 * @time 5:49 PM
 * @since 1.0
 */
public class CxfLogInInterceptor extends AbstractLoggingInterceptor {

    class LoggingInFaultInterceptor extends AbstractPhaseInterceptor<Message> {

        LoggingInFaultInterceptor() {
            super(Phase.RECEIVE);
        }

        @Override
        public void handleMessage(Message message) throws Fault {
        }

        @Override
        public void handleFault(Message message) throws Fault {
            this.handleMessage(message);
        }
    }

    public CxfLogInInterceptor() {
        this(new Slf4jVerboseEventSender());
    }

    public CxfLogInInterceptor(PrintWriter writer) {
        this(new PrintWriterEventSender(writer));
    }

    public CxfLogInInterceptor(LogEventSender sender) {
        super(Phase.PRE_INVOKE, sender);
    }

    public Collection<PhaseInterceptor<? extends Message>> getAdditionalInterceptors() {
        Collection<PhaseInterceptor<? extends Message>> ret = new ArrayList<>();
        ret.add(new WireTapIn(getWireTapLimit(), threshold));
        ret.add(new LoggingInFaultInterceptor());
        return ret;
    }

    public void handleMessage(Message message) throws Fault {
        if (isLoggingDisabledNow(message)) {
            return;
        }
        createExchangeId(message);
        final LogEvent event = eventMapper.map(message);
        if (shouldLogContent(event)) {
            addContent(message, event);
        } else {
            event.setPayload(AbstractLoggingInterceptor.CONTENT_SUPPRESSED);
        }
        sender.send(event);
    }

    private void addContent(Message message, final LogEvent event) {
        try {
            CachedOutputStream cos = message.getContent(CachedOutputStream.class);
            if (cos != null) {
                handleOutputStream(event, message, cos);
            } else {
                CachedWriter writer = message.getContent(CachedWriter.class);
                if (writer != null) {
                    handleWriter(event, writer);
                }
            }
        } catch (IOException e) {
            throw new Fault(e);
        }
    }

    private void handleOutputStream(final LogEvent event, Message message, CachedOutputStream cos) throws IOException {
        String encoding = (String) message.get(Message.ENCODING);
        if (StringUtils.isEmpty(encoding)) {
            encoding = StandardCharsets.UTF_8.name();
        }
        StringBuilder payload = new StringBuilder();
        cos.writeCacheTo(payload, encoding, limit);
        cos.close();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uuid = request.getHeader(UUID_IDENTIFIER);
        StringBuilder payloadwithUUID = new StringBuilder().append(payload.toString()).append("\nuuid: ").append(uuid);
        event.setPayload(payloadwithUUID.toString());
        boolean isTruncated = cos.size() > limit && limit != -1;
        event.setTruncated(isTruncated);
        event.setFullContentFile(cos.getTempFile());
    }

    private void handleWriter(final LogEvent event, CachedWriter writer) throws IOException {
        boolean isTruncated = writer.size() > limit && limit != -1;
        StringBuilder payload = new StringBuilder();
        writer.writeCacheTo(payload, limit);
        event.setPayload(payload.toString());
        event.setTruncated(isTruncated);
        event.setFullContentFile(writer.getTempFile());
    }

    int getWireTapLimit() {
        if (limit == -1) {
            return -1;
        } else if (limit == Integer.MAX_VALUE) {
            return limit;
        } else {
            // add limit +1 as limit for the wiretab in order to read one byte more, so that truncated
            // is correctly calculated in LogginInIntecepteor!
            // See code line :  boolean isTruncated = cos.size() > limit && limit != -1;
            // cos is here the outputstream read by the wiretab which will return for cos.size() the
            // limit in the truncated case!
            return limit + 1;
        }
    }
}
