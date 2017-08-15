package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0501IDifMctStdResult", description = "加工技术标准指标差异")
public class SLPD0501IDifMctStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "加工技术标准指标ID")
    private Long mctDifStdId;
    @ApiModelProperty(value = "加工技术标准指标类型")
    private String mctStdType;
    @ApiModelProperty(value = "加工技术标准指标类型")
    private String mctStdTypeStr;
    @ApiModelProperty(value = "合格差异值")
    private String mctOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String mctNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getMctDifStdId() {
        return mctDifStdId;
    }

    public void setMctDifStdId(Long mctDifStdId) {
        this.mctDifStdId = mctDifStdId;
    }

    public String getMctStdType() {
        return mctStdType;
    }

    public void setMctStdType(String mctStdType) {
        this.mctStdType = mctStdType;
    }

    public String getMctStdTypeStr() {
        return mctStdTypeStr;
    }

    public void setMctStdTypeStr(String mctStdTypeStr) {
        this.mctStdTypeStr = mctStdTypeStr;
    }

    public String getMctOkDifVal() {
        return mctOkDifVal;
    }

    public void setMctOkDifVal(String mctOkDifVal) {
        this.mctOkDifVal = mctOkDifVal;
    }

    public String getMctNgDifVal() {
        return mctNgDifVal;
    }

    public void setMctNgDifVal(String mctNgDifVal) {
        this.mctNgDifVal = mctNgDifVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
