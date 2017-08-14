package com.bms.puch.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan_chen on 2017/4/27.
 * <p>
 * Fms买手合伙人竞价订单明细（产品信息）
 */
public class FmsAgentBidOrderDetail implements Serializable {
    private static final long serialVersionUID = -5788097384389960591L;
    //行编号
    private int lineNum;
    //采购编号
    private String orgOrderCode;
    //商品ID对应的产品ID
    private String productId;
    //数量
    private BigDecimal orderedQuantity;
    //单位
    private String orderQuantityUom;
    //单价
    private BigDecimal unitSellingPriceDsp;
    //商品ID
    private String commodityId;
    //订单类型
    private String orderType;
    //入库时间
    private Date inboundDate;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getOrgOrderCode() {
        return orgOrderCode;
    }

    public void setOrgOrderCode(String orgOrderCode) {
        this.orgOrderCode = orgOrderCode;
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

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }
}
