package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class LINV0009ISource implements Serializable {
    //物流区域ID
    private Long logicAreaId;
    //物流区域编码
    private String logicAreaCode;
    //销售平台
    private String salePlatform;
    //货主Id
    private String ownerId;
    //货主编码
    private String ownerCode;
    //货主类型
    private String ownerType;
    //货主细分类
    private String ownerdType;
    //商品ID
    private String commodityId;
    //库存类型
    private String ivType;
    //销售标签
    private String salesLabel;

    public Long getLogicAreaId() {
        return logicAreaId;
    }

    public void setLogicAreaId(Long logicAreaId) {
        this.logicAreaId = logicAreaId;
    }

    public String getLogicAreaCode() {
        return logicAreaCode;
    }

    public void setLogicAreaCode(String logicAreaCode) {
        this.logicAreaCode = logicAreaCode;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerdType() {
        return ownerdType;
    }

    public void setOwnerdType(String ownerdType) {
        this.ownerdType = ownerdType;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }

    public String getSalesLabel() {
        return salesLabel;
    }

    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }
}
