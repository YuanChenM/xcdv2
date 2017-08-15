package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

public class SLPD0621ITspStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "主键")
    private Long tspStdId;
    @ApiModelProperty(value = "通用指标类型")
    private String tspStdType;
    @ApiModelProperty(value = "通用指标类型名称")
    private String tspStdTypeStr;
    @ApiModelProperty(value = "合格值")
    private String tspOkVal;
    @ApiModelProperty(value = "不合格值")
    private String tspNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "父节点")
    private String parentType;
    @ApiModelProperty(value = "父节点名称")
    private String parentTypeStr;


    public Long getTspStdId() {
        return tspStdId;
    }

    public void setTspStdId(Long tspStdId) {
        this.tspStdId = tspStdId;
    }

    public String getTspStdType() {
        return tspStdType;
    }

    public void setTspStdType(String tspStdType) {
        this.tspStdType = tspStdType;
    }

    public String getTspStdTypeStr() {
        return tspStdTypeStr;
    }

    public void setTspStdTypeStr(String tspStdTypeStr) {
        this.tspStdTypeStr = tspStdTypeStr;
    }

    public String getTspOkVal() {
        return tspOkVal;
    }

    public void setTspOkVal(String tspOkVal) {
        this.tspOkVal = tspOkVal;
    }

    public String getTspNgVal() {
        return tspNgVal;
    }

    public void setTspNgVal(String tspNgVal) {
        this.tspNgVal = tspNgVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
