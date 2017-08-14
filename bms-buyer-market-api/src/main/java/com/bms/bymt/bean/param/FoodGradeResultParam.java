package com.bms.bymt.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
@ApiModel(value = "FoodGradeResultParam", description = "菜场定性结果信息类")
public class FoodGradeResultParam implements Serializable {

    /**
     * 定级结果主键
     */
    @ApiModelProperty(value = "定级结果主键")
    private Long gradeResultId;
    /**
     * 定级详情ID
     */
    @ApiModelProperty(value = "定级详情ID")
    private Long gradeInfoId;
    /**
     * 买家数最多的分类产品
     */
    @ApiModelProperty(value = "买家数最多的分类产品")
    private String buyerLargestPro;
    /**
     * 买家最大分类产品个数
     */
    @ApiModelProperty(value = "买家最大分类产品个数")
    private Integer buyerLargestNum;
    /**
     * 买家平均定价
     */
    @ApiModelProperty(value = "买家平均定价")
    private String averagePrice;
    /**
     * 菜场级别
     */
    @ApiModelProperty(value = "菜场级别")
    private String foodMarketLevel;
    /**
     * 辐射范围
     */
    @ApiModelProperty(value = "辐射范围")
    private String marketRange;

    public Long getGradeResultId() {
        return gradeResultId;
    }

    public void setGradeResultId(Long gradeResultId) {
        this.gradeResultId = gradeResultId;
    }

    public Long getGradeInfoId() {
        return gradeInfoId;
    }

    public void setGradeInfoId(Long gradeInfoId) {
        this.gradeInfoId = gradeInfoId;
    }

    public String getBuyerLargestPro() {
        return buyerLargestPro;
    }

    public void setBuyerLargestPro(String buyerLargestPro) {
        this.buyerLargestPro = buyerLargestPro;
    }

    public Integer getBuyerLargestNum() {
        return buyerLargestNum;
    }

    public void setBuyerLargestNum(Integer buyerLargestNum) {
        this.buyerLargestNum = buyerLargestNum;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getFoodMarketLevel() {
        return foodMarketLevel;
    }

    public void setFoodMarketLevel(String foodMarketLevel) {
        this.foodMarketLevel = foodMarketLevel;
    }

    public String getMarketRange() {
        return marketRange;
    }

    public void setMarketRange(String marketRange) {
        this.marketRange = marketRange;
    }
}
