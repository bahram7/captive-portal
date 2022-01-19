package org.sohagroup.bsi.smsservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArrayOfStringDTO {

    @JsonProperty("string")
    private List<String> string;

    public List<String> getString() {
        return string;
    }

    public void setString(List<String> string) {
        this.string = string;
    }
}
