package org.sohagroup.bsi.smsservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ArrayOfStringDTO {

    @JsonProperty("string")
    private List<String> string;

    public List<String> getString() {
        return string;
    }

    public void setString(List<String> string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayOfStringDTO that = (ArrayOfStringDTO) o;
        return string.equals(that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public String toString() {
        return "ArrayOfStringDTO{" +
            "string=" + string +
            '}';
    }
}
