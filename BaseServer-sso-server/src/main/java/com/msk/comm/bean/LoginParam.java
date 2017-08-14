package com.msk.comm.bean;

/**
 * Created by mabo on 2016/4/19.
 */
public class LoginParam {

    /** 登录用户名 */
    private String userName;
    /** 登录密码 */
    private String password;
    /** 登录系统编码 */
    private String systemCode;
    /** 登录用户类型 */
    private String userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
