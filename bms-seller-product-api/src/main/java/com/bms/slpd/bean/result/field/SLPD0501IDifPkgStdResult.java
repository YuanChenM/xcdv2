package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0501IDifPkgStdResult", description = "包装标准指标差异")
public class SLPD0501IDifPkgStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "包装标准指标ID")
    private Long pkgDifStdId;
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

    public Long getPkgDifStdId() {
        return pkgDifStdId;
    }

    public void setPkgDifStdId(Long pkgDifStdId) {
        this.pkgDifStdId = pkgDifStdId;
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
}
