package com.bms.byim.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhou_yajun
 * @version 1.0
 */
@ApiModel(value = "BuyerOtherRsParam", description = "买家其余信息更新接口参数")
public class BuyerOtherRsParam implements Serializable {
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "店铺ID")
    private Long storeId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "买家名称")
    private String buyerName;
    @ApiModelProperty(value = "买家地址")
    private String buyerAddr;
    @ApiModelProperty(value = "买家QQ")
    private String buyerQq;
    @ApiModelProperty(value = "买家微信")
    private String buyerWechat;
    @ApiModelProperty(value = "买家支付方式")
    /** 有多个时以逗号隔开 */
    private String paymentType;
    @ApiModelProperty(value = "正常收货时间")
    private String normalReceiveTime;
    @ApiModelProperty(value = "最早时间")
    private String earliestTime;
    @ApiModelProperty(value = "最晚时间")
    private String latestTime;
    @ApiModelProperty(value = "电话营销时间段")
    private String telMarketingTime;
    @ApiModelProperty(value = "电话营销号码")
    private String telMarketingNo;
    @ApiModelProperty(value = "微信营销号")
    private String wechatMarketingNo;
    @ApiModelProperty(value = "QQ营销号")
    private String qqMarketingNo;
    @ApiModelProperty(value = "上线状态一级分类")
    private String marketingFirstStatus;
    @ApiModelProperty(value = "上线状态一级分类名称")
    private String marketingFirstStatusName;
    @ApiModelProperty(value = "上线状态二级分类")
    private String marketingSubStatus;
    @ApiModelProperty(value = "上线状态二级分类名称")
    private String marketingSubStatusName;
    @ApiModelProperty(value = "是否信息错误")
    private boolean infoErrorFlg;
    @ApiModelProperty(value = "信息错误备注")
    private String infoErrorRemark;
    @ApiModelProperty(value = "法人名称")
    private String legalPaperName;
    @ApiModelProperty(value = "法人证件类型")
    private String legalPaperType;
    @ApiModelProperty(value = "法人证件号")
    private String legalPaperNo;
    @ApiModelProperty(value = "法人证件照地址")
    private String legalPaperPic;
    @ApiModelProperty(value = "店铺经营地址")
    private String storeAddr;
    @ApiModelProperty(value = "店铺号")
    private String storeNo;
    @ApiModelProperty(value = "店铺营业电话")
    private String storeTel;
    @ApiModelProperty(value = "店铺网址")
    private String storeWebsite;
    @ApiModelProperty(value = "店铺微信公众号")
    private String storeWechat;
    @ApiModelProperty(value = "店铺营业执照类型")
    private String storeLicenseType;
    @ApiModelProperty(value = "店铺营业执照号")
    private String storeLicenseNo;
    @ApiModelProperty(value = "是否默认店铺")
    private boolean defaultStoreFlg;
    @ApiModelProperty(value = "登记人")
    private java.lang.String registrantId;
    @ApiModelProperty(value = "登记日")
    private java.util.Date registrantDate;
    @ApiModelProperty(value = "预注册人")
    private java.lang.String preRegistrantId;
    @ApiModelProperty(value = "预注册日")
    private java.util.Date preRegistrationDate;
    @ApiModelProperty(value = "物流区ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "物流区划地区主键")
    private Long zoneId;
    @ApiModelProperty(value = "物流区划地区编码")
    private String zoneCode;
    @ApiModelProperty(value = "物流区划地区名称")
    private String zoneName;
    @ApiModelProperty(value = "配送站主键")
    private Long distributionId;
    @ApiModelProperty(value = "配送站编码")
    private String distributionCode;
    @ApiModelProperty(value = "配送站名称")
    private String distributionName;
    @ApiModelProperty(value = "领地ID")
    private Long demesneId;
    @ApiModelProperty(value = "领地编码")
    private String demesneCode;
    @ApiModelProperty(value = "领地名称")
    private String demesneName;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;
    @ApiModelProperty(value = "创建者")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新着")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;
    @ApiModelProperty(value = "是否为账期用户买手")
    private java.lang.Boolean isCreditTermBuyer;
    @ApiModelProperty(value = "是否总部控制采购连锁")
    private java.lang.Boolean isControlPuerchasngChain;
    @ApiModelProperty(value = "省ID")
    private Long provinceId;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "城市ID")
    private Long cityId;
    @ApiModelProperty(value = "城市编码")
    private String cityCode;
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    @ApiModelProperty(value = "区县ID")
    private Long districtId;
    @ApiModelProperty(value = "区县编码")
    private String districtCode;
    @ApiModelProperty(value = "区县名称")
    private String districtName;
    @ApiModelProperty(value = "街道ID")
    private Long streetId;
    @ApiModelProperty(value = "街道编码")
    private String streetCode;
    @ApiModelProperty(value = "街道名称")
    private String streetName;
    @ApiModelProperty(value = "市场ID")
    private String marketId;
    @ApiModelProperty(value = "市场编码")
    private String marketCode;
    @ApiModelProperty(value = "市场名称")
    private String marketName;
    @ApiModelProperty(value = "市场规模编码")
    private String marketScaleCode;
    @ApiModelProperty(value = "市场规模")
    private String marketScale;
    @ApiModelProperty(value = "是否修改物流区划信息")
    private String modifyLgcs;
    @ApiModelProperty(value = "账期周期类型")
    private java.lang.String paymentPeriodType;
    @ApiModelProperty(value = "账期周期名称")
    private java.lang.String paymentPeriodName;
    @ApiModelProperty(value = "买家类型")
    private String buyerType;
    @ApiModelProperty(value = "买家类型名称")
    private String buyerTypeName;
    @ApiModelProperty(value = "买家一级分类编码")
    private String buyerFirstCategory;
    @ApiModelProperty(value = "买家一级分类编码名称")
    private String buyerFirstCategoryName;

    public String getBuyerId() {
        return buyerId;
    }

    public Boolean getIsCreditTermBuyer() {
        return isCreditTermBuyer;
    }

    public void setIsCreditTermBuyer(Boolean isCreditTermBuyer) {
        this.isCreditTermBuyer = isCreditTermBuyer;
    }

    public Boolean getIsControlPuerchasngChain() {
        return isControlPuerchasngChain;
    }

    public void setIsControlPuerchasngChain(Boolean isControlPuerchasngChain) {
        this.isControlPuerchasngChain = isControlPuerchasngChain;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddr() {
        return buyerAddr;
    }

    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
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

    public String getWechatMarketingNo() {
        return wechatMarketingNo;
    }

    public void setWechatMarketingNo(String wechatMarketingNo) {
        this.wechatMarketingNo = wechatMarketingNo;
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

    public String getInfoErrorRemark() {
        return infoErrorRemark;
    }

    public void setInfoErrorRemark(String infoErrorRemark) {
        this.infoErrorRemark = infoErrorRemark;
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

    public String getLegalPaperPic() {
        return legalPaperPic;
    }

    public void setLegalPaperPic(String legalPaperPic) {
        this.legalPaperPic = legalPaperPic;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
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

    public boolean isDefaultStoreFlg() {
        return defaultStoreFlg;
    }

    public void setDefaultStoreFlg(boolean defaultStoreFlg) {
        this.defaultStoreFlg = defaultStoreFlg;
    }

    public String getRegistrantId() {
        return registrantId;
    }

    public void setRegistrantId(String registrantId) {
        this.registrantId = registrantId;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    public String getPreRegistrantId() {
        return preRegistrantId;
    }

    public void setPreRegistrantId(String preRegistrantId) {
        this.preRegistrantId = preRegistrantId;
    }

    public Date getPreRegistrationDate() {
        return preRegistrationDate;
    }

    public void setPreRegistrationDate(Date preRegistrationDate) {
        this.preRegistrationDate = preRegistrationDate;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getLegalPaperName() {
        return legalPaperName;
    }

    public void setLegalPaperName(String legalPaperName) {
        this.legalPaperName = legalPaperName;
    }

    public boolean isInfoErrorFlg() {
        return infoErrorFlg;
    }

    public void setInfoErrorFlg(boolean infoErrorFlg) {
        this.infoErrorFlg = infoErrorFlg;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public Long getDemesneId() {
        return demesneId;
    }

    public void setDemesneId(Long demesneId) {
        this.demesneId = demesneId;
    }

    public String getDemesneCode() {
        return demesneCode;
    }

    public void setDemesneCode(String demesneCode) {
        this.demesneCode = demesneCode;
    }

    public String getDemesneName() {
        return demesneName;
    }

    public void setDemesneName(String demesneName) {
        this.demesneName = demesneName;
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

    public String getMarketScaleCode() {
        return marketScaleCode;
    }

    public void setMarketScaleCode(String marketScaleCode) {
        this.marketScaleCode = marketScaleCode;
    }

    public String getMarketScale() {
        return marketScale;
    }

    public void setMarketScale(String marketScale) {
        this.marketScale = marketScale;
    }

    public String getModifyLgcs() {
        return modifyLgcs;
    }

    public void setModifyLgcs(String modifyLgcs) {
        this.modifyLgcs = modifyLgcs;
    }

    public String getPaymentPeriodType() {
        return paymentPeriodType;
    }

    public void setPaymentPeriodType(String paymentPeriodType) {
        this.paymentPeriodType = paymentPeriodType;
    }

    public String getPaymentPeriodName() {
        return paymentPeriodName;
    }

    public void setPaymentPeriodName(String paymentPeriodName) {
        this.paymentPeriodName = paymentPeriodName;
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
}
