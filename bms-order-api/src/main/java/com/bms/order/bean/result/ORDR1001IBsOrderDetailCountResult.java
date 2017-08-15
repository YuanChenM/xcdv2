package com.bms.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liutao on 2017/3/8.
 */
public class ORDR1001IBsOrderDetailCountResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long bsStockpileSplitDetailId;

    private Long bsOrderId;

    private BigDecimal saleQuantity;

    private String goodsId;

    private String ownerId;

    private Date bsOrderTime;

    private BigDecimal orderGoodsQty;

    public Long getBsStockpileSplitDetailId() {
        return bsStockpileSplitDetailId;
    }

    public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
        this.bsStockpileSplitDetailId = bsStockpileSplitDetailId;
    }

    public BigDecimal getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(BigDecimal saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Long getBsOrderId() {
        return bsOrderId;
    }

    public void setBsOrderId(Long bsOrderId) {
        this.bsOrderId = bsOrderId;
    }

    public Date getBsOrderTime() {
        return bsOrderTime;
    }

    public void setBsOrderTime(Date bsOrderTime) {
        this.bsOrderTime = bsOrderTime;
    }

    public BigDecimal getOrderGoodsQty() {
        return orderGoodsQty;
    }

    public void setOrderGoodsQty(BigDecimal orderGoodsQty) {
        this.orderGoodsQty = orderGoodsQty;
    }
}
