package org.sohagroup.mobin.captiveportal.web.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;

public class BranchesResponse {

    @JsonProperty("id")
    private Integer id;

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

    @JsonProperty("prefix")
    private String prefix;

    @JsonProperty("branch_start_date")
    private String branchStartDate;

    @JsonProperty("branch_end_date")
    private String branchEndDate;

    @JsonProperty("max_allowed_registration_count")
    private Integer maxAllowedRegistrationCount;

    public BranchesResponse() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getBranchStartDate() {
        return branchStartDate;
    }

    public void setBranchStartDate(String branchStartDate) {
        this.branchStartDate = branchStartDate;
    }

    public String getBranchEndDate() {
        return branchEndDate;
    }

    public void setBranchEndDate(String branchEndDate) {
        this.branchEndDate = branchEndDate;
    }

    public Integer getMaxAllowedRegistrationCount() {
        return maxAllowedRegistrationCount;
    }

    public void setMaxAllowedRegistrationCount(Integer maxAllowedRegistrationCount) {
        this.maxAllowedRegistrationCount = maxAllowedRegistrationCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchesResponse that = (BranchesResponse) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(crmId, that.crmId) &&
            Objects.equals(crmName, that.crmName) &&
            Objects.equals(category, that.category) &&
            Objects.equals(extraData, that.extraData) &&
            Objects.equals(checkShahkar, that.checkShahkar) &&
            Objects.equals(defaultTemplate, that.defaultTemplate) &&
            Objects.equals(prefix, that.prefix) &&
            Objects.equals(branchStartDate, that.branchStartDate) &&
            Objects.equals(branchEndDate, that.branchEndDate) &&
            Objects.equals(maxAllowedRegistrationCount, that.maxAllowedRegistrationCount)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            name,
            crmId,
            crmName,
            category,
            extraData,
            checkShahkar,
            defaultTemplate,
            prefix,
            branchStartDate,
            branchEndDate,
            maxAllowedRegistrationCount
        );
    }

    @Override
    public String toString() {
        return (
            "BranchesResponse{" +
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
            ", category=" +
            category +
            ", extraData=" +
            extraData +
            ", checkShahkar=" +
            checkShahkar +
            ", defaultTemplate=" +
            defaultTemplate +
            ", prefix='" +
            prefix +
            '\'' +
            ", branchStartDate='" +
            branchStartDate +
            '\'' +
            ", branchEndDate='" +
            branchEndDate +
            '\'' +
            ", maxAllowedRegistrationCount=" +
            maxAllowedRegistrationCount +
            '}'
        );
    }
}
