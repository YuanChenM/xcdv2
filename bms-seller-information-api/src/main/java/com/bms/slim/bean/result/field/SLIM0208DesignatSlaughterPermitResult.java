package com.bms.slim.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0208DesignatSlaughterPermitResult implements Serializable {
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
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
