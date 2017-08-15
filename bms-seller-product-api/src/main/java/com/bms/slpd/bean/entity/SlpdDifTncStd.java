/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_TNC_STD对应的实体SlpdDifTncStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifTncStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long tncDifStdId;
    /** 加工质量类型ID */
    private String tncStdType;
    /** 品种ID */
    private Long breedId;
    /** 产品ID */
    private String productId;
    /** A1级质量标准差异值 */
    private String tncStdDifValA;
    /** A2级质量标准差异值 */
    private String tncStdDifValB;
    /** A3级质量标准差异值 */
    private String tncStdDifValC;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifTncStd() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getTncDifStdId() {
        return tncDifStdId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param tncDifStdId 主键ID
     */
    public void setTncDifStdId(Long tncDifStdId) {
        this.tncDifStdId = tncDifStdId;
    }
    /**
     * <p>加工质量类型ID</p>
     *
     * @return 加工质量类型ID
     */
    public String getTncStdType() {
        return tncStdType;
    }

    /**
     * <p>加工质量类型ID</p>
     *
     * @param tncStdType 加工质量类型ID
     */
    public void setTncStdType(String tncStdType) {
        this.tncStdType = tncStdType;
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
     * <p>A1级质量标准差异值</p>
     *
     * @return A1级质量标准差异值
     */
    public String getTncStdDifValA() {
        return tncStdDifValA;
    }

    /**
     * <p>A1级质量标准差异值</p>
     *
     * @param tncStdDifValA A1级质量标准差异值
     */
    public void setTncStdDifValA(String tncStdDifValA) {
        this.tncStdDifValA = tncStdDifValA;
    }
    /**
     * <p>A2级质量标准差异值</p>
     *
     * @return A2级质量标准差异值
     */
    public String getTncStdDifValB() {
        return tncStdDifValB;
    }

    /**
     * <p>A2级质量标准差异值</p>
     *
     * @param tncStdDifValB A2级质量标准差异值
     */
    public void setTncStdDifValB(String tncStdDifValB) {
        this.tncStdDifValB = tncStdDifValB;
    }
    /**
     * <p>A3级质量标准差异值</p>
     *
     * @return A3级质量标准差异值
     */
    public String getTncStdDifValC() {
        return tncStdDifValC;
    }

    /**
     * <p>A3级质量标准差异值</p>
     *
     * @param tncStdDifValC A3级质量标准差异值
     */
    public void setTncStdDifValC(String tncStdDifValC) {
        this.tncStdDifValC = tncStdDifValC;
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
