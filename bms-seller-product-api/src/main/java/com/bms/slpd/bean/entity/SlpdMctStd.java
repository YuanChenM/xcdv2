/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_MCT_STD对应的实体SlpdMctStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdMctStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long mctStdId;
    /** 加工技术类型ID */
    private String mctStdType;
    /** 品种ID */
    private Long breedId;
    /** 合格值 */
    private String mctOkVal;
    /** 不合格值 */
    private String mctNgVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdMctStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getMctStdId() {
        return mctStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param mctStdId 主键
     */
    public void setMctStdId(Long mctStdId) {
        this.mctStdId = mctStdId;
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
     * <p>合格值</p>
     *
     * @return 合格值
     */
    public String getMctOkVal() {
        return mctOkVal;
    }

    /**
     * <p>合格值</p>
     *
     * @param mctOkVal 合格值
     */
    public void setMctOkVal(String mctOkVal) {
        this.mctOkVal = mctOkVal;
    }
    /**
     * <p>不合格值</p>
     *
     * @return 不合格值
     */
    public String getMctNgVal() {
        return mctNgVal;
    }

    /**
     * <p>不合格值</p>
     *
     * @param mctNgVal 不合格值
     */
    public void setMctNgVal(String mctNgVal) {
        this.mctNgVal = mctNgVal;
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
