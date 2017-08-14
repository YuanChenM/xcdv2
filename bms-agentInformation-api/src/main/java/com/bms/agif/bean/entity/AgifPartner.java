/*
 * 2017/03/08 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表agif_partner对应的实体AgifPartner</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifPartner extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 合伙人ID */
    private String partnerId;
    /** 合伙人姓名 */
    private String partnerName;
    /** 合伙人编码 */
    private String partnerCode;
    /** 合伙人分类编码 */
    private String categoryCode;
    /** 合伙人分类名称 */
    private String categoryName;
    /** 0:男 1:女 */
    private String partnerSex;
    /** 头像 */
    private String partnerPic;
    /** 身份证号 */
    private String partnerCardId;
    /** 省名称 */
    private String provinceName;
    /** 省ID */
    private Long provinceId;
    /** 省编码 */
    private String provinceCode;
    /** 城市（地区）ID */
    private Long cityId;
    /** 城市（地区）编码 */
    private String cityCode;
    /** 城市（地区）名称 */
    private String cityName;
    /** 区（县）ID */
    private Long districtId;
    /** 区（县）编码 */
    private String districtCode;
    /** 区（县）名称 */
    private String districtName;
    /** 街道（乡）ID */
    private Long streetId;
    /** 街道（乡）编码 */
    private String streetCode;
    /** 街道（乡）名称 */
    private String streetName;
    /** 详细地址 */
    private String partnerAddr;
    /** 微信 */
    private String partnerWechat;
    /** QQ */
    private String partnerQq;
    /** 开户行 */
    private String partnerBankName;
    /** 开户名 */
    private String partnerBankAccountName;
    /** 存储图片上传文件服务器后返回的ID */
    private String partnerPicWeb;
    /** 开户帐号 */
    private String partnerBankAccount;

    /**
     * <p>默认构造函数</p>
     */
    public AgifPartner() {
    }

    /**
     * <p>合伙人ID</p>
     *
     * @return 合伙人ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * <p>合伙人ID</p>
     *
     * @param partnerId 合伙人ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
    /**
     * <p>合伙人姓名</p>
     *
     * @return 合伙人姓名
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * <p>合伙人姓名</p>
     *
     * @param partnerName 合伙人姓名
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    /**
     * <p>合伙人编码</p>
     *
     * @return 合伙人编码
     */
    public String getPartnerCode() {
        return partnerCode;
    }

    /**
     * <p>合伙人编码</p>
     *
     * @param partnerCode 合伙人编码
     */
    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }
    /**
     * <p>合伙人分类编码</p>
     *
     * @return 合伙人分类编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * <p>合伙人分类编码</p>
     *
     * @param categoryCode 合伙人分类编码
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
    /**
     * <p>合伙人分类名称</p>
     *
     * @return 合伙人分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * <p>合伙人分类名称</p>
     *
     * @param categoryName 合伙人分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    /**
     * <p>0:男 1:女</p>
     *
     * @return 0:男 1:女
     */
    public String getPartnerSex() {
        return partnerSex;
    }

    /**
     * <p>0:男 1:女</p>
     *
     * @param partnerSex 0:男 1:女
     */
    public void setPartnerSex(String partnerSex) {
        this.partnerSex = partnerSex;
    }
    /**
     * <p>头像</p>
     *
     * @return 头像
     */
    public String getPartnerPic() {
        return partnerPic;
    }

    /**
     * <p>头像</p>
     *
     * @param partnerPic 头像
     */
    public void setPartnerPic(String partnerPic) {
        this.partnerPic = partnerPic;
    }
    /**
     * <p>身份证号</p>
     *
     * @return 身份证号
     */
    public String getPartnerCardId() {
        return partnerCardId;
    }

    /**
     * <p>身份证号</p>
     *
     * @param partnerCardId 身份证号
     */
    public void setPartnerCardId(String partnerCardId) {
        this.partnerCardId = partnerCardId;
    }
    /**
     * <p>省名称</p>
     *
     * @return 省名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>省名称</p>
     *
     * @param provinceName 省名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    /**
     * <p>省ID</p>
     *
     * @return 省ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * <p>省ID</p>
     *
     * @param provinceId 省ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
    /**
     * <p>省编码</p>
     *
     * @return 省编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>省编码</p>
     *
     * @param provinceCode 省编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    /**
     * <p>城市（地区）ID</p>
     *
     * @return 城市（地区）ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * <p>城市（地区）ID</p>
     *
     * @param cityId 城市（地区）ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    /**
     * <p>城市（地区）编码</p>
     *
     * @return 城市（地区）编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>城市（地区）编码</p>
     *
     * @param cityCode 城市（地区）编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * <p>城市（地区）名称</p>
     *
     * @return 城市（地区）名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>城市（地区）名称</p>
     *
     * @param cityName 城市（地区）名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    /**
     * <p>区（县）ID</p>
     *
     * @return 区（县）ID
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * <p>区（县）ID</p>
     *
     * @param districtId 区（县）ID
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }
    /**
     * <p>区（县）编码</p>
     *
     * @return 区（县）编码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区（县）编码</p>
     *
     * @param districtCode 区（县）编码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
    /**
     * <p>区（县）名称</p>
     *
     * @return 区（县）名称
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * <p>区（县）名称</p>
     *
     * @param districtName 区（县）名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    /**
     * <p>街道（乡）ID</p>
     *
     * @return 街道（乡）ID
     */
    public Long getStreetId() {
        return streetId;
    }

    /**
     * <p>街道（乡）ID</p>
     *
     * @param streetId 街道（乡）ID
     */
    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }
    /**
     * <p>街道（乡）编码</p>
     *
     * @return 街道（乡）编码
     */
    public String getStreetCode() {
        return streetCode;
    }

    /**
     * <p>街道（乡）编码</p>
     *
     * @param streetCode 街道（乡）编码
     */
    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }
    /**
     * <p>街道（乡）名称</p>
     *
     * @return 街道（乡）名称
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * <p>街道（乡）名称</p>
     *
     * @param streetName 街道（乡）名称
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    /**
     * <p>详细地址</p>
     *
     * @return 详细地址
     */
    public String getPartnerAddr() {
        return partnerAddr;
    }

    /**
     * <p>详细地址</p>
     *
     * @param partnerAddr 详细地址
     */
    public void setPartnerAddr(String partnerAddr) {
        this.partnerAddr = partnerAddr;
    }
    /**
     * <p>微信</p>
     *
     * @return 微信
     */
    public String getPartnerWechat() {
        return partnerWechat;
    }

    /**
     * <p>微信</p>
     *
     * @param partnerWechat 微信
     */
    public void setPartnerWechat(String partnerWechat) {
        this.partnerWechat = partnerWechat;
    }
    /**
     * <p>QQ</p>
     *
     * @return QQ
     */
    public String getPartnerQq() {
        return partnerQq;
    }

    /**
     * <p>QQ</p>
     *
     * @param partnerQq QQ
     */
    public void setPartnerQq(String partnerQq) {
        this.partnerQq = partnerQq;
    }
    /**
     * <p>开户行</p>
     *
     * @return 开户行
     */
    public String getPartnerBankName() {
        return partnerBankName;
    }

    /**
     * <p>开户行</p>
     *
     * @param partnerBankName 开户行
     */
    public void setPartnerBankName(String partnerBankName) {
        this.partnerBankName = partnerBankName;
    }
    /**
     * <p>开户名</p>
     *
     * @return 开户名
     */
    public String getPartnerBankAccountName() {
        return partnerBankAccountName;
    }

    /**
     * <p>开户名</p>
     *
     * @param partnerBankAccountName 开户名
     */
    public void setPartnerBankAccountName(String partnerBankAccountName) {
        this.partnerBankAccountName = partnerBankAccountName;
    }
    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @return 存储图片上传文件服务器后返回的ID
     */
    public String getPartnerPicWeb() {
        return partnerPicWeb;
    }

    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @param partnerPicWeb 存储图片上传文件服务器后返回的ID
     */
    public void setPartnerPicWeb(String partnerPicWeb) {
        this.partnerPicWeb = partnerPicWeb;
    }
    /**
     * <p>开户帐号</p>
     *
     * @return 开户帐号
     */
    public String getPartnerBankAccount() {
        return partnerBankAccount;
    }

    /**
     * <p>开户帐号</p>
     *
     * @param partnerBankAccount 开户帐号
     */
    public void setPartnerBankAccount(String partnerBankAccount) {
        this.partnerBankAccount = partnerBankAccount;
    }

}
