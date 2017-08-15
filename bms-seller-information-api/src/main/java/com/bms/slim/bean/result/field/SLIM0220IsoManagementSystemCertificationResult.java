package com.bms.slim.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0220IsoManagementSystemCertificationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    private Long isoMscId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "类型")
    private String certType;
    @ApiModelProperty(value = "资质证书类型（1：ISO9001  2：ISO22000  3：ISO14001）")
    private String isoType;
    @ApiModelProperty(value = "证书编号")
    private String certNo;
    @ApiModelProperty(value = "认证标准")
    private String certificationStandard;
    @ApiModelProperty(value = "认证范围")
    private String certificationScope;
    @ApiModelProperty(value = "发证日期及有效期")
    private String issueDateValidPeriod;
    @ApiModelProperty(value = "认证机构")
    private String certificationAuthority;
    @ApiModelProperty(value = "认证证书URL")
    private String certUrl;
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

    public Long getIsoMscId() {
        return isoMscId;
    }

    public void setIsoMscId(Long isoMscId) {
        this.isoMscId = isoMscId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getIsoType() {
        return isoType;
    }

    public void setIsoType(String isoType) {
        this.isoType = isoType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertificationStandard() {
        return certificationStandard;
    }

    public void setCertificationStandard(String certificationStandard) {
        this.certificationStandard = certificationStandard;
    }

    public String getCertificationScope() {
        return certificationScope;
    }

    public void setCertificationScope(String certificationScope) {
        this.certificationScope = certificationScope;
    }

    public String getIssueDateValidPeriod() {
        return issueDateValidPeriod;
    }

    public void setIssueDateValidPeriod(String issueDateValidPeriod) {
        this.issueDateValidPeriod = issueDateValidPeriod;
    }

    public String getCertificationAuthority() {
        return certificationAuthority;
    }

    public void setCertificationAuthority(String certificationAuthority) {
        this.certificationAuthority = certificationAuthority;
    }

    public String getCertUrl() {
        return certUrl;
    }

    public void setCertUrl(String certUrl) {
        this.certUrl = certUrl;
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
