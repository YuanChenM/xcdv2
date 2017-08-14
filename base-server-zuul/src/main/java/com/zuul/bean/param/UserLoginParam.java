package com.zuul.bean.param;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/2/21.
 */
public class UserLoginParam implements Serializable {

    private String loginId;
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
