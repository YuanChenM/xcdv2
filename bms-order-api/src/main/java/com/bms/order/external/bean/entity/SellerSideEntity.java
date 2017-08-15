package com.bms.order.external.bean.entity;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class SellerSideEntity {
    // 销售方ID
    private String sellerSideId;

    // 销售方编码
    private String sellerSideCode;

    // 销售方名称
    private String sellerSideName;

    // 销售方角色
    private String sellerSideRole;

    public String getSellerSideId() {
        return sellerSideId;
    }

    public void setSellerSideId(String sellerSideId) {
        this.sellerSideId = sellerSideId;
    }

    public String getSellerSideCode() {
        return sellerSideCode;
    }

    public void setSellerSideCode(String sellerSideCode) {
        this.sellerSideCode = sellerSideCode;
    }

    public String getSellerSideName() {
        return sellerSideName;
    }

    public void setSellerSideName(String sellerSideName) {
        this.sellerSideName = sellerSideName;
    }

    public String getSellerSideRole() {
        return sellerSideRole;
    }

    public void setSellerSideRole(String sellerSideRole) {
        this.sellerSideRole = sellerSideRole;
    }
}
