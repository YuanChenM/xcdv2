package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

public class SLPD0605IFedStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "主键ID")
    private Long fedStdId;
    @ApiModelProperty(value = "饲养类型ID")
    private Long fedStdType;
    @ApiModelProperty(value = "优良值")
    private String fedGoodVal;
    @ApiModelProperty(value = "一般值")
    private String fedNormalVal;
    @ApiModelProperty(value = "合格值")
    private String fedOkVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "饲养类型名称")
    private String fedStdTypeStr;

    public Long getFedStdId() {
        return fedStdId;
    }

    public void setFedStdId(Long fedStdId) {
        this.fedStdId = fedStdId;
    }

    public Long getFedStdType() {
        return fedStdType;
    }

    public void setFedStdType(Long fedStdType) {
        this.fedStdType = fedStdType;
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

    public String getFedStdTypeStr() {
        return fedStdTypeStr;
    }

    public void setFedStdTypeStr(String fedStdTypeStr) {
        this.fedStdTypeStr = fedStdTypeStr;
    }
}
