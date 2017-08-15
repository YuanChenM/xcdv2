package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0103I批量修改实体卖家指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimEntitySellerTarget extends BaseTarget {

    /** 卖家全称 */
    private boolean fullNameFlg;
    /** 卖家简称 */
    private boolean shortNameFlg;
    /** 密码 */
    private boolean passwordFlg;
    /** 国家编码 */
    private boolean countryCodeFlg;
    /** 国家 */
    private boolean countryNameFlg;
    /** 省编码 */
    private boolean provinceCodeFlg;
    /** 省 */
    private boolean provinceNameFlg;
    /** 市编码 */
    private boolean cityCodeFlg;
    /** 市 */
    private boolean cityNameFlg;
    /** 固定电话 */
    private boolean telFlg;
    /** 传真号 */
    private boolean faxFlg;
    /** 网站及微信公众号 */
    private boolean mediaPlatformFlg;
    /** 详细地址 */
    private boolean addressFlg;

    public boolean isFullNameFlg() {
        return fullNameFlg;
    }

    public void setFullNameFlg(boolean fullNameFlg) {
        this.fullNameFlg = fullNameFlg;
    }

    public boolean isShortNameFlg() {
        return shortNameFlg;
    }

    public void setShortNameFlg(boolean shortNameFlg) {
        this.shortNameFlg = shortNameFlg;
    }

    public boolean isPasswordFlg() {
        return passwordFlg;
    }

    public void setPasswordFlg(boolean passwordFlg) {
        this.passwordFlg = passwordFlg;
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

    public boolean isTelFlg() {
        return telFlg;
    }

    public void setTelFlg(boolean telFlg) {
        this.telFlg = telFlg;
    }

    public boolean isFaxFlg() {
        return faxFlg;
    }

    public void setFaxFlg(boolean faxFlg) {
        this.faxFlg = faxFlg;
    }

    public boolean isMediaPlatformFlg() {
        return mediaPlatformFlg;
    }

    public void setMediaPlatformFlg(boolean mediaPlatformFlg) {
        this.mediaPlatformFlg = mediaPlatformFlg;
    }

    public boolean isAddressFlg() {
        return addressFlg;
    }

    public void setAddressFlg(boolean addressFlg) {
        this.addressFlg = addressFlg;
    }
}
