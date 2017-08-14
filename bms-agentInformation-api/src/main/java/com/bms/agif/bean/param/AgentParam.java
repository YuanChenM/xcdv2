package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
@ApiModel(value = "AgentParam",
    description = "买手信息类")
public class AgentParam implements Serializable {
    @ApiModelProperty(value = "买手ID")
    private String agentId;
    @ApiModelProperty(value = "买手名称")
    private String agentName;
    @ApiModelProperty(value = "买手编码")
    private String agentCode;
    @ApiModelProperty(value = "买手分类编码")
    private String categoryCode;
    @ApiModelProperty(value = "买手分类名称")
    private String categoryName;
    @ApiModelProperty(value = "是否为账期用户买手：true:是 false:否")
    private String isCreditTermAgent;
    @ApiModelProperty(value = "性别 0:男 1:女")
    private String agentSex;
    @ApiModelProperty(value = "照片")
    private String agentPic;
    @ApiModelProperty(value = "身份证号")
    private String agentCardId;
    @ApiModelProperty(value = "省ID")
    private Long provinceId;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
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
    private String agentAddr;
    @ApiModelProperty(value = "微信")
    private String agentWechat;
    @ApiModelProperty(value = "QQ")
    private String agentQq;
    @ApiModelProperty(value = "开户行")
    private String agentBankName;
    @ApiModelProperty(value = "开户名")
    private String agentBankAccountName;
    @ApiModelProperty(value = "开户帐号")
    private String agentBankAccount;
    @ApiModelProperty(value = "照片(前台用)存储图片上传文件服务器后返回的ID")
    private String agentPicWeb;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
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

    public String getIsCreditTermAgent() {
        return isCreditTermAgent;
    }

    public void setIsCreditTermAgent(String isCreditTermAgent) {
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
