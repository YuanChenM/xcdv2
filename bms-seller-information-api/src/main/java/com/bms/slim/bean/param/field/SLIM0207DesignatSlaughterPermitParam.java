package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0207DesignatSlaughterPermitParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long dspId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "批准号")
    private String approvalNo;
    @ApiModelProperty(value = "定点屠宰代码")
    private String dsgtSlgtPrmtCode;
    @ApiModelProperty(value = "定点屠宰许可证URL")
    private String dsgtSlgtPrmtUrl;

    public Long getDspId() {
        return dspId;
    }

    public void setDspId(Long dspId) {
        this.dspId = dspId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getDsgtSlgtPrmtCode() {
        return dsgtSlgtPrmtCode;
    }

    public void setDsgtSlgtPrmtCode(String dsgtSlgtPrmtCode) {
        this.dsgtSlgtPrmtCode = dsgtSlgtPrmtCode;
    }

    public String getDsgtSlgtPrmtUrl() {
        return dsgtSlgtPrmtUrl;
    }

    public void setDsgtSlgtPrmtUrl(String dsgtSlgtPrmtUrl) {
        this.dsgtSlgtPrmtUrl = dsgtSlgtPrmtUrl;
    }
}
