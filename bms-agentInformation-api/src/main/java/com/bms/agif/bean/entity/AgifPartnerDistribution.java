/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_PARTNER_DISTRIBUTION对应的实体AgifPartnerDistribution</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifPartnerDistribution extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** ID */
    private Long id;
    /** PARTNER_ID */
    private String partnerId;
    /** 物流区主键 */
    private Long lgcsAreaId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区名称 */
    private String lgcsAreaName;
    /** 物流区划地区主键 */
    private Long zoneId;
    /** 物流区划地区编码 */
    private String zoneCode;
    /** 物流区划地区名称 */
    private String zoneName;
    /** 配送站主键 */
    private Long distributionId;
    /** 配送站分类 */
    private String distributionType;
    /** 配送站表示码 */
    private String distributionName;
    /** 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码) */
    private String distributionCode;
    /** 配送站授权销售合伙人 */
    private String authorizedPartner;

    /**
     * <p>默认构造函数</p>
     */
    public AgifPartnerDistribution() {
    }

    /**
     * <p>ID</p>
     *
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>ID</p>
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * <p>PARTNER_ID</p>
     *
     * @return PARTNER_ID
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * <p>PARTNER_ID</p>
     *
     * @param partnerId PARTNER_ID
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
    /**
     * <p>物流区主键</p>
     *
     * @return 物流区主键
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区主键</p>
     *
     * @param lgcsAreaId 物流区主键
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param lgcsAreaName 物流区名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>物流区划地区主键</p>
     *
     * @return 物流区划地区主键
     */
    public Long getZoneId() {
        return zoneId;
    }

    /**
     * <p>物流区划地区主键</p>
     *
     * @param zoneId 物流区划地区主键
     */
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
    /**
     * <p>物流区划地区编码</p>
     *
     * @return 物流区划地区编码
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * <p>物流区划地区编码</p>
     *
     * @param zoneCode 物流区划地区编码
     */
    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
    /**
     * <p>物流区划地区名称</p>
     *
     * @return 物流区划地区名称
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * <p>物流区划地区名称</p>
     *
     * @param zoneName 物流区划地区名称
     */
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    /**
     * <p>配送站主键</p>
     *
     * @return 配送站主键
     */
    public Long getDistributionId() {
        return distributionId;
    }

    /**
     * <p>配送站主键</p>
     *
     * @param distributionId 配送站主键
     */
    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }
    /**
     * <p>配送站分类</p>
     *
     * @return 配送站分类
     */
    public String getDistributionType() {
        return distributionType;
    }

    /**
     * <p>配送站分类</p>
     *
     * @param distributionType 配送站分类
     */
    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }
    /**
     * <p>配送站表示码</p>
     *
     * @return 配送站表示码
     */
    public String getDistributionName() {
        return distributionName;
    }

    /**
     * <p>配送站表示码</p>
     *
     * @param distributionName 配送站表示码
     */
    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }
    /**
     * <p>配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)</p>
     *
     * @return 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)
     */
    public String getDistributionCode() {
        return distributionCode;
    }

    /**
     * <p>配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)</p>
     *
     * @param distributionCode 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)
     */
    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }
    /**
     * <p>配送站授权销售合伙人</p>
     *
     * @return 配送站授权销售合伙人
     */
    public String getAuthorizedPartner() {
        return authorizedPartner;
    }

    /**
     * <p>配送站授权销售合伙人</p>
     *
     * @param authorizedPartner 配送站授权销售合伙人
     */
    public void setAuthorizedPartner(String authorizedPartner) {
        this.authorizedPartner = authorizedPartner;
    }

}
