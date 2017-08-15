package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0206AnimalEpidemicPreventionConditionCertificateParam implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键ID")
    private Long aepccId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "证号")
    private String certNo;
    @ApiModelProperty(value = "有效期")
    private String validPeriod;
    @ApiModelProperty(value = "动物防疫条件合格证URL")
    private String aniEpiPrevContCertUrl;
    @ApiModelProperty(value = "版本")
    private Integer version;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public Long getAepccId() {
        return aepccId;
    }

    public void setAepccId(Long aepccId) {
        this.aepccId = aepccId;
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

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getAniEpiPrevContCertUrl() {
        return aniEpiPrevContCertUrl;
    }

    public void setAniEpiPrevContCertUrl(String aniEpiPrevContCertUrl) {
        this.aniEpiPrevContCertUrl = aniEpiPrevContCertUrl;
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
