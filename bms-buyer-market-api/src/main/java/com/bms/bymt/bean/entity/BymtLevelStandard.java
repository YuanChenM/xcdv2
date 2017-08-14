/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_LEVEL_STANDARD对应的实体BymtLevelStandard</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtLevelStandard extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 标准主键 */
    private Long standardId;
    /** 编码 */
    private String standardCode;
    /** 级别 */
    private String standardLevel;
    /** 占地面积 */
    private String coverArea;
    /** 市场年销售额 */
    private String yearAmount;
    /** 最大分类目标买家 */
    private String largestTargetBuyer;
    /** 目标买家总数 */
    private String targetBuyerNum;
    /** 主要买家群体 */
    private String buyerGroups;
    /** 市场辐射范围 */
    private String marketRange;

    /**
     * <p>默认构造函数</p>
     */
    public BymtLevelStandard() {
    }

    /**
     * <p>标准主键</p>
     *
     * @return 标准主键
     */
    public Long getStandardId() {
        return standardId;
    }

    /**
     * <p>标准主键</p>
     *
     * @param standardId 标准主键
     */
    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }
    /**
     * <p>编码</p>
     *
     * @return 编码
     */
    public String getStandardCode() {
        return standardCode;
    }

    /**
     * <p>编码</p>
     *
     * @param standardCode 编码
     */
    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }
    /**
     * <p>级别</p>
     *
     * @return 级别
     */
    public String getStandardLevel() {
        return standardLevel;
    }

    /**
     * <p>级别</p>
     *
     * @param standardLevel 级别
     */
    public void setStandardLevel(String standardLevel) {
        this.standardLevel = standardLevel;
    }
    /**
     * <p>占地面积</p>
     *
     * @return 占地面积
     */
    public String getCoverArea() {
        return coverArea;
    }

    /**
     * <p>占地面积</p>
     *
     * @param coverArea 占地面积
     */
    public void setCoverArea(String coverArea) {
        this.coverArea = coverArea;
    }
    /**
     * <p>市场年销售额</p>
     *
     * @return 市场年销售额
     */
    public String getYearAmount() {
        return yearAmount;
    }

    /**
     * <p>市场年销售额</p>
     *
     * @param yearAmount 市场年销售额
     */
    public void setYearAmount(String yearAmount) {
        this.yearAmount = yearAmount;
    }
    /**
     * <p>最大分类目标买家</p>
     *
     * @return 最大分类目标买家
     */
    public String getLargestTargetBuyer() {
        return largestTargetBuyer;
    }

    /**
     * <p>最大分类目标买家</p>
     *
     * @param largestTargetBuyer 最大分类目标买家
     */
    public void setLargestTargetBuyer(String largestTargetBuyer) {
        this.largestTargetBuyer = largestTargetBuyer;
    }
    /**
     * <p>目标买家总数</p>
     *
     * @return 目标买家总数
     */
    public String getTargetBuyerNum() {
        return targetBuyerNum;
    }

    /**
     * <p>目标买家总数</p>
     *
     * @param targetBuyerNum 目标买家总数
     */
    public void setTargetBuyerNum(String targetBuyerNum) {
        this.targetBuyerNum = targetBuyerNum;
    }
    /**
     * <p>主要买家群体</p>
     *
     * @return 主要买家群体
     */
    public String getBuyerGroups() {
        return buyerGroups;
    }

    /**
     * <p>主要买家群体</p>
     *
     * @param buyerGroups 主要买家群体
     */
    public void setBuyerGroups(String buyerGroups) {
        this.buyerGroups = buyerGroups;
    }
    /**
     * <p>市场辐射范围</p>
     *
     * @return 市场辐射范围
     */
    public String getMarketRange() {
        return marketRange;
    }

    /**
     * <p>市场辐射范围</p>
     *
     * @param marketRange 市场辐射范围
     */
    public void setMarketRange(String marketRange) {
        this.marketRange = marketRange;
    }
}
