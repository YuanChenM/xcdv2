package com.msk.comm.bean;


import java.io.Serializable;

public class LoginUser implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 员工编号 */
    private String emplNo;
    /** 员工名称 */
    private String emplName;
    /** 员工ID */
    private String emplId;
    /** 登录密码 */
    private String loginPwd;
    /** 邮件地址 */
    private String emialAddr;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
}
