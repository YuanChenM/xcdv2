/*
 * 2016/12/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_CITY对应的实体RegnCity</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnCity extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** CITY_ID */
    private Long cityId;
    /** PROVINCE_ID */
    private Long provinceId;
    /** CITY_CODE */
    private String cityCode;
    /** CITY_NAME */
    private String cityName;
    /** DIVISION_LEVEL */
    private Integer divisionLevel;
    /** DISABLE_FLG */
    private String disableFlg;

    /**
     * <p>默认构造函数</p>
     */
    public RegnCity() {
    }

    /**
     * <p>CITY_ID</p>
     *
     * @return CITY_ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * <p>CITY_ID</p>
     *
     * @param cityId CITY_ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    /**
     * <p>PROVINCE_ID</p>
     *
     * @return PROVINCE_ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * <p>PROVINCE_ID</p>
     *
     * @param provinceId PROVINCE_ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
    /**
     * <p>CITY_CODE</p>
     *
     * @return CITY_CODE
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>CITY_CODE</p>
     *
     * @param cityCode CITY_CODE
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * <p>CITY_NAME</p>
     *
     * @return CITY_NAME
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>CITY_NAME</p>
     *
     * @param cityName CITY_NAME
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
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
