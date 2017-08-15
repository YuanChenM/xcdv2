package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * Created by liutao on 2017/1/17.
 */
public class ORDR0501IPaymentRestParam extends RestBean {
    private Integer paymentMode;

    private BigDecimal paymentMoney;

    private String paymentCode;

    public Integer getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
}
