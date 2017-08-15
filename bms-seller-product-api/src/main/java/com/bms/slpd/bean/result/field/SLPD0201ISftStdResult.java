package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0201ISftStdResult", description = "安全标准指标")
public class SLPD0201ISftStdResult extends SLPDFileCardResult {

    @ApiModelProperty(value = "安全标准指标类型ID")
    private Long sftStdId;
    @ApiModelProperty(value = "安全标准指标类型")
    private String sftStdType;
    @ApiModelProperty(value = "安全标准指标类型")
    private String sftStdTypeStr;
    @ApiModelProperty(value = "合格值")
    private String sftOkVal;
    @ApiModelProperty(value = "不合格值")
    private String sftNgVal;
    @ApiModelProperty(value = "备注")
    private String remark;

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

    public String getSftStdTypeStr() {
        return sftStdTypeStr;
    }

    public void setSftStdTypeStr(String sftStdTypeStr) {
        this.sftStdTypeStr = sftStdTypeStr;
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
}
