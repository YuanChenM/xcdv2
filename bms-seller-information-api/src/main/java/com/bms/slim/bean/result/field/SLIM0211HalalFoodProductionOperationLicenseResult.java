package com.bms.slim.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0211HalalFoodProductionOperationLicenseResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键ID")
    private Long hfpolId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "证书编号")
    private String certNo;
    @ApiModelProperty(value = "商检证书号码")
    private String commInspCertNo;
    @ApiModelProperty(value = "签发日期")
    private Date issueDateBegin;
    @ApiModelProperty(value = "签发截止日期")
    private Date issueDateEnd;
    @ApiModelProperty(value = "签发机构")
    private String issueAuthority;
    @ApiModelProperty(value = "清真食品生产经营许可证URL")
    private String halalFoodProdOptLicUrl;
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

    public Long getHfpolId() {
        return hfpolId;
    }

    public void setHfpolId(Long hfpolId) {
        this.hfpolId = hfpolId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCommInspCertNo() {
        return commInspCertNo;
    }

    public void setCommInspCertNo(String commInspCertNo) {
        this.commInspCertNo = commInspCertNo;
    }

    public Date getIssueDateBegin() {
        return issueDateBegin;
    }

    public void setIssueDateBegin(Date issueDateBegin) {
        this.issueDateBegin = issueDateBegin;
    }

    public Date getIssueDateEnd() {
        return issueDateEnd;
    }

    public void setIssueDateEnd(Date issueDateEnd) {
        this.issueDateEnd = issueDateEnd;
    }

    public String getIssueAuthority() {
        return issueAuthority;
    }

    public void setIssueAuthority(String issueAuthority) {
        this.issueAuthority = issueAuthority;
    }

    public String getHalalFoodProdOptLicUrl() {
        return halalFoodProdOptLicUrl;
    }

    public void setHalalFoodProdOptLicUrl(String halalFoodProdOptLicUrl) {
        this.halalFoodProdOptLicUrl = halalFoodProdOptLicUrl;
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
