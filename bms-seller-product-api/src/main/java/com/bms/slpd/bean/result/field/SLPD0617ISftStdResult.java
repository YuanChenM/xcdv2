package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

public class SLPD0617ISftStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "主键Id")
    private Long sftStdId;
    @ApiModelProperty(value = "安全指标类型")
    private String sftStdType;
    @ApiModelProperty(value = "合格值")
    private String sftOkVal;
    @ApiModelProperty(value = "不合格值")
    private String sftNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "父节点")
    private String parentType;
    @ApiModelProperty(value = "父节点名称")
    private String parentTypeStr;
    @ApiModelProperty(value = "安全指标类型名称")
    private String sftStdTypeStr;

    public Long getSftStdId() {
        return sftStdId;
    }

    public void setSftStdId(Long sftStdId) {
        this.sftStdId = sftStdId;
    }

    public String getSftStdType() {
        return sftStdType;
    }

    public void setSftStdType(String sftStdType) {
        this.sftStdType = sftStdType;
    }

    public String getSftOkVal() {
        return sftOkVal;
    }

    public void setSftOkVal(String sftOkVal) {
        this.sftOkVal = sftOkVal;
    }

    public String getSftNgVal() {
        return sftNgVal;
    }

    public void setSftNgVal(String sftNgVal) {
        this.sftNgVal = sftNgVal;
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

    public String getSftStdTypeStr() {
        return sftStdTypeStr;
    }

    public void setSftStdTypeStr(String sftStdTypeStr) {
        this.sftStdTypeStr = sftStdTypeStr;
    }
}
