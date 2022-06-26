package org.sohagroup.bsi.smsservice.service;

import org.sohagroup.bsi.smsservice.service.dto.ArrayOfStringDTO;
import org.sohagroup.bsi.smsservice.service.dto.SendSMSSingleDTO;

public interface SmsService {
    ArrayOfStringDTO sendSmsSingle(SendSMSSingleDTO sendSMSSingleDTO);
}
