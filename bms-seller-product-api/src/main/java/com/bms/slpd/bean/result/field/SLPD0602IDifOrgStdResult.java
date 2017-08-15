package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0602IDifOrgStdResult",description = "原种种源指标标准档案卡")
public class SLPD0602IDifOrgStdResult extends SLPDFileCardResult {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    private Long orgDifStdId;
    @ApiModelProperty(value = "原种种源类型ID")
    private Long orgStdType;
    @ApiModelProperty(value = "原种种源类型名称")
    private String orgStdTypeStr;
    @ApiModelProperty(value = "优良差异值")
    private String orgGoodDifVal;
    @ApiModelProperty(value = "一般差异值")
    private String orgNormalDifVal;
    @ApiModelProperty(value = "合格差异值")
    private String orgOkDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;


    public Long getOrgDifStdId() {
        return orgDifStdId;
    }

    public void setOrgDifStdId(Long orgDifStdId) {
        this.orgDifStdId = orgDifStdId;
    }

    public Long getOrgStdType() {
        return orgStdType;
    }

    public void setOrgStdType(Long orgStdType) {
        this.orgStdType = orgStdType;
    }

    public String getOrgStdTypeStr() {
        return orgStdTypeStr;
    }

    public void setOrgStdTypeStr(String orgStdTypeStr) {
        this.orgStdTypeStr = orgStdTypeStr;
    }

    public String getOrgGoodDifVal() {
        return orgGoodDifVal;
    }

    public void setOrgGoodDifVal(String orgGoodDifVal) {
        this.orgGoodDifVal = orgGoodDifVal;
    }

    public String getOrgNormalDifVal() {
        return orgNormalDifVal;
    }

    public void setOrgNormalDifVal(String orgNormalDifVal) {
        this.orgNormalDifVal = orgNormalDifVal;
    }

    public String getOrgOkDifVal() {
        return orgOkDifVal;
    }

    public void setOrgOkDifVal(String orgOkDifVal) {
        this.orgOkDifVal = orgOkDifVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
