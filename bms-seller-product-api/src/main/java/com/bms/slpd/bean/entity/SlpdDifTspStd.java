/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_TSP_STD对应的实体SlpdDifTspStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifTspStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long tspDifStdId;
    /** 存储运输类型ID */
    private String tspStdType;
    /** 品种ID */
    private Long breedId;
    /** 产品ID */
    private String productId;
    /** 合格差异值 */
    private String tspOkDifVal;
    /** 不合格差异值 */
    private String tspNgDifVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifTspStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getTspDifStdId() {
        return tspDifStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param tspDifStdId 主键
     */
    public void setTspDifStdId(Long tspDifStdId) {
        this.tspDifStdId = tspDifStdId;
    }
    /**
     * <p>存储运输类型ID</p>
     *
     * @return 存储运输类型ID
     */
    public String getTspStdType() {
        return tspStdType;
    }

    /**
     * <p>存储运输类型ID</p>
     *
     * @param tspStdType 存储运输类型ID
     */
    public void setTspStdType(String tspStdType) {
        this.tspStdType = tspStdType;
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
    public String getTspOkDifVal() {
        return tspOkDifVal;
    }

    /**
     * <p>合格差异值</p>
     *
     * @param tspOkDifVal 合格差异值
     */
    public void setTspOkDifVal(String tspOkDifVal) {
        this.tspOkDifVal = tspOkDifVal;
    }
    /**
     * <p>不合格差异值</p>
     *
     * @return 不合格差异值
     */
    public String getTspNgDifVal() {
        return tspNgDifVal;
    }

    /**
     * <p>不合格差异值</p>
     *
     * @param tspNgDifVal 不合格差异值
     */
    public void setTspNgDifVal(String tspNgDifVal) {
        this.tspNgDifVal = tspNgDifVal;
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
