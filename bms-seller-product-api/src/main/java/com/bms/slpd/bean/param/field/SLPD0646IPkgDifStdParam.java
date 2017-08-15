/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *通用指标标准指标差异卡
 * @version 1.0.0
 */
public class SLPD0646IPkgDifStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long pkgDifStdId;
    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "内包装净重差异值")
    private String pkgDifInSuttle;
    @ApiModelProperty(value = "内包装净重误差范围差异值")
    private String pkgDifInError;
    @ApiModelProperty(value = "内包装净重/个数差异值")
    private String pkgDifInNumber;
    @ApiModelProperty(value = "内包装外径差异值")
    private String pkgDifInSize;
    @ApiModelProperty(value = "内包装材质差异值")
    private String pkgDifInTexture;
    @ApiModelProperty(value = "外包装净重误差范围差异值")
    private String pkgDifOutError;
    @ApiModelProperty(value = "外包装净重/毛重差异值")
    private String pkgDifOutNumber;
    @ApiModelProperty(value = "外包装外径差异值")
    private String pkgDifOutSize;
    @ApiModelProperty(value = "外包装材质差异值")
    private String pkgDifOutTexture;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getPkgDifStdId() {
        return pkgDifStdId;
    }

    public void setPkgDifStdId(Long pkgDifStdId) {
        this.pkgDifStdId = pkgDifStdId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPkgDifInSuttle() {
        return pkgDifInSuttle;
    }

    public void setPkgDifInSuttle(String pkgDifInSuttle) {
        this.pkgDifInSuttle = pkgDifInSuttle;
    }

    public String getPkgDifInError() {
        return pkgDifInError;
    }

    public void setPkgDifInError(String pkgDifInError) {
        this.pkgDifInError = pkgDifInError;
    }

    public String getPkgDifInNumber() {
        return pkgDifInNumber;
    }

    public void setPkgDifInNumber(String pkgDifInNumber) {
        this.pkgDifInNumber = pkgDifInNumber;
    }

    public String getPkgDifInSize() {
        return pkgDifInSize;
    }

    public void setPkgDifInSize(String pkgDifInSize) {
        this.pkgDifInSize = pkgDifInSize;
    }

    public String getPkgDifInTexture() {
        return pkgDifInTexture;
    }

    public void setPkgDifInTexture(String pkgDifInTexture) {
        this.pkgDifInTexture = pkgDifInTexture;
    }

    public String getPkgDifOutError() {
        return pkgDifOutError;
    }

    public void setPkgDifOutError(String pkgDifOutError) {
        this.pkgDifOutError = pkgDifOutError;
    }

    public String getPkgDifOutNumber() {
        return pkgDifOutNumber;
    }

    public void setPkgDifOutNumber(String pkgDifOutNumber) {
        this.pkgDifOutNumber = pkgDifOutNumber;
    }

    public String getPkgDifOutSize() {
        return pkgDifOutSize;
    }

    public void setPkgDifOutSize(String pkgDifOutSize) {
        this.pkgDifOutSize = pkgDifOutSize;
    }

    public String getPkgDifOutTexture() {
        return pkgDifOutTexture;
    }

    public void setPkgDifOutTexture(String pkgDifOutTexture) {
        this.pkgDifOutTexture = pkgDifOutTexture;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
