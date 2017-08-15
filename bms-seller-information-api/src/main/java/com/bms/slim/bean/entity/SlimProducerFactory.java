/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_producer_factory对应的实体SlimProducerFactory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimProducerFactory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 生产商工厂ID */
    private Long factoryId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 总资产 */
    private java.math.BigDecimal totalAsset;
    /** 注册资本 */
    private java.math.BigDecimal registeredCapital;
    /** 占地面积 */
    private java.math.BigDecimal coveredArea;
    /** 厂房面积 */
    private java.math.BigDecimal workshopArea;
    /** 主要设备 */
    private String majorEquipment;
    /** 设计产能 */
    private String designCapacity;
    /** 外贸销售占比 */
    private String exportSalePercent;
    /** 自销占比 */
    private String selfSalePercent;
    /** 代理销售占比 */
    private String agentSalePercent;
    /** 厂区照(远景)URL */
    private String factoryPicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimProducerFactory() {
    }

    /**
     * <p>生产商工厂ID</p>
     *
     * @return 生产商工厂ID
     */
    public Long getFactoryId() {
        return factoryId;
    }

    /**
     * <p>生产商工厂ID</p>
     *
     * @param factoryId 生产商工厂ID
     */
    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }
    /**
     * <p>卖家角色ID</p>
     *
     * @return 卖家角色ID
     */
    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @param sellerRoleId 卖家角色ID
     */
    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }
    /**
     * <p>总资产</p>
     *
     * @return 总资产
     */
    public java.math.BigDecimal getTotalAsset() {
        return totalAsset;
    }

    /**
     * <p>总资产</p>
     *
     * @param totalAsset 总资产
     */
    public void setTotalAsset(java.math.BigDecimal totalAsset) {
        this.totalAsset = totalAsset;
    }
    /**
     * <p>注册资本</p>
     *
     * @return 注册资本
     */
    public java.math.BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * <p>注册资本</p>
     *
     * @param registeredCapital 注册资本
     */
    public void setRegisteredCapital(java.math.BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }
    /**
     * <p>占地面积</p>
     *
     * @return 占地面积
     */
    public java.math.BigDecimal getCoveredArea() {
        return coveredArea;
    }

    /**
     * <p>占地面积</p>
     *
     * @param coveredArea 占地面积
     */
    public void setCoveredArea(java.math.BigDecimal coveredArea) {
        this.coveredArea = coveredArea;
    }
    /**
     * <p>厂房面积</p>
     *
     * @return 厂房面积
     */
    public java.math.BigDecimal getWorkshopArea() {
        return workshopArea;
    }

    /**
     * <p>厂房面积</p>
     *
     * @param workshopArea 厂房面积
     */
    public void setWorkshopArea(java.math.BigDecimal workshopArea) {
        this.workshopArea = workshopArea;
    }
    /**
     * <p>主要设备</p>
     *
     * @return 主要设备
     */
    public String getMajorEquipment() {
        return majorEquipment;
    }

    /**
     * <p>主要设备</p>
     *
     * @param majorEquipment 主要设备
     */
    public void setMajorEquipment(String majorEquipment) {
        this.majorEquipment = majorEquipment;
    }
    /**
     * <p>设计产能</p>
     *
     * @return 设计产能
     */
    public String getDesignCapacity() {
        return designCapacity;
    }

    /**
     * <p>设计产能</p>
     *
     * @param designCapacity 设计产能
     */
    public void setDesignCapacity(String designCapacity) {
        this.designCapacity = designCapacity;
    }
    /**
     * <p>外贸销售占比</p>
     *
     * @return 外贸销售占比
     */
    public String getExportSalePercent() {
        return exportSalePercent;
    }

    /**
     * <p>外贸销售占比</p>
     *
     * @param exportSalePercent 外贸销售占比
     */
    public void setExportSalePercent(String exportSalePercent) {
        this.exportSalePercent = exportSalePercent;
    }
    /**
     * <p>自销占比</p>
     *
     * @return 自销占比
     */
    public String getSelfSalePercent() {
        return selfSalePercent;
    }

    /**
     * <p>自销占比</p>
     *
     * @param selfSalePercent 自销占比
     */
    public void setSelfSalePercent(String selfSalePercent) {
        this.selfSalePercent = selfSalePercent;
    }
    /**
     * <p>代理销售占比</p>
     *
     * @return 代理销售占比
     */
    public String getAgentSalePercent() {
        return agentSalePercent;
    }

    /**
     * <p>代理销售占比</p>
     *
     * @param agentSalePercent 代理销售占比
     */
    public void setAgentSalePercent(String agentSalePercent) {
        this.agentSalePercent = agentSalePercent;
    }
    /**
     * <p>厂区照(远景)URL</p>
     *
     * @return 厂区照(远景)URL
     */
    public String getFactoryPicUrl() {
        return factoryPicUrl;
    }

    /**
     * <p>厂区照(远景)URL</p>
     *
     * @param factoryPicUrl 厂区照(远景)URL
     */
    public void setFactoryPicUrl(String factoryPicUrl) {
        this.factoryPicUrl = factoryPicUrl;
    }

}
