package org.sohagroup.mobin.captiveportal.web.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

public class CategoriesResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("created")
    private String created;

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("name")
    private String name;

    @JsonProperty("crm_id")
    private String crmId;

    @JsonProperty("crm_name")
    private String crmName;

    @JsonProperty("extra_data")
    private Map<String, Object> extraData = null;

    @JsonProperty("has_confirm")
    private Integer hasConfirm;

    @JsonProperty("check_shahkar")
    private Integer checkShahkar;

    @JsonProperty("registration_method")
    private Integer registrationMethod;

    @JsonProperty("force_default_template")
    private Boolean forceDefaultTemplate;

    @JsonProperty("force_packages")
    private Boolean forcePackages;

    @JsonProperty("prefix")
    private Boolean prefix;

    @JsonProperty("force_prefix")
    private Boolean forcePrefix;

    @JsonProperty("branch_start_date")
    private String branchStartDate;

    @JsonProperty("branch_end_date")
    private String branchEndDate;

    @JsonProperty("max_allowed_registration_count")
    private Integer maxAllowedRegistrationCount;

    @JsonProperty("force_branch_period")
    private Boolean forceBranchPeriod;

    @JsonProperty("customer")
    private Integer customer;

    @JsonProperty("default_template")
    private String defaultTemplate;

    public CategoriesResponse() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
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

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }

    public Integer getHasConfirm() {
        return hasConfirm;
    }

    public void setHasConfirm(Integer hasConfirm) {
        this.hasConfirm = hasConfirm;
    }

    public Integer getCheckShahkar() {
        return checkShahkar;
    }

    public void setCheckShahkar(Integer checkShahkar) {
        this.checkShahkar = checkShahkar;
    }

    public Integer getRegistrationMethod() {
        return registrationMethod;
    }

    public void setRegistrationMethod(Integer registrationMethod) {
        this.registrationMethod = registrationMethod;
    }

    public Boolean getForceDefaultTemplate() {
        return forceDefaultTemplate;
    }

    public void setForceDefaultTemplate(Boolean forceDefaultTemplate) {
        this.forceDefaultTemplate = forceDefaultTemplate;
    }

    public Boolean getForcePackages() {
        return forcePackages;
    }

    public void setForcePackages(Boolean forcePackages) {
        this.forcePackages = forcePackages;
    }

    public Boolean getPrefix() {
        return prefix;
    }

    public void setPrefix(Boolean prefix) {
        this.prefix = prefix;
    }

    public Boolean getForcePrefix() {
        return forcePrefix;
    }

    public void setForcePrefix(Boolean forcePrefix) {
        this.forcePrefix = forcePrefix;
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

    public Boolean getForceBranchPeriod() {
        return forceBranchPeriod;
    }

    public void setForceBranchPeriod(Boolean forceBranchPeriod) {
        this.forceBranchPeriod = forceBranchPeriod;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public String getDefaultTemplate() {
        return defaultTemplate;
    }

    public void setDefaultTemplate(String defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesResponse that = (CategoriesResponse) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(created, that.created) &&
            Objects.equals(updated, that.updated) &&
            Objects.equals(name, that.name) &&
            Objects.equals(crmId, that.crmId) &&
            Objects.equals(crmName, that.crmName) &&
            Objects.equals(extraData, that.extraData) &&
            Objects.equals(hasConfirm, that.hasConfirm) &&
            Objects.equals(checkShahkar, that.checkShahkar) &&
            Objects.equals(registrationMethod, that.registrationMethod) &&
            Objects.equals(forceDefaultTemplate, that.forceDefaultTemplate) &&
            Objects.equals(forcePackages, that.forcePackages) &&
            Objects.equals(prefix, that.prefix) &&
            Objects.equals(forcePrefix, that.forcePrefix) &&
            Objects.equals(branchStartDate, that.branchStartDate) &&
            Objects.equals(branchEndDate, that.branchEndDate) &&
            Objects.equals(maxAllowedRegistrationCount, that.maxAllowedRegistrationCount) &&
            Objects.equals(forceBranchPeriod, that.forceBranchPeriod) &&
            Objects.equals(customer, that.customer) &&
            Objects.equals(defaultTemplate, that.defaultTemplate)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            created,
            updated,
            name,
            crmId,
            crmName,
            extraData,
            hasConfirm,
            checkShahkar,
            registrationMethod,
            forceDefaultTemplate,
            forcePackages,
            prefix,
            forcePrefix,
            branchStartDate,
            branchEndDate,
            maxAllowedRegistrationCount,
            forceBranchPeriod,
            customer,
            defaultTemplate
        );
    }

    @Override
    public String toString() {
        return (
            "CategoriesResponse{" +
            "id=" +
            id +
            ", created='" +
            created +
            '\'' +
            ", updated='" +
            updated +
            '\'' +
            ", name='" +
            name +
            '\'' +
            ", crmId='" +
            crmId +
            '\'' +
            ", crmName='" +
            crmName +
            '\'' +
            ", extraData=" +
            extraData +
            ", hasConfirm=" +
            hasConfirm +
            ", checkShahkar=" +
            checkShahkar +
            ", registrationMethod=" +
            registrationMethod +
            ", forceDefaultTemplate=" +
            forceDefaultTemplate +
            ", forcePackages=" +
            forcePackages +
            ", prefix=" +
            prefix +
            ", forcePrefix=" +
            forcePrefix +
            ", branchStartDate='" +
            branchStartDate +
            '\'' +
            ", branchEndDate='" +
            branchEndDate +
            '\'' +
            ", maxAllowedRegistrationCount=" +
            maxAllowedRegistrationCount +
            ", forceBranchPeriod=" +
            forceBranchPeriod +
            ", customer=" +
            customer +
            ", defaultTemplate='" +
            defaultTemplate +
            '\'' +
            '}'
        );
    }
}
