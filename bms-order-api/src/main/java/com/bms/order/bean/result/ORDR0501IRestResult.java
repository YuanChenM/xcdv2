package com.bms.order.bean.result;

import java.io.Serializable;

/**
 * Created by liutao on 2017/1/17.
 */
public class ORDR0501IRestResult implements Serializable {
    private static final long serialVersionUID = 1983857488529271834L;

    private Long orderId;

    private Long shipId;

    private String orderStatus;

    private Integer ver;

    private String paymentType;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
