package org.sohagroup.mobin.captiveportal.web.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.cglib.core.Constants;

public class CustomersResponse {

    @JsonProperty("id")
    private Integer id;

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

    public CustomersResponse id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */
    @NotNull
    @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, required = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomersResponse name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Customer name
     * @return name
     */
    @NotNull
    @Size(max = 200)
    @Schema(name = "name", description = "Customer name", required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomersResponse crmId(String crmId) {
        this.crmId = crmId;
        return this;
    }

    /**
     * Customer CRM ID
     * @return crmId
     */
    @NotNull
    @Size(max = 200)
    @Schema(name = "crm_id", description = "Customer CRM ID", required = true)
    public String getCrmId() {
        return crmId;
    }

    public void setCrmId(String crmId) {
        this.crmId = crmId;
    }

    public CustomersResponse crmName(String crmName) {
        this.crmName = crmName;
        return this;
    }

    /**
     * Customer CRM Name
     * @return crmName
     */
    @NotNull
    @Size(max = 200)
    @Schema(name = "crm_name", description = "Customer CRM Name", required = true)
    public String getCrmName() {
        return crmName;
    }

    public void setCrmName(String crmName) {
        this.crmName = crmName;
    }

    public CustomersResponse crmEnglishName(String crmEnglishName) {
        this.crmEnglishName = crmEnglishName;
        return this;
    }

    /**
     * Customer CRM English Name
     * @return crmEnglishName
     */
    @NotNull
    @Size(max = 200)
    @Schema(name = "crm_english_name", description = "Customer CRM English Name", required = true)
    public String getCrmEnglishName() {
        return crmEnglishName;
    }

    public void setCrmEnglishName(String crmEnglishName) {
        this.crmEnglishName = crmEnglishName;
    }

    public CustomersResponse extraData(Map<String, Object> extraData) {
        this.extraData = extraData;
        return this;
    }

    public CustomersResponse putExtraDataItem(String key, Object extraDataItem) {
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
        CustomersResponse customer = (CustomersResponse) o;
        return (
            Objects.equals(this.id, customer.id) &&
            Objects.equals(this.name, customer.name) &&
            Objects.equals(this.crmId, customer.crmId) &&
            Objects.equals(this.crmName, customer.crmName) &&
            Objects.equals(this.crmEnglishName, customer.crmEnglishName) &&
            Objects.equals(this.extraData, customer.extraData)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, crmId, crmName, crmEnglishName, extraData);
    }

    @Override
    public String toString() {
        return (
            "CustomersResponse{" +
            "id=" +
            id +
            ", name='" +
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
