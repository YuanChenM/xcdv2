package com.bms.order.bean.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liutao on 2017/1/16.
 */
public class ORDR0402IOrderResult implements Serializable {

    private Long shipId;

    private Long orderId;

    private Integer paymentRule;

    private List<ORDR0402IOrderDetailResult> orderDetail;

    public Integer getPaymentRule() {
        return paymentRule;
    }

    public void setPaymentRule(Integer paymentRule) {
        this.paymentRule = paymentRule;
    }


    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public List<ORDR0402IOrderDetailResult> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<ORDR0402IOrderDetailResult> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
