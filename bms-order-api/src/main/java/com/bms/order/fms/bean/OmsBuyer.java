package com.bms.order.fms.bean;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * oms内部子系统-买家系统的买家
 */
public class OmsBuyer implements Serializable {

    private static final long serialVersionUID = 2004991355213646721L;
    //买家ID
    private String buyerId;
    //注册帐号名称
    private String accountName;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}

