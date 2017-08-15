package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class AGIF0209IRestResult implements Serializable {
    //账号ID
    private Long accountid;
    //邮箱地址
    private String mailAddr;
    //账号名称
    private String accountName;
    //电话号码
    private String telNo;
    //买手ID
    private String agentId;
    //合伙人ID
    private String partnerId;
    //买手编码
    private String agentcode;
    //买手姓名
    private String agentname;
    //买手分类编码
    private String categorycode;
    //买手分类名称
    private String categoryname;
    //买手等级
    private String levelName;
    //是否为账期用户买手
    private Boolean isCreditTermAgent;
    //性别
    private String agentSex;
    //照片
    private String agentPic;
    //身份证号
    private String agentCardId;
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
    private String agentAddr;
    //买手微信号
    private String agentWechat;
    //买手QQ号
    private String agentQq;
    //开户行
    private String agentBankName;
    //开户帐号
    private String agentBankAccountName;
    //开户帐号
    private String agentBankAccount;
    //照片（前台）
    private String agentPicWeb;

    //物流区ID
    private Long lgcsAreaId;
    //物流区编码
    private String lgcsAreaCode;
    //物流区名称
    private String lgcsAreaName;
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

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(String agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
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

    public Boolean getIsCreditTermAgent() {
        return isCreditTermAgent;
    }

    public void setIsCreditTermAgent(Boolean isCreditTermAgent) {
        this.isCreditTermAgent = isCreditTermAgent;
    }

    public String getAgentSex() {
        return agentSex;
    }

    public void setAgentSex(String agentSex) {
        this.agentSex = agentSex;
    }

    public String getAgentPic() {
        return agentPic;
    }

    public void setAgentPic(String agentPic) {
        this.agentPic = agentPic;
    }

    public String getAgentCardId() {
        return agentCardId;
    }

    public void setAgentCardId(String agentCardId) {
        this.agentCardId = agentCardId;
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

    public String getAgentAddr() {
        return agentAddr;
    }

    public void setAgentAddr(String agentAddr) {
        this.agentAddr = agentAddr;
    }

    public String getAgentWechat() {
        return agentWechat;
    }

    public void setAgentWechat(String agentWechat) {
        this.agentWechat = agentWechat;
    }

    public String getAgentQq() {
        return agentQq;
    }

    public void setAgentQq(String agentQq) {
        this.agentQq = agentQq;
    }

    public String getAgentBankName() {
        return agentBankName;
    }

    public void setAgentBankName(String agentBankName) {
        this.agentBankName = agentBankName;
    }

    public String getAgentBankAccountName() {
        return agentBankAccountName;
    }

    public void setAgentBankAccountName(String agentBankAccountName) {
        this.agentBankAccountName = agentBankAccountName;
    }

    public String getAgentBankAccount() {
        return agentBankAccount;
    }

    public void setAgentBankAccount(String agentBankAccount) {
        this.agentBankAccount = agentBankAccount;
    }

    public String getAgentPicWeb() {
        return agentPicWeb;
    }

    public void setAgentPicWeb(String agentPicWeb) {
        this.agentPicWeb = agentPicWeb;
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

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }
}
