/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_GNQ_STD对应的实体SlpdGnqStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdGnqStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long gnqStdId;
    /** 通用指标类型ID */
    private String gnqStdType;
    /** 品种ID */
    private Long breedId;
    /** 合格值 */
    private String gnqOkVal;
    /** 不合格值 */
    private String gnqNgVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdGnqStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getGnqStdId() {
        return gnqStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param gnqStdId 主键
     */
    public void setGnqStdId(Long gnqStdId) {
        this.gnqStdId = gnqStdId;
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
     * <p>合格值</p>
     *
     * @return 合格值
     */
    public String getGnqOkVal() {
        return gnqOkVal;
    }

    /**
     * <p>合格值</p>
     *
     * @param gnqOkVal 合格值
     */
    public void setGnqOkVal(String gnqOkVal) {
        this.gnqOkVal = gnqOkVal;
    }
    /**
     * <p>不合格值</p>
     *
     * @return 不合格值
     */
    public String getGnqNgVal() {
        return gnqNgVal;
    }

    /**
     * <p>不合格值</p>
     *
     * @param gnqNgVal 不合格值
     */
    public void setGnqNgVal(String gnqNgVal) {
        this.gnqNgVal = gnqNgVal;
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
