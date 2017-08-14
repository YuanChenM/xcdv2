/*
 * 2017/02/17 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.prce.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表PRCE_PRICE_PLATE_HISTORY对应的实体PrcePricePlateHistory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PrcePricePlateHistory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 价盘履历ID */
    private Long pricePlateHistoryId;
    /** 价盘ID */
    private Long pricePlateId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 商品ID */
    private String goodId;
    /** 营销通道ID */
    private Long marketingWayConfigId;
    /** 营销状态ID */
    private Long marketingStatusId;
    /** 用户类型 */
    private String userType;
    /** 买家等级 */
    private String buyerLevel;
    /** 价盘周期开始时间 */
    private java.util.Date startTime;
    /** 价盘周期结束时间 */
    private java.util.Date endTime;
    /** 标准商品定价 */
    private java.math.BigDecimal normPrice;
    /** 所有人类型 */
    private String ownerType;
    /** 所有人ID */
    private Long ownerId;
    /** 所有人名称 */
    private String ownerName;

    /**
     * <p>默认构造函数</p>
     */
    public PrcePricePlateHistory() {
    }

    /**
     * <p>价盘履历ID</p>
     *
     * @return 价盘履历ID
     */
    public Long getPricePlateHistoryId() {
        return pricePlateHistoryId;
    }

    /**
     * <p>价盘履历ID</p>
     *
     * @param pricePlateHistoryId 价盘履历ID
     */
    public void setPricePlateHistoryId(Long pricePlateHistoryId) {
        this.pricePlateHistoryId = pricePlateHistoryId;
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
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param goodId 商品ID
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId;
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
    /**
     * <p>价盘周期开始时间</p>
     *
     * @return 价盘周期开始时间
     */
    public java.util.Date getStartTime() {
        return startTime;
    }

    /**
     * <p>价盘周期开始时间</p>
     *
     * @param startTime 价盘周期开始时间
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }
    /**
     * <p>价盘周期结束时间</p>
     *
     * @return 价盘周期结束时间
     */
    public java.util.Date getEndTime() {
        return endTime;
    }

    /**
     * <p>价盘周期结束时间</p>
     *
     * @param endTime 价盘周期结束时间
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    /**
     * <p>标准商品定价</p>
     *
     * @return 标准商品定价
     */
    public java.math.BigDecimal getNormPrice() {
        return normPrice;
    }

    /**
     * <p>标准商品定价</p>
     *
     * @param normPrice 标准商品定价
     */
    public void setNormPrice(java.math.BigDecimal normPrice) {
        this.normPrice = normPrice;
    }
    /**
     * <p>所有人类型</p>
     *
     * @return 所有人类型
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>所有人类型</p>
     *
     * @param ownerType 所有人类型
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    /**
     * <p>所有人ID</p>
     *
     * @return 所有人ID
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * <p>所有人ID</p>
     *
     * @param ownerId 所有人ID
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>所有人名称</p>
     *
     * @return 所有人名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * <p>所有人名称</p>
     *
     * @param ownerName 所有人名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

}
