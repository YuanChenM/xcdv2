package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 * <p>
 * Fms买家取消订单溯源信息
 */
public class FmsBuyerCancelOrderStock implements Serializable {
    private static final long serialVersionUID = -3319305142162934347L;

    //行编号
    private int lineNum;
    //买手囤货订单ID
    private Long stockorderOrderId;
    //买手囤货订单编号
    private String stockorderOrderNumber;
    //囤货订单商品对应的产品ID
    private String productId;
    //囤货取消数量
    private BigDecimal stockorderQuantity;

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
}
