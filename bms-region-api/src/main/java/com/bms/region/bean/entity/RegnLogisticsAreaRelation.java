/*
 * 2016/12/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_LOGISTICS_AREA_RELATION对应的实体RegnLogisticsAreaRelation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnLogisticsAreaRelation extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** RELA_ID */
    private Long relaId;
    /** LGCS_AREA_ID */
    private Long lgcsAreaId;
    /** PROVINCE_ID */
    private Long provinceId;
    /** CITY_ID */
    private Long cityId;
    /** DISTRICT_ID */
    private Long districtId;
    /** STREET_ID */
    private Long streetId;

    /**
     * <p>默认构造函数</p>
     */
    public RegnLogisticsAreaRelation() {
    }

    /**
     * <p>RELA_ID</p>
     *
     * @return RELA_ID
     */
    public Long getRelaId() {
        return relaId;
    }

    /**
     * <p>RELA_ID</p>
     *
     * @param relaId RELA_ID
     */
    public void setRelaId(Long relaId) {
        this.relaId = relaId;
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

}
