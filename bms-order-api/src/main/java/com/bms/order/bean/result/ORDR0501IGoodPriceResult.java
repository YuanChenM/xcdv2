package com.bms.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/1/17.
 */
public class ORDR0501IGoodPriceResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long buyerOrderId;

    private BigDecimal orderQty;

    private String goodsId;

    private BigDecimal receivePrice;

    private BigDecimal kgPrice;// 公斤价

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getReceivePrice() {
        return receivePrice;
    }

    public void setReceivePrice(BigDecimal receivePrice) {
        this.receivePrice = receivePrice;
    }

    public BigDecimal getKgPrice() {
        return kgPrice;
    }

    public void setKgPrice(BigDecimal kgPrice) {
        this.kgPrice = kgPrice;
    }
}
