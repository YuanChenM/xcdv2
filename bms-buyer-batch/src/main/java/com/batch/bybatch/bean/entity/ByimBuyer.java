/*
 * 2017/02/16 自动生成 新规作成
 * (c) 江苏润和
 */
package com.batch.bybatch.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>
 * 表BYIM_BASIC对应的实体ByimBasic
 * </p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimBuyer extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** BUYER_ID */
    private String buyerId;
    /** BUYER_CODE */
    private String buyerCode;
    /** BUYER_TYPE */
    private String buyerType;
    /** BUYER_TYPE_NAME */
    private String buyerTypeName;
    /** BUYER_FIRST_CATEGORY */
    private String buyerFirstCategory;
    /** BUYER_FIRST_CATEGORY_NAME */
    private String buyerFirstCategoryName;
    /** BUYER_SUB_CATEGORY */
    private String buyerSubCategory;
    /** BUYER_SUB_CATEGORY_NAME */
    private String buyerSubCategoryName;
    /** BUYER_NAME */
    private String buyerName;
    /** BUYER_ADDR */
    private String buyerAddr;
    /** LGCS_AREA_ID */
    private Long lgcsAreaId;
    /** LGCS_AREA_CODE */
    private String lgcsAreaCode;
    /** LGCS_AREA_NAME */
    private String lgcsAreaName;
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
    /** STREET_ID */
    private Long streetId;
    /** STREET_CODE */
    private String streetCode;
    /** STREET_NAME */
    private String streetName;
    /** BUYER_QQ */
    private String buyerQq;
    /** BUYER_WECHAT */
    private String buyerWechat;
    /** 有多个时以逗号隔开 */
    private String paymentType;
    /** NORMAL_RECEIVE_TIME */
    private String normalReceiveTime;
    /** EARLIEST_TIME */
    private String earliestTime;
    /** LATEST_TIME */
    private String latestTime;
    /** TEL_MARKETING_TIME */
    private String telMarketingTime;
    /** TEL_MARKETING_NO */
    private String telMarketingNo;
    /** WECHAT_MARKETING_NO */
    private String wechatMarketingNo;
    /** QQ_MARKETING_NO */
    private String qqMarketingNo;
    /** MARKETING_FIRST_STATUS */
    private String marketingFirstStatus;
    /** MARKETING_FIRST_STATUS_NAME */
    private String marketingFirstStatusName;
    /** MARKETING_SUB_STATUS */
    private String marketingSubStatus;
    /** MARKETING_SUB_STATUS_NAME */
    private String marketingSubStatusName;
    /** INFO_ERROR_FLG */
    private Boolean infoErrorFlg;
    /** INFO_ERROR_REMARK */
    private String infoErrorRemark;
    /** REGISTER_SOURCE */
    private String registerSource;
    /** IS_CREDIT_TERM_BUYER */
    private Boolean isCreditTermBuyer;
    /** IS_CONTROL_PUERCHASNG_CHAIN */
    private Boolean isControlPuerchasngChain;
    /** REGISTER_SOURCE_NAME */
    private String registerSourceName;
    /** 常客买家等级（频次） */
    private String frequenterLevelF;
    /** 常客买家等级（量级） */
    private String frequenterLevelA;
    /** 常客买家等级编码(同时有取频次、量级中最小的一个级别 否则取存在的) */
    private String frequenterLevelCode;
    /** 买家定性评级 */
    private String grade;

    /**
     * <p>
     * 默认构造函数
     * </p>
     */
    public ByimBuyer() {}

    /**
     * <p>
     * BUYER_ID
     * </p>
     *
     * @return BUYER_ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>
     * BUYER_ID
     * </p>
     *
     * @param buyerId BUYER_ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>
     * BUYER_CODE
     * </p>
     *
     * @return BUYER_CODE
     */
    public String getBuyerCode() {
        return buyerCode;
    }

    /**
     * <p>
     * BUYER_CODE
     * </p>
     *
     * @param buyerCode BUYER_CODE
     */
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    /**
     * <p>
     * BUYER_TYPE
     * </p>
     *
     * @return BUYER_TYPE
     */
    public String getBuyerType() {
        return buyerType;
    }

    /**
     * <p>
     * BUYER_TYPE
     * </p>
     *
     * @param buyerType BUYER_TYPE
     */
    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    /**
     * <p>
     * BUYER_TYPE_NAME
     * </p>
     *
     * @return BUYER_TYPE_NAME
     */
    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    /**
     * <p>
     * BUYER_TYPE_NAME
     * </p>
     *
     * @param buyerTypeName BUYER_TYPE_NAME
     */
    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }

    /**
     * <p>
     * BUYER_FIRST_CATEGORY
     * </p>
     *
     * @return BUYER_FIRST_CATEGORY
     */
    public String getBuyerFirstCategory() {
        return buyerFirstCategory;
    }

    /**
     * <p>
     * BUYER_FIRST_CATEGORY
     * </p>
     *
     * @param buyerFirstCategory BUYER_FIRST_CATEGORY
     */
    public void setBuyerFirstCategory(String buyerFirstCategory) {
        this.buyerFirstCategory = buyerFirstCategory;
    }

    /**
     * <p>
     * BUYER_FIRST_CATEGORY_NAME
     * </p>
     *
     * @return BUYER_FIRST_CATEGORY_NAME
     */
    public String getBuyerFirstCategoryName() {
        return buyerFirstCategoryName;
    }

    /**
     * <p>
     * BUYER_FIRST_CATEGORY_NAME
     * </p>
     *
     * @param buyerFirstCategoryName BUYER_FIRST_CATEGORY_NAME
     */
    public void setBuyerFirstCategoryName(String buyerFirstCategoryName) {
        this.buyerFirstCategoryName = buyerFirstCategoryName;
    }

    /**
     * <p>
     * BUYER_SUB_CATEGORY
     * </p>
     *
     * @return BUYER_SUB_CATEGORY
     */
    public String getBuyerSubCategory() {
        return buyerSubCategory;
    }

    /**
     * <p>
     * BUYER_SUB_CATEGORY
     * </p>
     *
     * @param buyerSubCategory BUYER_SUB_CATEGORY
     */
    public void setBuyerSubCategory(String buyerSubCategory) {
        this.buyerSubCategory = buyerSubCategory;
    }

    /**
     * <p>
     * BUYER_SUB_CATEGORY_NAME
     * </p>
     *
     * @return BUYER_SUB_CATEGORY_NAME
     */
    public String getBuyerSubCategoryName() {
        return buyerSubCategoryName;
    }

    /**
     * <p>
     * BUYER_SUB_CATEGORY_NAME
     * </p>
     *
     * @param buyerSubCategoryName BUYER_SUB_CATEGORY_NAME
     */
    public void setBuyerSubCategoryName(String buyerSubCategoryName) {
        this.buyerSubCategoryName = buyerSubCategoryName;
    }

    /**
     * <p>
     * BUYER_NAME
     * </p>
     *
     * @return BUYER_NAME
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * <p>
     * BUYER_NAME
     * </p>
     *
     * @param buyerName BUYER_NAME
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * <p>
     * BUYER_ADDR
     * </p>
     *
     * @return BUYER_ADDR
     */
    public String getBuyerAddr() {
        return buyerAddr;
    }

    /**
     * <p>
     * BUYER_ADDR
     * </p>
     *
     * @param buyerAddr BUYER_ADDR
     */
    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
    }

    /**
     * <p>
     * LGCS_AREA_ID
     * </p>
     *
     * @return LGCS_AREA_ID
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>
     * LGCS_AREA_ID
     * </p>
     *
     * @param lgcsAreaId LGCS_AREA_ID
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    /**
     * <p>
     * LGCS_AREA_CODE
     * </p>
     *
     * @return LGCS_AREA_CODE
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>
     * LGCS_AREA_CODE
     * </p>
     *
     * @param lgcsAreaCode LGCS_AREA_CODE
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * <p>
     * LGCS_AREA_NAME
     * </p>
     *
     * @return LGCS_AREA_NAME
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>
     * LGCS_AREA_NAME
     * </p>
     *
     * @param lgcsAreaName LGCS_AREA_NAME
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * <p>
     * PROVINCE_ID
     * </p>
     *
     * @return PROVINCE_ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * <p>
     * PROVINCE_ID
     * </p>
     *
     * @param provinceId PROVINCE_ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * <p>
     * PROVINCE_CODE
     * </p>
     *
     * @return PROVINCE_CODE
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>
     * PROVINCE_CODE
     * </p>
     *
     * @param provinceCode PROVINCE_CODE
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * <p>
     * PROVINCE_NAME
     * </p>
     *
     * @return PROVINCE_NAME
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>
     * PROVINCE_NAME
     * </p>
     *
     * @param provinceName PROVINCE_NAME
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * <p>
     * CITY_ID
     * </p>
     *
     * @return CITY_ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * <p>
     * CITY_ID
     * </p>
     *
     * @param cityId CITY_ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * <p>
     * CITY_CODE
     * </p>
     *
     * @return CITY_CODE
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>
     * CITY_CODE
     * </p>
     *
     * @param cityCode CITY_CODE
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * <p>
     * CITY_NAME
     * </p>
     *
     * @return CITY_NAME
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>
     * CITY_NAME
     * </p>
     *
     * @param cityName CITY_NAME
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * <p>
     * DISTRICT_ID
     * </p>
     *
     * @return DISTRICT_ID
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * <p>
     * DISTRICT_ID
     * </p>
     *
     * @param districtId DISTRICT_ID
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * <p>
     * DISTRICT_CODE
     * </p>
     *
     * @return DISTRICT_CODE
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>
     * DISTRICT_CODE
     * </p>
     *
     * @param districtCode DISTRICT_CODE
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>
     * DISTRICT_NAME
     * </p>
     *
     * @return DISTRICT_NAME
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * <p>
     * DISTRICT_NAME
     * </p>
     *
     * @param districtName DISTRICT_NAME
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * <p>
     * STREET_ID
     * </p>
     *
     * @return STREET_ID
     */
    public Long getStreetId() {
        return streetId;
    }

    /**
     * <p>
     * STREET_ID
     * </p>
     *
     * @param streetId STREET_ID
     */
    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    /**
     * <p>
     * STREET_CODE
     * </p>
     *
     * @return STREET_CODE
     */
    public String getStreetCode() {
        return streetCode;
    }

    /**
     * <p>
     * STREET_CODE
     * </p>
     *
     * @param streetCode STREET_CODE
     */
    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    /**
     * <p>
     * STREET_NAME
     * </p>
     *
     * @return STREET_NAME
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * <p>
     * STREET_NAME
     * </p>
     *
     * @param streetName STREET_NAME
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * <p>
     * BUYER_QQ
     * </p>
     *
     * @return BUYER_QQ
     */
    public String getBuyerQq() {
        return buyerQq;
    }

    /**
     * <p>
     * BUYER_QQ
     * </p>
     *
     * @param buyerQq BUYER_QQ
     */
    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }

    /**
     * <p>
     * BUYER_WECHAT
     * </p>
     *
     * @return BUYER_WECHAT
     */
    public String getBuyerWechat() {
        return buyerWechat;
    }

    /**
     * <p>
     * BUYER_WECHAT
     * </p>
     *
     * @param buyerWechat BUYER_WECHAT
     */
    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    /**
     * <p>
     * 有多个时以逗号隔开
     * </p>
     *
     * @return 有多个时以逗号隔开
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * <p>
     * 有多个时以逗号隔开
     * </p>
     *
     * @param paymentType 有多个时以逗号隔开
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * <p>
     * NORMAL_RECEIVE_TIME
     * </p>
     *
     * @return NORMAL_RECEIVE_TIME
     */
    public String getNormalReceiveTime() {
        return normalReceiveTime;
    }

    /**
     * <p>
     * NORMAL_RECEIVE_TIME
     * </p>
     *
     * @param normalReceiveTime NORMAL_RECEIVE_TIME
     */
    public void setNormalReceiveTime(String normalReceiveTime) {
        this.normalReceiveTime = normalReceiveTime;
    }

    /**
     * <p>
     * EARLIEST_TIME
     * </p>
     *
     * @return EARLIEST_TIME
     */
    public String getEarliestTime() {
        return earliestTime;
    }

    /**
     * <p>
     * EARLIEST_TIME
     * </p>
     *
     * @param earliestTime EARLIEST_TIME
     */
    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    /**
     * <p>
     * LATEST_TIME
     * </p>
     *
     * @return LATEST_TIME
     */
    public String getLatestTime() {
        return latestTime;
    }

    /**
     * <p>
     * LATEST_TIME
     * </p>
     *
     * @param latestTime LATEST_TIME
     */
    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    /**
     * <p>
     * TEL_MARKETING_TIME
     * </p>
     *
     * @return TEL_MARKETING_TIME
     */
    public String getTelMarketingTime() {
        return telMarketingTime;
    }

    /**
     * <p>
     * TEL_MARKETING_TIME
     * </p>
     *
     * @param telMarketingTime TEL_MARKETING_TIME
     */
    public void setTelMarketingTime(String telMarketingTime) {
        this.telMarketingTime = telMarketingTime;
    }

    /**
     * <p>
     * TEL_MARKETING_NO
     * </p>
     *
     * @return TEL_MARKETING_NO
     */
    public String getTelMarketingNo() {
        return telMarketingNo;
    }

    /**
     * <p>
     * TEL_MARKETING_NO
     * </p>
     *
     * @param telMarketingNo TEL_MARKETING_NO
     */
    public void setTelMarketingNo(String telMarketingNo) {
        this.telMarketingNo = telMarketingNo;
    }

    /**
     * <p>
     * WECHAT_MARKETING_NO
     * </p>
     *
     * @return WECHAT_MARKETING_NO
     */
    public String getWechatMarketingNo() {
        return wechatMarketingNo;
    }

    /**
     * <p>
     * WECHAT_MARKETING_NO
     * </p>
     *
     * @param wechatMarketingNo WECHAT_MARKETING_NO
     */
    public void setWechatMarketingNo(String wechatMarketingNo) {
        this.wechatMarketingNo = wechatMarketingNo;
    }

    /**
     * <p>
     * QQ_MARKETING_NO
     * </p>
     *
     * @return QQ_MARKETING_NO
     */
    public String getQqMarketingNo() {
        return qqMarketingNo;
    }

    /**
     * <p>
     * QQ_MARKETING_NO
     * </p>
     *
     * @param qqMarketingNo QQ_MARKETING_NO
     */
    public void setQqMarketingNo(String qqMarketingNo) {
        this.qqMarketingNo = qqMarketingNo;
    }

    /**
     * <p>
     * MARKETING_FIRST_STATUS
     * </p>
     *
     * @return MARKETING_FIRST_STATUS
     */
    public String getMarketingFirstStatus() {
        return marketingFirstStatus;
    }

    /**
     * <p>
     * MARKETING_FIRST_STATUS
     * </p>
     *
     * @param marketingFirstStatus MARKETING_FIRST_STATUS
     */
    public void setMarketingFirstStatus(String marketingFirstStatus) {
        this.marketingFirstStatus = marketingFirstStatus;
    }

    /**
     * <p>
     * MARKETING_FIRST_STATUS_NAME
     * </p>
     *
     * @return MARKETING_FIRST_STATUS_NAME
     */
    public String getMarketingFirstStatusName() {
        return marketingFirstStatusName;
    }

    /**
     * <p>
     * MARKETING_FIRST_STATUS_NAME
     * </p>
     *
     * @param marketingFirstStatusName MARKETING_FIRST_STATUS_NAME
     */
    public void setMarketingFirstStatusName(String marketingFirstStatusName) {
        this.marketingFirstStatusName = marketingFirstStatusName;
    }

    /**
     * <p>
     * MARKETING_SUB_STATUS
     * </p>
     *
     * @return MARKETING_SUB_STATUS
     */
    public String getMarketingSubStatus() {
        return marketingSubStatus;
    }

    /**
     * <p>
     * MARKETING_SUB_STATUS
     * </p>
     *
     * @param marketingSubStatus MARKETING_SUB_STATUS
     */
    public void setMarketingSubStatus(String marketingSubStatus) {
        this.marketingSubStatus = marketingSubStatus;
    }

    /**
     * <p>
     * MARKETING_SUB_STATUS_NAME
     * </p>
     *
     * @return MARKETING_SUB_STATUS_NAME
     */
    public String getMarketingSubStatusName() {
        return marketingSubStatusName;
    }

    /**
     * <p>
     * MARKETING_SUB_STATUS_NAME
     * </p>
     *
     * @param marketingSubStatusName MARKETING_SUB_STATUS_NAME
     */
    public void setMarketingSubStatusName(String marketingSubStatusName) {
        this.marketingSubStatusName = marketingSubStatusName;
    }

    /**
     * <p>
     * INFO_ERROR_FLG
     * </p>
     *
     * @return INFO_ERROR_FLG
     */
    public Boolean getInfoErrorFlg() {
        return infoErrorFlg;
    }

    /**
     * <p>
     * INFO_ERROR_FLG
     * </p>
     *
     * @param infoErrorFlg INFO_ERROR_FLG
     */
    public void setInfoErrorFlg(Boolean infoErrorFlg) {
        this.infoErrorFlg = infoErrorFlg;
    }

    /**
     * <p>
     * INFO_ERROR_REMARK
     * </p>
     *
     * @return INFO_ERROR_REMARK
     */
    public String getInfoErrorRemark() {
        return infoErrorRemark;
    }

    /**
     * <p>
     * INFO_ERROR_REMARK
     * </p>
     *
     * @param infoErrorRemark INFO_ERROR_REMARK
     */
    public void setInfoErrorRemark(String infoErrorRemark) {
        this.infoErrorRemark = infoErrorRemark;
    }

    /**
     * <p>
     * REGISTER_SOURCE
     * </p>
     *
     * @return REGISTER_SOURCE
     */
    public String getRegisterSource() {
        return registerSource;
    }

    /**
     * <p>
     * REGISTER_SOURCE
     * </p>
     *
     * @param registerSource REGISTER_SOURCE
     */
    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }

    /**
     * <p>
     * IS_CREDIT_TERM_BUYER
     * </p>
     *
     * @return IS_CREDIT_TERM_BUYER
     */
    public Boolean getIsCreditTermBuyer() {
        return isCreditTermBuyer;
    }

    /**
     * <p>
     * IS_CREDIT_TERM_BUYER
     * </p>
     *
     * @param isCreditTermBuyer IS_CREDIT_TERM_BUYER
     */
    public void setIsCreditTermBuyer(Boolean isCreditTermBuyer) {
        this.isCreditTermBuyer = isCreditTermBuyer;
    }

    /**
     * <p>
     * IS_CONTROL_PUERCHASNG_CHAIN
     * </p>
     *
     * @return IS_CONTROL_PUERCHASNG_CHAIN
     */
    public Boolean getIsControlPuerchasngChain() {
        return isControlPuerchasngChain;
    }

    /**
     * <p>
     * IS_CONTROL_PUERCHASNG_CHAIN
     * </p>
     *
     * @param isControlPuerchasngChain IS_CONTROL_PUERCHASNG_CHAIN
     */
    public void setIsControlPuerchasngChain(Boolean isControlPuerchasngChain) {
        this.isControlPuerchasngChain = isControlPuerchasngChain;
    }

    /**
     * <p>
     * REGISTER_SOURCE_NAME
     * </p>
     *
     * @return REGISTER_SOURCE_NAME
     */
    public String getRegisterSourceName() {
        return registerSourceName;
    }

    /**
     * <p>
     * REGISTER_SOURCE_NAME
     * </p>
     *
     * @param registerSourceName REGISTER_SOURCE_NAME
     */
    public void setRegisterSourceName(String registerSourceName) {
        this.registerSourceName = registerSourceName;
    }

    public String getFrequenterLevelF() {
        return frequenterLevelF;
    }

    public void setFrequenterLevelF(String frequenterLevelF) {
        this.frequenterLevelF = frequenterLevelF;
    }

    public String getFrequenterLevelA() {
        return frequenterLevelA;
    }

    public void setFrequenterLevelA(String frequenterLevelA) {
        this.frequenterLevelA = frequenterLevelA;
    }

    public Boolean getCreditTermBuyer() {
        return isCreditTermBuyer;
    }

    public void setCreditTermBuyer(Boolean creditTermBuyer) {
        isCreditTermBuyer = creditTermBuyer;
    }

    public Boolean getControlPuerchasngChain() {
        return isControlPuerchasngChain;
    }

    public void setControlPuerchasngChain(Boolean controlPuerchasngChain) {
        isControlPuerchasngChain = controlPuerchasngChain;
    }

    public String getFrequenterLevelCode() {
        return frequenterLevelCode;
    }

    public void setFrequenterLevelCode(String frequenterLevelCode) {
        this.frequenterLevelCode = frequenterLevelCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
