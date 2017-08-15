package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

public class SLPD0621IDifTspStdResult extends SLPD0621ITspStdResult {

    @ApiModelProperty(value = "主键")
    private Long tspDifStdId;
    @ApiModelProperty(value = "存储运输类型")
    private String tspStdType;
    @ApiModelProperty("存储运输类型名称")
    private String tspStdTypeStr;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "合格差异值")
    private String tspOkDifVal;
    @ApiModelProperty(value = "不合格差异值")
    private String tspNgDifVal;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "父节点")
    private String parentType;
    @ApiModelProperty(value = "父节点名称")
    private String parentTypeStr;


    public Long getTspDifStdId() {
        return tspDifStdId;
    }

    public void setTspDifStdId(Long tspDifStdId) {
        this.tspDifStdId = tspDifStdId;
    }

    public String getTspStdType() {
        return tspStdType;
    }

    public void setTspStdType(String tspStdType) {
        this.tspStdType = tspStdType;
    }

    public String getTspStdTypeStr() {
        return tspStdTypeStr;
    }

    public void setTspStdTypeStr(String tspStdTypeStr) {
        this.tspStdTypeStr = tspStdTypeStr;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTspOkDifVal() {
        return tspOkDifVal;
    }

    public void setTspOkDifVal(String tspOkDifVal) {
        this.tspOkDifVal = tspOkDifVal;
    }

    public String getTspNgDifVal() {
        return tspNgDifVal;
    }

    public void setTspNgDifVal(String tspNgDifVal) {
        this.tspNgDifVal = tspNgDifVal;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
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
}
