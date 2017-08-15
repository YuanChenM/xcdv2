/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_SFT_STD对应的实体SlpdSftStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdSftStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long sftStdId;
    /** 安全指标类型ID */
    private String sftStdType;
    /** 品种ID */
    private Long breedId;
    /** 合格值 */
    private String sftOkVal;
    /** 不合格值 */
    private String sftNgVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdSftStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getSftStdId() {
        return sftStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param sftStdId 主键
     */
    public void setSftStdId(Long sftStdId) {
        this.sftStdId = sftStdId;
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
     * <p>合格值</p>
     *
     * @return 合格值
     */
    public String getSftOkVal() {
        return sftOkVal;
    }

    /**
     * <p>合格值</p>
     *
     * @param sftOkVal 合格值
     */
    public void setSftOkVal(String sftOkVal) {
        this.sftOkVal = sftOkVal;
    }
    /**
     * <p>不合格值</p>
     *
     * @return 不合格值
     */
    public String getSftNgVal() {
        return sftNgVal;
    }

    /**
     * <p>不合格值</p>
     *
     * @param sftNgVal 不合格值
     */
    public void setSftNgVal(String sftNgVal) {
        this.sftNgVal = sftNgVal;
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
