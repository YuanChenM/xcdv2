package com.bms.slim.bean.result.wrapper;

import java.io.Serializable;
import java.util.Date;

public class SlimSellerProducerResult implements Serializable{
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家ID */
    private Long entitySellerId;
    /** 生产商ID */
    private Long producerId;
    /** 生产商编码 */
    private String producerCode;
    /** 生产商全称 */
    private String fullName;
    /** 生产商名称 */
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
    /** 联系人ID */
    private Long contactId;
    /** 联系人名称 */
    private String contactName;
    /** 工作单位ID */
    private Long workunitId;
    /** 工作单位类型，1：卖家单位，2：生产商单位 */
    private String workunitType;
    /** 手机号 */
    private String mobile;
    /** 微信号 */
    private String wechat;
    /** QQ号 */
    private String qq;
    /** EMAIL地址 */
    private String email;
    /** 删除标识 */
    private Boolean delFlg;
    /** 创建人 */
    private String crtId;
    /** 创建时间 */
    private Date crtTime;
    /** 修改人 */
    private String updId;
    /** 修改时间 */
    private Date updTime;
    /** 版本号 */
    private Integer version;

    private Integer versionC;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
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

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Long getWorkunitId() {
        return workunitId;
    }

    public void setWorkunitId(Long workunitId) {
        this.workunitId = workunitId;
    }

    public String getWorkunitType() {
        return workunitType;
    }

    public void setWorkunitType(String workunitType) {
        this.workunitType = workunitType;
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersionC() {
        return versionC;
    }

    public void setVersionC(Integer versionC) {
        this.versionC = versionC;
    }
}
