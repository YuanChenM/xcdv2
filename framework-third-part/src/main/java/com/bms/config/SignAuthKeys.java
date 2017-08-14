package com.bms.config;


/**
 * Created by mao_yejun on 2017/5/16.
 */

public class SignAuthKeys {
    private static String apiKey;
    private static String securityKey;

    public static String getApiKey() {
        return apiKey;
    }

    public static void setApiKey(String apiKey) {
        SignAuthKeys.apiKey = apiKey;
    }

    public static String getSecurityKey() {
        return securityKey;
    }

    public static void setSecurityKey(String securityKey) {
        SignAuthKeys.securityKey = securityKey;
    }
}
