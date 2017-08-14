package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sun_jiaju on 2017/01/19.
 */
@ApiModel(value = "PRCE0211IDetailResult", description = "价盘详细Result")
public class PRCE0211IDetailResult implements Serializable {
    @ApiModelProperty(value = "通道准入开始数量")
    private Integer startQty;

    @ApiModelProperty(value = "通道准入结束数量")
    private Integer endQty;

    @ApiModelProperty(value = "通道分类ID")
    private Long wayTypeId;

    @ApiModelProperty(value = "通道分类名称")
    private String wayTypeName;

    public Long getWayLevel() {
        return wayLevel;
    }

    public void setWayLevel(Long wayLevel) {
        this.wayLevel = wayLevel;
    }

    @ApiModelProperty(value = "通道配置ID")

    private Long wayConfigId;

    @ApiModelProperty(value = "通道描述")
    private String wayDesc;

    @ApiModelProperty(value = "通道等级")
    private Long wayLevel;

    @ApiModelProperty(value = "价格（公斤）")
    private BigDecimal price;

    @ApiModelProperty(value = "价格（单位）")
    private BigDecimal unitPrice;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getWayDesc() {
        return wayDesc;
    }

    public void setWayDesc(String wayDesc) {
        this.wayDesc = wayDesc;
    }

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }
}
