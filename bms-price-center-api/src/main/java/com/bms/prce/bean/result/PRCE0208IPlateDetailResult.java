package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
@ApiModel(value = "PRCE0208IPlateDetailResult", description = "价盘详细Result")
public class PRCE0208IPlateDetailResult implements Serializable {
    @ApiModelProperty(value = "价盘详细ID")
    private Long pricePlateDetailId;

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

    public Long getPricePlateDetailId() {
        return pricePlateDetailId;
    }

    public void setPricePlateDetailId(Long pricePlateDetailId) {
        this.pricePlateDetailId = pricePlateDetailId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
