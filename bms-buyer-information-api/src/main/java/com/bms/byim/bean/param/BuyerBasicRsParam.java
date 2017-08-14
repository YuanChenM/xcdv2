package com.bms.byim.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author zhou_yajun
 * @version 1.0
 */
@ApiModel(value = "BuyerBasicRsParam", description = "买家基本信息接口参数")
public class BuyerBasicRsParam extends BuyerAccountRsParam {
    @ApiModelProperty(value = "店铺ID")
    private Long storeId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "买家显示编码")
    private String displayCode;
    @ApiModelProperty(value = "买家类型")
    private String buyerType;
    @ApiModelProperty(value = "买家类型名称")
    private String buyerTypeName;
    @ApiModelProperty(value = "买家一级分类")
    private String buyerFirstCategory;
    @ApiModelProperty(value = "买家一级分类名称")
    private String buyerFirstCategoryName;
    @ApiModelProperty(value = "买家二级分类")
    private String buyerSubCategory;
    @ApiModelProperty(value = "买家二级分类名称")
    private String buyerSubCategoryName;
    @ApiModelProperty(value = "买家名称")
    private String buyerName;
    @ApiModelProperty(value = "买家地址")
    private String buyerAddr;
    @ApiModelProperty(value = "物流区ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
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
    @ApiModelProperty(value = "买家QQ")
    private String buyerQq;
    @ApiModelProperty(value = "买家微信")
    private String buyerWechat;
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
    @ApiModelProperty(value = "注册来源")
    private String registerSource;
    @ApiModelProperty(value = "注册来源名称")
    private String registerSourceName;
    @ApiModelProperty(value = "市场ID")
    private String marketId;
    @ApiModelProperty(value = "市场编码")
    private String marketCode;
    @ApiModelProperty(value = "市场名称")
    private String marketName;
    @ApiModelProperty(value = "市场类型")
    private String marketType;
    @ApiModelProperty(value = "市场规模编码")
    private String marketScaleCode;
    @ApiModelProperty(value = "市场规模")
    private String marketScale;
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
    @ApiModelProperty(value = "check返回值值")
    private int existCount;
    /** FREQUENTER_LEVEL_F */
    private String frequenterLevelF;
    /** FREQUENTER_LEVEL_A */
    private String frequenterLevelA;
    /** FREQUENTER_LEVEL_CODE */
    private String frequenterLevelCode;
    /** GRADE */
    private String grade;
    @ApiModelProperty(value = "账期周期类型")
    private java.lang.String paymentPeriodType;
    @ApiModelProperty(value = "账期周期名称")
    private java.lang.String paymentPeriodName;
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

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getDisplayCode() {
        return displayCode;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
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

    public String getBuyerSubCategory() {
        return buyerSubCategory;
    }

    public void setBuyerSubCategory(String buyerSubCategory) {
        this.buyerSubCategory = buyerSubCategory;
    }

    public String getBuyerSubCategoryName() {
        return buyerSubCategoryName;
    }

    public void setBuyerSubCategoryName(String buyerSubCategoryName) {
        this.buyerSubCategoryName = buyerSubCategoryName;
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public boolean isInfoErrorFlg() {
        return infoErrorFlg;
    }

    public void setInfoErrorFlg(boolean infoErrorFlg) {
        this.infoErrorFlg = infoErrorFlg;
    }

    public String getInfoErrorRemark() {
        return infoErrorRemark;
    }

    public void setInfoErrorRemark(String infoErrorRemark) {
        this.infoErrorRemark = infoErrorRemark;
    }

    public String getMarketScaleCode() {
        return marketScaleCode;
    }

    public void setMarketScaleCode(String marketScaleCode) {
        this.marketScaleCode = marketScaleCode;
    }

    public int getExistCount() {
        return existCount;
    }

    public void setExistCount(int existCount) {
        this.existCount = existCount;
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
}
