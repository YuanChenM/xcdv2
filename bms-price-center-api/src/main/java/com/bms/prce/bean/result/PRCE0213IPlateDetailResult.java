package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "PRCE0213IPlateDetailResult", description = "价盘详细Result")
public class PRCE0213IPlateDetailResult implements Serializable {

    @ApiModelProperty(value = "价盘ID")
    private Long pricePlateId;

    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "买家等级")
    private Integer buyerLevel;

    @ApiModelProperty(value = "通道配置ID")
    private Long wayConfigId;

    @ApiModelProperty(value = "通道分类ID")
    private Long wayTypeId;

    @ApiModelProperty(value = "通道分类名称")
    private String wayTypeName;

    @ApiModelProperty(value = "通道描述")
    private String wayDesc;

    @ApiModelProperty(value = "通道准入开始数量")
    private Integer startQty;

    @ApiModelProperty(value = "通道准入结束数量")
    private Integer endQty;

    @ApiModelProperty(value = "通道等级平衡系数")
    private BigDecimal balanceRatio;

    @ApiModelProperty(value = "生成价格")
    private BigDecimal generatePrice;

    @ApiModelProperty(value = "实际价格")
    private BigDecimal factPrice;

    @ApiModelProperty(value = "实际箱价")
    private BigDecimal unitPrice;

    public Long getPricePlateId() {
        return pricePlateId;
    }

    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    public Integer getBuyerLevel() {
        return buyerLevel;
    }

    public void setBuyerLevel(Integer buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }

    public Long getWayTypeId() {
        return wayTypeId;
    }

    public void setWayTypeId(Long wayTypeId) {
        this.wayTypeId = wayTypeId;
    }

    public String getWayTypeName() {
        return wayTypeName;
    }

    public void setWayTypeName(String wayTypeName) {
        this.wayTypeName = wayTypeName;
    }

    public String getWayDesc() {
        return wayDesc;
    }

    public void setWayDesc(String wayDesc) {
        this.wayDesc = wayDesc;
    }

    public Integer getStartQty() {
        return startQty;
    }

    public void setStartQty(Integer startQty) {
        this.startQty = startQty;
    }

    public Integer getEndQty() {
        return endQty;
    }

    public void setEndQty(Integer endQty) {
        this.endQty = endQty;
    }

    public BigDecimal getBalanceRatio() {
        return balanceRatio;
    }

    public void setBalanceRatio(BigDecimal balanceRatio) {
        this.balanceRatio = balanceRatio;
    }

    public BigDecimal getGeneratePrice() {
        return generatePrice;
    }

    public void setGeneratePrice(BigDecimal generatePrice) {
        this.generatePrice = generatePrice;
    }

    public BigDecimal getFactPrice() {
        return factPrice;
    }

    public void setFactPrice(BigDecimal factPrice) {
        this.factPrice = factPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
