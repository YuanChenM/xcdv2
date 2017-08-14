package com.bms.bymt.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
@ApiModel(value = "FoodGradeRsResult", description = "返回对象")
public class FoodGradeRsResult extends FoodGradeInfoRsResult {
    @ApiModelProperty(value = "定级结果ID")
    private Long gradeResultId;
    @ApiModelProperty(value = "买家数最多的分类产品")
    private String buyerLargestPro;
    @ApiModelProperty(value = "买家最大分类产品个数")
    private Integer buyerLargestNum;
    @ApiModelProperty(value = "买家平均定价")
    private String averagePriceResult;
    @ApiModelProperty(value = "菜场级别")
    private String foodMarketLevel;
    @ApiModelProperty(value = "辐射范围")
    private String marketRange;

    public Long getGradeResultId() {
        return gradeResultId;
    }

    public void setGradeResultId(Long gradeResultId) {
        this.gradeResultId = gradeResultId;
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

    public String getAveragePriceResult() {
        return averagePriceResult;
    }

    public void setAveragePriceResult(String averagePriceResult) {
        this.averagePriceResult = averagePriceResult;
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
