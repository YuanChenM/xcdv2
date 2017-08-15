package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan_chen on 2017/5/8
 *
 * oms订单支付记录
 */
public class OmsOrderPayment implements Serializable {
    private static final long serialVersionUID = 1119136601962124594L;
    //订单ID
    private Long orderId;
    //支付金额
    private BigDecimal paymentAmount;
    //支付方式
    private String paymentWay;
    //支付时间
    private Date paymentDatetime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public Date getPaymentDatetime() {
        return paymentDatetime;
    }

    public void setPaymentDatetime(Date paymentDatetime) {
        this.paymentDatetime = paymentDatetime;
    }
}

