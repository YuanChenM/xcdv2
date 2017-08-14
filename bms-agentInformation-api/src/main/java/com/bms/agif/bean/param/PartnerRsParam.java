package com.bms.agif.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yuan_zhifei on 2017/3/2.
 */
@ApiModel(value = "PartnerRsParam", description = "销售合伙人基本信息参数")
public class PartnerRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "合伙人ID")
    private String partnerId;
    @ApiModelProperty(value = "合伙人姓名")
    private String partnerName;
    @ApiModelProperty(value = "合伙人编码")
    private String partnerCode;
    @ApiModelProperty(value = "合伙人分类编码")
    private String categoryCode;
    @ApiModelProperty(value = "合伙人分类名称")
    private String categoryName;
    @ApiModelProperty(value = "性别")
    private String partnerSex;
    @ApiModelProperty(value = "照片")
    private String partnerPic;
    @ApiModelProperty(value = "身份证号")
    private String partnerCardId;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "省ID")
    private Long provinceId;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "城市（地区）ID")
    private Long cityId;
    @ApiModelProperty(value = "城市（地区）编码")
    private String cityCode;
    @ApiModelProperty(value = "城市（地区）名称")
    private String cityName;
    @ApiModelProperty(value = "区（县）ID")
    private Long districtId;
    @ApiModelProperty(value = "区（县）编码")
    private String districtCode;
    @ApiModelProperty(value = "区（县）名称")
    private String districtName;
    @ApiModelProperty(value = "街道（乡）ID")
    private Long streetId;
    @ApiModelProperty(value = "街道（乡）编码")
    private String streetCode;
    @ApiModelProperty(value = "街道（乡）名称")
    private String streetName;
    @ApiModelProperty(value = "详细地址")
    private String partnerAddr;
    @ApiModelProperty(value = "微信")
    private String partnerWechat;
    @ApiModelProperty(value = "QQ")
    private String partnerQq;
    @ApiModelProperty(value = "开户行")
    private String partnerBankName;
    @ApiModelProperty(value = "开户名")
    private String partnerBankAccountName;
    @ApiModelProperty(value = "照片（前台用）")
    private String partnerPicWeb;
    @ApiModelProperty(value = "开户帐号")
    private String partnerBankAccount;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "帐号名")
    private String accountName;
    @ApiModelProperty(value = "注册手机")
    private String telNo;
    @ApiModelProperty(value = "注册邮箱")
    private String mailAddr;
    @ApiModelProperty(value = "物流区主键")
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
    @ApiModelProperty(value = "配送站分类")
    private String distributionType;
    @ApiModelProperty(value = "配送站表示码")
    private String distributionName;
    @ApiModelProperty(value = "配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)")
    private String distributionCode;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
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

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPartnerSex() {
        return partnerSex;
    }

    public void setPartnerSex(String partnerSex) {
        this.partnerSex = partnerSex;
    }

    public String getPartnerPic() {
        return partnerPic;
    }

    public void setPartnerPic(String partnerPic) {
        this.partnerPic = partnerPic;
    }

    public String getPartnerCardId() {
        return partnerCardId;
    }

    public void setPartnerCardId(String partnerCardId) {
        this.partnerCardId = partnerCardId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
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

    public String getPartnerAddr() {
        return partnerAddr;
    }

    public void setPartnerAddr(String partnerAddr) {
        this.partnerAddr = partnerAddr;
    }

    public String getPartnerWechat() {
        return partnerWechat;
    }

    public void setPartnerWechat(String partnerWechat) {
        this.partnerWechat = partnerWechat;
    }

    public String getPartnerQq() {
        return partnerQq;
    }

    public void setPartnerQq(String partnerQq) {
        this.partnerQq = partnerQq;
    }

    public String getPartnerBankName() {
        return partnerBankName;
    }

    public void setPartnerBankName(String partnerBankName) {
        this.partnerBankName = partnerBankName;
    }

    public String getPartnerBankAccountName() {
        return partnerBankAccountName;
    }

    public void setPartnerBankAccountName(String partnerBankAccountName) {
        this.partnerBankAccountName = partnerBankAccountName;
    }

    public String getPartnerPicWeb() {
        return partnerPicWeb;
    }

    public void setPartnerPicWeb(String partnerPicWeb) {
        this.partnerPicWeb = partnerPicWeb;
    }

    public String getPartnerBankAccount() {
        return partnerBankAccount;
    }

    public void setPartnerBankAccount(String partnerBankAccount) {
        this.partnerBankAccount = partnerBankAccount;
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

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
