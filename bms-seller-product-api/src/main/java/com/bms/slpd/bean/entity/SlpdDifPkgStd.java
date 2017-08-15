/*
 * 2017/04/19 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_dif_pkg_std对应的实体SlpdDifPkgStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifPkgStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long pkgDifStdId;
    /** 单品ID */
    private Long itemId;
    /** 产品ID */
    private String productId;
    /** 内包装净重差异值 */
    private String pkgDifInSuttle;
    /** 内包装净重误差范围差异值 */
    private String pkgDifInError;
    /** 内包装净重/个数差异值 */
    private String pkgDifInNumber;
    /** 内包装外径差异值 */
    private String pkgDifInSize;
    /** 内包装材质差异值 */
    private String pkgDifInTexture;
    /** 外包装净重误差范围差异值 */
    private String pkgDifOutError;
    /** 外包装净重/毛重差异值 */
    private String pkgDifOutNumber;
    /** 外包装外径差异值 */
    private String pkgDifOutSize;
    /** 外包装材质差异值 */
    private String pkgDifOutTexture;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifPkgStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getPkgDifStdId() {
        return pkgDifStdId;
    }

    /**
     * <p>主键</p>
     *
     * @param pkgDifStdId 主键
     */
    public void setPkgDifStdId(Long pkgDifStdId) {
        this.pkgDifStdId = pkgDifStdId;
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
     * <p>内包装净重差异值</p>
     *
     * @return 内包装净重差异值
     */
    public String getPkgDifInSuttle() {
        return pkgDifInSuttle;
    }

    /**
     * <p>内包装净重差异值</p>
     *
     * @param pkgDifInSuttle 内包装净重差异值
     */
    public void setPkgDifInSuttle(String pkgDifInSuttle) {
        this.pkgDifInSuttle = pkgDifInSuttle;
    }
    /**
     * <p>内包装净重误差范围差异值</p>
     *
     * @return 内包装净重误差范围差异值
     */
    public String getPkgDifInError() {
        return pkgDifInError;
    }

    /**
     * <p>内包装净重误差范围差异值</p>
     *
     * @param pkgDifInError 内包装净重误差范围差异值
     */
    public void setPkgDifInError(String pkgDifInError) {
        this.pkgDifInError = pkgDifInError;
    }
    /**
     * <p>内包装净重/个数差异值</p>
     *
     * @return 内包装净重/个数差异值
     */
    public String getPkgDifInNumber() {
        return pkgDifInNumber;
    }

    /**
     * <p>内包装净重/个数差异值</p>
     *
     * @param pkgDifInNumber 内包装净重/个数差异值
     */
    public void setPkgDifInNumber(String pkgDifInNumber) {
        this.pkgDifInNumber = pkgDifInNumber;
    }
    /**
     * <p>内包装外径差异值</p>
     *
     * @return 内包装外径差异值
     */
    public String getPkgDifInSize() {
        return pkgDifInSize;
    }

    /**
     * <p>内包装外径差异值</p>
     *
     * @param pkgDifInSize 内包装外径差异值
     */
    public void setPkgDifInSize(String pkgDifInSize) {
        this.pkgDifInSize = pkgDifInSize;
    }
    /**
     * <p>内包装材质差异值</p>
     *
     * @return 内包装材质差异值
     */
    public String getPkgDifInTexture() {
        return pkgDifInTexture;
    }

    /**
     * <p>内包装材质差异值</p>
     *
     * @param pkgDifInTexture 内包装材质差异值
     */
    public void setPkgDifInTexture(String pkgDifInTexture) {
        this.pkgDifInTexture = pkgDifInTexture;
    }
    /**
     * <p>外包装净重误差范围差异值</p>
     *
     * @return 外包装净重误差范围差异值
     */
    public String getPkgDifOutError() {
        return pkgDifOutError;
    }

    /**
     * <p>外包装净重误差范围差异值</p>
     *
     * @param pkgDifOutError 外包装净重误差范围差异值
     */
    public void setPkgDifOutError(String pkgDifOutError) {
        this.pkgDifOutError = pkgDifOutError;
    }
    /**
     * <p>外包装净重/毛重差异值</p>
     *
     * @return 外包装净重/毛重差异值
     */
    public String getPkgDifOutNumber() {
        return pkgDifOutNumber;
    }

    /**
     * <p>外包装净重/毛重差异值</p>
     *
     * @param pkgDifOutNumber 外包装净重/毛重差异值
     */
    public void setPkgDifOutNumber(String pkgDifOutNumber) {
        this.pkgDifOutNumber = pkgDifOutNumber;
    }
    /**
     * <p>外包装外径差异值</p>
     *
     * @return 外包装外径差异值
     */
    public String getPkgDifOutSize() {
        return pkgDifOutSize;
    }

    /**
     * <p>外包装外径差异值</p>
     *
     * @param pkgDifOutSize 外包装外径差异值
     */
    public void setPkgDifOutSize(String pkgDifOutSize) {
        this.pkgDifOutSize = pkgDifOutSize;
    }
    /**
     * <p>外包装材质差异值</p>
     *
     * @return 外包装材质差异值
     */
    public String getPkgDifOutTexture() {
        return pkgDifOutTexture;
    }

    /**
     * <p>外包装材质差异值</p>
     *
     * @param pkgDifOutTexture 外包装材质差异值
     */
    public void setPkgDifOutTexture(String pkgDifOutTexture) {
        this.pkgDifOutTexture = pkgDifOutTexture;
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
