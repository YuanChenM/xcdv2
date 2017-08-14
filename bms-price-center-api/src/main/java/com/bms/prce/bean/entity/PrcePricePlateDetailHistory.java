/*
 * 2017/01/24 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.prce.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表PRCE_PRICE_PLATE_DETAIL_HISTORY对应的实体PrcePricePlateDetailHistory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PrcePricePlateDetailHistory extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 价盘详细履历ID
     */
    private Long pricePlateDetailHistoryId;
    /**
     * 价盘详细ID
     */
    private Long pricePlateDetailId;
    /**
     * 价盘ID
     */
    private Long pricePlateId;
    /**
     * 通道配置ID
     */
    private Long wayConfigId;
    /**
     * 通道分类ID
     */
    private Long wayTypeId;
    /**
     * 通道等级平衡系数
     */
    private java.math.BigDecimal balanceRatio;
    /**
     * 通道准入开始数量
     */
    private Integer startQty;
    /**
     * 通道准入结束数量
     */
    private Integer endQty;
    /**
     * 单位
     */
    private String uom;
    /**
     * 系统生成价格
     */
    private java.math.BigDecimal systemGeneratePrice;
    /**
     * 实际价格
     */
    private java.math.BigDecimal factPrice;

    /**
     * <p>默认构造函数</p>
     */
    public PrcePricePlateDetailHistory() {
    }

    /**
     * <p>价盘详细履历ID</p>
     *
     * @return 价盘详细履历ID
     */
    public Long getPricePlateDetailHistoryId() {
        return pricePlateDetailHistoryId;
    }

    /**
     * <p>价盘详细履历ID</p>
     *
     * @param pricePlateDetailHistoryId 价盘详细履历ID
     */
    public void setPricePlateDetailHistoryId(Long pricePlateDetailHistoryId) {
        this.pricePlateDetailHistoryId = pricePlateDetailHistoryId;
    }

    /**
     * <p>价盘详细ID</p>
     *
     * @return 价盘详细ID
     */
    public Long getPricePlateDetailId() {
        return pricePlateDetailId;
    }

    /**
     * <p>价盘详细ID</p>
     *
     * @param pricePlateDetailId 价盘详细ID
     */
    public void setPricePlateDetailId(Long pricePlateDetailId) {
        this.pricePlateDetailId = pricePlateDetailId;
    }

    /**
     * <p>价盘ID</p>
     *
     * @return 价盘ID
     */
    public Long getPricePlateId() {
        return pricePlateId;
    }

    /**
     * <p>价盘ID</p>
     *
     * @param pricePlateId 价盘ID
     */
    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

    /**
     * <p>通道配置ID</p>
     *
     * @return 通道配置ID
     */
    public Long getWayConfigId() {
        return wayConfigId;
    }

    /**
     * <p>通道配置ID</p>
     *
     * @param wayConfigId 通道配置ID
     */
    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
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
     * <p>通道等级平衡系数</p>
     *
     * @return 通道等级平衡系数
     */
    public java.math.BigDecimal getBalanceRatio() {
        return balanceRatio;
    }

    /**
     * <p>通道等级平衡系数</p>
     *
     * @param balanceRatio 通道等级平衡系数
     */
    public void setBalanceRatio(java.math.BigDecimal balanceRatio) {
        this.balanceRatio = balanceRatio;
    }

    /**
     * <p>通道准入开始数量</p>
     *
     * @return 通道准入开始数量
     */
    public Integer getStartQty() {
        return startQty;
    }

    /**
     * <p>通道准入开始数量</p>
     *
     * @param startQty 通道准入开始数量
     */
    public void setStartQty(Integer startQty) {
        this.startQty = startQty;
    }

    /**
     * <p>通道准入结束数量</p>
     *
     * @return 通道准入结束数量
     */
    public Integer getEndQty() {
        return endQty;
    }

    /**
     * <p>通道准入结束数量</p>
     *
     * @param endQty 通道准入结束数量
     */
    public void setEndQty(Integer endQty) {
        this.endQty = endQty;
    }

    /**
     * <p>单位</p>
     *
     * @return 单位
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>单位</p>
     *
     * @param uom 单位
     */
    public void setUom(String uom) {
        this.uom = uom;
    }

    /**
     * <p>系统生成价格</p>
     *
     * @return 系统生成价格
     */
    public java.math.BigDecimal getSystemGeneratePrice() {
        return systemGeneratePrice;
    }

    /**
     * <p>系统生成价格</p>
     *
     * @param systemGeneratePrice 系统生成价格
     */
    public void setSystemGeneratePrice(java.math.BigDecimal systemGeneratePrice) {
        this.systemGeneratePrice = systemGeneratePrice;
    }

    /**
     * <p>实际价格</p>
     *
     * @return 实际价格
     */
    public java.math.BigDecimal getFactPrice() {
        return factPrice;
    }

    /**
     * <p>实际价格</p>
     *
     * @param factPrice 实际价格
     */
    public void setFactPrice(java.math.BigDecimal factPrice) {
        this.factPrice = factPrice;
    }

}
