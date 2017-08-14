/*
 * 2017/04/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_commodity_info对应的实体ComoCommodityInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoCommodityInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 商品ID */
    private Long commodityId;
    /** 产品主键ID */
    private Long productPid;
    /** 销售状态 */
    private Long saleStatusId;
    /** 销售状态描述 */
    private String saleStatusDesc;
    /** 商品ID */
    private String commodityCode;
    /** 商品名称 */
    private String commodityName;
    /** 是否是产品下默认商品 */
    private Boolean isDefault;
    /** 是否有效 */
    private Boolean isValid;
    /** 是否开放给买手 */
    private Boolean isOpenToAgent;

    /**
     * <p>默认构造函数</p>
     */
    public ComoCommodityInfo() {
    }

    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
    /**
     * <p>产品主键ID</p>
     *
     * @return 产品主键ID
     */
    public Long getProductPid() {
        return productPid;
    }

    /**
     * <p>产品主键ID</p>
     *
     * @param productPid 产品主键ID
     */
    public void setProductPid(Long productPid) {
        this.productPid = productPid;
    }
    /**
     * <p>销售状态</p>
     *
     * @return 销售状态
     */
    public Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * <p>销售状态</p>
     *
     * @param saleStatusId 销售状态
     */
    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }
    /**
     * <p>销售状态描述</p>
     *
     * @return 销售状态描述
     */
    public String getSaleStatusDesc() {
        return saleStatusDesc;
    }

    /**
     * <p>销售状态描述</p>
     *
     * @param saleStatusDesc 销售状态描述
     */
    public void setSaleStatusDesc(String saleStatusDesc) {
        this.saleStatusDesc = saleStatusDesc;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityCode 商品ID
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }
    /**
     * <p>商品名称</p>
     *
     * @return 商品名称
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * <p>商品名称</p>
     *
     * @param commodityName 商品名称
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    /**
     * <p>是否是产品下默认商品</p>
     *
     * @return 是否是产品下默认商品
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * <p>是否是产品下默认商品</p>
     *
     * @param isDefault 是否是产品下默认商品
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
    /**
     * <p>是否有效</p>
     *
     * @return 是否有效
     */
    public Boolean getIsValid() {
        return isValid;
    }

    /**
     * <p>是否有效</p>
     *
     * @param isValid 是否有效
     */
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
    /**
     * <p>是否开放给买手</p>
     *
     * @return 是否开放给买手
     */
    public Boolean getIsOpenToAgent() {
        return isOpenToAgent;
    }

    /**
     * <p>是否开放给买手</p>
     *
     * @param isOpenToAgent 是否开放给买手
     */
    public void setIsOpenToAgent(Boolean isOpenToAgent) {
        this.isOpenToAgent = isOpenToAgent;
    }

}
