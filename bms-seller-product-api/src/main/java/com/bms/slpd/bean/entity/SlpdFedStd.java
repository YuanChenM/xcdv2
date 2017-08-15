/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_FED_STD对应的实体SlpdFedStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdFedStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long fedStdId;
    /** 饲养类型ID */
    private String fedStdType;
    /** 品种ID */
    private Long breedId;
    /** 优良值 */
    private String fedGoodVal;
    /** 一般值 */
    private String fedNormalVal;
    /** 合格值 */
    private String fedOkVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdFedStd() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getFedStdId() {
        return fedStdId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param fedStdId 主键ID
     */
    public void setFedStdId(Long fedStdId) {
        this.fedStdId = fedStdId;
    }
    /**
     * <p>饲养类型ID</p>
     *
     * @return 饲养类型ID
     */
    public String getFedStdType() {
        return fedStdType;
    }

    /**
     * <p>饲养类型ID</p>
     *
     * @param fedStdType 饲养类型ID
     */
    public void setFedStdType(String fedStdType) {
        this.fedStdType = fedStdType;
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
     * <p>优良值</p>
     *
     * @return 优良值
     */
    public String getFedGoodVal() {
        return fedGoodVal;
    }

    /**
     * <p>优良值</p>
     *
     * @param fedGoodVal 优良值
     */
    public void setFedGoodVal(String fedGoodVal) {
        this.fedGoodVal = fedGoodVal;
    }
    /**
     * <p>一般值</p>
     *
     * @return 一般值
     */
    public String getFedNormalVal() {
        return fedNormalVal;
    }

    /**
     * <p>一般值</p>
     *
     * @param fedNormalVal 一般值
     */
    public void setFedNormalVal(String fedNormalVal) {
        this.fedNormalVal = fedNormalVal;
    }
    /**
     * <p>合格值</p>
     *
     * @return 合格值
     */
    public String getFedOkVal() {
        return fedOkVal;
    }

    /**
     * <p>合格值</p>
     *
     * @param fedOkVal 合格值
     */
    public void setFedOkVal(String fedOkVal) {
        this.fedOkVal = fedOkVal;
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
