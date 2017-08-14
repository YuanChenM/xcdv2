/*
 * 2017/01/10 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bypo.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYPO_PRODUCT_SALE对应的实体BypoProductSale</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BypoProductSale extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** PRODUCT_SALE_ID */
    private java.lang.Long productSaleId;
    /** RESEARCH_PRODUCT_ID */
    private java.lang.Long researchProductId;
    /** SALE_DATE */
    private java.util.Date saleDate;
    /** SALE_AMOUNT */
    private java.lang.Integer saleAmount;
    /** PRICE */
    private java.math.BigDecimal price;
    /** PRICE_CHANNEL */
    private java.lang.String priceChannel;
    /** CUSTOMER */
    private java.lang.String customer;

    /**
     * <p>默认构造函数</p>
     */
    public BypoProductSale() {
    }

    /**
     * <p>PRODUCT_SALE_ID</p>
     *
     * @return PRODUCT_SALE_ID
     */
    public java.lang.Long getProductSaleId() {
        return productSaleId;
    }

    /**
     * <p>PRODUCT_SALE_ID</p>
     *
     * @param productSaleId PRODUCT_SALE_ID
     */
    public void setProductSaleId(java.lang.Long productSaleId) {
        this.productSaleId = productSaleId;
    }
    /**
     * <p>RESEARCH_PRODUCT_ID</p>
     *
     * @return RESEARCH_PRODUCT_ID
     */
    public java.lang.Long getResearchProductId() {
        return researchProductId;
    }

    /**
     * <p>RESEARCH_PRODUCT_ID</p>
     *
     * @param researchProductId RESEARCH_PRODUCT_ID
     */
    public void setResearchProductId(java.lang.Long researchProductId) {
        this.researchProductId = researchProductId;
    }
    /**
     * <p>SALE_DATE</p>
     *
     * @return SALE_DATE
     */
    public java.util.Date getSaleDate() {
        return saleDate;
    }

    /**
     * <p>SALE_DATE</p>
     *
     * @param saleDate SALE_DATE
     */
    public void setSaleDate(java.util.Date saleDate) {
        this.saleDate = saleDate;
    }
    /**
     * <p>SALE_AMOUNT</p>
     *
     * @return SALE_AMOUNT
     */
    public java.lang.Integer getSaleAmount() {
        return saleAmount;
    }

    /**
     * <p>SALE_AMOUNT</p>
     *
     * @param saleAmount SALE_AMOUNT
     */
    public void setSaleAmount(java.lang.Integer saleAmount) {
        this.saleAmount = saleAmount;
    }
    /**
     * <p>PRICE</p>
     *
     * @return PRICE
     */
    public java.math.BigDecimal getPrice() {
        return price;
    }

    /**
     * <p>PRICE</p>
     *
     * @param price PRICE
     */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }
    /**
     * <p>PRICE_CHANNEL</p>
     *
     * @return PRICE_CHANNEL
     */
    public java.lang.String getPriceChannel() {
        return priceChannel;
    }

    /**
     * <p>PRICE_CHANNEL</p>
     *
     * @param priceChannel PRICE_CHANNEL
     */
    public void setPriceChannel(java.lang.String priceChannel) {
        this.priceChannel = priceChannel;
    }
    /**
     * <p>CUSTOMER</p>
     *
     * @return CUSTOMER
     */
    public java.lang.String getCustomer() {
        return customer;
    }

    /**
     * <p>CUSTOMER</p>
     *
     * @param customer CUSTOMER
     */
    public void setCustomer(java.lang.String customer) {
        this.customer = customer;
    }

}
