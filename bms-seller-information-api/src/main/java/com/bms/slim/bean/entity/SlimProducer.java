/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_PRODUCER对应的实体SlimProducer</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimProducer extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 生产商ID */
    private Long producerId;
    /** 生产商编码 */
    private String producerCode;
    /** 生产商全称 */
    private String fullName;
    /** 生产商简称 */
    private String shortName;
    /** 国家CODE */
    private String countryCode;
    /** 国家名称 */
    private String countryName;
    /** 省CODE */
    private String provinceCode;
    /** 省名称 */
    private String provinceName;
    /** 市CODE */
    private String cityCode;
    /** 市名称 */
    private String cityName;
    /** 详细地址 */
    private String address;
    /** 生产商固定电话 */
    private String tel;
    /** 生产商传真号 */
    private String fax;
    /** 生产商网站名及微信公众号 */
    private String mediaPlatform;
    /** 审核状态，0： 待审核，1：正式 */
    private String auditStu;
    /** 审核备注 */
    private String auditRemark;
    /** 审核履历，格式：0,未注册,admin,2017-01-25; */
    private String auditHistory;

    /**
     * <p>默认构造函数</p>
     */
    public SlimProducer() {
    }

    /**
     * <p>生产商ID</p>
     *
     * @return 生产商ID
     */
    public Long getProducerId() {
        return producerId;
    }

    /**
     * <p>生产商ID</p>
     *
     * @param producerId 生产商ID
     */
    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
    /**
     * <p>生产商编码</p>
     *
     * @return 生产商编码
     */
    public String getProducerCode() {
        return producerCode;
    }

    /**
     * <p>生产商编码</p>
     *
     * @param producerCode 生产商编码
     */
    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }
    /**
     * <p>生产商全称</p>
     *
     * @return 生产商全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * <p>生产商全称</p>
     *
     * @param fullName 生产商全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * <p>生产商简称</p>
     *
     * @return 生产商简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * <p>生产商简称</p>
     *
     * @param shortName 生产商简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    /**
     * <p>国家CODE</p>
     *
     * @return 国家CODE
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * <p>国家CODE</p>
     *
     * @param countryCode 国家CODE
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * <p>国家名称</p>
     *
     * @return 国家名称
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * <p>国家名称</p>
     *
     * @param countryName 国家名称
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    /**
     * <p>省CODE</p>
     *
     * @return 省CODE
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>省CODE</p>
     *
     * @param provinceCode 省CODE
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
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
     * <p>市CODE</p>
     *
     * @return 市CODE
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>市CODE</p>
     *
     * @param cityCode 市CODE
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * <p>市名称</p>
     *
     * @return 市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>市名称</p>
     *
     * @param cityName 市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
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
     * <p>生产商固定电话</p>
     *
     * @return 生产商固定电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * <p>生产商固定电话</p>
     *
     * @param tel 生产商固定电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**
     * <p>生产商传真号</p>
     *
     * @return 生产商传真号
     */
    public String getFax() {
        return fax;
    }

    /**
     * <p>生产商传真号</p>
     *
     * @param fax 生产商传真号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**
     * <p>生产商网站名及微信公众号</p>
     *
     * @return 生产商网站名及微信公众号
     */
    public String getMediaPlatform() {
        return mediaPlatform;
    }

    /**
     * <p>生产商网站名及微信公众号</p>
     *
     * @param mediaPlatform 生产商网站名及微信公众号
     */
    public void setMediaPlatform(String mediaPlatform) {
        this.mediaPlatform = mediaPlatform;
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
