/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_TNC_STD对应的实体SlpdTncStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdTncStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long tncStdId;
    /** 加工质量类型ID */
    private String tncStdType;
    /** 品种ID */
    private Long breedId;
    /** A1级质量标准 */
    private String tncStdValA;
    /** A2级质量标准 */
    private String tncStdValB;
    /** A3级质量标准 */
    private String tncStdValC;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdTncStd() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getTncStdId() {
        return tncStdId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param tncStdId 主键ID
     */
    public void setTncStdId(Long tncStdId) {
        this.tncStdId = tncStdId;
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
     * <p>A1级质量标准</p>
     *
     * @return A1级质量标准
     */
    public String getTncStdValA() {
        return tncStdValA;
    }

    /**
     * <p>A1级质量标准</p>
     *
     * @param tncStdValA A1级质量标准
     */
    public void setTncStdValA(String tncStdValA) {
        this.tncStdValA = tncStdValA;
    }
    /**
     * <p>A2级质量标准</p>
     *
     * @return A2级质量标准
     */
    public String getTncStdValB() {
        return tncStdValB;
    }

    /**
     * <p>A2级质量标准</p>
     *
     * @param tncStdValB A2级质量标准
     */
    public void setTncStdValB(String tncStdValB) {
        this.tncStdValB = tncStdValB;
    }
    /**
     * <p>A3级质量标准</p>
     *
     * @return A3级质量标准
     */
    public String getTncStdValC() {
        return tncStdValC;
    }

    /**
     * <p>A3级质量标准</p>
     *
     * @param tncStdValC A3级质量标准
     */
    public void setTncStdValC(String tncStdValC) {
        this.tncStdValC = tncStdValC;
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
