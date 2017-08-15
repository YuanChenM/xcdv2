package com.bms.order.external.bean.entity;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class SellerEntity {
    private static final long serialVersionUID = 1L;

    private Long sellerId;

    private String sellerCode;

    private String sellerName;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

}
