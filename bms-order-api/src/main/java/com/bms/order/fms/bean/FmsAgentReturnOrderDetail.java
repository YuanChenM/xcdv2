package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * Fms买手合伙人囤货退货订单明细（产品信息）
 */
public class FmsAgentReturnOrderDetail implements Serializable {
    private static final long serialVersionUID = 6916294305688038576L;
    //行编号
    private Long lineNum;
    //订购项目
    private String productId;
    //退货数量
    private BigDecimal orderedQuantity;
    //单位
    private String orderQuantityUom;
    //退货原因
    private String returnReason;

    public Long getLineNum() {
        return lineNum;
    }

    public void setLineNum(Long lineNum) {
        this.lineNum = lineNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }
}
