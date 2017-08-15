package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0224ProducerHonorCertificateParam implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "荣誉证书ID")
    private Long honorCertId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "发证机关")
    private String issueAuthority;
    @ApiModelProperty(value = "发证日期")
    private Date issueDate;
    @ApiModelProperty(value = "荣誉证书")
    private String honorCertUrl;
    @ApiModelProperty(value = "版本")
    private Integer version;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public Long getHonorCertId() {
        return honorCertId;
    }

    public void setHonorCertId(Long honorCertId) {
        this.honorCertId = honorCertId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getIssueAuthority() {
        return issueAuthority;
    }

    public void setIssueAuthority(String issueAuthority) {
        this.issueAuthority = issueAuthority;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getHonorCertUrl() {
        return honorCertUrl;
    }

    public void setHonorCertUrl(String honorCertUrl) {
        this.honorCertUrl = honorCertUrl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
