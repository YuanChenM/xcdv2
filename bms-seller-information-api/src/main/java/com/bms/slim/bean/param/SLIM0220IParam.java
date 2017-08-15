package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0220IParam", description = "批量查询生产商生产资质-管理体系认证证书接口入参")
public class SLIM0220IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-管理体系认证证书Id集合")
    private List<Long> isoMscIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    /*@ApiModelProperty(value = "类型")
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
    private String certUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getIsoMscIds() {
        return isoMscIds;
    }

    public void setIsoMscIds(List<Long> isoMscIds) {
        this.isoMscIds = isoMscIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    /*public String getCertType() {
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
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
