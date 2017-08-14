package com.bms.linv.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/18.
 */
@ApiModel(value = "LINV0102ISourceParam",
    description = "销售发货Source参数")
public class LINV0102ISourceParam implements Serializable {
    @ApiModelProperty(value = "物流区域ID")
    private Long logicAreaId;
    @ApiModelProperty(value = "销售平台")
    private String salePlatform;
    @ApiModelProperty(value = "货权人Id")
    private String ownerId;
    @ApiModelProperty(value = "货权人类型")
    private String ownerType;
    @ApiModelProperty(value = "产品货主id")
    private String masterOwnerId;
    @ApiModelProperty(value = "产品货主类型")
    private String masterOwnerType;
    @ApiModelProperty(value = "仓库Id")
    private Long whId;
    @ApiModelProperty(value = "SKU编码")
    private String skuCode;
    @ApiModelProperty(value = "供应商Id")
    private String supplierId;
    @ApiModelProperty(value = "采购批次")
    private String lotNo;
    @ApiModelProperty(value = "销售状态id")
    private Long salesStatusId;
    @ApiModelProperty(value = "商品id")
    private String commodityId;
    @ApiModelProperty(value = "库存类型")
    private String ivType;
    @ApiModelProperty(value = "单位")
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