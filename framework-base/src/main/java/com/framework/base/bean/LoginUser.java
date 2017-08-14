package com.framework.base.bean;

import com.framework.base.rest.entity.BaseEntity;

/**
 * 用户信息
 *
 * @author mao_yejun
 * @version 1.0
 */
public class LoginUser extends BaseEntity {
    private String emplNo;
    /**
     * 员工名称
     */
    private String emplName;
    /**
     * 员工ID
     */
    private String emplId;
    /**
     * 登录密码
     */
    private String loginPwd;
    /**
     * 邮件地址
     */
    private String emialAddr;
    /**
     * 用户登录令牌
     */
    private String token;
    /**
     * 状态
     */
    private int status;
    /**
     * 用户类型
     */
    private String userType;

    public String getEmplNo() {
        return emplNo;
    }

    public void setEmplNo(String emplNo) {
        this.emplNo = emplNo;
    }

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmialAddr() {
        return emialAddr;
    }

    public void setEmialAddr(String emialAddr) {
        this.emialAddr = emialAddr;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
