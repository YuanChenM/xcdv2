package com.bms.order.bean;

import java.math.BigDecimal;
import java.util.Date;

public class BuyerBatchOrderDetailSummary {
    /** 明细：商品单位 [CodeMaster KG/箱] */
    private String goodsUnit;

    /**
     * 获取明细：商品单位 [CodeMaster KG/箱]
     * 
     * @return 明细：商品单位 [CodeMaster KG/箱]
     */
    public String getGoodsUnit() {
        return this.goodsUnit;
    }

    /**
     * 设置明细：商品单位 [CodeMaster KG/箱]
     * 
     * @param goodsUnit
     */
    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    /** 明细：商品数量 */
    private BigDecimal goodsQuantity;

    /**
     * 获取明细：商品数量
     * 
     * @return 明细：商品数量
     */
    public BigDecimal getGoodsQuantity() {
        return this.goodsQuantity;
    }

    /**
     * 设置明细：商品数量
     * 
     * @param goodsQuantity
     */
    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    /** 明细：取消数量 */
    private BigDecimal cancelQuantity;

    /**
     * 获取明细：取消数量
     * 
     * @return 明细：取消数量
     */
    public BigDecimal getCancelQuantity() {
        return this.cancelQuantity;
    }

    /**
     * 设置明细：取消数量
     * 
     * @param cancelQuantity
     */
    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    /** 价盘：下单时单位价格 */
    private BigDecimal orderCreateUnitPrice;

    /**
     * 获取价盘：下单时单位价格
     * 
     * @return 价盘：下单时单位价格
     */
    public BigDecimal getOrderCreateUnitPrice() {
        return this.orderCreateUnitPrice;
    }

    /**
     * 设置价盘：下单时单位价格
     * 
     * @param orderCreateUnitPrice
     */
    public void setOrderCreateUnitPrice(BigDecimal orderCreateUnitPrice) {
        this.orderCreateUnitPrice = orderCreateUnitPrice;
    }

    /** 价盘：下单时千克价格 */
    private BigDecimal orderCreateKgPrice;

    /**
     * 获取价盘：下单时千克价格
     * 
     * @return 价盘：下单时千克价格
     */
    public BigDecimal getOrderCreateKgPrice() {
        return this.orderCreateKgPrice;
    }

    /**
     * 设置价盘：下单时千克价格
     * 
     * @param orderCreateKgPrice
     */
    public void setOrderCreateKgPrice(BigDecimal orderCreateKgPrice) {
        this.orderCreateKgPrice = orderCreateKgPrice;
    }

    /** 价盘：实际单价 */
    private BigDecimal realUnitPrice;

    /**
     * 获取价盘：实际单价
     * 
     * @return 价盘：实际单价
     */
    public BigDecimal getRealUnitPrice() {
        return this.realUnitPrice;
    }

    /**
     * 设置价盘：实际单价
     * 
     * @param realUnitPrice
     */
    public void setRealUnitPrice(BigDecimal realUnitPrice) {
        this.realUnitPrice = realUnitPrice;
    }

    /** 价盘：实际千克价格 */
    private BigDecimal realKgPrice;

    /**
     * 获取价盘：实际千克价格
     * 
     * @return 价盘：实际千克价格
     */
    public BigDecimal getRealKgPrice() {
        return this.realKgPrice;
    }

    /**
     * 设置价盘：实际千克价格
     * 
     * @param realKgPrice
     */
    public void setRealKgPrice(BigDecimal realKgPrice) {
        this.realKgPrice = realKgPrice;
    }

    /** 价盘：首次价盘获取时间 */
    private Date priceCreateTime;

    /**
     * 获取价盘：首次价盘获取时间
     * 
     * @return 价盘：首次价盘获取时间
     */
    public Date getPriceCreateTime() {
        return this.priceCreateTime;
    }

    /**
     * 设置价盘：首次价盘获取时间
     * 
     * @param priceCreateTime
     */
    public void setPriceCreateTime(Date priceCreateTime) {
        this.priceCreateTime = priceCreateTime;
    }

    /** 价盘：价格通道 */
    private String priceWay;

    /**
     * 获取价盘：价格通道
     * 
     * @return 价盘：价格通道
     */
    public String getPriceWay() {
        return this.priceWay;
    }

    /**
     * 设置价盘：价格通道
     * 
     * @param priceWay
     */
    public void setPriceWay(String priceWay) {
        this.priceWay = priceWay;
    }

    /** 商品：商品ID [任意一级可销售层级+销售标签] */
    private String goodsId;

    /**
     * 获取商品：商品ID [任意一级可销售层级+销售标签]
     * 
     * @return 商品：商品ID [任意一级可销售层级+销售标签]
     */
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置商品：商品ID [任意一级可销售层级+销售标签]
     * 
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
