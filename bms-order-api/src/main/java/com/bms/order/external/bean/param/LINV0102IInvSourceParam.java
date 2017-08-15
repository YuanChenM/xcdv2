package com.bms.order.external.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/18.
 */
public class LINV0102IInvSourceParam implements Serializable {
    private Long logicAreaId;
    private String salePlatform;
    private String ownerId;
    private String ownerType;
    private String masterOwnerId;
    private String masterOwnerType;
    private Long whId;
    private String skuCode;
    private String supplierId;
    private String lotNo;
    private Long salesStatusId;
    private String commodityId;
    private String ivType;
    private String uom;

    public Long getLogicAreaId() {
        return logicAreaId;
    }

    public void setLogicAreaId(Long logicAreaId) {
        this.logicAreaId = logicAreaId;
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

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getMasterOwnerId() {
        return masterOwnerId;
    }

    public void setMasterOwnerId(String masterOwnerId) {
        this.masterOwnerId = masterOwnerId;
    }

    public String getMasterOwnerType() {
        return masterOwnerType;
    }

    public void setMasterOwnerType(String masterOwnerType) {
        this.masterOwnerType = masterOwnerType;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public Long getSalesStatusId() {
        return salesStatusId;
    }

    public void setSalesStatusId(Long salesStatusId) {
        this.salesStatusId = salesStatusId;
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

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}