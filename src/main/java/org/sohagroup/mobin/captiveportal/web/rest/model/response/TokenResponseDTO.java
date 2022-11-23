package org.sohagroup.mobin.captiveportal.web.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class TokenResponseDTO {

    @JsonProperty
    private String refresh;

    @JsonProperty
    private String access;

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public TokenResponseDTO() {}

    public TokenResponseDTO(String refresh, String access) {
        this.refresh = refresh;
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenResponseDTO that = (TokenResponseDTO) o;
        return Objects.equals(refresh, that.refresh) && Objects.equals(access, that.access);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refresh, access);
    }

    @Override
    public String toString() {
        return "CaptivePortalTokenResponseDTO{" + "refresh='" + refresh + '\'' + ", access='" + access + '\'' + '}';
    }
}
