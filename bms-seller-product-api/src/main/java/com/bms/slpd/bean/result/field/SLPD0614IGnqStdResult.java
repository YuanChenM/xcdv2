package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

public class SLPD0614IGnqStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "主键")
    private Long gnqStdId;
    @ApiModelProperty(value = "通用指标类型ID")
    private String gnqStdType;
    @ApiModelProperty(value = "合格值")
    private String gnqOkVal;
    @ApiModelProperty(value = "不合格值")
    private String gnqNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "通用指标类型名称")
    private String gnqStdTypeStr;
    @ApiModelProperty(value = "父类型")
    private String parentType;
    @ApiModelProperty(value = "父类型名称")
    private String parentTypeStr;

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

    public String getGnqStdTypeStr() {
        return gnqStdTypeStr;
    }

    public void setGnqStdTypeStr(String gnqStdTypeStr) {
        this.gnqStdTypeStr = gnqStdTypeStr;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentTypeStr() {
        return parentTypeStr;
    }

    public void setParentTypeStr(String parentTypeStr) {
        this.parentTypeStr = parentTypeStr;
    }
}