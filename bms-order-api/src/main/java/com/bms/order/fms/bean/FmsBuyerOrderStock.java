package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 * <p>
 * Fms买家订单明细（产品的货主信息）
 */
public class FmsBuyerOrderStock implements Serializable {
    private static final long serialVersionUID = -8950132773934552795L;

    //行编号
    private int lineNum;
    //囤货订单ID
    private Long stockorderOrderId;
    //囤货订单编号
    private String stockorderOrderNumber;
    //囤货订单行号
    private String productId;
    //囤货订单行数量
    private BigDecimal stockorderQuantity;
    //真实囤货物料单价
    private BigDecimal stockorderPrice;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getStockorderQuantity() {
        return stockorderQuantity;
    }

    public void setStockorderQuantity(BigDecimal stockorderQuantity) {
        this.stockorderQuantity = stockorderQuantity;
    }

    public BigDecimal getStockorderPrice() {
        return stockorderPrice;
    }

    public void setStockorderPrice(BigDecimal stockorderPrice) {
        this.stockorderPrice = stockorderPrice;
    }
}
