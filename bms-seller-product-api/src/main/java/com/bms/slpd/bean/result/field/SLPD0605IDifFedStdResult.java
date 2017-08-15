package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0605IDifFedStdResult",description = "饲养指标差异卡")
public class SLPD0605IDifFedStdResult extends SLPDFileCardResult {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 饲养指标ID
     */
    @ApiModelProperty(value = "饲养指标ID")
    private Long fedDifStdId;
    /**
     * 饲养指类型ID
     */
    @ApiModelProperty(value = "饲养指类型ID")
    private Long fedStdType;
    /**
     * 优良差异值
     */
    @ApiModelProperty(value = "优良差异值")
    private String fedGoodDifVal;
    /**
     * 一般差异值
     */
    @ApiModelProperty(value = "一般差异值")
    private String fedNormalDifVal;
    /**
     * 合格差异值
     */
    @ApiModelProperty(value = "合格差异值")
    private String fedOkDifVal;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /*
     * 饲养类型名称
     */
    @ApiModelProperty(value = "饲养类型名称")
    private String fedStdTypeStr;

    public Long getFedDifStdId() {
        return fedDifStdId;
    }

    public void setFedDifStdId(Long fedDifStdId) {
        this.fedDifStdId = fedDifStdId;
    }

    public Long getFedStdType() {
        return fedStdType;
    }

    public void setFedStdType(Long fedStdType) {
        this.fedStdType = fedStdType;
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

    public String getFedStdTypeStr() {
        return fedStdTypeStr;
    }

    public void setFedStdTypeStr(String fedStdTypeStr) {
        this.fedStdTypeStr = fedStdTypeStr;
    }
}
