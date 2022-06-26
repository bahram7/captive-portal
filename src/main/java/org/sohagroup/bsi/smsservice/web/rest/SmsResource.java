package org.sohagroup.bsi.smsservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sohagroup.bsi.smsservice.service.SmsService;
import org.sohagroup.bsi.smsservice.service.dto.ArrayOfStringDTO;
import org.sohagroup.bsi.smsservice.service.dto.SendSMSSingleDTO;
import org.sohagroup.bsi.smsservice.service.dto.SendSMSSingleResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SmsResource {
    private final Logger log = LoggerFactory.getLogger(SmsResource.class);
    private final SmsService smsService;

    public SmsResource(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/sendSmsSingle")
    public ResponseEntity<SendSMSSingleResponseDTO> sendSmsSingle(@Valid @RequestBody SendSMSSingleDTO sendSMSSingleDTO) {
        log.debug("Rest request to sendSmsSingle , the request body: , {} ",sendSMSSingleDTO);
        SendSMSSingleResponseDTO sendSMSSingleResponseDTO = new SendSMSSingleResponseDTO();
        try {
            ArrayOfStringDTO arrayOfStringDTO = smsService.sendSmsSingle(sendSMSSingleDTO);
            sendSMSSingleResponseDTO.setStatusCode(200);
            sendSMSSingleResponseDTO.setMessage("operation successful");
            sendSMSSingleResponseDTO.setResult(arrayOfStringDTO);
            log.debug("sendSmsSingle was successful : , {} ",sendSMSSingleResponseDTO);
        }
        catch (Exception e)
        {
            sendSMSSingleResponseDTO.setStatusCode(401);
            sendSMSSingleResponseDTO.setMessage("operation failed , " + e.getMessage());
            sendSMSSingleResponseDTO.setResult(null);
            log.error("sendSmsSingle failed : , {} ",sendSMSSingleResponseDTO);
        }
        return ResponseEntity.status(sendSMSSingleResponseDTO.getStatusCode()).body(sendSMSSingleResponseDTO);
    }
}
