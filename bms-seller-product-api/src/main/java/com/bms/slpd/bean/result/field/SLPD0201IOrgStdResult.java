package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0201IOrgStdResult", description = "原种种源标准指标")
public class SLPD0201IOrgStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "原种种源标准指标ID")
    private Long orgStdId;
    @ApiModelProperty(value = "原种种源标准指标类型")
    private String orgStdType;
    @ApiModelProperty(value = "原种种源标准指标类型")
    private String orgStdTypeStr;
    @ApiModelProperty(value = "优良值")
    private String orgGoodVal;
    @ApiModelProperty(value = "一般值")
    private String orgNormalVal;
    @ApiModelProperty(value = "合格")
    private String orgOkVal;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getOrgStdId() {
        return orgStdId;
    }

    public void setOrgStdId(Long orgStdId) {
        this.orgStdId = orgStdId;
    }

    public String getOrgStdType() {
        return orgStdType;
    }

    public void setOrgStdType(String orgStdType) {
        this.orgStdType = orgStdType;
    }

    public String getOrgStdTypeStr() {
        return orgStdTypeStr;
    }

    public void setOrgStdTypeStr(String orgStdTypeStr) {
        this.orgStdTypeStr = orgStdTypeStr;
    }

    public String getOrgGoodVal() {
        return orgGoodVal;
    }

    public void setOrgGoodVal(String orgGoodVal) {
        this.orgGoodVal = orgGoodVal;
    }

    public String getOrgNormalVal() {
        return orgNormalVal;
    }

    public void setOrgNormalVal(String orgNormalVal) {
        this.orgNormalVal = orgNormalVal;
    }

    public String getOrgOkVal() {
        return orgOkVal;
    }

    public void setOrgOkVal(String orgOkVal) {
        this.orgOkVal = orgOkVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
