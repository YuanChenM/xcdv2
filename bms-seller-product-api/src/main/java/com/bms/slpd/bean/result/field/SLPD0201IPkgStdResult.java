package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(value = "SLPD0201IPkgStdResult", description = "包装标准指标")
public class SLPD0201IPkgStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "包装标准指标ID")
    private Long pkgStdId;
    @ApiModelProperty(value = "内包装净重")
    private BigDecimal pkgInSuttle;
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

    public Long getPkgStdId() {
        return pkgStdId;
    }

    public void setPkgStdId(Long pkgStdId) {
        this.pkgStdId = pkgStdId;
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
}
