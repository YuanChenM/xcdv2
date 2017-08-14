package com.bms.agif.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


@ApiModel(value = "ButlerLevelStandardPageParam", description = "冻品管家定级标类")
public class ButlerLevelStandardPageParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "等级ID")
    private Long levelId;
    @ApiModelProperty(value = "等级名称")
    private String levelName;
    @ApiModelProperty(value = "等级值")
    private java.math.BigDecimal levelValue;
    @ApiModelProperty(value = "物流区主键")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "月均销售额")
    private java.math.BigDecimal monthAverageSales;
    @ApiModelProperty(value = "月均毛利")
    private java.math.BigDecimal monthAverageGrossProfit;
    @ApiModelProperty(value = "月均净利")
    private java.math.BigDecimal monthAverageNetProfit;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;


    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public BigDecimal getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(BigDecimal levelValue) {
        this.levelValue = levelValue;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public BigDecimal getMonthAverageSales() {
        return monthAverageSales;
    }

    public void setMonthAverageSales(BigDecimal monthAverageSales) {
        this.monthAverageSales = monthAverageSales;
    }

    public BigDecimal getMonthAverageGrossProfit() {
        return monthAverageGrossProfit;
    }

    public void setMonthAverageGrossProfit(BigDecimal monthAverageGrossProfit) {
        this.monthAverageGrossProfit = monthAverageGrossProfit;
    }

    public BigDecimal getMonthAverageNetProfit() {
        return monthAverageNetProfit;
    }

    public void setMonthAverageNetProfit(BigDecimal monthAverageNetProfit) {
        this.monthAverageNetProfit = monthAverageNetProfit;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}



