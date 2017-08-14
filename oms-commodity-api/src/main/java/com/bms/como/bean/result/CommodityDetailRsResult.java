package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class CommodityDetailRsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品组成规则表
     * COMO_COMMODITY_RULE
     */
//    @ApiModelProperty(value = "主键-规则ID")
//    private Long ruleId;
    @ApiModelProperty(value = "商品ID")
    private Long commodityId;
    @ApiModelProperty(value = "制造商产品SKU")
    private String skuCode;
    @ApiModelProperty(value = "生产商ID")
    private Long producerId;
    @ApiModelProperty(value = "生产商编码")
    private String producerCode;
    @ApiModelProperty(value = "生产商名称")
    private String producerName;
    @ApiModelProperty(value = "库存状态")
    private String inventoryStu;
    @ApiModelProperty(value = "指定的入库批次")
    private String lotNo;
    @ApiModelProperty(value = "货权人类型")
    private String ownerType;
    @ApiModelProperty(value = "货权人Id")
    private Long ownerId;
    @ApiModelProperty(value = "货权人编码")
    private String ownerCode;
    @ApiModelProperty(value = "货权人名称")
    private String ownerName;

//    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
//    private Boolean delFlg;
//    @ApiModelProperty(value = "新建人ID")
//    private String crtId;
//    @ApiModelProperty(value = "新建时间")
//    private Date crtTime;
//    @ApiModelProperty(value = "修改人ID")
//    private String updId;
//    @ApiModelProperty(value = "修改时间")
//    private Date updTime;
//    @ApiModelProperty(value = "版本")
//    private Integer version;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getInventoryStu() {
        return inventoryStu;
    }

    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
