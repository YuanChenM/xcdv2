/*
 * 2017/01/03 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_DELIVERY_ADDR对应的实体ByimDeliveryAddr</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimDeliveryAddr extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** DELIVERY_ID */
    private Long deliveryId;
    /** BUYER_ID */
    private String buyerId;
    /** PROVINCE_ID */
    private Long provinceId;
    /** PROVINCE_CODE */
    private String provinceCode;
    /** PROVINCE_NAME */
    private String provinceName;
    /** CITY_ID */
    private Long cityId;
    /** CITY_CODE */
    private String cityCode;
    /** CITY_NAME */
    private String cityName;
    /** DISTRICT_ID */
    private Long districtId;
    /** DISTRICT_CODE */
    private String districtCode;
    /** DISTRICT_NAME */
    private String districtName;
    /** DELIVERY_ADDR */
    private String deliveryAddr;
    /** VIRTUAL_ADDR */
    private String virtualAddr;
    /** REFERENCE_ADDR */
    private String referenceAddr;
    /** MANAGE_ADDR */
    private String manageAddr;
    /** RECEIVE_PERSON_NAME */
    private String receivePersonName;
    /** RECEIVE_PERSON_TEL */
    private String receivePersonTel;
    /** RECEIVE_PERSON_WECHAT */
    private String receivePersonWechat;
    /** RECEIVE_PERSON_QQ */
    private String receivePersonQq;
    /** DELIVERY_AREA_ID */
    private Long deliveryAreaId;
    /** DELIVERY_AREA */
    private String deliveryArea;
    /** DELIVERY_AREA_CODE */
    private java.lang.String deliveryAreaCode;
    /** PASS_TRAFFIC_MODEL */
    private String passTrafficModel;
    /** true:表示默认地址;false:表示不是默认地址 */
    private Boolean isDefaultFlg;

    /**
     * <p>默认构造函数</p>
     */
    public ByimDeliveryAddr() {
    }

    /**
     * <p>DELIVERY_ID</p>
     *
     * @return DELIVERY_ID
     */
    public Long getDeliveryId() {
        return deliveryId;
    }

    /**
     * <p>DELIVERY_ID</p>
     *
     * @param deliveryId DELIVERY_ID
     */
    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
    /**
     * <p>BUYER_ID</p>
     *
     * @return BUYER_ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>BUYER_ID</p>
     *
     * @param buyerId BUYER_ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
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
     * <p>PROVINCE_CODE</p>
     *
     * @return PROVINCE_CODE
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>PROVINCE_CODE</p>
     *
     * @param provinceCode PROVINCE_CODE
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    /**
     * <p>PROVINCE_NAME</p>
     *
     * @return PROVINCE_NAME
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>PROVINCE_NAME</p>
     *
     * @param provinceName PROVINCE_NAME
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
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
     * <p>DELIVERY_ADDR</p>
     *
     * @return DELIVERY_ADDR
     */
    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    /**
     * <p>DELIVERY_ADDR</p>
     *
     * @param deliveryAddr DELIVERY_ADDR
     */
    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }
    /**
     * <p>VIRTUAL_ADDR</p>
     *
     * @return VIRTUAL_ADDR
     */
    public String getVirtualAddr() {
        return virtualAddr;
    }

    /**
     * <p>VIRTUAL_ADDR</p>
     *
     * @param virtualAddr VIRTUAL_ADDR
     */
    public void setVirtualAddr(String virtualAddr) {
        this.virtualAddr = virtualAddr;
    }
    /**
     * <p>REFERENCE_ADDR</p>
     *
     * @return REFERENCE_ADDR
     */
    public String getReferenceAddr() {
        return referenceAddr;
    }

    /**
     * <p>REFERENCE_ADDR</p>
     *
     * @param referenceAddr REFERENCE_ADDR
     */
    public void setReferenceAddr(String referenceAddr) {
        this.referenceAddr = referenceAddr;
    }
    /**
     * <p>MANAGE_ADDR</p>
     *
     * @return MANAGE_ADDR
     */
    public String getManageAddr() {
        return manageAddr;
    }

    /**
     * <p>MANAGE_ADDR</p>
     *
     * @param manageAddr MANAGE_ADDR
     */
    public void setManageAddr(String manageAddr) {
        this.manageAddr = manageAddr;
    }
    /**
     * <p>RECEIVE_PERSON_NAME</p>
     *
     * @return RECEIVE_PERSON_NAME
     */
    public String getReceivePersonName() {
        return receivePersonName;
    }

    /**
     * <p>RECEIVE_PERSON_NAME</p>
     *
     * @param receivePersonName RECEIVE_PERSON_NAME
     */
    public void setReceivePersonName(String receivePersonName) {
        this.receivePersonName = receivePersonName;
    }
    /**
     * <p>RECEIVE_PERSON_TEL</p>
     *
     * @return RECEIVE_PERSON_TEL
     */
    public String getReceivePersonTel() {
        return receivePersonTel;
    }

    /**
     * <p>RECEIVE_PERSON_TEL</p>
     *
     * @param receivePersonTel RECEIVE_PERSON_TEL
     */
    public void setReceivePersonTel(String receivePersonTel) {
        this.receivePersonTel = receivePersonTel;
    }
    /**
     * <p>RECEIVE_PERSON_WECHAT</p>
     *
     * @return RECEIVE_PERSON_WECHAT
     */
    public String getReceivePersonWechat() {
        return receivePersonWechat;
    }

    /**
     * <p>RECEIVE_PERSON_WECHAT</p>
     *
     * @param receivePersonWechat RECEIVE_PERSON_WECHAT
     */
    public void setReceivePersonWechat(String receivePersonWechat) {
        this.receivePersonWechat = receivePersonWechat;
    }
    /**
     * <p>RECEIVE_PERSON_QQ</p>
     *
     * @return RECEIVE_PERSON_QQ
     */
    public String getReceivePersonQq() {
        return receivePersonQq;
    }

    /**
     * <p>RECEIVE_PERSON_QQ</p>
     *
     * @param receivePersonQq RECEIVE_PERSON_QQ
     */
    public void setReceivePersonQq(String receivePersonQq) {
        this.receivePersonQq = receivePersonQq;
    }
    /**
     * <p>DELIVERY_AREA_ID</p>
     *
     * @return DELIVERY_AREA_ID
     */
    public Long getDeliveryAreaId() {
        return deliveryAreaId;
    }

    /**
     * <p>DELIVERY_AREA_ID</p>
     *
     * @param deliveryAreaId DELIVERY_AREA_ID
     */
    public void setDeliveryAreaId(Long deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
    }
    /**
     * <p>DELIVERY_AREA</p>
     *
     * @return DELIVERY_AREA
     */
    public String getDeliveryArea() {
        return deliveryArea;
    }

    /**
     * <p>DELIVERY_AREA</p>
     *
     * @param deliveryArea DELIVERY_AREA
     */
    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }
    /**
     * <p>PASS_TRAFFIC_MODEL</p>
     *
     * @return PASS_TRAFFIC_MODEL
     */
    public String getPassTrafficModel() {
        return passTrafficModel;
    }

    /**
     * <p>PASS_TRAFFIC_MODEL</p>
     *
     * @param passTrafficModel PASS_TRAFFIC_MODEL
     */
    public void setPassTrafficModel(String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }
    /**
     * <p>true:表示默认地址;false:表示不是默认地址</p>
     *
     * @return true:表示默认地址;false:表示不是默认地址
     */
    public Boolean getIsDefaultFlg() {
        return isDefaultFlg;
    }

    /**
     * <p>true:表示默认地址;false:表示不是默认地址</p>
     *
     * @param isDefaultFlg true:表示默认地址;false:表示不是默认地址
     */
    public void setIsDefaultFlg(Boolean isDefaultFlg) {
        this.isDefaultFlg = isDefaultFlg;
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

}
