package org.sohagroup.mobin.captiveportal.web.rest.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

public class CategoriesRequestModel {

    @JsonProperty("name")
    private String name;

    @JsonProperty("crm_id")
    private String crmId;

    @JsonProperty("crm_name")
    private String crmName;

    @JsonProperty("has_confirm")
    private Integer hasConfirm;

    @JsonProperty("extra_data")
    private Map<String, Object> extraData = null;

    @JsonProperty("check_shahkar")
    private Integer checkShahkar;

    @JsonProperty("registration_method")
    private Integer registrationMethod;

    @JsonProperty("force_default_template")
    private Boolean forceDefaultTemplate;

    @JsonProperty("force_packages")
    private Boolean forcePackages;

    @JsonProperty("customer")
    private Integer customer;

    @JsonProperty("default_template")
    private String defaultTemplate;

    public CategoriesRequestModel() {}

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
        CategoriesRequestModel that = (CategoriesRequestModel) o;
        return (
            Objects.equals(name, that.name) &&
            Objects.equals(crmId, that.crmId) &&
            Objects.equals(crmName, that.crmName) &&
            Objects.equals(hasConfirm, that.hasConfirm) &&
            Objects.equals(extraData, that.extraData) &&
            Objects.equals(checkShahkar, that.checkShahkar) &&
            Objects.equals(registrationMethod, that.registrationMethod) &&
            Objects.equals(forceDefaultTemplate, that.forceDefaultTemplate) &&
            Objects.equals(forcePackages, that.forcePackages) &&
            Objects.equals(customer, that.customer) &&
            Objects.equals(defaultTemplate, that.defaultTemplate)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            name,
            crmId,
            crmName,
            hasConfirm,
            extraData,
            checkShahkar,
            registrationMethod,
            forceDefaultTemplate,
            forcePackages,
            customer,
            defaultTemplate
        );
    }

    @Override
    public String toString() {
        return (
            "CategoriesRequestModel{" +
            "name='" +
            name +
            '\'' +
            ", crmId='" +
            crmId +
            '\'' +
            ", crmName='" +
            crmName +
            '\'' +
            ", hasConfirm='" +
            hasConfirm +
            '\'' +
            ", extraData=" +
            extraData +
            ", checkShahkar='" +
            checkShahkar +
            '\'' +
            ", registrationMethod='" +
            registrationMethod +
            '\'' +
            ", forceDefaultTemplate='" +
            forceDefaultTemplate +
            '\'' +
            ", forcePackages='" +
            forcePackages +
            '\'' +
            ", customer='" +
            customer +
            '\'' +
            ", defaultTemplate='" +
            defaultTemplate +
            '\'' +
            '}'
        );
    }
}
