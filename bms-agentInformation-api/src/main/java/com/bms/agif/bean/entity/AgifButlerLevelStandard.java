/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_LEVEL_STANDARD对应的实体AgifButlerLevelStandard</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerLevelStandard extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** LEVEL_ID */
    private Long levelId;
    /** LEVEL_NAME */
    private String levelName;
    /** LEVEL_VALUE */
    private java.math.BigDecimal levelValue;
    /** 物流区主键 */
    private Long lgcsAreaId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区名称 */
    private String lgcsAreaName;
    /** MONTH_AVERAGE_SALES */
    private java.math.BigDecimal monthAverageSales;
    /** MONTH_AVERAGE_GROSS_PROFIT */
    private java.math.BigDecimal monthAverageGrossProfit;
    /** MONTH_AVERAGE_NET_PROFIT */
    private java.math.BigDecimal monthAverageNetProfit;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerLevelStandard() {
    }

    /**
     * <p>LEVEL_ID</p>
     *
     * @return LEVEL_ID
     */
    public Long getLevelId() {
        return levelId;
    }

    /**
     * <p>LEVEL_ID</p>
     *
     * @param levelId LEVEL_ID
     */
    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
    /**
     * <p>LEVEL_NAME</p>
     *
     * @return LEVEL_NAME
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * <p>LEVEL_NAME</p>
     *
     * @param levelName LEVEL_NAME
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    /**
     * <p>LEVEL_VALUE</p>
     *
     * @return LEVEL_VALUE
     */
    public java.math.BigDecimal getLevelValue() {
        return levelValue;
    }

    /**
     * <p>LEVEL_VALUE</p>
     *
     * @param levelValue LEVEL_VALUE
     */
    public void setLevelValue(java.math.BigDecimal levelValue) {
        this.levelValue = levelValue;
    }
    /**
     * <p>物流区主键</p>
     *
     * @return 物流区主键
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区主键</p>
     *
     * @param lgcsAreaId 物流区主键
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param lgcsAreaName 物流区名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>MONTH_AVERAGE_SALES</p>
     *
     * @return MONTH_AVERAGE_SALES
     */
    public java.math.BigDecimal getMonthAverageSales() {
        return monthAverageSales;
    }

    /**
     * <p>MONTH_AVERAGE_SALES</p>
     *
     * @param monthAverageSales MONTH_AVERAGE_SALES
     */
    public void setMonthAverageSales(java.math.BigDecimal monthAverageSales) {
        this.monthAverageSales = monthAverageSales;
    }
    /**
     * <p>MONTH_AVERAGE_GROSS_PROFIT</p>
     *
     * @return MONTH_AVERAGE_GROSS_PROFIT
     */
    public java.math.BigDecimal getMonthAverageGrossProfit() {
        return monthAverageGrossProfit;
    }

    /**
     * <p>MONTH_AVERAGE_GROSS_PROFIT</p>
     *
     * @param monthAverageGrossProfit MONTH_AVERAGE_GROSS_PROFIT
     */
    public void setMonthAverageGrossProfit(java.math.BigDecimal monthAverageGrossProfit) {
        this.monthAverageGrossProfit = monthAverageGrossProfit;
    }
    /**
     * <p>MONTH_AVERAGE_NET_PROFIT</p>
     *
     * @return MONTH_AVERAGE_NET_PROFIT
     */
    public java.math.BigDecimal getMonthAverageNetProfit() {
        return monthAverageNetProfit;
    }

    /**
     * <p>MONTH_AVERAGE_NET_PROFIT</p>
     *
     * @param monthAverageNetProfit MONTH_AVERAGE_NET_PROFIT
     */
    public void setMonthAverageNetProfit(java.math.BigDecimal monthAverageNetProfit) {
        this.monthAverageNetProfit = monthAverageNetProfit;
    }

}
