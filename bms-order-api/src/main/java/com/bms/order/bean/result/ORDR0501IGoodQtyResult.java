package com.bms.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liutao on 2017/1/18.
 */
public class ORDR0501IGoodQtyResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long buyerForcastDeliverDetailId;

    private String goodsId;

    private BigDecimal receiveQty;

    private BigDecimal delayQty;

    private BigDecimal returnQty;

    private Date receiptDate;

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Long getBuyerForcastDeliverDetailId() {
        return buyerForcastDeliverDetailId;
    }

    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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
}
