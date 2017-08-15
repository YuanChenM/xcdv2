package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 *
 * Fms买家退货订单溯源信息
 */
public class FmsBuyerReturnOrderStock implements Serializable {
    private static final long serialVersionUID = -5289428891975534438L;
    //行编号
    private int lineNum;
    //囤货订单商品对应的产品ID
    private String productId;
    //买手囤货订单ID
    private Long stockorderOrderId;
    //囤货订单编号
    private String stockorderOrderNumber;
    //退货数量
    private BigDecimal returnQty;

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

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }
}
