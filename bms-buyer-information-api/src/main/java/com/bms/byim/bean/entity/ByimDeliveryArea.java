/*
 * 2016/12/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_DELIVERY_AREA对应的实体ByimDeliveryArea</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimDeliveryArea extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** DELIVERY_AREA_ID */
    private java.lang.Long deliveryAreaId;
    /** LGCS_AREA_ID */
    private java.lang.Long lgcsAreaId;
    /** LGCS_AREA_CODE */
    private java.lang.String lgcsAreaCode;
    /** LGCS_AREA_NAME */
    private java.lang.String lgcsAreaName;
    /** LGCS_AREA_ID */
    private java.lang.Long provinceId;
    /** PROVINCE_CODE */
    private java.lang.String provinceCode;
    /** PROVINCE_NAME */
    private java.lang.String provinceName;
    /** LGCS_AREA_ID */
    private java.lang.Long cityId;
    /** CITY_CODE */
    private java.lang.String cityCode;
    /** CITY_NAME */
    private java.lang.String cityName;
    /** DELIVERY_AREA */
    private java.lang.String deliveryArea;
    /** PASS_TRAFFIC_MODEL */
    private java.lang.String passTrafficModel;
    /** DELIVERY_AREA_CODE */
    private java.lang.String deliveryAreaCode;
    /** DEL_FLG */


    /**
     * <p>默认构造函数</p>
     */
    public ByimDeliveryArea() {
    }

    /**
     * <p>DELIVERY_AREA_ID</p>
     *
     * @return DELIVERY_AREA_ID
     */
    public java.lang.Long getDeliveryAreaId() {
        return deliveryAreaId;
    }

    /**
     * <p>DELIVERY_AREA_ID</p>
     *
     * @param deliveryAreaId DELIVERY_AREA_ID
     */
    public void setDeliveryAreaId(java.lang.Long deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
    }
    /**
     * <p>LGCS_AREA_CODE</p>
     *
     * @return LGCS_AREA_CODE
     */
    public java.lang.String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>LGCS_AREA_CODE</p>
     *
     * @param lgcsAreaCode LGCS_AREA_CODE
     */
    public void setLgcsAreaCode(java.lang.String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>LGCS_AREA_NAME</p>
     *
     * @return LGCS_AREA_NAME
     */
    public java.lang.String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>LGCS_AREA_NAME</p>
     *
     * @param lgcsAreaName LGCS_AREA_NAME
     */
    public void setLgcsAreaName(java.lang.String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>PROVINCE_CODE</p>
     *
     * @return PROVINCE_CODE
     */
    public java.lang.String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>PROVINCE_CODE</p>
     *
     * @param provinceCode PROVINCE_CODE
     */
    public void setProvinceCode(java.lang.String provinceCode) {
        this.provinceCode = provinceCode;
    }
    /**
     * <p>PROVINCE_NAME</p>
     *
     * @return PROVINCE_NAME
     */
    public java.lang.String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>PROVINCE_NAME</p>
     *
     * @param provinceName PROVINCE_NAME
     */
    public void setProvinceName(java.lang.String provinceName) {
        this.provinceName = provinceName;
    }
    /**
     * <p>CITY_CODE</p>
     *
     * @return CITY_CODE
     */
    public java.lang.String getCityCode() {
        return cityCode;
    }

    /**
     * <p>CITY_CODE</p>
     *
     * @param cityCode CITY_CODE
     */
    public void setCityCode(java.lang.String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * <p>CITY_NAME</p>
     *
     * @return CITY_NAME
     */
    public java.lang.String getCityName() {
        return cityName;
    }

    /**
     * <p>CITY_NAME</p>
     *
     * @param cityName CITY_NAME
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }
    /**
     * <p>DELIVERY_AREA</p>
     *
     * @return DELIVERY_AREA
     */
    public java.lang.String getDeliveryArea() {
        return deliveryArea;
    }

    /**
     * <p>DELIVERY_AREA</p>
     *
     * @param deliveryArea DELIVERY_AREA
     */
    public void setDeliveryArea(java.lang.String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }
    /**
     * <p>PASS_TRAFFIC_MODEL</p>
     *
     * @return PASS_TRAFFIC_MODEL
     */
    public java.lang.String getPassTrafficModel() {
        return passTrafficModel;
    }

    /**
     * <p>PASS_TRAFFIC_MODEL</p>
     *
     * @param passTrafficModel PASS_TRAFFIC_MODEL
     */
    public void setPassTrafficModel(java.lang.String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }
    /**
     * <p>DELIVERY_AREA_CODE</p>
     *
     * @return DELIVERY_AREA_CODE
     */
    public java.lang.String getDeliveryAreaCode() {
        return deliveryAreaCode;
    }

    /**
     * <p>DELIVERY_AREA_CODE</p>
     *
     * @param deliveryAreaCode DELIVERY_AREA_CODE
     */
    public void setDeliveryAreaCode(java.lang.String deliveryAreaCode) {
        this.deliveryAreaCode = deliveryAreaCode;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
