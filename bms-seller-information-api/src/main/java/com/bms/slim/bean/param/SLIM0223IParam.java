package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "SLIM0223IParam", description = "批量查询生产商荣誉证书接口入参")
public class SLIM0223IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商荣誉证书Id集合")
    private List<Long> honorCertificateIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    /*@ApiModelProperty(value = "发证机关")
    private String issueAuthority;
    @ApiModelProperty(value = "发证日期")
    private Date issueDate;
    @ApiModelProperty(value = "荣誉证书")
    private String honorCertUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getHonorCertificateIds() {
        return honorCertificateIds;
    }

    public void setHonorCertificateIds(List<Long> honorCertificateIds) {
        this.honorCertificateIds = honorCertificateIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    /*public String getIssueAuthority() {
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
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
