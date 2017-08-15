/*
 * 2017/04/19 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_pkg_std对应的实体SlpdPkgStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdPkgStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long pkgStdId;
    /** 单品ID */
    private Long itemId;
    /** 内包装净重 */
    private java.math.BigDecimal pkgInSuttle;
    /** 内包装净重误差范围 */
    private String pkgInError;
    /** 内包装净重/个数 */
    private String pkgInNumber;
    /** 内包装外径 */
    private String pkgInSize;
    /** 内包装材质 */
    private String pkgInTexture;
    /** 外包装净重误差范围 */
    private String pkgOutError;
    /** 外包装净重/毛重 */
    private String pkgOutNumber;
    /** 外包装外径 */
    private String pkgOutSize;
    /** 外包装材质 */
    private String pkgOutTexture;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdPkgStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getPkgStdId() {
        return pkgStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param pkgStdId 主键
     */
    public void setPkgStdId(Long pkgStdId) {
        this.pkgStdId = pkgStdId;
    }
    /**
     * <p>单品ID</p>
     *
     * @return 单品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * <p>单品ID</p>
     *
     * @param itemId 单品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    /**
     * <p>内包装净重</p>
     *
     * @return 内包装净重
     */
    public java.math.BigDecimal getPkgInSuttle() {
        return pkgInSuttle;
    }

    /**
     * <p>内包装净重</p>
     *
     * @param pkgInSuttle 内包装净重
     */
    public void setPkgInSuttle(java.math.BigDecimal pkgInSuttle) {
        this.pkgInSuttle = pkgInSuttle;
    }
    /**
     * <p>内包装净重误差范围</p>
     *
     * @return 内包装净重误差范围
     */
    public String getPkgInError() {
        return pkgInError;
    }

    /**
     * <p>内包装净重误差范围</p>
     *
     * @param pkgInError 内包装净重误差范围
     */
    public void setPkgInError(String pkgInError) {
        this.pkgInError = pkgInError;
    }
    /**
     * <p>内包装净重/个数</p>
     *
     * @return 内包装净重/个数
     */
    public String getPkgInNumber() {
        return pkgInNumber;
    }

    /**
     * <p>内包装净重/个数</p>
     *
     * @param pkgInNumber 内包装净重/个数
     */
    public void setPkgInNumber(String pkgInNumber) {
        this.pkgInNumber = pkgInNumber;
    }
    /**
     * <p>内包装外径</p>
     *
     * @return 内包装外径
     */
    public String getPkgInSize() {
        return pkgInSize;
    }

    /**
     * <p>内包装外径</p>
     *
     * @param pkgInSize 内包装外径
     */
    public void setPkgInSize(String pkgInSize) {
        this.pkgInSize = pkgInSize;
    }
    /**
     * <p>内包装材质</p>
     *
     * @return 内包装材质
     */
    public String getPkgInTexture() {
        return pkgInTexture;
    }

    /**
     * <p>内包装材质</p>
     *
     * @param pkgInTexture 内包装材质
     */
    public void setPkgInTexture(String pkgInTexture) {
        this.pkgInTexture = pkgInTexture;
    }
    /**
     * <p>外包装净重误差范围</p>
     *
     * @return 外包装净重误差范围
     */
    public String getPkgOutError() {
        return pkgOutError;
    }

    /**
     * <p>外包装净重误差范围</p>
     *
     * @param pkgOutError 外包装净重误差范围
     */
    public void setPkgOutError(String pkgOutError) {
        this.pkgOutError = pkgOutError;
    }
    /**
     * <p>外包装净重/毛重</p>
     *
     * @return 外包装净重/毛重
     */
    public String getPkgOutNumber() {
        return pkgOutNumber;
    }

    /**
     * <p>外包装净重/毛重</p>
     *
     * @param pkgOutNumber 外包装净重/毛重
     */
    public void setPkgOutNumber(String pkgOutNumber) {
        this.pkgOutNumber = pkgOutNumber;
    }
    /**
     * <p>外包装外径</p>
     *
     * @return 外包装外径
     */
    public String getPkgOutSize() {
        return pkgOutSize;
    }

    /**
     * <p>外包装外径</p>
     *
     * @param pkgOutSize 外包装外径
     */
    public void setPkgOutSize(String pkgOutSize) {
        this.pkgOutSize = pkgOutSize;
    }
    /**
     * <p>外包装材质</p>
     *
     * @return 外包装材质
     */
    public String getPkgOutTexture() {
        return pkgOutTexture;
    }

    /**
     * <p>外包装材质</p>
     *
     * @param pkgOutTexture 外包装材质
     */
    public void setPkgOutTexture(String pkgOutTexture) {
        this.pkgOutTexture = pkgOutTexture;
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
