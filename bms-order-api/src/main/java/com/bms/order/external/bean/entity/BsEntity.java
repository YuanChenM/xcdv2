package com.bms.order.external.bean.entity;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class BsEntity {
    //账号ID
    private Long accountid;
    //邮箱地址
    private String mailAddr;
    //账号名称
    private String accountName;
    //电话号码
    private String telNo;
    //买手ID
    private String bsId;
    //合伙人ID
    private String partnerId;
    //买手编码
    private String bsCode;
    //买手姓名
    private String bsName;
    //买手分类编码
    private String categorycode;
    //买手分类名称
    private String categoryname;
    //买手等级
    private String levelName;
    //是否为账期用户买手
    private Boolean isCreditTermBs;
    //性别
    private String bsSex;
    //照片
    private String bsPic;
    //身份证号
    private String bsCardId;
    //省ID
    private Long provinceId;
    //省编码
    private String provinceCode;
    //省名称
    private String provinceName;
    //城市ID
    private Long cityId;
    //城市编码
    private String cityCode;
    //城市名称
    private String cityName;
    //区县ID
    private Long districtId;
    //区县编码
    private String districtCode;
    //区县名称
    private String districtName;
    //街道ID
    private Long streetId;
    //街道编码
    private String streetCode;
    //街道名称
    private String streetName;
    //买手地址
    private String bsAddr;
    //买手微信号
    private String bsWechat;
    //买手QQ号
    private String bsQq;
    //开户行
    private String bsBankName;
    //开户帐号
    private String bsBankAccountName;
    //开户帐号
    private String bsBankAccount;
    //照片（前台）
    private String bsPicWeb;
    //物流区ID
    private Long lgcsAreaId;
    //物流区编码
    private String lgcsAreaCode;
    //物流区名称
    private String lgcsAreaName;
    //地区ID
    private Long zoneId;
    //地区编码
    private String zoneCode;
    //地区名称
    private String zoneName;
    //
    private Long distributionId;
    //配送站ID
    private String distributionType;
    //配送站分类
    private String distributionName;
    //配送站表示码
    private String distributionCode;
    //领地ID
    private Long demesneId;
    //领地分类
    private String demesneType;
    //领地表示码
    private String demesneName;
    //领地编码
    private String demesneCode;
    //管家ID
    private String saId;
    //管家姓名
    private String saName;
    //管家编码
    private String saCode;
    //管家帐号
    private String saAccount;
    //管家注册手机号
    private String saTelNo;
    //买手类型： 1、纯粹买手  2、销售合伙人
    private int agentType;

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
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

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Boolean getIsCreditTermBs() {
        return isCreditTermBs;
    }

    public void setIsCreditTermBs(Boolean isCreditTermBs) {
        this.isCreditTermBs = isCreditTermBs;
    }

    public String getBsSex() {
        return bsSex;
    }

    public void setBsSex(String bsSex) {
        this.bsSex = bsSex;
    }

    public String getBsPic() {
        return bsPic;
    }

    public void setBsPic(String bsPic) {
        this.bsPic = bsPic;
    }

    public String getBsCardId() {
        return bsCardId;
    }

    public void setBsCardId(String bsCardId) {
        this.bsCardId = bsCardId;
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

    public String getBsAddr() {
        return bsAddr;
    }

    public void setBsAddr(String bsAddr) {
        this.bsAddr = bsAddr;
    }

    public String getBsWechat() {
        return bsWechat;
    }

    public void setBsWechat(String bsWechat) {
        this.bsWechat = bsWechat;
    }

    public String getBsQq() {
        return bsQq;
    }

    public void setBsQq(String bsQq) {
        this.bsQq = bsQq;
    }

    public String getBsBankName() {
        return bsBankName;
    }

    public void setBsBankName(String bsBankName) {
        this.bsBankName = bsBankName;
    }

    public String getBsBankAccountName() {
        return bsBankAccountName;
    }

    public void setBsBankAccountName(String bsBankAccountName) {
        this.bsBankAccountName = bsBankAccountName;
    }

    public String getBsBankAccount() {
        return bsBankAccount;
    }

    public void setBsBankAccount(String bsBankAccount) {
        this.bsBankAccount = bsBankAccount;
    }

    public String getBsPicWeb() {
        return bsPicWeb;
    }

    public void setBsPicWeb(String bsPicWeb) {
        this.bsPicWeb = bsPicWeb;
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

    public Long getDemesneId() {
        return demesneId;
    }

    public void setDemesneId(Long demesneId) {
        this.demesneId = demesneId;
    }

    public String getDemesneType() {
        return demesneType;
    }

    public void setDemesneType(String demesneType) {
        this.demesneType = demesneType;
    }

    public String getDemesneName() {
        return demesneName;
    }

    public void setDemesneName(String demesneName) {
        this.demesneName = demesneName;
    }

    public String getDemesneCode() {
        return demesneCode;
    }

    public void setDemesneCode(String demesneCode) {
        this.demesneCode = demesneCode;
    }

    public String getSaId() {
        return saId;
    }

    public void setSaId(String saId) {
        this.saId = saId;
    }

    public String getSaName() {
        return saName;
    }

    public void setSaName(String saName) {
        this.saName = saName;
    }

    public String getSaCode() {
        return saCode;
    }

    public void setSaCode(String saCode) {
        this.saCode = saCode;
    }

    public String getSaAccount() {
        return saAccount;
    }

    public void setSaAccount(String saAccount) {
        this.saAccount = saAccount;
    }

    public String getSaTelNo() {
        return saTelNo;
    }

    public void setSaTelNo(String saTelNo) {
        this.saTelNo = saTelNo;
    }

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }
}
