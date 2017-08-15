package com.bms.order.fms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 *
 * Fms买家取消订单Bean
 */
public class FmsBuyerCancelOrderBean implements Serializable {
    private static final long serialVersionUID = -6547171561474251329L;
    //云冻品前台订单号
    private String orgsystemId;
    //OMS订单编码
    private String omsOrderNumber;
    //OMS订单ID
    private Long omsOrderId;
    //订单类型（买家销售）
    private String orderType;
    //订单日期
    private String orderedDateMir;
    //状态
    private String omsStatus;
    //line
    private List<FmsBuyerCancelOrderDetail> line;

    public String getOrgsystemId() {
        return orgsystemId;
    }

    public void setOrgsystemId(String orgsystemId) {
        this.orgsystemId = orgsystemId;
    }

    public String getOmsOrderNumber() {
        return omsOrderNumber;
    }

    public void setOmsOrderNumber(String omsOrderNumber) {
        this.omsOrderNumber = omsOrderNumber;
    }

    public Long getOmsOrderId() {
        return omsOrderId;
    }

    public void setOmsOrderId(Long omsOrderId) {
        this.omsOrderId = omsOrderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderedDateMir() {
        return orderedDateMir;
    }

    public void setOrderedDateMir(String orderedDateMir) {
        this.orderedDateMir = orderedDateMir;
    }

    public String getOmsStatus() {
        return omsStatus;
    }

    public void setOmsStatus(String omsStatus) {
        this.omsStatus = omsStatus;
    }

    public List<FmsBuyerCancelOrderDetail> getLine() {
        return line;
    }

    public void setLine(List<FmsBuyerCancelOrderDetail> line) {
        this.line = line;
    }
}
