package com.batch.bybatch.bean.result;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class ByimBuyerResult implements Serializable{

    /** BUYER_ID */
    private String buyerId;
    /** BUYER_CODE */
    private String buyerCode;
    /** BUYER_TYPE */
    private String buyerType;
    /** BUYER_TYPE_NAME */
    private String buyerTypeName;

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

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }
}
