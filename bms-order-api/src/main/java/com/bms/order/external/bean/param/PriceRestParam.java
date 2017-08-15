package com.bms.order.external.bean.param;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public class PriceRestParam {
    //物流区编码
    private String lgcsAreaCode;
    //商品ID
    private String goodId;
    //用户类型
    private String userType;
    //买家等级
    private String buyerLevel;
    //比较查询时间
    private Date compareTimeOne;
    //比较查询时间
    private Date compareTimeTwo;
    //数量
    private BigDecimal qty;
    //返回类型
    private Integer returnType;

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
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

    public Date getCompareTimeOne() {
        return compareTimeOne;
    }

    public void setCompareTimeOne(Date compareTimeOne) {
        this.compareTimeOne = compareTimeOne;
    }

    public Date getCompareTimeTwo() {
        return compareTimeTwo;
    }

    public void setCompareTimeTwo(Date compareTimeTwo) {
        this.compareTimeTwo = compareTimeTwo;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }
}
