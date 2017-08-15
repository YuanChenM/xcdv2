package com.bms.order.bean.param;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * 支付通知回传接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0701IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -3734402815385938451L;


    /**
     * 买家/买手 订单ID
     */
    private Long orderId;

    /**
     * 买家/买手 订单类型
     */
    private String orderType;

    /**
     * 支付金额
     */
    private BigDecimal paymentAmount;

    private Long batchOrderId;

    private String paymentWay;

    private String paymentSubject;

    public Long getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(Long batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getPaymentSubject() {
        return paymentSubject;
    }

    public void setPaymentSubject(String paymentSubject) {
        this.paymentSubject = paymentSubject;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BuyerOrder generateBuyerOrder(){

        BuyerOrder buyerOrder = BuyerOrder.build(null).forComplete(orderId);
        return buyerOrder;
    }

    public BsOrder generateBsOrder(){

        BsOrder bsOrder = BsOrder.build(null).forComplete(orderId);
        return bsOrder;
    }
}
