/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_TSP_STD对应的实体SlpdTspStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdTspStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long tspStdId;
    /** 存储运输类型ID */
    private String tspStdType;
    /** 品种ID */
    private Long breedId;
    /** 合格值 */
    private String tspOkVal;
    /** 不合格值 */
    private String tspNgVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdTspStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getTspStdId() {
        return tspStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param tspStdId 主键
     */
    public void setTspStdId(Long tspStdId) {
        this.tspStdId = tspStdId;
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
     * <p>合格值</p>
     *
     * @return 合格值
     */
    public String getTspOkVal() {
        return tspOkVal;
    }

    /**
     * <p>合格值</p>
     *
     * @param tspOkVal 合格值
     */
    public void setTspOkVal(String tspOkVal) {
        this.tspOkVal = tspOkVal;
    }
    /**
     * <p>不合格值</p>
     *
     * @return 不合格值
     */
    public String getTspNgVal() {
        return tspNgVal;
    }

    /**
     * <p>不合格值</p>
     *
     * @param tspNgVal 不合格值
     */
    public void setTspNgVal(String tspNgVal) {
        this.tspNgVal = tspNgVal;
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
