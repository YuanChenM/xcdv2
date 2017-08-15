package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * 买家配送地址信息查询接口，出参
 * 
 * @author li_huiqian
 *
 */
public class BYIM0113IRestResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8527719979926888300L;
    /** 配送地址ID */
    private Long deliveryId;
    /** 省ID */
    private Long provinceId;
    /** 省编码 */
    private String provinceCode;
    /** 省名称 */
    private String provinceName;
    /** 城市ID */
    private Long cityId;
    /** 城市编码 */
    private String cityCode;
    /** 城市名称 */
    private String cityName;
    /** 区（县）ID */
    private Long districtId;
    /** 区（县）编码 */
    private String districtCode;
    /** 区（县）名称 */
    private String districtName;
    /** 配送地址 */
    private String deliveryAddr;
    /** 配送参照地址 */
    private String referenceAddr;
    /** 经营地址 */
    private String manageAddr;
    /** 收货联系人 */
    private String receivePersonName;
    /** 联系人电话 */
    private String receivePersonTel;
    /** 联系人微信 */
    private String receivePersonWechat;
    /** 联系人QQ */
    private String receivePersonQq;
    /** 通行区域ID */
    private Long deliveryAreaId;
    /** 订单配送区域 */
    private String deliveryArea;
    /** 准入通行车型 */
    private String passTrafficModel;
    /** 是否默认配送地址 */
    private Boolean isDefaultFlg;

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public String getReferenceAddr() {
        return referenceAddr;
    }

    public void setReferenceAddr(String referenceAddr) {
        this.referenceAddr = referenceAddr;
    }

    public String getManageAddr() {
        return manageAddr;
    }

    public void setManageAddr(String manageAddr) {
        this.manageAddr = manageAddr;
    }

    public String getReceivePersonName() {
        return receivePersonName;
    }

    public void setReceivePersonName(String receivePersonName) {
        this.receivePersonName = receivePersonName;
    }

    public String getReceivePersonTel() {
        return receivePersonTel;
    }

    public void setReceivePersonTel(String receivePersonTel) {
        this.receivePersonTel = receivePersonTel;
    }

    public String getReceivePersonWechat() {
        return receivePersonWechat;
    }

    public void setReceivePersonWechat(String receivePersonWechat) {
        this.receivePersonWechat = receivePersonWechat;
    }

    public String getReceivePersonQq() {
        return receivePersonQq;
    }

    public void setReceivePersonQq(String receivePersonQq) {
        this.receivePersonQq = receivePersonQq;
    }

    public Long getDeliveryAreaId() {
        return deliveryAreaId;
    }

    public void setDeliveryAreaId(Long deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getPassTrafficModel() {
        return passTrafficModel;
    }

    public void setPassTrafficModel(String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }

    public Boolean getIsDefaultFlg() {
        return isDefaultFlg;
    }

    public void setIsDefaultFlg(Boolean isDefaultFlg) {
        this.isDefaultFlg = isDefaultFlg;
    }

}
