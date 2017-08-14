package com.batch.order.bean.result;

import com.batch.order.bean.entity.DistributionNotificationDetailEntity;

import java.math.BigDecimal;

/**
 * Created by liutao on 2017/3/10.
 */
public class ORDR0302DistributionDetailsResult extends DistributionNotificationDetailEntity {

    private BigDecimal realUnitPrice;

    public BigDecimal getRealUnitPrice() {
        return realUnitPrice;
    }

    public void setRealUnitPrice(BigDecimal realUnitPrice) {
        this.realUnitPrice = realUnitPrice;
    }
}
