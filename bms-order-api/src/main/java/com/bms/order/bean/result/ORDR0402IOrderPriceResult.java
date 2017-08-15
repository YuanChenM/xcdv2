package com.bms.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/1/15.
 */
public class ORDR0402IOrderPriceResult implements Serializable {


    private Long orderLevel;

    private BigDecimal levelStart;

    private BigDecimal levelEnd;

    private BigDecimal levelPrice;

    public BigDecimal getLevelStart() {
        return levelStart;
    }

    public void setLevelStart(BigDecimal levelStart) {
        this.levelStart = levelStart;
    }

    public BigDecimal getLevelEnd() {
        return levelEnd;
    }

    public void setLevelEnd(BigDecimal levelEnd) {
        this.levelEnd = levelEnd;
    }

    public BigDecimal getLevelPrice() {
        return levelPrice;
    }

    public void setLevelPrice(BigDecimal levelPrice) {
        this.levelPrice = levelPrice;
    }

    public Long getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Long orderLevel) {
        this.orderLevel = orderLevel;
    }
}
