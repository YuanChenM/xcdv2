/*
 * 2017/01/24 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.prce.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表PRCE_WAY_TYPE对应的实体PrceWayType</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PrceWayType extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 通道分类ID
     */
    private Long wayTypeId;
    /**
     * 通道分类名称
     */
    private String wayTypeName;
    /**
     * 价差平台分配系数
     */
    private java.math.BigDecimal priceMarginPlateRatio;
    /**
     * 价差买手分配系数
     */
    private java.math.BigDecimal priceMarginSaRatio;
    /**
     * <p>默认构造函数</p>
     */
    public PrceWayType() {
    }

    /**
     * <p>通道分类ID</p>
     *
     * @return 通道分类ID
     */
    public Long getWayTypeId() {
        return wayTypeId;
    }

    /**
     * <p>通道分类ID</p>
     *
     * @param wayTypeId 通道分类ID
     */
    public void setWayTypeId(Long wayTypeId) {
        this.wayTypeId = wayTypeId;
    }

    /**
     * <p>通道分类名称</p>
     *
     * @return 通道分类名称
     */
    public String getWayTypeName() {
        return wayTypeName;
    }

    /**
     * <p>通道分类名称</p>
     *
     * @param wayTypeName 通道分类名称
     */
    public void setWayTypeName(String wayTypeName) {
        this.wayTypeName = wayTypeName;
    }

    /**
     * <p>价差平台分配系数</p>
     *
     * @return 价差平台分配系数
     */
    public java.math.BigDecimal getPriceMarginPlateRatio() {
        return priceMarginPlateRatio;
    }

    /**
     * <p>价差平台分配系数</p>
     *
     * @param priceMarginPlateRatio 价差平台分配系数
     */
    public void setPriceMarginPlateRatio(java.math.BigDecimal priceMarginPlateRatio) {
        this.priceMarginPlateRatio = priceMarginPlateRatio;
    }

    /**
     * <p>价差买手分配系数</p>
     *
     * @return 价差买手分配系数
     */
    public java.math.BigDecimal getPriceMarginSaRatio() {
        return priceMarginSaRatio;
    }

    /**
     * <p>价差买手分配系数</p>
     *
     * @param priceMarginSaRatio 价差买手分配系数
     */
    public void setPriceMarginSaRatio(java.math.BigDecimal priceMarginSaRatio) {
        this.priceMarginSaRatio = priceMarginSaRatio;
    }
}
