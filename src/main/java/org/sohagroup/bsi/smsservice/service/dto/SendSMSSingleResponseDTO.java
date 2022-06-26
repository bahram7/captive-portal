package org.sohagroup.bsi.smsservice.service.dto;

import java.util.Objects;

public class SendSMSSingleResponseDTO {
    private Integer statusCode;
    private String message;
    private ArrayOfStringDTO result;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayOfStringDTO getResult() {
        return result;
    }

    public void setResult(ArrayOfStringDTO result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendSMSSingleResponseDTO that = (SendSMSSingleResponseDTO) o;
        return statusCode.equals(that.statusCode) && message.equals(that.message) && result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, message, result);
    }

    @Override
    public String toString() {
        return "SendSMSSingleResponseDTO{" +
            "statusCode=" + statusCode +
            ", message='" + message + '\'' +
            ", result=" + result +
            '}';
    }
}
