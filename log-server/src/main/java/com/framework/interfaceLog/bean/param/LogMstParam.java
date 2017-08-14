package com.framework.interfaceLog.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by 健 on 2017/4/24.
 */
public class LogMstParam extends BaseRestPaginationParam {

    private String mstId;

    private String systemName;

    private String url;

    private String remark;

    private String requestFormat;

    private String urlAuth;

    private String urlPassword;

    private String requestType;

    private String requestExample;

    private String responseExample;

    public String getMstId() {
        return mstId;
    }

    public void setMstId(String mstId) {
        this.mstId = mstId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequestFormat() {
        return requestFormat;
    }

    public void setRequestFormat(String requestFormat) {
        this.requestFormat = requestFormat;
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestExample() {
        return requestExample;
    }

    public void setRequestExample(String requestExample) {
        this.requestExample = requestExample;
    }

    public String getResponseExample() {
        return responseExample;
    }

    public void setResponseExample(String responseExample) {
        this.responseExample = responseExample;
    }
}
