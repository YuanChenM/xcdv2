package com.msk.sso.client.bean.param;

import java.io.Serializable;

public class SellerLoginParam implements Serializable{
    private String slAccount;
    private String slTel;
    private String accountPsd;

    public String getSlAccount() {
        return slAccount;
    }

    public void setSlAccount(String slAccount) {
        this.slAccount = slAccount;
    }

    public String getSlTel() {
        return slTel;
    }

    public void setSlTel(String slTel) {
        this.slTel = slTel;
    }

    public String getAccountPsd() {
        return accountPsd;
    }

    public void setAccountPsd(String accountPsd) {
        this.accountPsd = accountPsd;
    }
}
