package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "SLIM0211IParam", description = "批量查询生产商生产资质-清真食品生产经营许可证接口入参")
public class SLIM0211IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-清真食品生产经营许可证Id集合")
    private List<Long> hfpolIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    /*@ApiModelProperty(value = "证书编号")
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
    private String halalFoodProdOptLicUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getHfpolIds() {
        return hfpolIds;
    }

    public void setHfpolIds(List<Long> hfpolIds) {
        this.hfpolIds = hfpolIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    /*public String getCertNo() {
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
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
