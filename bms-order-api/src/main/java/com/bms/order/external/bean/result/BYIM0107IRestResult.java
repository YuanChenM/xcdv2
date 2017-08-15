package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * 买家基本信息查询接口，出参
 * 
 * @author li_huiqian
 *
 */
public class BYIM0107IRestResult implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4010525100512770683L;
    /** 买家ID */
    private String buyerId;
    /** 买家名称 */
    private String buyerName;
    /** 买家编码 */
    private String buyerCode;
    /** 买家地址 */
    private String buyerAddr;
    /** 买家类型 */
    private String buyerType;
    /** 买家类型名称 */
    private String buyerTypeName;
    /** 买家一级分类编码 */
    private String buyerFirstCategory;
    /** 买家一级分类名称 */
    private String buyerFirstCategoryName;
    /** 是否为账期用户买家 */
    private Boolean isCreditTermBuyer;
    /** 是否总部控制采购连锁 */
    private Boolean isControlPurchasngChain;
    /** 物流区ID */
    private Long lgcsAreaId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区名称 */
    private String lgcsAreaName;
    /** 省ID */
    private Long provinceId;
    /** 省编码 */
    private String provinceCode;
    /** 省名称 */
    private String provinceName;
    /** 市ID */
    private Long cityId;
    /** 市编码 */
    private String cityCode;
    /** 市名称 */
    private String cityName;
    /** 区县ID */
    private Long districtId;
    /** 区县编码 */
    private String districtCode;
    /** 区县名称 */
    private String districtName;
    /** 街道ID */
    private Long streetId;
    /** 街道编码 */
    private String streetCode;
    /** 街道名称 */
    private String streetName;
    /** 买家QQ */
    private String buyerQq;
    /** 买家微信 */
    private String buyerWechat;
    /** 买家习惯支付方式 */
    private String paymentType;
    /** 买家正常收货时间段 */
    private String normalReceiveTime;
    /** 最早时间 */
    private String earliestTime;
    /** 最晚时间 */
    private String latestTime;
    /** 电话营销标准时间段 */
    private String telMarketingTime;
    /** 电话营销号码 */
    private String telMarketingNo;
    /** 微信营销号 */
    private String weichatMarketingNo;
    /** QQ营销号 */
    private String qqMarketingNo;
    /** 上线状态一级分类 */
    private String marketingFirstStatus;
    /** 上线状态一级分类名称 */
    private String marketingFirstStatusName;
    /** 上线状态二级分类 */
    private String marketingSubStatus;
    /** 上线状态二级分类名称 */
    private String marketingSubStatusName;
    /** 信息错误买家 */
    private Boolean infoErrorFlg;
    /** 信息错误备注 */
    private String infoErrorRemark;
    /** 买家注册来源 */
    private String registerSource;
    /** 买家注册来源名称 */
    private String registerSourceName;
    /** 市场ID */
    private String marketId;
    /** 市场编码 */
    private String marketCode;
    /** 市场名称 */
    private String marketName;
    /** 市场类型 */
    private String marketType;
    /** 市场规模 */
    private String marketScale;
    /** 法人证件类型 */
    private String legalPaperType;
    /** 法人证件号 */
    private String legalPaperNo;
    /** 经营地址 */
    private String storeAddr;
    /** 店铺ID */
    private String storeId;
    /** 店铺号 */
    private String storeNo;
    /** 店铺营业电话 */
    private String storeTel;
    /** 店铺网址 */
    private String storeWebsite;
    /** 店铺微信公众号 */
    private String storeWechat;
    /** 店铺营业执照类型 */
    private String storeLicenseType;
    /** 店铺营业执照号 */
    private String storeLicenseNo;
    /** 买家注册帐号名 */
    private String accountName;
    /** 买家注册手机号 */
    private String telNo;
    /** 买家注册邮箱 */
    private String mailAddr;

    private String frequenterLevelCode;

    private Long distributionId;

    private String distributionName;

    private String distributionCode;


    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerAddr() {
        return buyerAddr;
    }

    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }

    public String getBuyerFirstCategory() {
        return buyerFirstCategory;
    }

    public void setBuyerFirstCategory(String buyerFirstCategory) {
        this.buyerFirstCategory = buyerFirstCategory;
    }

    public String getBuyerFirstCategoryName() {
        return buyerFirstCategoryName;
    }

    public void setBuyerFirstCategoryName(String buyerFirstCategoryName) {
        this.buyerFirstCategoryName = buyerFirstCategoryName;
    }

    public Boolean getIsCreditTermBuyer() {
        return isCreditTermBuyer;
    }

    public void setIsCreditTermBuyer(Boolean isCreditTermBuyer) {
        this.isCreditTermBuyer = isCreditTermBuyer;
    }

    public Boolean getIsControlPurchasngChain() {
        return isControlPurchasngChain;
    }

    public void setIsControlPurchasngChain(Boolean isControlPurchasngChain) {
        this.isControlPurchasngChain = isControlPurchasngChain;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
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

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuyerQq() {
        return buyerQq;
    }

    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }

    public String getBuyerWechat() {
        return buyerWechat;
    }

    public void setBuyerWechat(String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNormalReceiveTime() {
        return normalReceiveTime;
    }

    public void setNormalReceiveTime(String normalReceiveTime) {
        this.normalReceiveTime = normalReceiveTime;
    }

    public String getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public String getTelMarketingTime() {
        return telMarketingTime;
    }

    public void setTelMarketingTime(String telMarketingTime) {
        this.telMarketingTime = telMarketingTime;
    }

    public String getTelMarketingNo() {
        return telMarketingNo;
    }

    public void setTelMarketingNo(String telMarketingNo) {
        this.telMarketingNo = telMarketingNo;
    }

    public String getWeichatMarketingNo() {
        return weichatMarketingNo;
    }

    public void setWeichatMarketingNo(String weichatMarketingNo) {
        this.weichatMarketingNo = weichatMarketingNo;
    }

    public String getQqMarketingNo() {
        return qqMarketingNo;
    }

    public void setQqMarketingNo(String qqMarketingNo) {
        this.qqMarketingNo = qqMarketingNo;
    }

    public String getMarketingFirstStatus() {
        return marketingFirstStatus;
    }

    public void setMarketingFirstStatus(String marketingFirstStatus) {
        this.marketingFirstStatus = marketingFirstStatus;
    }

    public String getMarketingFirstStatusName() {
        return marketingFirstStatusName;
    }

    public void setMarketingFirstStatusName(String marketingFirstStatusName) {
        this.marketingFirstStatusName = marketingFirstStatusName;
    }

    public String getMarketingSubStatus() {
        return marketingSubStatus;
    }

    public void setMarketingSubStatus(String marketingSubStatus) {
        this.marketingSubStatus = marketingSubStatus;
    }

    public String getMarketingSubStatusName() {
        return marketingSubStatusName;
    }

    public void setMarketingSubStatusName(String marketingSubStatusName) {
        this.marketingSubStatusName = marketingSubStatusName;
    }

    public Boolean getInfoErrorFlg() {
        return infoErrorFlg;
    }

    public void setInfoErrorFlg(Boolean infoErrorFlg) {
        this.infoErrorFlg = infoErrorFlg;
    }

    public String getInfoErrorRemark() {
        return infoErrorRemark;
    }

    public void setInfoErrorRemark(String infoErrorRemark) {
        this.infoErrorRemark = infoErrorRemark;
    }

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }

    public String getRegisterSourceName() {
        return registerSourceName;
    }

    public void setRegisterSourceName(String registerSourceName) {
        this.registerSourceName = registerSourceName;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getMarketScale() {
        return marketScale;
    }

    public void setMarketScale(String marketScale) {
        this.marketScale = marketScale;
    }

    public String getLegalPaperType() {
        return legalPaperType;
    }

    public void setLegalPaperType(String legalPaperType) {
        this.legalPaperType = legalPaperType;
    }

    public String getLegalPaperNo() {
        return legalPaperNo;
    }

    public void setLegalPaperNo(String legalPaperNo) {
        this.legalPaperNo = legalPaperNo;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }

    public String getStoreWebsite() {
        return storeWebsite;
    }

    public void setStoreWebsite(String storeWebsite) {
        this.storeWebsite = storeWebsite;
    }

    public String getStoreWechat() {
        return storeWechat;
    }

    public void setStoreWechat(String storeWechat) {
        this.storeWechat = storeWechat;
    }

    public String getStoreLicenseType() {
        return storeLicenseType;
    }

    public void setStoreLicenseType(String storeLicenseType) {
        this.storeLicenseType = storeLicenseType;
    }

    public String getStoreLicenseNo() {
        return storeLicenseNo;
    }

    public void setStoreLicenseNo(String storeLicenseNo) {
        this.storeLicenseNo = storeLicenseNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getFrequenterLevelCode() {
        return frequenterLevelCode;
    }

    public void setFrequenterLevelCode(String frequenterLevelCode) {
        this.frequenterLevelCode = frequenterLevelCode;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }
}
