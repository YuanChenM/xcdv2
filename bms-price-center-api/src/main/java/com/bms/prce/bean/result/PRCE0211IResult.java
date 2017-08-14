package com.bms.prce.bean.result;

import com.sun.xml.internal.rngom.binary.DataExceptPattern;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/19.
 */
@ApiModel(value = "PRCE0211IResult", description = "价盘Result")
public class PRCE0211IResult implements Serializable {
    @ApiModelProperty(value = "价盘ID")
    private Long pricePlateId;

    @ApiModelProperty(value = "商品ID")
    private String goodId;

    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "价盘开始时间")
    private Date startTime;

    @ApiModelProperty(value = "价盘结束时间")
    private Date endTime;

    @ApiModelProperty(value = "通道分类ID")
    private Long wayTypeId;

    @ApiModelProperty(value = "通道配置ID")
    private Long wayConfigId;

    @ApiModelProperty(value = "通道描述")
    private String wayDesc;

    @ApiModelProperty(value = "通道等级")
    private Long wayLevel;

    @ApiModelProperty(value = "通道分类名称")
    private String wayTypeName;

    @ApiModelProperty(value = "价格（公斤）")
    private BigDecimal price;

    @ApiModelProperty(value = "价格（单位）")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "价盘详细List")
    private List<PRCE0211IDetailResult> plateDetailList;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public List<PRCE0211IDetailResult> getPlateDetailList() {
        return plateDetailList;
    }

    public void setPlateDetailList(List<PRCE0211IDetailResult> plateDetailList) {
        this.plateDetailList = plateDetailList;
    }

    public Long getPricePlateId() {
        return pricePlateId;
    }

    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBuyerLevel() {
        return buyerLevel;
    }

    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }

    public String getWayDesc() {
        return wayDesc;
    }

    public void setWayDesc(String wayDesc) {
        this.wayDesc = wayDesc;
    }

    public Long getWayLevel() {
        return wayLevel;
    }

    public void setWayLevel(Long wayLevel) {
        this.wayLevel = wayLevel;
    }
}
