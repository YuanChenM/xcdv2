package com.batch.order.bean.price.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/1/10.
 */
public class PRCE0211IParam implements Serializable {
    private static final long serialVersionUID = 4966684673548754807L;
    //物流区编码
    private String lgcsAreaCode;
    //商品ID
    private String goodId;
    //用户类型
    private String userType;
    //买家等级
    private String buyerLevel;
    //比较查询时间
    private String[] compareTime;
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

    public String[] getCompareTime() {
        return compareTime;
    }

    public void setCompareTime(String[] compareTime) {
        this.compareTime = compareTime;
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
