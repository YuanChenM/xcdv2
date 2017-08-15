package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0501IDifFedStdResult", description = "饲养标准指标差异")
public class SLPD0501IDifFedStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "饲养标准指标ID")
    private Long fedDifStdId;
    @ApiModelProperty(value = "饲养标准指标类型")
    private String fedStdType;
    @ApiModelProperty(value = "饲养标准指标类型")
    private String fedStdTypeStr;
    @ApiModelProperty(value = "优良差异值")
    private String fedGoodDifVal;
    @ApiModelProperty(value = "一般差异值")
    private String fedNormalDifVal;
    @ApiModelProperty(value = "合格差异值")
    private String fedOkDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getFedDifStdId() {
        return fedDifStdId;
    }

    public void setFedDifStdId(Long fedDifStdId) {
        this.fedDifStdId = fedDifStdId;
    }

    public String getFedStdType() {
        return fedStdType;
    }

    public void setFedStdType(String fedStdType) {
        this.fedStdType = fedStdType;
    }

    public String getFedStdTypeStr() {
        return fedStdTypeStr;
    }

    public void setFedStdTypeStr(String fedStdTypeStr) {
        this.fedStdTypeStr = fedStdTypeStr;
    }

    public String getFedGoodDifVal() {
        return fedGoodDifVal;
    }

    public void setFedGoodDifVal(String fedGoodDifVal) {
        this.fedGoodDifVal = fedGoodDifVal;
    }

    public String getFedNormalDifVal() {
        return fedNormalDifVal;
    }

    public void setFedNormalDifVal(String fedNormalDifVal) {
        this.fedNormalDifVal = fedNormalDifVal;
    }

    public String getFedOkDifVal() {
        return fedOkDifVal;
    }

    public void setFedOkDifVal(String fedOkDifVal) {
        this.fedOkDifVal = fedOkDifVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
