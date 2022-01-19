package org.sohagroup.bsi.smsservice.service.mapper;

import org.mapstruct.Mapper;
import org.sohagroup.bsi.smsservice.service.dto.SendSMSSingleDTO;
import org.sohagroup.bsi.smsservice.tempuri.SendSMSSingle;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface SendSMSSingleMapper extends XmlMapper<SendSMSSingleDTO, SendSMSSingle> {
    @Override
    SendSMSSingle toXml(SendSMSSingleDTO dto);

    @Override
    SendSMSSingleDTO toDto(SendSMSSingle xml);

    @Override
    List<SendSMSSingle> toXml(List<SendSMSSingleDTO> dtoList);

    @Override
    List<SendSMSSingleDTO> toDto(List<SendSMSSingle> xmlList);
}
