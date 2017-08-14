package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/4/14.
 */
public class LINV0103ISourceParam implements Serializable {
    @ApiModelProperty(value = "物流区域Id")
    private Long logicAreaId;
    @ApiModelProperty(value = "产品货主Id")
    private String ownerId;
    @ApiModelProperty(value = "产品货主code")
    private String ownerCode;
    @ApiModelProperty(value = "货主类型")
    private String ownerType;
    @ApiModelProperty(value = "货主细分类")
    private String ownerdType;
    @ApiModelProperty(value = "销售平台编码")
    private String salePlatform;
    @ApiModelProperty(value = "sku编码")
    private String skuCode;
    @ApiModelProperty(value = "采购批次")
    private String lotNo;
    @ApiModelProperty(value = "库存类型")
    private String ivType;
    @ApiModelProperty(value = "销售状态")
    private Long saleStatusId;
    @ApiModelProperty(value = "存储计量单位")
    private String uom;

    public Long getLogicAreaId() {
        return logicAreaId;
    }

    public void setLogicAreaId(Long logicAreaId) {
        this.logicAreaId = logicAreaId;
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

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }

    public Long getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
