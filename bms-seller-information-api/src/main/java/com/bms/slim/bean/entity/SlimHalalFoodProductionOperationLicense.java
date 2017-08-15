/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_halal_food_production_operation_license对应的实体SlimHalalFoodProductionOperationLicense</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimHalalFoodProductionOperationLicense extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long hfpolId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 证书编号 */
    private String certNo;
    /** 商检证书号码 */
    private String commInspCertNo;
    /** 签发日期 */
    private java.util.Date issueDateBegin;
    /** 签发截止日期 */
    private java.util.Date issueDateEnd;
    /** 签发机构 */
    private String issueAuthority;
    /** 清真食品生产经营许可证URL */
    private String halalFoodProdOptLicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimHalalFoodProductionOperationLicense() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getHfpolId() {
        return hfpolId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param hfpolId 主键ID
     */
    public void setHfpolId(Long hfpolId) {
        this.hfpolId = hfpolId;
    }
    /**
     * <p>卖家角色ID</p>
     *
     * @return 卖家角色ID
     */
    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @param sellerRoleId 卖家角色ID
     */
    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }
    /**
     * <p>证书编号</p>
     *
     * @return 证书编号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * <p>证书编号</p>
     *
     * @param certNo 证书编号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
    /**
     * <p>商检证书号码</p>
     *
     * @return 商检证书号码
     */
    public String getCommInspCertNo() {
        return commInspCertNo;
    }

    /**
     * <p>商检证书号码</p>
     *
     * @param commInspCertNo 商检证书号码
     */
    public void setCommInspCertNo(String commInspCertNo) {
        this.commInspCertNo = commInspCertNo;
    }
    /**
     * <p>签发日期</p>
     *
     * @return 签发日期
     */
    public java.util.Date getIssueDateBegin() {
        return issueDateBegin;
    }

    /**
     * <p>签发日期</p>
     *
     * @param issueDateBegin 签发日期
     */
    public void setIssueDateBegin(java.util.Date issueDateBegin) {
        this.issueDateBegin = issueDateBegin;
    }
    /**
     * <p>签发截止日期</p>
     *
     * @return 签发截止日期
     */
    public java.util.Date getIssueDateEnd() {
        return issueDateEnd;
    }

    /**
     * <p>签发截止日期</p>
     *
     * @param issueDateEnd 签发截止日期
     */
    public void setIssueDateEnd(java.util.Date issueDateEnd) {
        this.issueDateEnd = issueDateEnd;
    }
    /**
     * <p>签发机构</p>
     *
     * @return 签发机构
     */
    public String getIssueAuthority() {
        return issueAuthority;
    }

    /**
     * <p>签发机构</p>
     *
     * @param issueAuthority 签发机构
     */
    public void setIssueAuthority(String issueAuthority) {
        this.issueAuthority = issueAuthority;
    }
    /**
     * <p>清真食品生产经营许可证URL</p>
     *
     * @return 清真食品生产经营许可证URL
     */
    public String getHalalFoodProdOptLicUrl() {
        return halalFoodProdOptLicUrl;
    }

    /**
     * <p>清真食品生产经营许可证URL</p>
     *
     * @param halalFoodProdOptLicUrl 清真食品生产经营许可证URL
     */
    public void setHalalFoodProdOptLicUrl(String halalFoodProdOptLicUrl) {
        this.halalFoodProdOptLicUrl = halalFoodProdOptLicUrl;
    }

}
