package org.sohagroup.bsi.smsservice.service.mapper;

import org.mapstruct.Mapper;
import org.sohagroup.bsi.smsservice.service.dto.ArrayOfStringDTO;
import org.sohagroup.bsi.smsservice.tempuri.ArrayOfString;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ArrayOfStringMapper extends XmlMapper<ArrayOfStringDTO, ArrayOfString> {
    @Override
    ArrayOfString toXml(ArrayOfStringDTO dto);

    @Override
    ArrayOfStringDTO toDto(ArrayOfString xml);

    @Override
    List<ArrayOfString> toXml(List<ArrayOfStringDTO> dtoList);

    @Override
    List<ArrayOfStringDTO> toDto(List<ArrayOfString> xmlList);
}
