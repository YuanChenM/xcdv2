package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0201IGnqStdResult", description = "通用质量标准指标")
public class SLPD0201IGnqStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "通用质量标准指标ID")
    private Long gnqStdId;
    @ApiModelProperty(value = "通用质量标准指标类型")
    private String gnqStdType;
    @ApiModelProperty(value = "通用质量标准指标类型")
    private String gnqStdTypeStr;
    @ApiModelProperty(value = "合格值")
    private String gnqOkVal;
    @ApiModelProperty(value = "不合格值")
    private String gnqNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getGnqStdId() {
        return gnqStdId;
    }

    public void setGnqStdId(Long gnqStdId) {
        this.gnqStdId = gnqStdId;
    }

    public String getGnqStdType() {
        return gnqStdType;
    }

    public void setGnqStdType(String gnqStdType) {
        this.gnqStdType = gnqStdType;
    }

    public String getGnqStdTypeStr() {
        return gnqStdTypeStr;
    }

    public void setGnqStdTypeStr(String gnqStdTypeStr) {
        this.gnqStdTypeStr = gnqStdTypeStr;
    }

    public String getGnqOkVal() {
        return gnqOkVal;
    }

    public void setGnqOkVal(String gnqOkVal) {
        this.gnqOkVal = gnqOkVal;
    }

    public String getGnqNgVal() {
        return gnqNgVal;
    }

    public void setGnqNgVal(String gnqNgVal) {
        this.gnqNgVal = gnqNgVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}