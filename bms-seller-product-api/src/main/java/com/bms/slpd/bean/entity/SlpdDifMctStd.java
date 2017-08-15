/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_MCT_STD对应的实体SlpdDifMctStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifMctStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long mctDifStdId;
    /** 加工技术类型ID */
    private String mctStdType;
    /** 品种ID */
    private Long breedId;
    /** 产品ID */
    private String productId;
    /** 合格差异值 */
    private String mctOkDifVal;
    /** 不合格差异值 */
    private String mctNgDifVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifMctStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getMctDifStdId() {
        return mctDifStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param mctDifStdId 主键
     */
    public void setMctDifStdId(Long mctDifStdId) {
        this.mctDifStdId = mctDifStdId;
    }
    /**
     * <p>加工技术类型ID</p>
     *
     * @return 加工技术类型ID
     */
    public String getMctStdType() {
        return mctStdType;
    }

    /**
     * <p>加工技术类型ID</p>
     *
     * @param mctStdType 加工技术类型ID
     */
    public void setMctStdType(String mctStdType) {
        this.mctStdType = mctStdType;
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
    public String getMctOkDifVal() {
        return mctOkDifVal;
    }

    /**
     * <p>合格差异值</p>
     *
     * @param mctOkDifVal 合格差异值
     */
    public void setMctOkDifVal(String mctOkDifVal) {
        this.mctOkDifVal = mctOkDifVal;
    }
    /**
     * <p>不合格差异值</p>
     *
     * @return 不合格差异值
     */
    public String getMctNgDifVal() {
        return mctNgDifVal;
    }

    /**
     * <p>不合格差异值</p>
     *
     * @param mctNgDifVal 不合格差异值
     */
    public void setMctNgDifVal(String mctNgDifVal) {
        this.mctNgDifVal = mctNgDifVal;
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
