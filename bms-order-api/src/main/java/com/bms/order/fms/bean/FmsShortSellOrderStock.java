package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_chen on 2017/4/28.
 * <p>
 * Fms估货订单溯源信息
 */
public class FmsShortSellOrderStock implements Serializable {
    private static final long serialVersionUID = -1907081558277891868L;
    //行编号
    private int lineNum;
    //商品ID对应的产品ID
    private String productId;
    //囤货/沽货订单ID订单ID
    private Long stockorderOrderId;
    //囤货/沽货订单ID订单编号
    private String stockorderOrderNumber;
    //订单数量
    private BigDecimal orderedQuantity;
    //囤货订单/沽货订单
    private String orderType;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getStockorderOrderId() {
        return stockorderOrderId;
    }

    public void setStockorderOrderId(Long stockorderOrderId) {
        this.stockorderOrderId = stockorderOrderId;
    }

    public String getStockorderOrderNumber() {
        return stockorderOrderNumber;
    }

    public void setStockorderOrderNumber(String stockorderOrderNumber) {
        this.stockorderOrderNumber = stockorderOrderNumber;
    }

    public BigDecimal getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
