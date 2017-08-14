package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
@ApiModel(value = "PRCE0208IResult", description = "价盘Result")
public class PRCE0208IResult implements Serializable {
    @ApiModelProperty(value = "价盘ID")
    private Long pricePlateId;

    @ApiModelProperty(value = "商品ID")
    private String goodId;

    @ApiModelProperty(value = "商品信息")
    private String goodInfo;

    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "商品标准价格")
    private BigDecimal normPrice;

    @ApiModelProperty(value = "营销通道ID")
    private Long marketingWayConfigId;

    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "营销状态名称")
    private String marketingStatusName;

    @ApiModelProperty(value = "生效时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "价盘详细list")
    private List<PRCE0208IPlateDetailResult> plateDetailList;

    public BigDecimal getNormPrice() {
        return normPrice;
    }

    public void setNormPrice(BigDecimal normPrice) {
        this.normPrice = normPrice;
    }

    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<PRCE0208IPlateDetailResult> getPlateDetailList() {
        return plateDetailList;
    }

    public void setPlateDetailList(List<PRCE0208IPlateDetailResult> plateDetailList) {
        this.plateDetailList = plateDetailList;
    }

    public Long getPricePlateId() {
        return pricePlateId;
    }

    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

    public String getBuyerLevel() {
        return buyerLevel;
    }

    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(String goodInfo) {
        this.goodInfo = goodInfo;
    }

    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getMarketingWayConfigId() {
        return marketingWayConfigId;
    }

    public void setMarketingWayConfigId(Long marketingWayConfigId) {
        this.marketingWayConfigId = marketingWayConfigId;
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
}
