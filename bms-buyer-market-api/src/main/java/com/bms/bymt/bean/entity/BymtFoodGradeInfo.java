/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;
/**
 * <p>表BYMT_FOOD_GRADE_INFO对应的实体BymtFoodGradeInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtFoodGradeInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 定级详情主键 */
    private Long gradeInfoId;
    /** 菜场UUID */
    private String foodMarketId;
    /** 市场买家最大分类产品 */
    private String largestMarketPro;
    /** 市场买家最大分类产品个数 */
    private Integer largestMarletNum;
    /** 市场买家最大分类产品标准 */
    private String largestMarketStandard;
    /** 菜场辐射范围 */
    private String marketCoverArea;
    /** 菜场辐射范围级别标准 */
    private String marketCoverAreaStandard;
    /** 买家平均定价 */
    private String averagePrice;
    /** 定价 标准 */
    private String standardPrice;

    /**
     * <p>默认构造函数</p>
     */
    public BymtFoodGradeInfo() {
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
     * <p>菜场UUID</p>
     *
     * @return 菜场UUID
     */
    public String getFoodMarketId() {
        return foodMarketId;
    }

    /**
     * <p>菜场UUID</p>
     *
     * @param foodMarketId 菜场UUID
     */
    public void setFoodMarketId(String foodMarketId) {
        this.foodMarketId = foodMarketId;
    }
    /**
     * <p>市场买家最大分类产品</p>
     *
     * @return 市场买家最大分类产品
     */
    public String getLargestMarketPro() {
        return largestMarketPro;
    }

    /**
     * <p>市场买家最大分类产品</p>
     *
     * @param largestMarketPro 市场买家最大分类产品
     */
    public void setLargestMarketPro(String largestMarketPro) {
        this.largestMarketPro = largestMarketPro;
    }
    /**
     * <p>市场买家最大分类产品个数</p>
     *
     * @return 市场买家最大分类产品个数
     */
    public Integer getLargestMarletNum() {
        return largestMarletNum;
    }

    /**
     * <p>市场买家最大分类产品个数</p>
     *
     * @param largestMarletNum 市场买家最大分类产品个数
     */
    public void setLargestMarletNum(Integer largestMarletNum) {
        this.largestMarletNum = largestMarletNum;
    }
    /**
     * <p>市场买家最大分类产品标准</p>
     *
     * @return 市场买家最大分类产品标准
     */
    public String getLargestMarketStandard() {
        return largestMarketStandard;
    }

    /**
     * <p>市场买家最大分类产品标准</p>
     *
     * @param largestMarketStandard 市场买家最大分类产品标准
     */
    public void setLargestMarketStandard(String largestMarketStandard) {
        this.largestMarketStandard = largestMarketStandard;
    }
    /**
     * <p>菜场辐射范围</p>
     *
     * @return 菜场辐射范围
     */
    public String getMarketCoverArea() {
        return marketCoverArea;
    }

    /**
     * <p>菜场辐射范围</p>
     *
     * @param marketCoverArea 菜场辐射范围
     */
    public void setMarketCoverArea(String marketCoverArea) {
        this.marketCoverArea = marketCoverArea;
    }
    /**
     * <p>菜场辐射范围级别标准</p>
     *
     * @return 菜场辐射范围级别标准
     */
    public String getMarketCoverAreaStandard() {
        return marketCoverAreaStandard;
    }

    /**
     * <p>菜场辐射范围级别标准</p>
     *
     * @param marketCoverAreaStandard 菜场辐射范围级别标准
     */
    public void setMarketCoverAreaStandard(String marketCoverAreaStandard) {
        this.marketCoverAreaStandard = marketCoverAreaStandard;
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
     * <p>定价 标准</p>
     *
     * @return 定价 标准
     */
    public String getStandardPrice() {
        return standardPrice;
    }

    /**
     * <p>定价 标准</p>
     *
     * @param standardPrice 定价 标准
     */
    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice;
    }

}
