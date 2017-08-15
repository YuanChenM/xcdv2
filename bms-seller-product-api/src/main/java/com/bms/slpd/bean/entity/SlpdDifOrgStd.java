/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_ORG_STD对应的实体SlpdDifOrgStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifOrgStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long orgDifStdId;
    /** 原种种源类型ID */
    private String orgStdType;
    /** 品种ID */
    private Long breedId;
    /** 产品ID */
    private String productId;
    /** 优良差异值 */
    private String orgGoodDifVal;
    /** 一般差异值 */
    private String orgNormalDifVal;
    /** 合格差异值 */
    private String orgOkDifVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifOrgStd() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getOrgDifStdId() {
        return orgDifStdId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param orgDifStdId 主键ID
     */
    public void setOrgDifStdId(Long orgDifStdId) {
        this.orgDifStdId = orgDifStdId;
    }
    /**
     * <p>原种种源类型ID</p>
     *
     * @return 原种种源类型ID
     */
    public String getOrgStdType() {
        return orgStdType;
    }

    /**
     * <p>原种种源类型ID</p>
     *
     * @param orgStdType 原种种源类型ID
     */
    public void setOrgStdType(String orgStdType) {
        this.orgStdType = orgStdType;
    }
    /**
     * <p>品种ID</p>
     *
     * @return 品种ID
     */
    public Long getBreedId() {
        return breedId;
    }

    /**
     * <p>品种ID</p>
     *
     * @param breedId 品种ID
     */
    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }
    /**
     * <p>产品ID</p>
     *
     * @return 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * <p>产品ID</p>
     *
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }
    /**
     * <p>优良差异值</p>
     *
     * @return 优良差异值
     */
    public String getOrgGoodDifVal() {
        return orgGoodDifVal;
    }

    /**
     * <p>优良差异值</p>
     *
     * @param orgGoodDifVal 优良差异值
     */
    public void setOrgGoodDifVal(String orgGoodDifVal) {
        this.orgGoodDifVal = orgGoodDifVal;
    }
    /**
     * <p>一般差异值</p>
     *
     * @return 一般差异值
     */
    public String getOrgNormalDifVal() {
        return orgNormalDifVal;
    }

    /**
     * <p>一般差异值</p>
     *
     * @param orgNormalDifVal 一般差异值
     */
    public void setOrgNormalDifVal(String orgNormalDifVal) {
        this.orgNormalDifVal = orgNormalDifVal;
    }
    /**
     * <p>合格差异值</p>
     *
     * @return 合格差异值
     */
    public String getOrgOkDifVal() {
        return orgOkDifVal;
    }

    /**
     * <p>合格差异值</p>
     *
     * @param orgOkDifVal 合格差异值
     */
    public void setOrgOkDifVal(String orgOkDifVal) {
        this.orgOkDifVal = orgOkDifVal;
    }
    /**
     * <p>备注</p>
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>备注</p>
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
