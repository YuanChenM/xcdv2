package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * Created by guan_zhongheng on 2017/4/26.
 */
public class ORDR110101IBeanParam extends RestBean {

    private String commodityCode;

    private String commodityName;

    private BigDecimal orderCount;

    private String unit;

    private BigDecimal orderPrice;

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
