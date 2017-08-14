package com.msk.sso.authentication;

import org.jasig.cas.authentication.UsernamePasswordCredential;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jackjiang on 16/8/5.
 */
public class RestLoginCredential extends UsernamePasswordCredential {
    @NotNull
    @Size(min=1, message = "required.userType")
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String getId() {
        return this.getUsername() + " " + this.getUserType();
    }
}
