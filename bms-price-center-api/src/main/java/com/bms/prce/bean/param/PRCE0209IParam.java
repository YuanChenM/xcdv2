package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/23.
 */
public class PRCE0209IParam implements Serializable {
    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "商品ID")
    private String goodId;

    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "商品标准价格")
    private BigDecimal normPrice;

    @ApiModelProperty(value = "价盘生效时间")
    private String startTime;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "价格详细list")
    private List<PRCE0209IDetailParam> pricePlateList;

    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    public BigDecimal getNormPrice() {
        return normPrice;
    }

    public void setNormPrice(BigDecimal normPrice) {
        this.normPrice = normPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

    public List<PRCE0209IDetailParam> getPricePlateList() {
        return pricePlateList;
    }

    public void setPricePlateList(List<PRCE0209IDetailParam> pricePlateList) {
        this.pricePlateList = pricePlateList;
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
