package org.sohagroup.bsi.smsservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SendSMSSingleDTO implements Serializable {

    @JsonProperty("message")
    private String message;

    @JsonProperty("destinationAddress")
    private String destinationAddress;

    @JsonProperty("number")
    private String number;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("ipSend")
    private String ipSend;

    @JsonProperty("company")
    private String company;

    @JsonProperty("isFlash")
    private boolean isFlash;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpSend() {
        return ipSend;
    }

    public void setIpSend(String ipSend) {
        this.ipSend = ipSend;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isFlash() {
        return isFlash;
    }

    public void setFlash(boolean flash) {
        isFlash = flash;
    }


}
