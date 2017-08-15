package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/28.
 * <p>
 * Fms估货订单明细（产品信息）
 */
public class FmsShortSellOrderDetail implements Serializable {
    private static final long serialVersionUID = -1907081558277891868L;
    //行编号
    private Long lineNum;
    //物料编码
    private String productId;
    //订单数量
    private BigDecimal orderedQuantity;
    //物料单位
    private String orderQuantityUom;
    //销售单价
    private BigDecimal unitSellingPrice;
    //Fms估货订单溯源信息
    private List<FmsShortSellOrderStock> subLine;

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

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public List<FmsShortSellOrderStock> getSubLine() {
        return subLine;
    }

    public void setSubLine(List<FmsShortSellOrderStock> subLine) {
        this.subLine = subLine;
    }
}
