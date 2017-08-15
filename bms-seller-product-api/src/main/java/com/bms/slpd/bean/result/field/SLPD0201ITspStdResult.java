package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0201ITspStdResult", description = "存储运输标准指标")
public class SLPD0201ITspStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "存储运输标准指标ID")
    private Long tspStdId;
    @ApiModelProperty(value = "存储运输标准指标类型")
    private String tspStdType;
    @ApiModelProperty(value = "存储运输标准指标类型")
    private String tspStdTypeStr;
    @ApiModelProperty(value = "合格值")
    private String tspOkVal;
    @ApiModelProperty(value = "不合格值")
    private String tspNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;

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
}
