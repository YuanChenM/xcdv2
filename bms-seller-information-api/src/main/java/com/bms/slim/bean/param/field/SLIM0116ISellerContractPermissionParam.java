package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0116ISellerContractPermissionParam", description = "卖家合同信息")
public class SLIM0116ISellerContractPermissionParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value="卖家全称")
    private String sellerFullName;
    @ApiModelProperty(value="国家编码")
    private String countryCode;
    @ApiModelProperty(value="国家")
    private String countryName;
    @ApiModelProperty(value="省编码")
    private String provinceCode;
    @ApiModelProperty(value="省")
    private String provinceName;
    @ApiModelProperty(value="市编码")
    private String cityCode;
    @ApiModelProperty(value="市")
    private String cityName;
    @ApiModelProperty(value="经营地址")
    private String businessAddress;
    @ApiModelProperty(value="收款人全称")
    private String payeeName;
    @ApiModelProperty(value="收款银行")
    private String payeeBank;
    @ApiModelProperty(value="银行账号")
    private String bankAccount;
    @ApiModelProperty(value="合同快递收件地址")
    private String expressAddress;

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public void setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
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

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeBank() {
        return payeeBank;
    }

    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getExpressAddress() {
        return expressAddress;
    }

    public void setExpressAddress(String expressAddress) {
        this.expressAddress = expressAddress;
    }
}
