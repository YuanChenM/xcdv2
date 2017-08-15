/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_COMMODITY对应的实体SlpdCommodity</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdCommodity extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long id;
    /** 商品ID */
    private String commodityId;
    /** 产品ID */
    private String productId;
    /** 销售类型，1：集中定价， 2：独立定价 */
    private String saleType;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdCommodity() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>主键ID</p>
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
    /**
     * <p>产品ID</p>
     *
     * @return 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * <p>产品ID</p>
     *
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
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

}
