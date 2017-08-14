package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sun_jiaju on 2017/01/11.
 */
@ApiModel(value = "PRCE0201IResult", description = "价盘通道分类Result")
public class PRCE0201IResult implements Serializable {

    @ApiModelProperty(value = "通道分类ID")
    private String wayTypeId;

    @ApiModelProperty(value = "通道分类名称")
    private String wayTypeName;

    @ApiModelProperty(value = "价差平台分配系数")
    private BigDecimal priceMarginPlateRatio;

    @ApiModelProperty(value = "价差买手分配系数")
    private BigDecimal priceMarginSaRatio;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public String getWayTypeId() {
        return wayTypeId;
    }

    public void setWayTypeId(String wayTypeId) {
        this.wayTypeId = wayTypeId;
    }

    public String getWayTypeName() {
        return wayTypeName;
    }

    public void setWayTypeName(String wayTypeName) {
        this.wayTypeName = wayTypeName;
    }

    public BigDecimal getPriceMarginPlateRatio() {
        return priceMarginPlateRatio;
    }

    public void setPriceMarginPlateRatio(BigDecimal priceMarginPlateRatio) {
        this.priceMarginPlateRatio = priceMarginPlateRatio;
    }

    public BigDecimal getPriceMarginSaRatio() {
        return priceMarginSaRatio;
    }

    public void setPriceMarginSaRatio(BigDecimal priceMarginSaRatio) {
        this.priceMarginSaRatio = priceMarginSaRatio;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
