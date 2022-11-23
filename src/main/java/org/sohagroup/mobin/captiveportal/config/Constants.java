package org.sohagroup.mobin.captiveportal.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";

    public static final String SYSTEM = "system";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String URI_SCHEME = "http";

    public static final String BRACES_ID = "{id}/";

    public static final String HTTPS = "https";

    public static final String LIMIT = "limit";
    public static final String OFFSET = "offset";
    public static final String CATEGORY_CUSTOMER_CRM_ENGLISH_NAME = "categorycustomercrm_english_name__contains";
    public static final String CATEGORY_CUSTOMER_CRM_ID = "categorycustomercrm_id";
    public static final String CATEGORY_CUSTOMER_ID = "categorycustomerid";
    public static final String CATEGORY_CUSTOMER_NAME = "categorycustomername__contains";
    public static final String CRM_ID_CONTAINS = "crm_id__contains";
    public static final String CRM_NAME_CONTAINS = "crm_name__contains";

    private Constants() {}
}
