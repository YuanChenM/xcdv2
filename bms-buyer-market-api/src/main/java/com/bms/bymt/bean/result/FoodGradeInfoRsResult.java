package com.bms.bymt.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
@ApiModel(value = "FoodGradeInfoRsResult", description = "返回对象")
public class FoodGradeInfoRsResult implements Serializable {
    @ApiModelProperty(value = "定级详情主键")
    private Long gradeInfoId;
    @ApiModelProperty(value = "菜场ID")
    private String foodMarketId;
    @ApiModelProperty(value = "市场买家最大分类产品")
    private String largestMarketPro;
    @ApiModelProperty(value = "市场买家最大分类产品个数")
    private Integer largestMarletNum;
    @ApiModelProperty(value = "市场买家最大分类产品标准")
    private String largestMarketStandard;
    @ApiModelProperty(value = "菜场辐射范围")
    private String marketCoverArea;
    @ApiModelProperty(value = "菜场辐射范围级别标准")
    private String marketCoverAreaStandard;
    @ApiModelProperty(value = "买家平均定价")
    private String averagePrice;
    @ApiModelProperty(value = "定价 标准")
    private String standardPrice;

    public Long getGradeInfoId() {
        return gradeInfoId;
    }

    public void setGradeInfoId(Long gradeInfoId) {
        this.gradeInfoId = gradeInfoId;
    }

    public String getFoodMarketId() {
        return foodMarketId;
    }

    public void setFoodMarketId(String foodMarketId) {
        this.foodMarketId = foodMarketId;
    }

    public String getLargestMarketPro() {
        return largestMarketPro;
    }

    public void setLargestMarketPro(String largestMarketPro) {
        this.largestMarketPro = largestMarketPro;
    }

    public Integer getLargestMarletNum() {
        return largestMarletNum;
    }

    public void setLargestMarletNum(Integer largestMarletNum) {
        this.largestMarletNum = largestMarletNum;
    }

    public String getLargestMarketStandard() {
        return largestMarketStandard;
    }

    public void setLargestMarketStandard(String largestMarketStandard) {
        this.largestMarketStandard = largestMarketStandard;
    }

    public String getMarketCoverArea() {
        return marketCoverArea;
    }

    public void setMarketCoverArea(String marketCoverArea) {
        this.marketCoverArea = marketCoverArea;
    }

    public String getMarketCoverAreaStandard() {
        return marketCoverAreaStandard;
    }

    public void setMarketCoverAreaStandard(String marketCoverAreaStandard) {
        this.marketCoverAreaStandard = marketCoverAreaStandard;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice;
    }
}
