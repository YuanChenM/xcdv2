package com.framework.base.bean;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/11/8.
 */
public class Authentication implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 签名
     */
    private String sign;
    /**
     * apiKey
     */
    private String apiKey;
    /**
     * securityKey
     */
    private String securityKey;
    /**
     * 时间戳
     */
    private Number timestamp;

    public Authentication() {
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public Number getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Number timestamp) {
        this.timestamp = timestamp;
    }
}
