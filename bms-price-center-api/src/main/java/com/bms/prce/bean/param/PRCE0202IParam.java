package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sun_jiaju on 2017/01/11.
 */
public class PRCE0202IParam implements Serializable {
    @ApiModelProperty(value = "通道分类ID")
    private Long wayTypeId;
    @ApiModelProperty(value = "通道分类名称")
    private String wayTypeName;
    @ApiModelProperty(value = "价差平台分配系数")
    private BigDecimal priceMarginPlateRatio;
    @ApiModelProperty(value = "价差买手分配系数")
    private BigDecimal priceMarginSaRatio;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public String getWayTypeName() {
        return wayTypeName;
    }

    public void setWayTypeName(String wayTypeName) {
        this.wayTypeName = wayTypeName;
    }

    public Long getWayTypeId() {
        return wayTypeId;
    }

    public void setWayTypeId(Long wayTypeId) {
        this.wayTypeId = wayTypeId;
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
