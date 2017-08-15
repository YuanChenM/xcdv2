package com.bms.order.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/4/27.
 */
public class LINV0105ISourceParam implements Serializable{

    @ApiModelProperty(value = "物流区域ID")
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
    @ApiModelProperty(value = "商品id")
    private String commodityId;
    @ApiModelProperty(value = "库存类型")
    private String ivType;
    @ApiModelProperty(value = "商品库存类型")
    private String comoIvType;
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

    public String getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String comoIvType) {
        this.comoIvType = comoIvType;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
