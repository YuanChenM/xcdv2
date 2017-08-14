package com.msk.sso.client.constant;

import org.apache.commons.lang.StringUtils;

public final class SSORelevanceDefine {
    private static String SYSTEM_MODULE_SERVER_URL;
    private static String CAS_SERVER_LOGIN_URL;
    private static String LOGIN_EMPLOY_INFO_SERVER_URL;
    private static String LOGIN_SELLER_INFO_SERVER_URL;
    private static String SERVER_NAME;
    private static String CAS_SERVER_URL_PREFIX;
    private static String CAS_SERVER_LOGOUT_URL;
    private static String MAIN_JSP_PATCH;
    private static String SEARCH_MENU_SERVER_URL;
    private static String LOGIN_USER_INFO_SERVER_URL;
    private static String VERSION;
    private static String DEPARTMENT_ROLE;
    private static String MODIFY_PASSWORD;
    private static String LOGIN_USER_AUTH_SERVER_URL;
    private static String LOGIN_RES_SYSTEM_URL;

    private static String API_KEY;
    private static String SECURITY_KEY;
    private static String SIGN;

    public static String getModifyPassword() {
        if (StringUtils.isEmpty(LOGIN_USER_INFO_SERVER_URL)) {
            return "http://127.0.0.1:8989/api/employ/password/_modify";
        }
        return MODIFY_PASSWORD;
    }

    public static void setModifyPassword(String modifyPassword) {
        MODIFY_PASSWORD = modifyPassword;
    }

    public static String getDepartmentRole() {
        return DEPARTMENT_ROLE;
    }

    public static void setDepartmentRole(String departmentRole) {
        DEPARTMENT_ROLE = departmentRole;
    }

    public static String getVersion() {
        return VERSION;
    }

    public static void setVersion(String version) {
        VERSION = version;
    }

    public static String getLoginUserInfoServerUrl() {
        if (StringUtils.isEmpty(LOGIN_USER_INFO_SERVER_URL)) {
            return "http://127.0.0.1:8989/api/login/user/_get";
        }
        return LOGIN_USER_INFO_SERVER_URL;
    }

    public static void setLoginUserInfoServerUrl(String loginUserInfoServerUrl) {
        LOGIN_USER_INFO_SERVER_URL = loginUserInfoServerUrl;
    }

    public static String getSearchMenuServerUrl() {
        if (StringUtils.isEmpty(SEARCH_MENU_SERVER_URL)) {
            return "http://localhost:9999/api/org/menu/search";
        }

        return SEARCH_MENU_SERVER_URL;
    }

    public static void setSearchMenuServerUrl(String searchMenuServerUrl) {
        SEARCH_MENU_SERVER_URL = searchMenuServerUrl;
    }

    public static String getMainJspPatch() {
        if (StringUtils.isEmpty(MAIN_JSP_PATCH)) {
            return "/jsp/main/main.jsp";
        }
        return MAIN_JSP_PATCH;
    }

    public static void setMainJspPatch(String mainJspPatch) {
        MAIN_JSP_PATCH = mainJspPatch;
    }

    public static String getCasServerLogoutUrl() {
        if (StringUtils.isEmpty(CAS_SERVER_LOGOUT_URL)) {
            return "http://localhost:8080/logout";
        }
        return CAS_SERVER_LOGOUT_URL;
    }

    public static void setCasServerLogoutUrl(String casServerLogoutUrl) {
        CAS_SERVER_LOGOUT_URL = casServerLogoutUrl;
    }

    public static String getSystemModuleServerUrl() {
        if (StringUtils.isEmpty(SYSTEM_MODULE_SERVER_URL)) {
            return "http://10.20.16.83/msk-config-server/api/system/module/_search";
        }

        return SYSTEM_MODULE_SERVER_URL;
    }

    public static void setSystemModuleServerUrl(String systemModuleServerUrl) {
        SYSTEM_MODULE_SERVER_URL = systemModuleServerUrl;
    }

    public static String getCasServerLoginUrl() {
        if (StringUtils.isEmpty(CAS_SERVER_LOGIN_URL)) {
            return "http://localhost:8080/login";
        }
        return CAS_SERVER_LOGIN_URL;
    }

    public static void setCasServerLoginUrl(String casServerLoginUrl) {
        CAS_SERVER_LOGIN_URL = casServerLoginUrl;
    }

    public static String getLoginEmployInfoServerUrl() {
        if (StringUtils.isEmpty(LOGIN_EMPLOY_INFO_SERVER_URL)) {
            return "http://localhost:9999/api/employ/info/_get";
        }

        return LOGIN_EMPLOY_INFO_SERVER_URL;
    }

    public static void setLoginEmployInfoServerUrl(String loginEmployInfoServerUrl) {
        LOGIN_EMPLOY_INFO_SERVER_URL = loginEmployInfoServerUrl;
    }

    public static String getLoginSellerInfoServerUrl() {
        if (StringUtils.isEmpty(LOGIN_SELLER_INFO_SERVER_URL)) {
            return "http://localhost:9999/api/sl/slInfo/slAccount/search";
        }

        return LOGIN_SELLER_INFO_SERVER_URL;
    }

    public static void setLoginSellerInfoServerUrl(String loginSellerInfoServerUrl) {
        LOGIN_SELLER_INFO_SERVER_URL = loginSellerInfoServerUrl;
    }

    public static String getServerName() {
        // if(StringUtils.isEmpty(SERVER_NAME)){
        // return "http://localhost:8085";
        // }

        return SERVER_NAME;
    }

    public static void setServerName(String serverName) {
        SERVER_NAME = serverName;
    }

    public static String getCasServerUrlPrefix() {
        if (StringUtils.isEmpty(CAS_SERVER_URL_PREFIX)) {
            return "http://localhost:8080/";
        }
        return CAS_SERVER_URL_PREFIX;
    }

    public static void setCasServerUrlPrefix(String casServerUrlPrefix) {
        CAS_SERVER_URL_PREFIX = casServerUrlPrefix;
    }

    public static String getLoginUserAuthServerUrl() {
        return LOGIN_USER_AUTH_SERVER_URL;
    }

    public static void setLoginUserAuthServerUrl(String loginUserAuthServerUrl) {
        LOGIN_USER_AUTH_SERVER_URL = loginUserAuthServerUrl;
    }

    public static String getLoginResSystemUrl() {
        return LOGIN_RES_SYSTEM_URL;
    }

    public static void setLoginResSystemUrl(String loginResSystemUrl) {
        LOGIN_RES_SYSTEM_URL = loginResSystemUrl;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static void setApiKey(String apiKey) {
        API_KEY = apiKey;
    }

    public static String getSecurityKey() {
        return SECURITY_KEY;
    }

    public static void setSecurityKey(String securityKey) {
        SECURITY_KEY = securityKey;
    }

    public static String getSIGN() {
        return SIGN;
    }

    public static void setSIGN(String SIGN) {
        SSORelevanceDefine.SIGN = SIGN;
    }
}
