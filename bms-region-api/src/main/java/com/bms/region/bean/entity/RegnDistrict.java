/*
 * 2016/12/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_DISTRICT对应的实体RegnDistrict</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnDistrict extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** DISTRICT_ID */
    private Long districtId;
    /** CITY_ID */
    private Long cityId;
    /** DISTRICT_CODE */
    private String districtCode;
    /** DISTRICT_NAME */
    private String districtName;
    /** DIVISION_LEVEL */
    private Integer divisionLevel;
    /** DISABLE_FLG */
    private String disableFlg;

    /**
     * <p>默认构造函数</p>
     */
    public RegnDistrict() {
    }

    /**
     * <p>DISTRICT_ID</p>
     *
     * @return DISTRICT_ID
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * <p>DISTRICT_ID</p>
     *
     * @param districtId DISTRICT_ID
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
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
     * <p>DISTRICT_CODE</p>
     *
     * @return DISTRICT_CODE
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>DISTRICT_CODE</p>
     *
     * @param districtCode DISTRICT_CODE
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
    /**
     * <p>DISTRICT_NAME</p>
     *
     * @return DISTRICT_NAME
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * <p>DISTRICT_NAME</p>
     *
     * @param districtName DISTRICT_NAME
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
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
