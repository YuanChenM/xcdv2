package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0210HalalFoodProductionOperationLicenseParam implements Serializable {
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
}
