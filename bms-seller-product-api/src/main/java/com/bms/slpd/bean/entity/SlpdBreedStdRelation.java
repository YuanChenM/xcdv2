/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_BREED_STD_RELATION对应的实体SlpdBreedStdRelation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdBreedStdRelation extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long breedStdId;
    /** 品种ID */
    private Long breedId;
    /** 原种种源标准 0:不存在 1：存在 */
    private Boolean orgStdFlg;
    /** 饲养标准 0:不存在 1：存在 */
    private Boolean fedStdFlg;
    /** 加工技术标准 0:不存在 1：存在 */
    private Boolean mctStdFlg;
    /** 加工质量标准 0:不存在 1：存在 */
    private Boolean tncStdFlg;
    /** 通用质量标准 0:不存在 1：存在 */
    private Boolean gnqStdFlg;
    /** 安全标准 0:不存在 1：存在 */
    private Boolean sftStdFlg;
    /** 存储运输标准 0:不存在 1：存在 */
    private Boolean tspStdFlg;
    /** 包装标准 0:不存在 1：存在 */
    private Boolean pkgStdFlg;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdBreedStdRelation() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getBreedStdId() {
        return breedStdId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param breedStdId 主键ID
     */
    public void setBreedStdId(Long breedStdId) {
        this.breedStdId = breedStdId;
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
     * <p>原种种源标准 0:不存在 1：存在</p>
     *
     * @return 原种种源标准 0:不存在 1：存在
     */
    public Boolean getOrgStdFlg() {
        return orgStdFlg;
    }

    /**
     * <p>原种种源标准 0:不存在 1：存在</p>
     *
     * @param orgStdFlg 原种种源标准 0:不存在 1：存在
     */
    public void setOrgStdFlg(Boolean orgStdFlg) {
        this.orgStdFlg = orgStdFlg;
    }
    /**
     * <p>饲养标准 0:不存在 1：存在</p>
     *
     * @return 饲养标准 0:不存在 1：存在
     */
    public Boolean getFedStdFlg() {
        return fedStdFlg;
    }

    /**
     * <p>饲养标准 0:不存在 1：存在</p>
     *
     * @param fedStdFlg 饲养标准 0:不存在 1：存在
     */
    public void setFedStdFlg(Boolean fedStdFlg) {
        this.fedStdFlg = fedStdFlg;
    }
    /**
     * <p>加工技术标准 0:不存在 1：存在</p>
     *
     * @return 加工技术标准 0:不存在 1：存在
     */
    public Boolean getMctStdFlg() {
        return mctStdFlg;
    }

    /**
     * <p>加工技术标准 0:不存在 1：存在</p>
     *
     * @param mctStdFlg 加工技术标准 0:不存在 1：存在
     */
    public void setMctStdFlg(Boolean mctStdFlg) {
        this.mctStdFlg = mctStdFlg;
    }
    /**
     * <p>加工质量标准 0:不存在 1：存在</p>
     *
     * @return 加工质量标准 0:不存在 1：存在
     */
    public Boolean getTncStdFlg() {
        return tncStdFlg;
    }

    /**
     * <p>加工质量标准 0:不存在 1：存在</p>
     *
     * @param tncStdFlg 加工质量标准 0:不存在 1：存在
     */
    public void setTncStdFlg(Boolean tncStdFlg) {
        this.tncStdFlg = tncStdFlg;
    }
    /**
     * <p>通用质量标准 0:不存在 1：存在</p>
     *
     * @return 通用质量标准 0:不存在 1：存在
     */
    public Boolean getGnqStdFlg() {
        return gnqStdFlg;
    }

    /**
     * <p>通用质量标准 0:不存在 1：存在</p>
     *
     * @param gnqStdFlg 通用质量标准 0:不存在 1：存在
     */
    public void setGnqStdFlg(Boolean gnqStdFlg) {
        this.gnqStdFlg = gnqStdFlg;
    }
    /**
     * <p>安全标准 0:不存在 1：存在</p>
     *
     * @return 安全标准 0:不存在 1：存在
     */
    public Boolean getSftStdFlg() {
        return sftStdFlg;
    }

    /**
     * <p>安全标准 0:不存在 1：存在</p>
     *
     * @param sftStdFlg 安全标准 0:不存在 1：存在
     */
    public void setSftStdFlg(Boolean sftStdFlg) {
        this.sftStdFlg = sftStdFlg;
    }
    /**
     * <p>存储运输标准 0:不存在 1：存在</p>
     *
     * @return 存储运输标准 0:不存在 1：存在
     */
    public Boolean getTspStdFlg() {
        return tspStdFlg;
    }

    /**
     * <p>存储运输标准 0:不存在 1：存在</p>
     *
     * @param tspStdFlg 存储运输标准 0:不存在 1：存在
     */
    public void setTspStdFlg(Boolean tspStdFlg) {
        this.tspStdFlg = tspStdFlg;
    }
    /**
     * <p>包装标准 0:不存在 1：存在</p>
     *
     * @return 包装标准 0:不存在 1：存在
     */
    public Boolean getPkgStdFlg() {
        return pkgStdFlg;
    }

    /**
     * <p>包装标准 0:不存在 1：存在</p>
     *
     * @param pkgStdFlg 包装标准 0:不存在 1：存在
     */
    public void setPkgStdFlg(Boolean pkgStdFlg) {
        this.pkgStdFlg = pkgStdFlg;
    }

}
