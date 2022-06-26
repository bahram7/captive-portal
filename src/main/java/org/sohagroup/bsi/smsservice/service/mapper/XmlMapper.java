package org.sohagroup.bsi.smsservice.service.mapper;

import java.util.List;

public interface XmlMapper<D, X> {
    X toXml(D dto);

    D toDto(X xml);

    List<X> toXml(List<D> dtoList);

    List<D> toDto(List<X> xmlList);
}
