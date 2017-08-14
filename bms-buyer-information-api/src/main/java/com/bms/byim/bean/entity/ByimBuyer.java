/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表byim_buyer对应的实体ByimBuyer</p>
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
    /** DISPLAY_CODE */
    private String displayCode;
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
    /** 物流区划地区主键 */
    private Long zoneId;
    /** 物流区划地区编码 */
    private String zoneCode;
    /** 物流区划地区名称 */
    private String zoneName;
    /** 配送站主键 */
    private Long distributionId;
    /** 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码) */
    private String distributionCode;
    /** 配送站名称 */
    private String distributionName;
    /** 领地ID */
    private Long demesneId;
    /** 领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码) */
    private String demesneCode;
    /** 领地名称 */
    private String demesneName;
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
    /** REGISTER_SOURCE_NAME */
    private String registerSourceName;
    /** IS_CREDIT_TERM_BUYER */
    private Boolean isCreditTermBuyer;
    /** IS_CONTROL_PUERCHASNG_CHAIN */
    private Boolean isControlPuerchasngChain;
    /** FREQUENTER_LEVEL_F */
    private String frequenterLevelF;
    /** FREQUENTER_LEVEL_A */
    private String frequenterLevelA;
    /** FREQUENTER_LEVEL_CODE */
    private String frequenterLevelCode;
    /** GRADE */
    private String grade;
    /** 账期周期类型 有四个时间段 01:0天  02:15天  03:30天 04:45天  默认01 */
    private java.lang.String paymentPeriodType;
    /** 账期周期名称 */
    private java.lang.String paymentPeriodName;
    /**
     * <p>默认构造函数</p>
     */
    public ByimBuyer() {
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
     * <p>BUYER_CODE</p>
     *
     * @return BUYER_CODE
     */
    public String getBuyerCode() {
        return buyerCode;
    }

    /**
     * <p>BUYER_CODE</p>
     *
     * @param buyerCode BUYER_CODE
     */
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }
    /**
     * <p>DISPLAY_CODE</p>
     *
     * @return DISPLAY_CODE
     */
    public String getDisplayCode() {
        return displayCode;
    }
    /**
     * <p>DISPLAY_CODE</p>
     *
     * @param displayCode DISPLAY_CODE
     */
    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }
    /**
     * <p>BUYER_TYPE</p>
     *
     * @return BUYER_TYPE
     */
    public String getBuyerType() {
        return buyerType;
    }

    /**
     * <p>BUYER_TYPE</p>
     *
     * @param buyerType BUYER_TYPE
     */
    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }
    /**
     * <p>BUYER_TYPE_NAME</p>
     *
     * @return BUYER_TYPE_NAME
     */
    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    /**
     * <p>BUYER_TYPE_NAME</p>
     *
     * @param buyerTypeName BUYER_TYPE_NAME
     */
    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }
    /**
     * <p>BUYER_FIRST_CATEGORY</p>
     *
     * @return BUYER_FIRST_CATEGORY
     */
    public String getBuyerFirstCategory() {
        return buyerFirstCategory;
    }

    /**
     * <p>BUYER_FIRST_CATEGORY</p>
     *
     * @param buyerFirstCategory BUYER_FIRST_CATEGORY
     */
    public void setBuyerFirstCategory(String buyerFirstCategory) {
        this.buyerFirstCategory = buyerFirstCategory;
    }
    /**
     * <p>BUYER_FIRST_CATEGORY_NAME</p>
     *
     * @return BUYER_FIRST_CATEGORY_NAME
     */
    public String getBuyerFirstCategoryName() {
        return buyerFirstCategoryName;
    }

    /**
     * <p>BUYER_FIRST_CATEGORY_NAME</p>
     *
     * @param buyerFirstCategoryName BUYER_FIRST_CATEGORY_NAME
     */
    public void setBuyerFirstCategoryName(String buyerFirstCategoryName) {
        this.buyerFirstCategoryName = buyerFirstCategoryName;
    }
    /**
     * <p>BUYER_SUB_CATEGORY</p>
     *
     * @return BUYER_SUB_CATEGORY
     */
    public String getBuyerSubCategory() {
        return buyerSubCategory;
    }

    /**
     * <p>BUYER_SUB_CATEGORY</p>
     *
     * @param buyerSubCategory BUYER_SUB_CATEGORY
     */
    public void setBuyerSubCategory(String buyerSubCategory) {
        this.buyerSubCategory = buyerSubCategory;
    }
    /**
     * <p>BUYER_SUB_CATEGORY_NAME</p>
     *
     * @return BUYER_SUB_CATEGORY_NAME
     */
    public String getBuyerSubCategoryName() {
        return buyerSubCategoryName;
    }

    /**
     * <p>BUYER_SUB_CATEGORY_NAME</p>
     *
     * @param buyerSubCategoryName BUYER_SUB_CATEGORY_NAME
     */
    public void setBuyerSubCategoryName(String buyerSubCategoryName) {
        this.buyerSubCategoryName = buyerSubCategoryName;
    }
    /**
     * <p>BUYER_NAME</p>
     *
     * @return BUYER_NAME
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * <p>BUYER_NAME</p>
     *
     * @param buyerName BUYER_NAME
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    /**
     * <p>BUYER_ADDR</p>
     *
     * @return BUYER_ADDR
     */
    public String getBuyerAddr() {
        return buyerAddr;
    }

    /**
     * <p>BUYER_ADDR</p>
     *
     * @param buyerAddr BUYER_ADDR
     */
    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
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
     * <p>物流区划地区主键</p>
     *
     * @return 物流区划地区主键
     */
    public Long getZoneId() {
        return zoneId;
    }

    /**
     * <p>物流区划地区主键</p>
     *
     * @param zoneId 物流区划地区主键
     */
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
    /**
     * <p>物流区划地区编码</p>
     *
     * @return 物流区划地区编码
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * <p>物流区划地区编码</p>
     *
     * @param zoneCode 物流区划地区编码
     */
    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
    /**
     * <p>物流区划地区名称</p>
     *
     * @return 物流区划地区名称
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * <p>物流区划地区名称</p>
     *
     * @param zoneName 物流区划地区名称
     */
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    /**
     * <p>配送站主键</p>
     *
     * @return 配送站主键
     */
    public Long getDistributionId() {
        return distributionId;
    }

    /**
     * <p>配送站主键</p>
     *
     * @param distributionId 配送站主键
     */
    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }
    /**
     * <p>配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)</p>
     *
     * @return 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)
     */
    public String getDistributionCode() {
        return distributionCode;
    }

    /**
     * <p>配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)</p>
     *
     * @param distributionCode 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)
     */
    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }
    /**
     * <p>配送站名称</p>
     *
     * @return 配送站名称
     */
    public String getDistributionName() {
        return distributionName;
    }

    /**
     * <p>配送站名称</p>
     *
     * @param distributionName 配送站名称
     */
    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }
    /**
     * <p>领地ID</p>
     *
     * @return 领地ID
     */
    public Long getDemesneId() {
        return demesneId;
    }

    /**
     * <p>领地ID</p>
     *
     * @param demesneId 领地ID
     */
    public void setDemesneId(Long demesneId) {
        this.demesneId = demesneId;
    }
    /**
     * <p>领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)</p>
     *
     * @return 领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)
     */
    public String getDemesneCode() {
        return demesneCode;
    }

    /**
     * <p>领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)</p>
     *
     * @param demesneCode 领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)
     */
    public void setDemesneCode(String demesneCode) {
        this.demesneCode = demesneCode;
    }
    /**
     * <p>领地名称</p>
     *
     * @return 领地名称
     */
    public String getDemesneName() {
        return demesneName;
    }

    /**
     * <p>领地名称</p>
     *
     * @param demesneName 领地名称
     */
    public void setDemesneName(String demesneName) {
        this.demesneName = demesneName;
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
     * <p>BUYER_QQ</p>
     *
     * @return BUYER_QQ
     */
    public String getBuyerQq() {
        return buyerQq;
    }

    /**
     * <p>BUYER_QQ</p>
     *
     * @param buyerQq BUYER_QQ
     */
    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }
    /**
     * <p>BUYER_WECHAT</p>
     *
     * @return BUYER_WECHAT
     */
    public String getBuyerWechat() {
        return buyerWechat;
    }

    /**
     * <p>BUYER_WECHAT</p>
     *
     * @param buyerWechat BUYER_WECHAT
     */
    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }
    /**
     * <p>有多个时以逗号隔开</p>
     *
     * @return 有多个时以逗号隔开
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * <p>有多个时以逗号隔开</p>
     *
     * @param paymentType 有多个时以逗号隔开
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    /**
     * <p>NORMAL_RECEIVE_TIME</p>
     *
     * @return NORMAL_RECEIVE_TIME
     */
    public String getNormalReceiveTime() {
        return normalReceiveTime;
    }

    /**
     * <p>NORMAL_RECEIVE_TIME</p>
     *
     * @param normalReceiveTime NORMAL_RECEIVE_TIME
     */
    public void setNormalReceiveTime(String normalReceiveTime) {
        this.normalReceiveTime = normalReceiveTime;
    }
    /**
     * <p>EARLIEST_TIME</p>
     *
     * @return EARLIEST_TIME
     */
    public String getEarliestTime() {
        return earliestTime;
    }

    /**
     * <p>EARLIEST_TIME</p>
     *
     * @param earliestTime EARLIEST_TIME
     */
    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }
    /**
     * <p>LATEST_TIME</p>
     *
     * @return LATEST_TIME
     */
    public String getLatestTime() {
        return latestTime;
    }

    /**
     * <p>LATEST_TIME</p>
     *
     * @param latestTime LATEST_TIME
     */
    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }
    /**
     * <p>TEL_MARKETING_TIME</p>
     *
     * @return TEL_MARKETING_TIME
     */
    public String getTelMarketingTime() {
        return telMarketingTime;
    }

    /**
     * <p>TEL_MARKETING_TIME</p>
     *
     * @param telMarketingTime TEL_MARKETING_TIME
     */
    public void setTelMarketingTime(String telMarketingTime) {
        this.telMarketingTime = telMarketingTime;
    }
    /**
     * <p>TEL_MARKETING_NO</p>
     *
     * @return TEL_MARKETING_NO
     */
    public String getTelMarketingNo() {
        return telMarketingNo;
    }

    /**
     * <p>TEL_MARKETING_NO</p>
     *
     * @param telMarketingNo TEL_MARKETING_NO
     */
    public void setTelMarketingNo(String telMarketingNo) {
        this.telMarketingNo = telMarketingNo;
    }
    /**
     * <p>WECHAT_MARKETING_NO</p>
     *
     * @return WECHAT_MARKETING_NO
     */
    public String getWechatMarketingNo() {
        return wechatMarketingNo;
    }

    /**
     * <p>WECHAT_MARKETING_NO</p>
     *
     * @param wechatMarketingNo WECHAT_MARKETING_NO
     */
    public void setWechatMarketingNo(String wechatMarketingNo) {
        this.wechatMarketingNo = wechatMarketingNo;
    }
    /**
     * <p>QQ_MARKETING_NO</p>
     *
     * @return QQ_MARKETING_NO
     */
    public String getQqMarketingNo() {
        return qqMarketingNo;
    }

    /**
     * <p>QQ_MARKETING_NO</p>
     *
     * @param qqMarketingNo QQ_MARKETING_NO
     */
    public void setQqMarketingNo(String qqMarketingNo) {
        this.qqMarketingNo = qqMarketingNo;
    }
    /**
     * <p>MARKETING_FIRST_STATUS</p>
     *
     * @return MARKETING_FIRST_STATUS
     */
    public String getMarketingFirstStatus() {
        return marketingFirstStatus;
    }

    /**
     * <p>MARKETING_FIRST_STATUS</p>
     *
     * @param marketingFirstStatus MARKETING_FIRST_STATUS
     */
    public void setMarketingFirstStatus(String marketingFirstStatus) {
        this.marketingFirstStatus = marketingFirstStatus;
    }
    /**
     * <p>MARKETING_FIRST_STATUS_NAME</p>
     *
     * @return MARKETING_FIRST_STATUS_NAME
     */
    public String getMarketingFirstStatusName() {
        return marketingFirstStatusName;
    }

    /**
     * <p>MARKETING_FIRST_STATUS_NAME</p>
     *
     * @param marketingFirstStatusName MARKETING_FIRST_STATUS_NAME
     */
    public void setMarketingFirstStatusName(String marketingFirstStatusName) {
        this.marketingFirstStatusName = marketingFirstStatusName;
    }
    /**
     * <p>MARKETING_SUB_STATUS</p>
     *
     * @return MARKETING_SUB_STATUS
     */
    public String getMarketingSubStatus() {
        return marketingSubStatus;
    }

    /**
     * <p>MARKETING_SUB_STATUS</p>
     *
     * @param marketingSubStatus MARKETING_SUB_STATUS
     */
    public void setMarketingSubStatus(String marketingSubStatus) {
        this.marketingSubStatus = marketingSubStatus;
    }
    /**
     * <p>MARKETING_SUB_STATUS_NAME</p>
     *
     * @return MARKETING_SUB_STATUS_NAME
     */
    public String getMarketingSubStatusName() {
        return marketingSubStatusName;
    }

    /**
     * <p>MARKETING_SUB_STATUS_NAME</p>
     *
     * @param marketingSubStatusName MARKETING_SUB_STATUS_NAME
     */
    public void setMarketingSubStatusName(String marketingSubStatusName) {
        this.marketingSubStatusName = marketingSubStatusName;
    }
    /**
     * <p>INFO_ERROR_FLG</p>
     *
     * @return INFO_ERROR_FLG
     */
    public Boolean getInfoErrorFlg() {
        return infoErrorFlg;
    }

    /**
     * <p>INFO_ERROR_FLG</p>
     *
     * @param infoErrorFlg INFO_ERROR_FLG
     */
    public void setInfoErrorFlg(Boolean infoErrorFlg) {
        this.infoErrorFlg = infoErrorFlg;
    }
    /**
     * <p>INFO_ERROR_REMARK</p>
     *
     * @return INFO_ERROR_REMARK
     */
    public String getInfoErrorRemark() {
        return infoErrorRemark;
    }

    /**
     * <p>INFO_ERROR_REMARK</p>
     *
     * @param infoErrorRemark INFO_ERROR_REMARK
     */
    public void setInfoErrorRemark(String infoErrorRemark) {
        this.infoErrorRemark = infoErrorRemark;
    }
    /**
     * <p>REGISTER_SOURCE</p>
     *
     * @return REGISTER_SOURCE
     */
    public String getRegisterSource() {
        return registerSource;
    }

    /**
     * <p>REGISTER_SOURCE</p>
     *
     * @param registerSource REGISTER_SOURCE
     */
    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }
    /**
     * <p>REGISTER_SOURCE_NAME</p>
     *
     * @return REGISTER_SOURCE_NAME
     */
    public String getRegisterSourceName() {
        return registerSourceName;
    }

    /**
     * <p>REGISTER_SOURCE_NAME</p>
     *
     * @param registerSourceName REGISTER_SOURCE_NAME
     */
    public void setRegisterSourceName(String registerSourceName) {
        this.registerSourceName = registerSourceName;
    }
    /**
     * <p>IS_CREDIT_TERM_BUYER</p>
     *
     * @return IS_CREDIT_TERM_BUYER
     */
    public Boolean getIsCreditTermBuyer() {
        return isCreditTermBuyer;
    }

    /**
     * <p>IS_CREDIT_TERM_BUYER</p>
     *
     * @param isCreditTermBuyer IS_CREDIT_TERM_BUYER
     */
    public void setIsCreditTermBuyer(Boolean isCreditTermBuyer) {
        this.isCreditTermBuyer = isCreditTermBuyer;
    }
    /**
     * <p>IS_CONTROL_PUERCHASNG_CHAIN</p>
     *
     * @return IS_CONTROL_PUERCHASNG_CHAIN
     */
    public Boolean getIsControlPuerchasngChain() {
        return isControlPuerchasngChain;
    }

    /**
     * <p>IS_CONTROL_PUERCHASNG_CHAIN</p>
     *
     * @param isControlPuerchasngChain IS_CONTROL_PUERCHASNG_CHAIN
     */
    public void setIsControlPuerchasngChain(Boolean isControlPuerchasngChain) {
        this.isControlPuerchasngChain = isControlPuerchasngChain;
    }
    /**
     * <p>FREQUENTER_LEVEL_F</p>
     *
     * @return FREQUENTER_LEVEL_F
     */
    public String getFrequenterLevelF() {
        return frequenterLevelF;
    }

    /**
     * <p>FREQUENTER_LEVEL_F</p>
     *
     * @param frequenterLevelF FREQUENTER_LEVEL_F
     */
    public void setFrequenterLevelF(String frequenterLevelF) {
        this.frequenterLevelF = frequenterLevelF;
    }
    /**
     * <p>FREQUENTER_LEVEL_A</p>
     *
     * @return FREQUENTER_LEVEL_A
     */
    public String getFrequenterLevelA() {
        return frequenterLevelA;
    }

    /**
     * <p>FREQUENTER_LEVEL_A</p>
     *
     * @param frequenterLevelA FREQUENTER_LEVEL_A
     */
    public void setFrequenterLevelA(String frequenterLevelA) {
        this.frequenterLevelA = frequenterLevelA;
    }
    /**
     * <p>FREQUENTER_LEVEL_CODE</p>
     *
     * @return FREQUENTER_LEVEL_CODE
     */
    public String getFrequenterLevelCode() {
        return frequenterLevelCode;
    }

    /**
     * <p>FREQUENTER_LEVEL_CODE</p>
     *
     * @param frequenterLevelCode FREQUENTER_LEVEL_CODE
     */
    public void setFrequenterLevelCode(String frequenterLevelCode) {
        this.frequenterLevelCode = frequenterLevelCode;
    }
    /**
     * <p>GRADE</p>
     *
     * @return GRADE
     */
    public String getGrade() {
        return grade;
    }

    /**
     * <p>GRADE</p>
     *
     * @param grade GRADE
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
    /**
     * <p>账期周期类型 有四个时间段 01:15天  02:30天 03:45天</p>
     *
     * @return 账期周期类型 有四个时间段 01:15天  02:30天 03:45天
     */
    public java.lang.String getPaymentPeriodType() {
        return paymentPeriodType;
    }

    /**
     * <p>账期周期类型 有四个时间段 01:15天  02:30天 03:45天</p>
     *
     * @param paymentPeriodType 账期周期类型 有四个时间段 01:15天  02:30天 03:45天
     */
    public void setPaymentPeriodType(java.lang.String paymentPeriodType) {
        this.paymentPeriodType = paymentPeriodType;
    }
    /**
     * <p>账期周期名称</p>
     *
     * @return 账期周期名称
     */
    public java.lang.String getPaymentPeriodName() {
        return paymentPeriodName;
    }

    /**
     * <p>账期周期名称</p>
     *
     * @param paymentPeriodName 账期周期名称
     */
    public void setPaymentPeriodName(java.lang.String paymentPeriodName) {
        this.paymentPeriodName = paymentPeriodName;
    }
}
