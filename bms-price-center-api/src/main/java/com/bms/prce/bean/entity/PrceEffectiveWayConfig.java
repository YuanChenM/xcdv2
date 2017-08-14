/*
 * 2017/01/24 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.prce.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表PRCE_EFFECTIVE_WAY_CONFIG对应的实体PrceEffectiveWayConfig</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PrceEffectiveWayConfig extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 有效通道配置ID
     */
    private Long wayEffectiveConfigId;
    /**
     * 通道配置ID
     */
    private Long wayConfigId;
    /**
     * 营销通道ID
     */
    private Long marketingWayConfigId;
    /**
     * 通道分类ID
     */
    private Long wayTypeId;
    /**
     * 通道等级平衡系数
     */
    private java.math.BigDecimal balanceRatio;
    /**
     * 平台分配系数
     */
    private java.math.BigDecimal platBalanceRatio;
    /**
     * 买手分配系数
     */
    private java.math.BigDecimal saBalanceRatio;
    /**
     * 账期总平衡系数
     */
    private java.math.BigDecimal sumBalanceRatio;
    /**
     * 通道准入开始数量
     */
    private Integer startQty;
    /**
     * 通道准入结束数量
     */
    private Integer endQty;

    /**
     * <p>默认构造函数</p>
     */
    public PrceEffectiveWayConfig() {
    }

    /**
     * <p>有效通道配置ID</p>
     *
     * @return 有效通道配置ID
     */
    public Long getWayEffectiveConfigId() {
        return wayEffectiveConfigId;
    }

    /**
     * <p>有效通道配置ID</p>
     *
     * @param wayEffectiveConfigId 有效通道配置ID
     */
    public void setWayEffectiveConfigId(Long wayEffectiveConfigId) {
        this.wayEffectiveConfigId = wayEffectiveConfigId;
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
     * <p>营销通道ID</p>
     *
     * @return 营销通道ID
     */
    public Long getMarketingWayConfigId() {
        return marketingWayConfigId;
    }

    /**
     * <p>营销通道ID</p>
     *
     * @param marketingWayConfigId 营销通道ID
     */
    public void setMarketingWayConfigId(Long marketingWayConfigId) {
        this.marketingWayConfigId = marketingWayConfigId;
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
     * <p>平台分配系数</p>
     *
     * @return 平台分配系数
     */
    public java.math.BigDecimal getPlatBalanceRatio() {
        return platBalanceRatio;
    }

    /**
     * <p>平台分配系数</p>
     *
     * @param platBalanceRatio 平台分配系数
     */
    public void setPlatBalanceRatio(java.math.BigDecimal platBalanceRatio) {
        this.platBalanceRatio = platBalanceRatio;
    }

    /**
     * <p>买手分配系数</p>
     *
     * @return 买手分配系数
     */
    public java.math.BigDecimal getSaBalanceRatio() {
        return saBalanceRatio;
    }

    /**
     * <p>买手分配系数</p>
     *
     * @param saBalanceRatio 买手分配系数
     */
    public void setSaBalanceRatio(java.math.BigDecimal saBalanceRatio) {
        this.saBalanceRatio = saBalanceRatio;
    }

    /**
     * <p>账期总平衡系数</p>
     *
     * @return 账期总平衡系数
     */
    public java.math.BigDecimal getSumBalanceRatio() {
        return sumBalanceRatio;
    }

    /**
     * <p>账期总平衡系数</p>
     *
     * @param sumBalanceRatio 账期总平衡系数
     */
    public void setSumBalanceRatio(java.math.BigDecimal sumBalanceRatio) {
        this.sumBalanceRatio = sumBalanceRatio;
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

}
