package com.bms.bean.log;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mao_yejun on 2017/4/28.
 */
public class LogParam implements Serializable {
    private String exceptionMessage;
    private String httpState;
    private String requestBody;
    private String requestFormat;
    private Date requestTime;
    private String requestType;
    private String responseBody;
    private String responseState;
    private String systemName;
    private String urlAuth;
    private String urlPassword;
    private String url;

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getHttpState() {
        return httpState;
    }

    public void setHttpState(String httpState) {
        this.httpState = httpState;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestFormat() {
        return requestFormat;
    }

    public void setRequestFormat(String requestFormat) {
        this.requestFormat = requestFormat;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseState() {
        return responseState;
    }

    public void setResponseState(String responseState) {
        this.responseState = responseState;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUrlAuth() {
        return urlAuth;
    }

    public void setUrlAuth(String urlAuth) {
        this.urlAuth = urlAuth;
    }

    public String getUrlPassword() {
        return urlPassword;
    }

    public void setUrlPassword(String urlPassword) {
        this.urlPassword = urlPassword;
    }
}
