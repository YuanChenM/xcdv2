package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0201IFedStdResult", description = "饲养标准指标")
public class SLPD0201IFedStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "饲养标准指标ID")
    private Long fedStdId;
    @ApiModelProperty(value = "饲养标准指标类型")
    private String fedStdType;
    @ApiModelProperty(value = "饲养标准指标类型")
    private String fedStdTypeStr;
    @ApiModelProperty(value = "优良值")
    private String fedGoodVal;
    @ApiModelProperty(value = "一般值")
    private String fedNormalVal;
    @ApiModelProperty(value = "合格值")
    private String fedOkVal;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getFedStdId() {
        return fedStdId;
    }

    public void setFedStdId(Long fedStdId) {
        this.fedStdId = fedStdId;
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

    public String getFedGoodVal() {
        return fedGoodVal;
    }

    public void setFedGoodVal(String fedGoodVal) {
        this.fedGoodVal = fedGoodVal;
    }

    public String getFedNormalVal() {
        return fedNormalVal;
    }

    public void setFedNormalVal(String fedNormalVal) {
        this.fedNormalVal = fedNormalVal;
    }

    public String getFedOkVal() {
        return fedOkVal;
    }

    public void setFedOkVal(String fedOkVal) {
        this.fedOkVal = fedOkVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
