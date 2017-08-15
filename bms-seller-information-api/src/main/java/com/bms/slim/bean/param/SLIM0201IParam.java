package com.bms.slim.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLIM0201IParam", description = "新增卖家生产商接口入参")
public class SLIM0201IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "卖家生产商集合")
    private List<SLIM0201IParam> producers;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "生产商编码")
    private String producerCode;
    @ApiModelProperty(value = "生产商名称")
    private String shortName;
    @ApiModelProperty(value = "生产商全称")
    private String fullName;
    @ApiModelProperty(value = "国家CODE")
    private String countryCode;
    @ApiModelProperty(value = "国家名称")
    private String countryName;
    @ApiModelProperty(value = "省CODE")
    private String provinceCode;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "市CODE")
    private String cityCode;
    @ApiModelProperty(value = "市名称")
    private String cityName;
    @ApiModelProperty(value = "详细地址")
    private String address;
    @ApiModelProperty(value = "生产商固定电话")
    private String tel;
    @ApiModelProperty(value = "生产商传真号")
    private String fax;
    @ApiModelProperty(value = "生产商网站名及微信公众号")
    private String mediaPlatform;
    @ApiModelProperty(value = "审核状态，0： 待审核，1：正式")
    private String auditStu;
    @ApiModelProperty(value = "审核备注")
    private String auditRemark;
    @ApiModelProperty(value = "审核履历，格式：0,未注册,admin,2017-01-25;")
    private String auditHistory;
    @ApiModelProperty(value = "联系人名称")
    private String contactName;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "微信号")
    private String wechat;
    @ApiModelProperty(value = "QQ号")
    private String qq;
    @ApiModelProperty(value = "EMAIL地址")
    private String email;

    public List<SLIM0201IParam> getProducers() {
        return producers;
    }

    public void setProducers(List<SLIM0201IParam> producers) {
        this.producers = producers;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMediaPlatform() {
        return mediaPlatform;
    }

    public void setMediaPlatform(String mediaPlatform) {
        this.mediaPlatform = mediaPlatform;
    }

    public String getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public String getAuditHistory() {
        return auditHistory;
    }

    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
