/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_SELLER_BRAND对应的实体SlimSellerBrand</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerBrand extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家品牌ID */
    private Long sellerBrandId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 品牌ID */
    private Long brandId;
    /** 品牌版权类型，1：自有品牌，2：代理品牌 */
    private String copyrightType;
    /** 代理及分销授权合同号 */
    private String agcyDistAuzContNo;
    /** 代理及分销授权合同URL */
    private String agcyDistAuzContUrl;
    /** 授权期开始时间 */
    private java.util.Date startAuzDate;
    /** 授权期结束时间 */
    private java.util.Date endAuzDate;

    /**
     * <p>默认构造函数</p>
     */
    public SlimSellerBrand() {
    }

    /**
     * <p>卖家品牌ID</p>
     *
     * @return 卖家品牌ID
     */
    public Long getSellerBrandId() {
        return sellerBrandId;
    }

    /**
     * <p>卖家品牌ID</p>
     *
     * @param sellerBrandId 卖家品牌ID
     */
    public void setSellerBrandId(Long sellerBrandId) {
        this.sellerBrandId = sellerBrandId;
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
    /**
     * <p>品牌ID</p>
     *
     * @return 品牌ID
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * <p>品牌ID</p>
     *
     * @param brandId 品牌ID
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    /**
     * <p>品牌版权类型，1：自有品牌，2：代理品牌</p>
     *
     * @return 品牌版权类型，1：自有品牌，2：代理品牌
     */
    public String getCopyrightType() {
        return copyrightType;
    }

    /**
     * <p>品牌版权类型，1：自有品牌，2：代理品牌</p>
     *
     * @param copyrightType 品牌版权类型，1：自有品牌，2：代理品牌
     */
    public void setCopyrightType(String copyrightType) {
        this.copyrightType = copyrightType;
    }
    /**
     * <p>代理及分销授权合同号</p>
     *
     * @return 代理及分销授权合同号
     */
    public String getAgcyDistAuzContNo() {
        return agcyDistAuzContNo;
    }

    /**
     * <p>代理及分销授权合同号</p>
     *
     * @param agcyDistAuzContNo 代理及分销授权合同号
     */
    public void setAgcyDistAuzContNo(String agcyDistAuzContNo) {
        this.agcyDistAuzContNo = agcyDistAuzContNo;
    }
    /**
     * <p>代理及分销授权合同URL</p>
     *
     * @return 代理及分销授权合同URL
     */
    public String getAgcyDistAuzContUrl() {
        return agcyDistAuzContUrl;
    }

    /**
     * <p>代理及分销授权合同URL</p>
     *
     * @param agcyDistAuzContUrl 代理及分销授权合同URL
     */
    public void setAgcyDistAuzContUrl(String agcyDistAuzContUrl) {
        this.agcyDistAuzContUrl = agcyDistAuzContUrl;
    }
    /**
     * <p>授权期开始时间</p>
     *
     * @return 授权期开始时间
     */
    public java.util.Date getStartAuzDate() {
        return startAuzDate;
    }

    /**
     * <p>授权期开始时间</p>
     *
     * @param startAuzDate 授权期开始时间
     */
    public void setStartAuzDate(java.util.Date startAuzDate) {
        this.startAuzDate = startAuzDate;
    }
    /**
     * <p>授权期结束时间</p>
     *
     * @return 授权期结束时间
     */
    public java.util.Date getEndAuzDate() {
        return endAuzDate;
    }

    /**
     * <p>授权期结束时间</p>
     *
     * @param endAuzDate 授权期结束时间
     */
    public void setEndAuzDate(java.util.Date endAuzDate) {
        this.endAuzDate = endAuzDate;
    }

}
