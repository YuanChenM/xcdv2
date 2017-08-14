package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
@ApiModel(value = "PRCE0205IWayDetailResult", description = "营销状态通道详细Result")
public class PRCE0205IWayConfigResult implements Serializable {
    @ApiModelProperty(value = "通道配置ID")
    private Long wayConfigId;

    @ApiModelProperty(value = "通道分类ID")
    private Long wayTypeId;

    @ApiModelProperty(value = "单位")
    private String uom;

    @ApiModelProperty(value = "通道等级平衡系数")
    private BigDecimal balanceRatio;

    @ApiModelProperty(value = "平台分配系数")
    private BigDecimal platBalanceRatio;

    @ApiModelProperty(value = "买手分配系数")
    private BigDecimal saBalanceRatio;

    @ApiModelProperty(value = "账期总平衡系数")
    private BigDecimal sumBalanceRatio;

    @ApiModelProperty(value = "相邻等级系数差")
    private BigDecimal ratioDiff;

    @ApiModelProperty(value = "通道准入开始数量")
    private Integer startQty;

    @ApiModelProperty(value = "通道准入结束数量")
    private Integer endQty;

    @ApiModelProperty(value = "通道准入描述")
    private String qtyDesc;

    @ApiModelProperty(value = "通道等级描述")
    private String wayDesc;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public BigDecimal getBalanceRatio() {
        return balanceRatio;
    }

    public void setBalanceRatio(BigDecimal balanceRatio) {
        this.balanceRatio = balanceRatio;
    }

    public BigDecimal getSaBalanceRatio() {
        return saBalanceRatio;
    }

    public void setSaBalanceRatio(BigDecimal saBalanceRatio) {
        this.saBalanceRatio = saBalanceRatio;
    }

    public BigDecimal getSumBalanceRatio() {
        return sumBalanceRatio;
    }

    public void setSumBalanceRatio(BigDecimal sumBalanceRatio) {
        this.sumBalanceRatio = sumBalanceRatio;
    }

    public BigDecimal getRatioDiff() {
        return ratioDiff;
    }

    public void setRatioDiff(BigDecimal ratioDiff) {
        this.ratioDiff = ratioDiff;
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

    public String getQtyDesc() {
        return qtyDesc;
    }

    public void setQtyDesc(String qtyDesc) {
        this.qtyDesc = qtyDesc;
    }

    public String getWayDesc() {
        return wayDesc;
    }

    public void setWayDesc(String wayDesc) {
        this.wayDesc = wayDesc;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getPlatBalanceRatio() {
        return platBalanceRatio;
    }

    public void setPlatBalanceRatio(BigDecimal platBalanceRatio) {
        this.platBalanceRatio = platBalanceRatio;
    }

    public Long getWayTypeId() {
        return wayTypeId;
    }

    public void setWayTypeId(Long wayTypeId) {
        this.wayTypeId = wayTypeId;
    }
}
