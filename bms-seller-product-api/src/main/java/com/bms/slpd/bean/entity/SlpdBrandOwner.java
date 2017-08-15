/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_BRAND_OWNER对应的实体SlpdBrandOwner</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdBrandOwner extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 品牌所有人ID */
    private Long brandOwnerId;
    /** 品牌所有人编码 */
    private String brandOwnerCode;
    /** 品牌所有人名称 */
    private String ownerName;
    /** 品牌所有人类型，1：生产商，2：制造商 */
    private String ownerType;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdBrandOwner() {
    }

    /**
     * <p>品牌所有人ID</p>
     *
     * @return 品牌所有人ID
     */
    public Long getBrandOwnerId() {
        return brandOwnerId;
    }

    /**
     * <p>品牌所有人ID</p>
     *
     * @param brandOwnerId 品牌所有人ID
     */
    public void setBrandOwnerId(Long brandOwnerId) {
        this.brandOwnerId = brandOwnerId;
    }
    /**
     * <p>品牌所有人编码</p>
     *
     * @return 品牌所有人编码
     */
    public String getBrandOwnerCode() {
        return brandOwnerCode;
    }

    /**
     * <p>品牌所有人编码</p>
     *
     * @param brandOwnerCode 品牌所有人编码
     */
    public void setBrandOwnerCode(String brandOwnerCode) {
        this.brandOwnerCode = brandOwnerCode;
    }
    /**
     * <p>品牌所有人名称</p>
     *
     * @return 品牌所有人名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * <p>品牌所有人名称</p>
     *
     * @param ownerName 品牌所有人名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    /**
     * <p>品牌所有人类型，1：生产商，2：制造商</p>
     *
     * @return 品牌所有人类型，1：生产商，2：制造商
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>品牌所有人类型，1：生产商，2：制造商</p>
     *
     * @param ownerType 品牌所有人类型，1：生产商，2：制造商
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

}
