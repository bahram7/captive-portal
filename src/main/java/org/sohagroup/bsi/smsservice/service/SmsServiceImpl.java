package org.sohagroup.bsi.smsservice.service;

import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohagroup.bsi.smsservice.aop.logging.CxfLogOutInterceptor;
import org.sohagroup.bsi.smsservice.service.dto.ArrayOfStringDTO;
import org.sohagroup.bsi.smsservice.service.dto.SendSMSSingleDTO;
import org.sohagroup.bsi.smsservice.service.mapper.ArrayOfStringMapper;
import org.sohagroup.bsi.smsservice.tempuri.ArrayOfString;
import org.sohagroup.bsi.smsservice.tempuri.BSaderatSendServiceSoap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    private final Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Value("${smsService.config.wsdlAddress}")
    private String wsdlAddress;
    private BSaderatSendServiceSoap bSaderatSendServiceSoap;

    private final ArrayOfStringMapper arrayOfStringMapper;

    public SmsServiceImpl(ArrayOfStringMapper arrayOfStringMapper) {
        this.arrayOfStringMapper = arrayOfStringMapper;
    }

    @Override
    public ArrayOfStringDTO sendSmsSingle(SendSMSSingleDTO sendSMSSingleDTO) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(BSaderatSendServiceSoap.class);
        factory.setAddress(wsdlAddress);
        bSaderatSendServiceSoap = (BSaderatSendServiceSoap) factory.create();
        ClientProxy.getClient(bSaderatSendServiceSoap).getOutInterceptors().add(new LoggingOutInterceptor());
        ClientProxy.getClient(bSaderatSendServiceSoap).getOutInterceptors().add(new CxfLogOutInterceptor());
        LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
        loggingInInterceptor.setInMemThreshold(Long.MAX_VALUE);
        loggingInInterceptor.setLimit(Integer.MAX_VALUE);
        loggingInInterceptor.setPrettyLogging(true);
        ClientProxy.getClient(bSaderatSendServiceSoap).getInInterceptors().add(loggingInInterceptor);
        log.debug("factory created with wsdl : {}",wsdlAddress);
        ArrayOfString arrayOfString = bSaderatSendServiceSoap.sendSMSSingle(
            sendSMSSingleDTO.getMessage(),
            sendSMSSingleDTO.getDestinationAddress(),
            sendSMSSingleDTO.getNumber(),
            sendSMSSingleDTO.getUserName(),
            sendSMSSingleDTO.getPassword(),
            sendSMSSingleDTO.getIpSend(),
            sendSMSSingleDTO.getCompany(),
            sendSMSSingleDTO.isFlash()
        );
        ArrayOfStringDTO arrayOfStringDTO = arrayOfStringMapper.toDto(arrayOfString);
        log.debug("response from sendSMSSingle service: {}",arrayOfStringDTO);
        return arrayOfStringDTO;
    }
}
