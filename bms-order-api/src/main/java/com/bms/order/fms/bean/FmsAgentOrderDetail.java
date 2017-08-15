package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * Fms买手合伙人囤货订单（产品信息）
 */
public class FmsAgentOrderDetail implements Serializable {
    private static final long serialVersionUID = 4842070832751381438L;
    //行编号
    private Long orderDetailId;
    //商品ID对应的产品ID
    private String productId;
    //数量
    private BigDecimal orderedQuantity;
    //单位
    private String orderQuantityUom;
    //单价
    private BigDecimal unitSellingPriceDsp;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
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

    public BigDecimal getUnitSellingPriceDsp() {
        return unitSellingPriceDsp;
    }

    public void setUnitSellingPriceDsp(BigDecimal unitSellingPriceDsp) {
        this.unitSellingPriceDsp = unitSellingPriceDsp;
    }
}
