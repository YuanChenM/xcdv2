package com.msk.comm.bean;


import java.io.Serializable;

/**
 * Created by jackjiang on 16/8/18.
 */
public class UserTypeResult implements Serializable{
    private String userType;
    private String userTypeName;

    public UserTypeResult() {
    }

    public UserTypeResult(String userType, String userTypeName) {
        this.userType = userType;
        this.userTypeName = userTypeName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
