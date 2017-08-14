package com.zuul.bean.result;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/2/21.
 */
public class UserLoginResult implements Serializable {
    private String securityKey;
    private String apiKey;

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
