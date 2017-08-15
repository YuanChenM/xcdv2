/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_SFT_STD对应的实体SlpdDifSftStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifSftStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long sftDifStdId;
    /** 安全指标类型ID */
    private String sftStdType;
    /** 品种ID */
    private Long breedId;
    /** 产品ID */
    private String productId;
    /** 合格差异值 */
    private String sftOkDifVal;
    /** 不合格差异值 */
    private String sftNgDifVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifSftStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getSftDifStdId() {
        return sftDifStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param sftDifStdId 主键
     */
    public void setSftDifStdId(Long sftDifStdId) {
        this.sftDifStdId = sftDifStdId;
    }
    /**
     * <p>安全指标类型ID</p>
     *
     * @return 安全指标类型ID
     */
    public String getSftStdType() {
        return sftStdType;
    }

    /**
     * <p>安全指标类型ID</p>
     *
     * @param sftStdType 安全指标类型ID
     */
    public void setSftStdType(String sftStdType) {
        this.sftStdType = sftStdType;
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
    public String getSftOkDifVal() {
        return sftOkDifVal;
    }

    /**
     * <p>合格差异值</p>
     *
     * @param sftOkDifVal 合格差异值
     */
    public void setSftOkDifVal(String sftOkDifVal) {
        this.sftOkDifVal = sftOkDifVal;
    }
    /**
     * <p>不合格差异值</p>
     *
     * @return 不合格差异值
     */
    public String getSftNgDifVal() {
        return sftNgDifVal;
    }

    /**
     * <p>不合格差异值</p>
     *
     * @param sftNgDifVal 不合格差异值
     */
    public void setSftNgDifVal(String sftNgDifVal) {
        this.sftNgDifVal = sftNgDifVal;
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
