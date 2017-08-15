/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_FED_STD对应的实体SlpdDifFedStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifFedStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long fedDifStdId;
    /** 饲养类型ID */
    private String fedStdType;
    /** 品种ID */
    private Long breedId;
    /** 产品ID */
    private String productId;
    /** 优良差异值 */
    private String fedGoodDifVal;
    /** 一般差异值 */
    private String fedNormalDifVal;
    /** 合格差异值 */
    private String fedOkDifVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifFedStd() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getFedDifStdId() {
        return fedDifStdId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param fedDifStdId 主键ID
     */
    public void setFedDifStdId(Long fedDifStdId) {
        this.fedDifStdId = fedDifStdId;
    }
    /**
     * <p>饲养类型ID</p>
     *
     * @return 饲养类型ID
     */
    public String getFedStdType() {
        return fedStdType;
    }

    /**
     * <p>饲养类型ID</p>
     *
     * @param fedStdType 饲养类型ID
     */
    public void setFedStdType(String fedStdType) {
        this.fedStdType = fedStdType;
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
    public String getFedGoodDifVal() {
        return fedGoodDifVal;
    }

    /**
     * <p>优良差异值</p>
     *
     * @param fedGoodDifVal 优良差异值
     */
    public void setFedGoodDifVal(String fedGoodDifVal) {
        this.fedGoodDifVal = fedGoodDifVal;
    }
    /**
     * <p>一般差异值</p>
     *
     * @return 一般差异值
     */
    public String getFedNormalDifVal() {
        return fedNormalDifVal;
    }

    /**
     * <p>一般差异值</p>
     *
     * @param fedNormalDifVal 一般差异值
     */
    public void setFedNormalDifVal(String fedNormalDifVal) {
        this.fedNormalDifVal = fedNormalDifVal;
    }
    /**
     * <p>合格差异值</p>
     *
     * @return 合格差异值
     */
    public String getFedOkDifVal() {
        return fedOkDifVal;
    }

    /**
     * <p>合格差异值</p>
     *
     * @param fedOkDifVal 合格差异值
     */
    public void setFedOkDifVal(String fedOkDifVal) {
        this.fedOkDifVal = fedOkDifVal;
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
