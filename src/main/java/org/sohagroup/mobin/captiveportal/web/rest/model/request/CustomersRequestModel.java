package org.sohagroup.mobin.captiveportal.web.rest.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.cglib.core.Constants;

public class CustomersRequestModel {

    @JsonProperty("name")
    private String name;

    @JsonProperty("crm_id")
    private String crmId;

    @JsonProperty("crm_name")
    private String crmName;

    @JsonProperty("crm_english_name")
    private String crmEnglishName;

    @JsonProperty("extra_data")
    @Valid
    private Map<String, Object> extraData = null;

    /**
     * Customer name
     * @return name
     */
    @NotNull
    @Size(min = 1, max = 200)
    @Schema(name = "name", description = "Customer name", required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Customer CRM ID
     * @return crmId
     */
    @NotNull
    @Size(min = 1, max = 200)
    @Schema(name = "crm_id", description = "Customer CRM ID", required = true)
    public String getCrmId() {
        return crmId;
    }

    public void setCrmId(String crmId) {
        this.crmId = crmId;
    }

    /**
     * Customer CRM Name
     * @return crmName
     */
    @NotNull
    @Size(min = 1, max = 200)
    @Schema(name = "crm_name", description = "Customer CRM Name", required = true)
    public String getCrmName() {
        return crmName;
    }

    public void setCrmName(String crmName) {
        this.crmName = crmName;
    }

    /**
     * Customer CRM English Name
     * @return crmEnglishName
     */
    @NotNull
    @Size(min = 1, max = 200)
    @Schema(name = "crm_english_name", description = "Customer CRM English Name", required = true)
    public String getCrmEnglishName() {
        return crmEnglishName;
    }

    public void setCrmEnglishName(String crmEnglishName) {
        this.crmEnglishName = crmEnglishName;
    }

    public CustomersRequestModel extraData(Map<String, Object> extraData) {
        this.extraData = extraData;
        return this;
    }

    public CustomersRequestModel putExtraDataItem(String key, Object extraDataItem) {
        if (this.extraData == null) {
            this.extraData = new HashMap<>();
        }
        this.extraData.put(key, extraDataItem);
        return this;
    }

    /**
     * Get extraData
     * @return extraData
     */

    @Schema(name = "extra_data", required = false)
    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomersRequestModel customerRequest = (CustomersRequestModel) o;
        return (
            Objects.equals(this.name, customerRequest.name) &&
            Objects.equals(this.crmId, customerRequest.crmId) &&
            Objects.equals(this.crmName, customerRequest.crmName) &&
            Objects.equals(this.crmEnglishName, customerRequest.crmEnglishName) &&
            Objects.equals(this.extraData, customerRequest.extraData)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crmId, crmName, crmEnglishName, extraData);
    }

    @Override
    public String toString() {
        return (
            "CustomersRequestModel{" +
            "name='" +
            name +
            '\'' +
            ", crmId='" +
            crmId +
            '\'' +
            ", crmName='" +
            crmName +
            '\'' +
            ", crmEnglishName='" +
            crmEnglishName +
            '\'' +
            ", extraData=" +
            extraData +
            '}'
        );
    }
}
