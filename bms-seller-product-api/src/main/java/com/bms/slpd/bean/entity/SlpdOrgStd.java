/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_ORG_STD对应的实体SlpdOrgStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdOrgStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long orgStdId;
    /** 原种种源类型ID */
    private String orgStdType;
    /** 品种ID */
    private Long breedId;
    /** 优良值 */
    private String orgGoodVal;
    /** 一般值 */
    private String orgNormalVal;
    /** 合格 */
    private String orgOkVal;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdOrgStd() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getOrgStdId() {
        return orgStdId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param orgStdId 主键ID
     */
    public void setOrgStdId(Long orgStdId) {
        this.orgStdId = orgStdId;
    }
    /**
     * <p>原种种源类型ID</p>
     *
     * @return 原种种源类型ID
     */
    public String getOrgStdType() {
        return orgStdType;
    }

    /**
     * <p>原种种源类型ID</p>
     *
     * @param orgStdType 原种种源类型ID
     */
    public void setOrgStdType(String orgStdType) {
        this.orgStdType = orgStdType;
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
    public String getOrgGoodVal() {
        return orgGoodVal;
    }

    /**
     * <p>优良值</p>
     *
     * @param orgGoodVal 优良值
     */
    public void setOrgGoodVal(String orgGoodVal) {
        this.orgGoodVal = orgGoodVal;
    }
    /**
     * <p>一般值</p>
     *
     * @return 一般值
     */
    public String getOrgNormalVal() {
        return orgNormalVal;
    }

    /**
     * <p>一般值</p>
     *
     * @param orgNormalVal 一般值
     */
    public void setOrgNormalVal(String orgNormalVal) {
        this.orgNormalVal = orgNormalVal;
    }
    /**
     * <p>合格</p>
     *
     * @return 合格
     */
    public String getOrgOkVal() {
        return orgOkVal;
    }

    /**
     * <p>合格</p>
     *
     * @param orgOkVal 合格
     */
    public void setOrgOkVal(String orgOkVal) {
        this.orgOkVal = orgOkVal;
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
