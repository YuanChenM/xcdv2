package com.bms.linv.bean.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/14.
 */
@ApiModel(value = "LINV0101ISourceParam",
    description = "入库业务Source参数")
public class LINV0101ISourceParam implements Serializable {
    @ApiModelProperty(value = "物流区域Id")
    private Long logicAreaId;
    @ApiModelProperty(value = "物流区域编码")
    private String logicAreaCode;
    @ApiModelProperty(value = "物流区域名称")
    private String logicAreaName;
    @ApiModelProperty(value = "销售平台编码")
    private String salePlatform;
    @ApiModelProperty(value = "商品货权人Id")
    private String ownerId;
    @ApiModelProperty(value = "商品货权人编码")
    private String ownerCode;
    @ApiModelProperty(value = "商品货权人类型")
    private String ownerType;
    @ApiModelProperty(value = "商品货权人名称")
    private String ownerName;
    @ApiModelProperty(value = "商品货权人细分类")
    private String ownerdType;
    @ApiModelProperty(value = "产品货主ID")
    private String masterOwnerId;
    @ApiModelProperty(value = "产品货主编码")
    private String masterOwnerCode;
    @ApiModelProperty(value = "产品货主类型")
    private String masterOwnerType;
    @ApiModelProperty(value = "产品货主名称")
    private String masterOwnerName;
    @ApiModelProperty(value = "仓库Id")
    private Long whId;
    @ApiModelProperty(value = "仓库编码")
    private String whCode;
    @ApiModelProperty(value = "仓库名称")
    private String whName;
    @ApiModelProperty(value = "SKU编码")
    private String skuCode;
    @ApiModelProperty(value = "单位")
    private String uom;

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

    public String getLogicAreaName() {
        return logicAreaName;
    }

    public void setLogicAreaName(String logicAreaName) {
        this.logicAreaName = logicAreaName;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getMasterOwnerName() {
        return masterOwnerName;
    }

    public void setMasterOwnerName(String masterOwnerName) {
        this.masterOwnerName = masterOwnerName;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}