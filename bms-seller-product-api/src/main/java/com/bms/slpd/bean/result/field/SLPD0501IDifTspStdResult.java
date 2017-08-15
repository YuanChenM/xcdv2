package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0501IDifTspStdResult", description = "存储运输标准指标差异")
public class SLPD0501IDifTspStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "存储运输标准指标ID")
    private Long tspDifStdId;
    @ApiModelProperty(value = "存储运输标准指标类型")
    private String tspStdType;
    @ApiModelProperty(value = "存储运输标准指标类型")
    private String tspStdTypeStr;
    @ApiModelProperty(value = "合格差异值")
    private String tspOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String tspNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getTspDifStdId() {
        return tspDifStdId;
    }

    public void setTspDifStdId(Long tspDifStdId) {
        this.tspDifStdId = tspDifStdId;
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

    public String getTspOkDifVal() {
        return tspOkDifVal;
    }

    public void setTspOkDifVal(String tspOkDifVal) {
        this.tspOkDifVal = tspOkDifVal;
    }

    public String getTspNgDifVal() {
        return tspNgDifVal;
    }

    public void setTspNgDifVal(String tspNgDifVal) {
        this.tspNgDifVal = tspNgDifVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
