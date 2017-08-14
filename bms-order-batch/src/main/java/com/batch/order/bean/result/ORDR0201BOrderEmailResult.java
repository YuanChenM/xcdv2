package com.batch.order.bean.result;

import java.io.Serializable;

/**
 * Created by sunjiaju on 2017/03/20.
 */
public class ORDR0201BOrderEmailResult implements Serializable {
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private String orderCode;
}
