package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sun_jiaju on 2017/01/17.
 */
public class PRCE0211IParam implements Serializable {
    @ApiModelProperty(value = "商品ID")
    private String goodId;

    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "比较查询时间")
    private String[] compareTime;

    @ApiModelProperty(value = "数量")
    private Integer qty;

    @ApiModelProperty(value = "返回类型")
    private Integer returnType;

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

    public String[] getCompareTime() {
        return compareTime;
    }

    public void setCompareTime(String[] compareTime) {
        this.compareTime = compareTime;
    }

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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
