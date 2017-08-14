/*
 * 2016/12/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_STREET对应的实体RegnStreet</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnStreet extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** STREET_ID */
    private Long streetId;
    /** DISTRICT_ID */
    private Long districtId;
    /** STREET_CODE */
    private String streetCode;
    /** STREET_NAME */
    private String streetName;
    /** DIVISION_LEVEL */
    private Integer divisionLevel;
    /** DISABLE_FLG */
    private String disableFlg;

    /**
     * <p>默认构造函数</p>
     */
    public RegnStreet() {
    }

    /**
     * <p>STREET_ID</p>
     *
     * @return STREET_ID
     */
    public Long getStreetId() {
        return streetId;
    }

    /**
     * <p>STREET_ID</p>
     *
     * @param streetId STREET_ID
     */
    public void setStreetId(Long streetId) {
        this.streetId = streetId;
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
     * <p>STREET_CODE</p>
     *
     * @return STREET_CODE
     */
    public String getStreetCode() {
        return streetCode;
    }

    /**
     * <p>STREET_CODE</p>
     *
     * @param streetCode STREET_CODE
     */
    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }
    /**
     * <p>STREET_NAME</p>
     *
     * @return STREET_NAME
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * <p>STREET_NAME</p>
     *
     * @param streetName STREET_NAME
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
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
