/*
 * 2016/12/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_LOGISTICS_AREA对应的实体RegnLogisticsArea</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnLogisticsArea extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** LGCS_AREA_ID */
    private Long lgcsAreaId;
    /** LGCS_AREA_CODE */
    private String lgcsAreaCode;
    /** LGCS_AREA_NAME */
    private String lgcsAreaName;
    /** DIVISION_LEVEL */
    private Integer divisionLevel;
    /** DISABLE_FLG */
    private String disableFlg;

    /**
     * <p>默认构造函数</p>
     */
    public RegnLogisticsArea() {
    }

    /**
     * <p>LGCS_AREA_ID</p>
     *
     * @return LGCS_AREA_ID
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>LGCS_AREA_ID</p>
     *
     * @param lgcsAreaId LGCS_AREA_ID
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>LGCS_AREA_CODE</p>
     *
     * @return LGCS_AREA_CODE
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>LGCS_AREA_CODE</p>
     *
     * @param lgcsAreaCode LGCS_AREA_CODE
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>LGCS_AREA_NAME</p>
     *
     * @return LGCS_AREA_NAME
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>LGCS_AREA_NAME</p>
     *
     * @param lgcsAreaName LGCS_AREA_NAME
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>DIVISION_LEVEL</p>
     *
     * @return DIVISION_LEVEL
     */
    public Integer getDivisionLevel() {
        return divisionLevel;
    }

    /**
     * <p>DIVISION_LEVEL</p>
     *
     * @param divisionLevel DIVISION_LEVEL
     */
    public void setDivisionLevel(Integer divisionLevel) {
        this.divisionLevel = divisionLevel;
    }
    /**
     * <p>DISABLE_FLG</p>
     *
     * @return DISABLE_FLG
     */
    public String getDisableFlg() {
        return disableFlg;
    }

    /**
     * <p>DISABLE_FLG</p>
     *
     * @param disableFlg DISABLE_FLG
     */
    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

}
