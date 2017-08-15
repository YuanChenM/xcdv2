package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD1201ILgcsAreaProduct", description = "物流区产品")
public class SLPD1201ILgcsAreaProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流区Id")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "产品Id")
    private String productId;
    @ApiModelProperty(value = "产品需求等级")
    private String productDemandGrade;

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDemandGrade() {
        return productDemandGrade;
    }

    public void setProductDemandGrade(String productDemandGrade) {
        this.productDemandGrade = productDemandGrade;
    }
}
