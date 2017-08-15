package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SlpdDifGnqStdResult",description = "通用质量标准档案卡")
public class SLPD0614IDifGnqStdResult extends SLPDFileCardResult {
    @ApiModelProperty(value = "通用质量标准ID")
    private Long gnqDifStdId;
    @ApiModelProperty(value = "通用质量类型ID")
    private String gnqStdType;
    @ApiModelProperty(value = "合格差异值")
    private String gnqOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String gnqNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "通用指标类型名称")
    private String gnqStdTypeStr;
    @ApiModelProperty(value = "父类型")
    private String parentType;
    @ApiModelProperty(value = "父类型名称")
    private String parentTypeStr;


    public Long getGnqDifStdId() {
        return gnqDifStdId;
    }

    public void setGnqDifStdId(Long gnqDifStdId) {
        this.gnqDifStdId = gnqDifStdId;
    }

    public String getGnqStdType() {
        return gnqStdType;
    }

    public void setGnqStdType(String gnqStdType) {
        this.gnqStdType = gnqStdType;
    }

    public String getGnqOkDifVal() {
        return gnqOkDifVal;
    }

    public void setGnqOkDifVal(String gnqOkDifVal) {
        this.gnqOkDifVal = gnqOkDifVal;
    }

    public String getGnqNgDifVal() {
        return gnqNgDifVal;
    }

    public void setGnqNgDifVal(String gnqNgDifVal) {
        this.gnqNgDifVal = gnqNgDifVal;
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
