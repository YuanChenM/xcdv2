/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_animal_epidemic_prevention_condition_certificate对应的实体SlimAnimalEpidemicPreventionConditionCertificate</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimAnimalEpidemicPreventionConditionCertificate extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long aepccId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 证号 */
    private String certNo;
    /** 有效期 */
    private String validPeriod;
    /** 动物防疫条件合格证URL */
    private String aniEpiPrevContCertUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimAnimalEpidemicPreventionConditionCertificate() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getAepccId() {
        return aepccId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param aepccId 主键ID
     */
    public void setAepccId(Long aepccId) {
        this.aepccId = aepccId;
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
     * <p>证号</p>
     *
     * @return 证号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * <p>证号</p>
     *
     * @param certNo 证号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
    /**
     * <p>有效期</p>
     *
     * @return 有效期
     */
    public String getValidPeriod() {
        return validPeriod;
    }

    /**
     * <p>有效期</p>
     *
     * @param validPeriod 有效期
     */
    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }
    /**
     * <p>动物防疫条件合格证URL</p>
     *
     * @return 动物防疫条件合格证URL
     */
    public String getAniEpiPrevContCertUrl() {
        return aniEpiPrevContCertUrl;
    }

    /**
     * <p>动物防疫条件合格证URL</p>
     *
     * @param aniEpiPrevContCertUrl 动物防疫条件合格证URL
     */
    public void setAniEpiPrevContCertUrl(String aniEpiPrevContCertUrl) {
        this.aniEpiPrevContCertUrl = aniEpiPrevContCertUrl;
    }

}
