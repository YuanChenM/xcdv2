package com.msk.sso.client.bean;


import java.io.Serializable;


public class SystemModule implements Serializable{
    /** 模块代号 */
    private String sysModule;
    /** 1:员工,2:卖家(供应商),3:买家 */
    private Integer loginUserType;
    /** 模块显示名称 */
    private String sysShowName;
    /** 系统编号 */
    private String sysCode;
    /** 系统主画面URL */
    private String sysMainUrl;

    /**
     * 获得sysModule
     **/
    public String getSysModule() {
        return sysModule;
    }

    /**
     * 设置sysModule
     *
     * @param sysModule sysModule
     **/
    public void setSysModule(String sysModule) {
        this.sysModule = sysModule;
    }

    /**
     * 获得loginUserType
     **/
    public Integer getLoginUserType() {
        return loginUserType;
    }

    /**
     * 设置loginUserType
     *
     * @param loginUserType loginUserType
     **/
    public void setLoginUserType(Integer loginUserType) {
        this.loginUserType = loginUserType;
    }

    /**
     * 获得sysShowName
     **/
    public String getSysShowName() {
        return sysShowName;
    }

    /**
     * 设置sysShowName
     *
     * @param sysShowName sysShowName
     **/
    public void setSysShowName(String sysShowName) {
        this.sysShowName = sysShowName;
    }

    /**
     * 获得sysCode
     **/
    public String getSysCode() {
        return sysCode;
    }

    /**
     * 设置sysCode
     *
     * @param sysCode sysCode
     **/
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * 获得sysMainUrl
     **/
    public String getSysMainUrl() {
        return sysMainUrl;
    }

    /**
     * 设置sysMainUrl
     *
     * @param sysMainUrl sysMainUrl
     **/
    public void setSysMainUrl(String sysMainUrl) {
        this.sysMainUrl = sysMainUrl;
    }
}
