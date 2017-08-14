package com.bms.bymt.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yuan_zhifei on 2016/12/15.
 */
@ApiModel(value = "MarketLevelStandardRsParam", description = "批发市场级别标准参数")
public class MarketLevelStandardRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "标准级别ID")
    private Long standardId;
    @ApiModelProperty(value = "级别标准编码")
    private String standardCode;
    @ApiModelProperty(value = "级别标准等级")
    private String standardLevel;
    @ApiModelProperty(value = "占地面积")
    private String coverArea;
    @ApiModelProperty(value = "市场年销售额")
    private String yearAmount;
    @ApiModelProperty(value = "最大分类目标买家")
    private String largestTargetBuyer;
    @ApiModelProperty(value = "目标买家总数")
    private String targetBuyerNum;
    @ApiModelProperty(value = "主要买家群体")
    private String buyerGroups;
    @ApiModelProperty(value = "市场辐射范围")
    private String marketRange;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getStandardLevel() {
        return standardLevel;
    }

    public void setStandardLevel(String standardLevel) {
        this.standardLevel = standardLevel;
    }

    public String getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(String coverArea) {
        this.coverArea = coverArea;
    }

    public String getYearAmount() {
        return yearAmount;
    }

    public void setYearAmount(String yearAmount) {
        this.yearAmount = yearAmount;
    }

    public String getLargestTargetBuyer() {
        return largestTargetBuyer;
    }

    public void setLargestTargetBuyer(String largestTargetBuyer) {
        this.largestTargetBuyer = largestTargetBuyer;
    }

    public String getTargetBuyerNum() {
        return targetBuyerNum;
    }

    public void setTargetBuyerNum(String targetBuyerNum) {
        this.targetBuyerNum = targetBuyerNum;
    }

    public String getBuyerGroups() {
        return buyerGroups;
    }

    public void setBuyerGroups(String buyerGroups) {
        this.buyerGroups = buyerGroups;
    }

    public String getMarketRange() {
        return marketRange;
    }

    public void setMarketRange(String marketRange) {
        this.marketRange = marketRange;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
