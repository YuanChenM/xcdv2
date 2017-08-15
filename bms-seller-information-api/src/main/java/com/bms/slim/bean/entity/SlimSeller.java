/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_SELLER对应的实体SlimSeller</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSeller extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家ID */
    private Long sellerId;
    /** 卖家编码 */
    private String sellerCode;
    /** 销售类型，1：集中定价， 2：独立定价 */
    private String saleType;
    /** 实体卖家ID */
    private Long entitySellerId;

    /**
     * <p>默认构造函数</p>
     */
    public SlimSeller() {
    }

    /**
     * <p>卖家ID</p>
     *
     * @return 卖家ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * <p>卖家ID</p>
     *
     * @param sellerId 卖家ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    /**
     * <p>卖家编码</p>
     *
     * @return 卖家编码
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>卖家编码</p>
     *
     * @param sellerCode 卖家编码
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
    /**
     * <p>销售类型，1：集中定价， 2：独立定价</p>
     *
     * @return 销售类型，1：集中定价， 2：独立定价
     */
    public String getSaleType() {
        return saleType;
    }

    /**
     * <p>销售类型，1：集中定价， 2：独立定价</p>
     *
     * @param saleType 销售类型，1：集中定价， 2：独立定价
     */
    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }
    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

}
