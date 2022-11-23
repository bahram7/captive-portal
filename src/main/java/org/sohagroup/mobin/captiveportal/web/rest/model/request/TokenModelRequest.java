package org.sohagroup.mobin.captiveportal.web.rest.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.ConnectionBuilder;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;

public class TokenModelRequest {

    @JsonProperty("username")
    private String username = "mobin_esb";

    @JsonProperty("password")
    private String password = "G03TryPr5d3X^fk3";

    public TokenModelRequest() {}

    public TokenModelRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenModelRequest that = (TokenModelRequest) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "TokenModelRequest{" + "userName='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
