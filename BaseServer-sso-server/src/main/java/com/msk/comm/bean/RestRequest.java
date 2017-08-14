package com.msk.comm.bean;

public class RestRequest<T> {
    /** 客户端标识 */
    private String siteCode;
    /** 身份认证密码 */
    private String auth;
    /** 登录人 */
    private String loginId;
    /** 业务参数 */
    private T param;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
