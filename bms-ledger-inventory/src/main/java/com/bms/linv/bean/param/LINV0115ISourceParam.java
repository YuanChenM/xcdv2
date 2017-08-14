package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by zhang_jian4 on 2017/4/21.
 */
public class LINV0115ISourceParam implements Serializable {

    @ApiModelProperty(value = "物流区域Id")
    private Long logicAreaId;
    @ApiModelProperty(value = "销售平台")
    private String salePlatform;
    @ApiModelProperty(value = "货权人Id")
    private String ownerId;
    @ApiModelProperty(value = "货权人编码")
    private String ownerCode;
    @ApiModelProperty(value = "货权人类型")
    private String ownerType;
    @ApiModelProperty(value = "货权人细分类")
    private String ownerdType;
    @ApiModelProperty(value = "产品货主ID")
    private String masterOwnerId;
    @ApiModelProperty(value = "产品货主编码")
    private String masterOwnerCode;
    @ApiModelProperty(value = "产品货主类型")
    private String masterOwnerType;
    @ApiModelProperty(value = "划拨出库商品ID")
    private Long oldCommodityId;
    @ApiModelProperty(value = "划拨出库产品SKUCode")
    private String skuCode;
    @ApiModelProperty(value = "库存类型")
    private String ivType;
    @ApiModelProperty(value = "存储计量单位")
    private String uom;
    @ApiModelProperty(value = "指定批次划拨")
    private String lotNo;


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

    public String getMasterOwnerId() {
        return masterOwnerId;
    }

    public void setMasterOwnerId(String masterOwnerId) {
        this.masterOwnerId = masterOwnerId;
    }

    public String getMasterOwnerCode() {
        return masterOwnerCode;
    }

    public void setMasterOwnerCode(String masterOwnerCode) {
        this.masterOwnerCode = masterOwnerCode;
    }

    public String getMasterOwnerType() {
        return masterOwnerType;
    }

    public void setMasterOwnerType(String masterOwnerType) {
        this.masterOwnerType = masterOwnerType;
    }

    public Long getOldCommodityId() {
        return oldCommodityId;
    }

    public void setOldCommodityId(Long oldCommodityId) {
        this.oldCommodityId = oldCommodityId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
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

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }
}
