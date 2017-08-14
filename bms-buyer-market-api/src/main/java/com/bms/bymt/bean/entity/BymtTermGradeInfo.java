/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;
/**
 * <p>表BYMT_TERM_GRADE_INFO对应的实体BymtTermGradeInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtTermGradeInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 定级详情主键 */
    private Long gradeInfoId;
    /** 批发市场UUID */
    private String termMarketId;
    /** 依托大型冷库(依托) */
    private Boolean isSupport;
    /** 占地面积(单位:亩) */
    private Integer coverArea;
    /** 市场面积级别标准 */
    private String coverAreaStandard;
    /** 年销售额(单位:元) 展示到亿元 */
    private Long yearAmount;
    /** 销售额级别标准 */
    private String yearAmountStandard;
    /** 目标买家最大分类产品 */
    private String largestTargetPro;
    /** 目标买家最大分类买家数(单位:户) */
    private Integer largestTargetNum;
    /** 目标买家最大分类级别标准 */
    private String largestTargetStandard;
    /** 目标买家消费卖家标准 */
    private String targetConsumerNumStandard;
    /** 目标买家消费卖家数(单位:户) */
    private Integer targetConsumerNum;
    /** 批发市场目标买家分级类型 */
    private String marketTargetLevelType;
    /** 批发市场目标买家分级级别标准 */
    private String marketTargetLevelStandard;
    /** 批发市场辐射范围 */
    private String marketCoverArea;
    /** 批发市场辐射范围级别标准 */
    private String marketCoverAreaStandard;
    /** 批发市场定性类别 */
    private String marketNatureRank;

    /**
     * <p>默认构造函数</p>
     */
    public BymtTermGradeInfo() {
    }

    /**
     * <p>定级详情主键</p>
     *
     * @return 定级详情主键
     */
    public Long getGradeInfoId() {
        return gradeInfoId;
    }

    /**
     * <p>定级详情主键</p>
     *
     * @param gradeInfoId 定级详情主键
     */
    public void setGradeInfoId(Long gradeInfoId) {
        this.gradeInfoId = gradeInfoId;
    }
    /**
     * <p>批发市场UUID</p>
     *
     * @return 批发市场UUID
     */
    public String getTermMarketId() {
        return termMarketId;
    }

    /**
     * <p>批发市场UUID</p>
     *
     * @param termMarketId 批发市场UUID
     */
    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }
    /**
     * <p>依托大型冷库(依托)</p>
     *
     * @return 依托大型冷库(依托)
     */
    /*public boolean getIsSupport() {
        return isSupport;
    }

    *//**
     * <p>依托大型冷库(依托)</p>
     *
     * @param isSupport 依托大型冷库(依托)
     *//*
    public void setIsSupport(boolean isSupport) {
        this.isSupport = isSupport;
    }*/

    public Boolean getIsSupport() {
        return isSupport;
    }

    public void setIsSupport(Boolean isSupport) {
        this.isSupport = isSupport;
    }

    /**
     * <p>占地面积(单位:亩)</p>
     *
     * @return 占地面积(单位:亩)
     */
    public Integer getCoverArea() {
        return coverArea;
    }

    /**
     * <p>占地面积(单位:亩)</p>
     *
     * @param coverArea 占地面积(单位:亩)
     */
    public void setCoverArea(Integer coverArea) {
        this.coverArea = coverArea;
    }
    /**
     * <p>市场面积级别标准</p>
     *
     * @return 市场面积级别标准
     */
    public String getCoverAreaStandard() {
        return coverAreaStandard;
    }

    /**
     * <p>市场面积级别标准</p>
     *
     * @param coverAreaStandard 市场面积级别标准
     */
    public void setCoverAreaStandard(String coverAreaStandard) {
        this.coverAreaStandard = coverAreaStandard;
    }
    /**
     * <p>年销售额(单位:元) 展示到亿元</p>
     *
     * @return 年销售额(单位:元) 展示到亿元
     */
    public Long getYearAmount() {
        return yearAmount;
    }

    /**
     * <p>年销售额(单位:元) 展示到亿元</p>
     *
     * @param yearAmount 年销售额(单位:元) 展示到亿元
     */
    public void setYearAmount(Long yearAmount) {
        this.yearAmount = yearAmount;
    }
    /**
     * <p>销售额级别标准</p>
     *
     * @return 销售额级别标准
     */
    public String getYearAmountStandard() {
        return yearAmountStandard;
    }

    /**
     * <p>销售额级别标准</p>
     *
     * @param yearAmountStandard 销售额级别标准
     */
    public void setYearAmountStandard(String yearAmountStandard) {
        this.yearAmountStandard = yearAmountStandard;
    }
    /**
     * <p>目标买家最大分类产品</p>
     *
     * @return 目标买家最大分类产品
     */
    public String getLargestTargetPro() {
        return largestTargetPro;
    }

    /**
     * <p>目标买家最大分类产品</p>
     *
     * @param largestTargetPro 目标买家最大分类产品
     */
    public void setLargestTargetPro(String largestTargetPro) {
        this.largestTargetPro = largestTargetPro;
    }
    /**
     * <p>目标买家最大分类买家数(单位:户)</p>
     *
     * @return 目标买家最大分类买家数(单位:户)
     */
    public Integer getLargestTargetNum() {
        return largestTargetNum;
    }

    /**
     * <p>目标买家最大分类买家数(单位:户)</p>
     *
     * @param largestTargetNum 目标买家最大分类买家数(单位:户)
     */
    public void setLargestTargetNum(Integer largestTargetNum) {
        this.largestTargetNum = largestTargetNum;
    }
    /**
     * <p>目标买家最大分类级别标准</p>
     *
     * @return 目标买家最大分类级别标准
     */
    public String getLargestTargetStandard() {
        return largestTargetStandard;
    }

    /**
     * <p>目标买家最大分类级别标准</p>
     *
     * @param largestTargetStandard 目标买家最大分类级别标准
     */
    public void setLargestTargetStandard(String largestTargetStandard) {
        this.largestTargetStandard = largestTargetStandard;
    }
    /**
     * <p>目标买家消费卖家数(单位:户)</p>
     *
     * @return 目标买家消费卖家数(单位:户)
     */
    public Integer getTargetConsumerNum() {
        return targetConsumerNum;
    }

    /**
     * <p>目标买家消费卖家数(单位:户)</p>
     *
     * @param targetConsumerNum 目标买家消费卖家数(单位:户)
     */
    public void setTargetConsumerNum(Integer targetConsumerNum) {
        this.targetConsumerNum = targetConsumerNum;
    }
    /**
     * <p>批发市场目标买家分级类型</p>
     *
     * @return 批发市场目标买家分级类型
     */
    public String getMarketTargetLevelType() {
        return marketTargetLevelType;
    }

    /**
     * <p>批发市场目标买家分级类型</p>
     *
     * @param marketTargetLevelType 批发市场目标买家分级类型
     */
    public void setMarketTargetLevelType(String marketTargetLevelType) {
        this.marketTargetLevelType = marketTargetLevelType;
    }
    /**
     * <p>批发市场目标买家分级级别标准</p>
     *
     * @return 批发市场目标买家分级级别标准
     */
    public String getMarketTargetLevelStandard() {
        return marketTargetLevelStandard;
    }

    /**
     * <p>批发市场目标买家分级级别标准</p>
     *
     * @param marketTargetLevelStandard 批发市场目标买家分级级别标准
     */
    public void setMarketTargetLevelStandard(String marketTargetLevelStandard) {
        this.marketTargetLevelStandard = marketTargetLevelStandard;
    }
    /**
     * <p>批发市场辐射范围</p>
     *
     * @return 批发市场辐射范围
     */
    public String getMarketCoverArea() {
        return marketCoverArea;
    }

    /**
     * <p>批发市场辐射范围</p>
     *
     * @param marketCoverArea 批发市场辐射范围
     */
    public void setMarketCoverArea(String marketCoverArea) {
        this.marketCoverArea = marketCoverArea;
    }
    /**
     * <p>批发市场辐射范围级别标准</p>
     *
     * @return 批发市场辐射范围级别标准
     */
    public String getMarketCoverAreaStandard() {
        return marketCoverAreaStandard;
    }

    /**
     * <p>批发市场辐射范围级别标准</p>
     *
     * @param marketCoverAreaStandard 批发市场辐射范围级别标准
     */
    public void setMarketCoverAreaStandard(String marketCoverAreaStandard) {
        this.marketCoverAreaStandard = marketCoverAreaStandard;
    }
    /**
     * <p>批发市场定性类别</p>
     *
     * @return 批发市场定性类别
     */
    public String getMarketNatureRank() {
        return marketNatureRank;
    }

    /**
     * <p>批发市场定性类别</p>
     *
     * @param marketNatureRank 批发市场定性类别
     */
    public void setMarketNatureRank(String marketNatureRank) {
        this.marketNatureRank = marketNatureRank;
    }


    public String getTargetConsumerNumStandard() {
        return targetConsumerNumStandard;
    }

    public void setTargetConsumerNumStandard(String targetConsumerNumStandard) {
        this.targetConsumerNumStandard = targetConsumerNumStandard;
    }
}
