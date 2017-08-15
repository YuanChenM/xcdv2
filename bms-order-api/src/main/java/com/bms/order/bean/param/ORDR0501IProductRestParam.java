package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * Created by liutao on 2017/1/17.
 */
public class ORDR0501IProductRestParam extends RestBean {
    private Long shipDetailId;

    private String supplierCode;

    private String skuCode;

    private BigDecimal receiveQty;

    private BigDecimal delayQty;

    private BigDecimal returnQty;

    private BigDecimal receivePrice;

    public Long getShipDetailId() {
        return shipDetailId;
    }

    public void setShipDetailId(Long shipDetailId) {
        this.shipDetailId = shipDetailId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(BigDecimal receiveQty) {
        this.receiveQty = receiveQty;
    }

    public BigDecimal getDelayQty() {
        return delayQty;
    }

    public void setDelayQty(BigDecimal delayQty) {
        this.delayQty = delayQty;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public BigDecimal getReceivePrice() {
        return receivePrice;
    }

    public void setReceivePrice(BigDecimal receivePrice) {
        this.receivePrice = receivePrice;
    }
}
