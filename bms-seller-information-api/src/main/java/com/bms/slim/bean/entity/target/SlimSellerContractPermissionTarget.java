package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

public class SlimSellerContractPermissionTarget extends BaseTarget {

    /**
     * 实体卖家ID
     */
    private boolean entitySellerIdFlg;
    /**
     * 卖家全称
     */
    private boolean sellerFullNameFlg;
    /**
     * 国家编码
     */
    private boolean countryCodeFlg;
    /**
     * 国家
     */
    private boolean countryNameFlg;
    /**
     * 省编码
     */
    private boolean provinceCodeFlg;
    /**
     * 省
     */
    private boolean provinceNameFlg;
    /**
     * 市编码
     */
    private boolean cityCodeFlg;
    /**
     * 市
     */
    private boolean cityNameFlg;
    /**
     * 经营地址
     */
    private boolean businessAddressFlg;
    /**
     * 收款人全称
     */
    private boolean payeeNameFlg;
    /**
     * 收款银行
     */
    private boolean payeeBankFlg;
    /**
     * 银行账号
     */
    private boolean bankAccountFlg;
    /**
     * 合同快递收件地址
     */
    private boolean expressAddressFlg;

    public boolean isEntitySellerIdFlg() {
        return entitySellerIdFlg;
    }

    public void setEntitySellerIdFlg(boolean entitySellerIdFlg) {
        this.entitySellerIdFlg = entitySellerIdFlg;
    }

    public boolean isSellerFullNameFlg() {
        return sellerFullNameFlg;
    }

    public void setSellerFullNameFlg(boolean sellerFullNameFlg) {
        this.sellerFullNameFlg = sellerFullNameFlg;
    }

    public boolean isCountryCodeFlg() {
        return countryCodeFlg;
    }

    public void setCountryCodeFlg(boolean countryCodeFlg) {
        this.countryCodeFlg = countryCodeFlg;
    }

    public boolean isCountryNameFlg() {
        return countryNameFlg;
    }

    public void setCountryNameFlg(boolean countryNameFlg) {
        this.countryNameFlg = countryNameFlg;
    }

    public boolean isProvinceCodeFlg() {
        return provinceCodeFlg;
    }

    public void setProvinceCodeFlg(boolean provinceCodeFlg) {
        this.provinceCodeFlg = provinceCodeFlg;
    }

    public boolean isProvinceNameFlg() {
        return provinceNameFlg;
    }

    public void setProvinceNameFlg(boolean provinceNameFlg) {
        this.provinceNameFlg = provinceNameFlg;
    }

    public boolean isCityCodeFlg() {
        return cityCodeFlg;
    }

    public void setCityCodeFlg(boolean cityCodeFlg) {
        this.cityCodeFlg = cityCodeFlg;
    }

    public boolean isCityNameFlg() {
        return cityNameFlg;
    }

    public void setCityNameFlg(boolean cityNameFlg) {
        this.cityNameFlg = cityNameFlg;
    }

    public boolean isBusinessAddressFlg() {
        return businessAddressFlg;
    }

    public void setBusinessAddressFlg(boolean businessAddressFlg) {
        this.businessAddressFlg = businessAddressFlg;
    }

    public boolean isPayeeNameFlg() {
        return payeeNameFlg;
    }

    public void setPayeeNameFlg(boolean payeeNameFlg) {
        this.payeeNameFlg = payeeNameFlg;
    }

    public boolean isPayeeBankFlg() {
        return payeeBankFlg;
    }

    public void setPayeeBankFlg(boolean payeeBankFlg) {
        this.payeeBankFlg = payeeBankFlg;
    }

    public boolean isBankAccountFlg() {
        return bankAccountFlg;
    }

    public void setBankAccountFlg(boolean bankAccountFlg) {
        this.bankAccountFlg = bankAccountFlg;
    }

    public boolean isExpressAddressFlg() {
        return expressAddressFlg;
    }

    public void setExpressAddressFlg(boolean expressAddressFlg) {
        this.expressAddressFlg = expressAddressFlg;
    }
}
