package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by yuan_chen on 2017/5/7
 *
 * Oms买家订单溯源用bean
 */
public class OmsOrderOrigin implements Serializable {
    private static final long serialVersionUID = 6426402579096763880L;
    //订单ID
    private Long orderId;
    //订单ID
    private String orderCode;
    //分批订单明细ID
    private Long orderDetailId;
    //业务明细ID
    private Long detailId;
    //供货方ID
    private String sellSideId;
    //供货方类型（平台，买手，合伙人）
    private String sellSideType;
    //买家ID
    private String buyerId;
    //业务类型
    private String bizType;
    //订单ID
    private Long buyerOrderId;
    //商品ID
    private Long commodityId;
    //行权价格
    private BigDecimal commodityPrice;
    //行权数量
    private BigDecimal commodityQty;

    //订单明细，供货类型
    Map<Long, String> comoInventoryTypeMap;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getSellSideId() {
        return sellSideId;
    }

    public void setSellSideId(String sellSideId) {
        this.sellSideId = sellSideId;
    }

    public String getSellSideType() {
        return sellSideType;
    }

    public void setSellSideType(String sellSideType) {
        this.sellSideType = sellSideType;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Map<Long, String> getComoInventoryTypeMap() {
        return comoInventoryTypeMap;
    }

    public void setComoInventoryTypeMap(Map<Long, String> comoInventoryTypeMap) {
        this.comoInventoryTypeMap = comoInventoryTypeMap;
    }

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public BigDecimal getCommodityQty() {
        return commodityQty;
    }

    public void setCommodityQty(BigDecimal commodityQty) {
        this.commodityQty = commodityQty;
    }
}
