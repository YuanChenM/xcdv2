/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_GNQ_STD对应的实体SlpdDifGnqStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifGnqStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long gnqDifStdId;
    /** 通用指标类型ID */
    private String gnqStdType;
    /** 品种ID */
    private Long breedId;
    /** 产品ID */
    private String productId;
    /** 合格差异值 */
    private String gnqOkDifVal;
    /** 不合格差异值 */
    private String gnqNgDifVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifGnqStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getGnqDifStdId() {
        return gnqDifStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param gnqDifStdId 主键
     */
    public void setGnqDifStdId(Long gnqDifStdId) {
        this.gnqDifStdId = gnqDifStdId;
    }
    /**
     * <p>通用指标类型ID</p>
     *
     * @return 通用指标类型ID
     */
    public String getGnqStdType() {
        return gnqStdType;
    }

    /**
     * <p>通用指标类型ID</p>
     *
     * @param gnqStdType 通用指标类型ID
     */
    public void setGnqStdType(String gnqStdType) {
        this.gnqStdType = gnqStdType;
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
     * <p>合格差异值</p>
     *
     * @return 合格差异值
     */
    public String getGnqOkDifVal() {
        return gnqOkDifVal;
    }

    /**
     * <p>合格差异值</p>
     *
     * @param gnqOkDifVal 合格差异值
     */
    public void setGnqOkDifVal(String gnqOkDifVal) {
        this.gnqOkDifVal = gnqOkDifVal;
    }
    /**
     * <p>不合格差异值</p>
     *
     * @return 不合格差异值
     */
    public String getGnqNgDifVal() {
        return gnqNgDifVal;
    }

    /**
     * <p>不合格差异值</p>
     *
     * @param gnqNgDifVal 不合格差异值
     */
    public void setGnqNgDifVal(String gnqNgDifVal) {
        this.gnqNgDifVal = gnqNgDifVal;
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
