package com.zuul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mao_yejun on 2017/3/14.
 */
@Component
@ConfigurationProperties(prefix = "oms.interface")
public class ApiKeyConfig {
    private String apiKey;
    private Boolean doAuthFlg = true;
    private String securityKey;

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public Boolean getDoAuthFlg() {
        return doAuthFlg;
    }

    public void setDoAuthFlg(Boolean doAuthFlg) {
        this.doAuthFlg = doAuthFlg;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
