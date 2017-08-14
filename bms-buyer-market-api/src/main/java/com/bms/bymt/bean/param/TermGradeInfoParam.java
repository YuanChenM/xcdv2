package com.bms.bymt.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2016/12/15.
 */
@ApiModel(value = "TermGradeInfoParam", description = "批发定性定级详情信息类")
public class TermGradeInfoParam implements Serializable {

    @ApiModelProperty(value = "定级详情主键")
    private Long gradeInfoId;
    @ApiModelProperty(value = "批发市场UUID")
    private String termMarketId;
    @ApiModelProperty(value = "依托大型冷库(依托)")
    private Boolean isSupport;
    @ApiModelProperty(value = "占地面积(单位:亩)")
    private Integer coverArea;
    @ApiModelProperty(value = "市场面积级别标准")
    private String coverAreaStandard;
    @ApiModelProperty(value = "年销售额(单位:元) 展示到亿元")
    private Long yearAmount;
    @ApiModelProperty(value = "销售额级别标准")
    private String yearAmountStandard;
    @ApiModelProperty(value = "目标买家最大分类产品")
    private String largestTargetPro;
    @ApiModelProperty(value = "目标买家最大分类买家数(单位:户)")
    private Integer largestTargetNum;
    @ApiModelProperty(value = "目标买家最大分类级别标准")
    private String largestTargetStandard;
    @ApiModelProperty(value = "目标买家消费卖家数")
    private Integer targetConsumerNum;
    @ApiModelProperty(value = "目标买家消费卖家标准")
    private String targetConsumerNumStandard;
    @ApiModelProperty(value = "批发市场目标买家分级类型")
    private String marketTargetLevelType;
    @ApiModelProperty(value = "批发市场目标买家分级级别标准")
    private String marketTargetLevelStandard;
    @ApiModelProperty(value = "批发市场辐射范围")
    private String marketCoverArea;
    @ApiModelProperty(value = "批发市场辐射范围级别标准")
    private String marketCoverAreaStandard;
    @ApiModelProperty(value = "批发市场定性类别")
    private String marketNatureRank;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;

    public Long getGradeInfoId() {
        return gradeInfoId;
    }

    public void setGradeInfoId(Long gradeInfoId) {
        this.gradeInfoId = gradeInfoId;
    }

    public String getTermMarketId() {
        return termMarketId;
    }

    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }

    public Boolean getIsSupport() {
        return isSupport;
    }

    public void setIsSupport(Boolean isSupport) {
        this.isSupport = isSupport;
    }

    public Integer getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(Integer coverArea) {
        this.coverArea = coverArea;
    }

    public String getCoverAreaStandard() {
        return coverAreaStandard;
    }

    public void setCoverAreaStandard(String coverAreaStandard) {
        this.coverAreaStandard = coverAreaStandard;
    }

    public Long getYearAmount() {
        return yearAmount;
    }

    public void setYearAmount(Long yearAmount) {
        this.yearAmount = yearAmount;
    }

    public String getYearAmountStandard() {
        return yearAmountStandard;
    }

    public void setYearAmountStandard(String yearAmountStandard) {
        this.yearAmountStandard = yearAmountStandard;
    }

    public String getLargestTargetPro() {
        return largestTargetPro;
    }

    public void setLargestTargetPro(String largestTargetPro) {
        this.largestTargetPro = largestTargetPro;
    }

    public Integer getLargestTargetNum() {
        return largestTargetNum;
    }

    public void setLargestTargetNum(Integer largestTargetNum) {
        this.largestTargetNum = largestTargetNum;
    }

    public String getLargestTargetStandard() {
        return largestTargetStandard;
    }

    public void setLargestTargetStandard(String largestTargetStandard) {
        this.largestTargetStandard = largestTargetStandard;
    }

    public Integer getTargetConsumerNum() {
        return targetConsumerNum;
    }

    public void setTargetConsumerNum(Integer targetConsumerNum) {
        this.targetConsumerNum = targetConsumerNum;
    }

    public String getTargetConsumerNumStandard() {
        return targetConsumerNumStandard;
    }

    public void setTargetConsumerNumStandard(String targetConsumerNumStandard) {
        this.targetConsumerNumStandard = targetConsumerNumStandard;
    }

    public String getMarketTargetLevelType() {
        return marketTargetLevelType;
    }

    public void setMarketTargetLevelType(String marketTargetLevelType) {
        this.marketTargetLevelType = marketTargetLevelType;
    }

    public String getMarketTargetLevelStandard() {
        return marketTargetLevelStandard;
    }

    public void setMarketTargetLevelStandard(String marketTargetLevelStandard) {
        this.marketTargetLevelStandard = marketTargetLevelStandard;
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

    public String getMarketNatureRank() {
        return marketNatureRank;
    }

    public void setMarketNatureRank(String marketNatureRank) {
        this.marketNatureRank = marketNatureRank;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
