package com.bms.order.bean.externalCall.buyers.param;

import java.io.Serializable;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class BuyersRestParam implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 买家：买家ID [【需要和买家确认】]
     */
    private String buyerId;

    /**
     * 买家：买家编码
     */
    private String buyerCode;

    /**
     * 买家：买家名称
     */
    private String buyerName;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
