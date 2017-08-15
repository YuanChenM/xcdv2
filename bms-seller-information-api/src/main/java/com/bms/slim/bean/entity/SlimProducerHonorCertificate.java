/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_producer_honor_certificate对应的实体SlimProducerHonorCertificate</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimProducerHonorCertificate extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long honorCertId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 发证机关 */
    private String issueAuthority;
    /** 发证日期 */
    private java.util.Date issueDate;
    /** 荣誉证书 */
    private String honorCertUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimProducerHonorCertificate() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getHonorCertId() {
        return honorCertId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param honorCertId 主键ID
     */
    public void setHonorCertId(Long honorCertId) {
        this.honorCertId = honorCertId;
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
     * <p>发证机关</p>
     *
     * @return 发证机关
     */
    public String getIssueAuthority() {
        return issueAuthority;
    }

    /**
     * <p>发证机关</p>
     *
     * @param issueAuthority 发证机关
     */
    public void setIssueAuthority(String issueAuthority) {
        this.issueAuthority = issueAuthority;
    }
    /**
     * <p>发证日期</p>
     *
     * @return 发证日期
     */
    public java.util.Date getIssueDate() {
        return issueDate;
    }

    /**
     * <p>发证日期</p>
     *
     * @param issueDate 发证日期
     */
    public void setIssueDate(java.util.Date issueDate) {
        this.issueDate = issueDate;
    }
    /**
     * <p>荣誉证书</p>
     *
     * @return 荣誉证书
     */
    public String getHonorCertUrl() {
        return honorCertUrl;
    }

    /**
     * <p>荣誉证书</p>
     *
     * @param honorCertUrl 荣誉证书
     */
    public void setHonorCertUrl(String honorCertUrl) {
        this.honorCertUrl = honorCertUrl;
    }

}
