package org.sohagroup.bsi.smsservice.service.dto;

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
}
