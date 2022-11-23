package org.sohagroup.mobin.captiveportal.web.rest.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

public class BranchesRequestModel {

    @JsonProperty("name")
    private String name;

    @JsonProperty("crm_id")
    private String crmId;

    @JsonProperty("crm_name")
    private String crmName;

    @JsonProperty("category")
    private Integer category;

    @JsonProperty("extra_data")
    private Map<String, Object> extraData = null;

    @JsonProperty("check_shahkar")
    private Integer checkShahkar;

    @JsonProperty("default_template")
    private Integer defaultTemplate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrmId() {
        return crmId;
    }

    public void setCrmId(String crmId) {
        this.crmId = crmId;
    }

    public String getCrmName() {
        return crmName;
    }

    public void setCrmName(String crmName) {
        this.crmName = crmName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }

    public Integer getCheckShahkar() {
        return checkShahkar;
    }

    public void setCheckShahkar(Integer checkShahkar) {
        this.checkShahkar = checkShahkar;
    }

    public Integer getDefaultTemplate() {
        return defaultTemplate;
    }

    public void setDefaultTemplate(Integer defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    public BranchesRequestModel(
        String name,
        String crmId,
        String crmName,
        Integer category,
        Map<String, Object> extraData,
        Integer checkShahkar,
        Integer defaultTemplate
    ) {
        this.name = name;
        this.crmId = crmId;
        this.crmName = crmName;
        this.category = category;
        this.extraData = extraData;
        this.checkShahkar = checkShahkar;
        this.defaultTemplate = defaultTemplate;
    }

    public BranchesRequestModel() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchesRequestModel that = (BranchesRequestModel) o;
        return (
            Objects.equals(name, that.name) &&
            Objects.equals(crmId, that.crmId) &&
            Objects.equals(crmName, that.crmName) &&
            Objects.equals(category, that.category) &&
            Objects.equals(extraData, that.extraData) &&
            Objects.equals(checkShahkar, that.checkShahkar) &&
            Objects.equals(defaultTemplate, that.defaultTemplate)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crmId, crmName, category, extraData, checkShahkar, defaultTemplate);
    }

    @Override
    public String toString() {
        return (
            "BranchesRequestModel{" +
            "name='" +
            name +
            '\'' +
            ", crmId='" +
            crmId +
            '\'' +
            ", crmName='" +
            crmName +
            '\'' +
            ", category=" +
            category +
            ", extraData=" +
            extraData +
            ", checkShahkar=" +
            checkShahkar +
            ", defaultTemplate=" +
            defaultTemplate +
            '}'
        );
    }
}
