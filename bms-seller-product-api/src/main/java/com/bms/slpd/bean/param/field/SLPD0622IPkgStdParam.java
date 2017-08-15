/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *包装指标标准档案卡
 * @version 1.0.0
 */
public class SLPD0622IPkgStdParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "包装主键ID")
    private Long pkgStdId;
    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "内包装净重")
    private java.math.BigDecimal pkgInSuttle;
    @ApiModelProperty(value = "内包装净重误差范围")
    private String pkgInError;
    @ApiModelProperty(value = "内包装净重/个数")
    private String pkgInNumber;
    @ApiModelProperty(value = "内包装外径")
    private String pkgInSize;
    @ApiModelProperty(value = "内包装材质")
    private String pkgInTexture;
    @ApiModelProperty(value = "外包装净重误差范围")
    private String pkgOutError;
    @ApiModelProperty(value = "外包装净重/毛重")
    private String pkgOutNumber;
    @ApiModelProperty(value = "外包装外径")
    private String pkgOutSize;
    @ApiModelProperty(value = "外包装材质")
    private String pkgOutTexture;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;


    public Long getPkgStdId() {
        return pkgStdId;
    }

    public void setPkgStdId(Long pkgStdId) {
        this.pkgStdId = pkgStdId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPkgInSuttle() {
        return pkgInSuttle;
    }

    public void setPkgInSuttle(BigDecimal pkgInSuttle) {
        this.pkgInSuttle = pkgInSuttle;
    }

    public String getPkgInError() {
        return pkgInError;
    }

    public void setPkgInError(String pkgInError) {
        this.pkgInError = pkgInError;
    }

    public String getPkgInNumber() {
        return pkgInNumber;
    }

    public void setPkgInNumber(String pkgInNumber) {
        this.pkgInNumber = pkgInNumber;
    }

    public String getPkgInSize() {
        return pkgInSize;
    }

    public void setPkgInSize(String pkgInSize) {
        this.pkgInSize = pkgInSize;
    }

    public String getPkgInTexture() {
        return pkgInTexture;
    }

    public void setPkgInTexture(String pkgInTexture) {
        this.pkgInTexture = pkgInTexture;
    }

    public String getPkgOutError() {
        return pkgOutError;
    }

    public void setPkgOutError(String pkgOutError) {
        this.pkgOutError = pkgOutError;
    }

    public String getPkgOutNumber() {
        return pkgOutNumber;
    }

    public void setPkgOutNumber(String pkgOutNumber) {
        this.pkgOutNumber = pkgOutNumber;
    }

    public String getPkgOutSize() {
        return pkgOutSize;
    }

    public void setPkgOutSize(String pkgOutSize) {
        this.pkgOutSize = pkgOutSize;
    }

    public String getPkgOutTexture() {
        return pkgOutTexture;
    }

    public void setPkgOutTexture(String pkgOutTexture) {
        this.pkgOutTexture = pkgOutTexture;
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
