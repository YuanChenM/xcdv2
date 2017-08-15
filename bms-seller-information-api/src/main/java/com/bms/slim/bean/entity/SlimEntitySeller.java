/*
 * 2017/03/27 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_entity_seller对应的实体SlimEntitySeller</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimEntitySeller extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 实体卖家显示编码 */
    private String entitySellerDisplayCode;
    /** 实体卖家CODE */
    private String entitySellerCode;
    /** 卖家全称 */
    private String fullName;
    /** 卖家简称 */
    private String shortName;
    /** 账号 */
    private String account;
    /** 密码 */
    private String password;
    /** 国家编码 */
    private String countryCode;
    /** 国家 */
    private String countryName;
    /** 省编码 */
    private String provinceCode;
    /** 省 */
    private String provinceName;
    /** 市编码 */
    private String cityCode;
    /** 市 */
    private String cityName;
    /** 固定电话 */
    private String tel;
    /** 传真号 */
    private String fax;
    /** 网站及微信公众号 */
    private String mediaPlatform;
    /** 详细地址 */
    private String address;
    /** 品牌必需标识，0：选填，1：必填 */
    private Boolean brandRequiredFlg;
    /** 品牌注册标识，0：未注册，1：已注册 */
    private Boolean brandRegFlg;
    /** 生产商必需标识，0：选填，1：必填 */
    private Boolean producerRequiredFlg;
    /** 生产商注册标识，0：未注册，1：已注册 */
    private Boolean producerRegFlg;
    /** 经营资质必需标识，0：选填，1：必填 */
    private Boolean bizQualRequiredFlg;
    /** 经营资质注册标识，0：未注册，1：已注册 */
    private Boolean bizQualRegFlg;
    /** 供应资质必需标识，0：选填，1：必填 */
    private Boolean supQualRequiredFlg;
    /** 供应资质注册标识，0：未注册，1：已注册 */
    private Boolean supQualRegFlg;
    /** 电商团队必需标识，0：选填，1：必填 */
    private Boolean bizTeamRequiredFlg;
    /** 电商团队注册标识，0：未注册，1：已注册 */
    private Boolean bizTeamRegFlg;
    /** 管理团队必需标识，0：选填，1：必填 */
    private Boolean mgtTeamRequiredFlg;
    /** 管理团队注册标识，0：未注册，1：已注册 */
    private Boolean mgtTeamRegFlg;
    /** 合同信息必需标识，0：选填，1：必填 */
    private Boolean contractRequiredFlg;
    /** 合同信息注册标识，0：未注册，1：已注册 */
    private Boolean contractRegFlg;
    /** 审核状态，0： 待审核，1：正式 */
    private String auditStu;
    /** 审核备注 */
    private String auditRemark;
    /** 审核履历，格式：0,未注册,admin,2017-01-25; */
    private String auditHistory;

    /**
     * <p>默认构造函数</p>
     */
    public SlimEntitySeller() {
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
    /**
     * <p>实体卖家显示编码</p>
     *
     * @return 实体卖家显示编码
     */
    public String getEntitySellerDisplayCode() {
        return entitySellerDisplayCode;
    }

    /**
     * <p>实体卖家显示编码</p>
     *
     * @param entitySellerDisplayCode 实体卖家显示编码
     */
    public void setEntitySellerDisplayCode(String entitySellerDisplayCode) {
        this.entitySellerDisplayCode = entitySellerDisplayCode;
    }
    /**
     * <p>实体卖家CODE</p>
     *
     * @return 实体卖家CODE
     */
    public String getEntitySellerCode() {
        return entitySellerCode;
    }

    /**
     * <p>实体卖家CODE</p>
     *
     * @param entitySellerCode 实体卖家CODE
     */
    public void setEntitySellerCode(String entitySellerCode) {
        this.entitySellerCode = entitySellerCode;
    }
    /**
     * <p>卖家全称</p>
     *
     * @return 卖家全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * <p>卖家全称</p>
     *
     * @param fullName 卖家全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * <p>卖家简称</p>
     *
     * @return 卖家简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * <p>卖家简称</p>
     *
     * @param shortName 卖家简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    /**
     * <p>账号</p>
     *
     * @return 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * <p>账号</p>
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }
    /**
     * <p>密码</p>
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>密码</p>
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * <p>国家编码</p>
     *
     * @return 国家编码
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * <p>国家编码</p>
     *
     * @param countryCode 国家编码
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * <p>国家</p>
     *
     * @return 国家
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * <p>国家</p>
     *
     * @param countryName 国家
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
     * <p>省</p>
     *
     * @return 省
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>省</p>
     *
     * @param provinceName 省
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    /**
     * <p>市编码</p>
     *
     * @return 市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>市编码</p>
     *
     * @param cityCode 市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * <p>市</p>
     *
     * @return 市
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>市</p>
     *
     * @param cityName 市
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    /**
     * <p>固定电话</p>
     *
     * @return 固定电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * <p>固定电话</p>
     *
     * @param tel 固定电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**
     * <p>传真号</p>
     *
     * @return 传真号
     */
    public String getFax() {
        return fax;
    }

    /**
     * <p>传真号</p>
     *
     * @param fax 传真号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**
     * <p>网站及微信公众号</p>
     *
     * @return 网站及微信公众号
     */
    public String getMediaPlatform() {
        return mediaPlatform;
    }

    /**
     * <p>网站及微信公众号</p>
     *
     * @param mediaPlatform 网站及微信公众号
     */
    public void setMediaPlatform(String mediaPlatform) {
        this.mediaPlatform = mediaPlatform;
    }
    /**
     * <p>详细地址</p>
     *
     * @return 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>详细地址</p>
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * <p>品牌必需标识，0：选填，1：必填</p>
     *
     * @return 品牌必需标识，0：选填，1：必填
     */
    public Boolean getBrandRequiredFlg() {
        return brandRequiredFlg;
    }

    /**
     * <p>品牌必需标识，0：选填，1：必填</p>
     *
     * @param brandRequiredFlg 品牌必需标识，0：选填，1：必填
     */
    public void setBrandRequiredFlg(Boolean brandRequiredFlg) {
        this.brandRequiredFlg = brandRequiredFlg;
    }
    /**
     * <p>品牌注册标识，0：未注册，1：已注册</p>
     *
     * @return 品牌注册标识，0：未注册，1：已注册
     */
    public Boolean getBrandRegFlg() {
        return brandRegFlg;
    }

    /**
     * <p>品牌注册标识，0：未注册，1：已注册</p>
     *
     * @param brandRegFlg 品牌注册标识，0：未注册，1：已注册
     */
    public void setBrandRegFlg(Boolean brandRegFlg) {
        this.brandRegFlg = brandRegFlg;
    }
    /**
     * <p>生产商必需标识，0：选填，1：必填</p>
     *
     * @return 生产商必需标识，0：选填，1：必填
     */
    public Boolean getProducerRequiredFlg() {
        return producerRequiredFlg;
    }

    /**
     * <p>生产商必需标识，0：选填，1：必填</p>
     *
     * @param producerRequiredFlg 生产商必需标识，0：选填，1：必填
     */
    public void setProducerRequiredFlg(Boolean producerRequiredFlg) {
        this.producerRequiredFlg = producerRequiredFlg;
    }
    /**
     * <p>生产商注册标识，0：未注册，1：已注册</p>
     *
     * @return 生产商注册标识，0：未注册，1：已注册
     */
    public Boolean getProducerRegFlg() {
        return producerRegFlg;
    }

    /**
     * <p>生产商注册标识，0：未注册，1：已注册</p>
     *
     * @param producerRegFlg 生产商注册标识，0：未注册，1：已注册
     */
    public void setProducerRegFlg(Boolean producerRegFlg) {
        this.producerRegFlg = producerRegFlg;
    }
    /**
     * <p>经营资质必需标识，0：选填，1：必填</p>
     *
     * @return 经营资质必需标识，0：选填，1：必填
     */
    public Boolean getBizQualRequiredFlg() {
        return bizQualRequiredFlg;
    }

    /**
     * <p>经营资质必需标识，0：选填，1：必填</p>
     *
     * @param bizQualRequiredFlg 经营资质必需标识，0：选填，1：必填
     */
    public void setBizQualRequiredFlg(Boolean bizQualRequiredFlg) {
        this.bizQualRequiredFlg = bizQualRequiredFlg;
    }
    /**
     * <p>经营资质注册标识，0：未注册，1：已注册</p>
     *
     * @return 经营资质注册标识，0：未注册，1：已注册
     */
    public Boolean getBizQualRegFlg() {
        return bizQualRegFlg;
    }

    /**
     * <p>经营资质注册标识，0：未注册，1：已注册</p>
     *
     * @param bizQualRegFlg 经营资质注册标识，0：未注册，1：已注册
     */
    public void setBizQualRegFlg(Boolean bizQualRegFlg) {
        this.bizQualRegFlg = bizQualRegFlg;
    }
    /**
     * <p>供应资质必需标识，0：选填，1：必填</p>
     *
     * @return 供应资质必需标识，0：选填，1：必填
     */
    public Boolean getSupQualRequiredFlg() {
        return supQualRequiredFlg;
    }

    /**
     * <p>供应资质必需标识，0：选填，1：必填</p>
     *
     * @param supQualRequiredFlg 供应资质必需标识，0：选填，1：必填
     */
    public void setSupQualRequiredFlg(Boolean supQualRequiredFlg) {
        this.supQualRequiredFlg = supQualRequiredFlg;
    }
    /**
     * <p>供应资质注册标识，0：未注册，1：已注册</p>
     *
     * @return 供应资质注册标识，0：未注册，1：已注册
     */
    public Boolean getSupQualRegFlg() {
        return supQualRegFlg;
    }

    /**
     * <p>供应资质注册标识，0：未注册，1：已注册</p>
     *
     * @param supQualRegFlg 供应资质注册标识，0：未注册，1：已注册
     */
    public void setSupQualRegFlg(Boolean supQualRegFlg) {
        this.supQualRegFlg = supQualRegFlg;
    }
    /**
     * <p>电商团队必需标识，0：选填，1：必填</p>
     *
     * @return 电商团队必需标识，0：选填，1：必填
     */
    public Boolean getBizTeamRequiredFlg() {
        return bizTeamRequiredFlg;
    }

    /**
     * <p>电商团队必需标识，0：选填，1：必填</p>
     *
     * @param bizTeamRequiredFlg 电商团队必需标识，0：选填，1：必填
     */
    public void setBizTeamRequiredFlg(Boolean bizTeamRequiredFlg) {
        this.bizTeamRequiredFlg = bizTeamRequiredFlg;
    }
    /**
     * <p>电商团队注册标识，0：未注册，1：已注册</p>
     *
     * @return 电商团队注册标识，0：未注册，1：已注册
     */
    public Boolean getBizTeamRegFlg() {
        return bizTeamRegFlg;
    }

    /**
     * <p>电商团队注册标识，0：未注册，1：已注册</p>
     *
     * @param bizTeamRegFlg 电商团队注册标识，0：未注册，1：已注册
     */
    public void setBizTeamRegFlg(Boolean bizTeamRegFlg) {
        this.bizTeamRegFlg = bizTeamRegFlg;
    }
    /**
     * <p>管理团队必需标识，0：选填，1：必填</p>
     *
     * @return 管理团队必需标识，0：选填，1：必填
     */
    public Boolean getMgtTeamRequiredFlg() {
        return mgtTeamRequiredFlg;
    }

    /**
     * <p>管理团队必需标识，0：选填，1：必填</p>
     *
     * @param mgtTeamRequiredFlg 管理团队必需标识，0：选填，1：必填
     */
    public void setMgtTeamRequiredFlg(Boolean mgtTeamRequiredFlg) {
        this.mgtTeamRequiredFlg = mgtTeamRequiredFlg;
    }
    /**
     * <p>管理团队注册标识，0：未注册，1：已注册</p>
     *
     * @return 管理团队注册标识，0：未注册，1：已注册
     */
    public Boolean getMgtTeamRegFlg() {
        return mgtTeamRegFlg;
    }

    /**
     * <p>管理团队注册标识，0：未注册，1：已注册</p>
     *
     * @param mgtTeamRegFlg 管理团队注册标识，0：未注册，1：已注册
     */
    public void setMgtTeamRegFlg(Boolean mgtTeamRegFlg) {
        this.mgtTeamRegFlg = mgtTeamRegFlg;
    }
    /**
     * <p>合同信息必需标识，0：选填，1：必填</p>
     *
     * @return 合同信息必需标识，0：选填，1：必填
     */
    public Boolean getContractRequiredFlg() {
        return contractRequiredFlg;
    }

    /**
     * <p>合同信息必需标识，0：选填，1：必填</p>
     *
     * @param contractRequiredFlg 合同信息必需标识，0：选填，1：必填
     */
    public void setContractRequiredFlg(Boolean contractRequiredFlg) {
        this.contractRequiredFlg = contractRequiredFlg;
    }
    /**
     * <p>合同信息注册标识，0：未注册，1：已注册</p>
     *
     * @return 合同信息注册标识，0：未注册，1：已注册
     */
    public Boolean getContractRegFlg() {
        return contractRegFlg;
    }

    /**
     * <p>合同信息注册标识，0：未注册，1：已注册</p>
     *
     * @param contractRegFlg 合同信息注册标识，0：未注册，1：已注册
     */
    public void setContractRegFlg(Boolean contractRegFlg) {
        this.contractRegFlg = contractRegFlg;
    }
    /**
     * <p>审核状态，0： 待审核，1：正式</p>
     *
     * @return 审核状态，0： 待审核，1：正式
     */
    public String getAuditStu() {
        return auditStu;
    }

    /**
     * <p>审核状态，0： 待审核，1：正式</p>
     *
     * @param auditStu 审核状态，0： 待审核，1：正式
     */
    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }
    /**
     * <p>审核备注</p>
     *
     * @return 审核备注
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * <p>审核备注</p>
     *
     * @param auditRemark 审核备注
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }
    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @return 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public String getAuditHistory() {
        return auditHistory;
    }

    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @param auditHistory 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }

}
