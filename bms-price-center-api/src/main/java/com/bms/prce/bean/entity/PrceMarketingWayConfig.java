/*
 * 2017/01/24 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.prce.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表PRCE_MARKETING_WAY_CONFIG对应的实体PrceMarketingWayConfig</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PrceMarketingWayConfig extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 营销通道ID
     */
    private Long marketingWayConfigId;
    /**
     * 营销状态ID
     */
    private Long marketingStatusId;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 买家等级
     */
    private String buyerLevel;

    /**
     * <p>默认构造函数</p>
     */
    public PrceMarketingWayConfig() {
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
     * <p>营销状态ID</p>
     *
     * @return 营销状态ID
     */
    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    /**
     * <p>营销状态ID</p>
     *
     * @param marketingStatusId 营销状态ID
     */
    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    /**
     * <p>用户类型</p>
     *
     * @return 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * <p>用户类型</p>
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * <p>买家等级</p>
     *
     * @return 买家等级
     */
    public String getBuyerLevel() {
        return buyerLevel;
    }

    /**
     * <p>买家等级</p>
     *
     * @param buyerLevel 买家等级
     */
    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

}
