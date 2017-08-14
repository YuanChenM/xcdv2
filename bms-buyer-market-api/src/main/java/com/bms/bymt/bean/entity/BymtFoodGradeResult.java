/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_FOOD_GRADE_RESULT对应的实体BymtFoodGradeResult</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtFoodGradeResult extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 定级结果主键 */
    private Long gradeResultId;
    /** 定级详情ID */
    private Long gradeInfoId;
    /** 买家数最多的分类产品 */
    private String buyerLargestPro;
    /** 买家最大分类产品个数 */
    private Integer buyerLargestNum;
    /** 买家平均定价 */
    private String averagePrice;
    /** 菜场级别 */
    private String foodMarketLevel;
    /** 辐射范围 */
    private String marketRange;


    /**
     * <p>默认构造函数</p>
     */
    public BymtFoodGradeResult() {
    }

    /**
     * <p>定级结果主键</p>
     *
     * @return 定级结果主键
     */
    public Long getGradeResultId() {
        return gradeResultId;
    }

    /**
     * <p>定级结果主键</p>
     *
     * @param gradeResultId 定级结果主键
     */
    public void setGradeResultId(Long gradeResultId) {
        this.gradeResultId = gradeResultId;
    }
    /**
     * <p>定级详情ID</p>
     *
     * @return 定级详情ID
     */
    public Long getGradeInfoId() {
        return gradeInfoId;
    }

    /**
     * <p>定级详情ID</p>
     *
     * @param gradeInfoId 定级详情ID
     */
    public void setGradeInfoId(Long gradeInfoId) {
        this.gradeInfoId = gradeInfoId;
    }
    /**
     * <p>买家数最多的分类产品</p>
     *
     * @return 买家数最多的分类产品
     */
    public String getBuyerLargestPro() {
        return buyerLargestPro;
    }

    /**
     * <p>买家数最多的分类产品</p>
     *
     * @param buyerLargestPro 买家数最多的分类产品
     */
    public void setBuyerLargestPro(String buyerLargestPro) {
        this.buyerLargestPro = buyerLargestPro;
    }
    /**
     * <p>买家最大分类产品个数</p>
     *
     * @return 买家最大分类产品个数
     */
    public Integer getBuyerLargestNum() {
        return buyerLargestNum;
    }

    /**
     * <p>买家最大分类产品个数</p>
     *
     * @param buyerLargestNum 买家最大分类产品个数
     */
    public void setBuyerLargestNum(Integer buyerLargestNum) {
        this.buyerLargestNum = buyerLargestNum;
    }
    /**
     * <p>买家平均定价</p>
     *
     * @return 买家平均定价
     */
    public String getAveragePrice() {
        return averagePrice;
    }

    /**
     * <p>买家平均定价</p>
     *
     * @param averagePrice 买家平均定价
     */
    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }
    /**
     * <p>菜场级别</p>
     *
     * @return 菜场级别
     */
    public String getFoodMarketLevel() {
        return foodMarketLevel;
    }

    /**
     * <p>菜场级别</p>
     *
     * @param foodMarketLevel 菜场级别
     */
    public void setFoodMarketLevel(String foodMarketLevel) {
        this.foodMarketLevel = foodMarketLevel;
    }
    /**
     * <p>辐射范围</p>
     *
     * @return 辐射范围
     */
    public String getMarketRange() {
        return marketRange;
    }

    /**
     * <p>辐射范围</p>
     *
     * @param marketRange 辐射范围
     */
    public void setMarketRange(String marketRange) {
        this.marketRange = marketRange;
    }

}
