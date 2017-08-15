package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1203ILgcsProductParam", description = "物流区产品")
public class SLPD1203ILgcsProductParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流区产品Id")
    private Long lacId;

    @ApiModelProperty(value = "产品需求等级")
    private String productDemandGrade;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getLacId() {
        return lacId;
    }

    public void setLacId(Long lacId) {
        this.lacId = lacId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getProductDemandGrade() {
        return productDemandGrade;
    }

    public void setProductDemandGrade(String productDemandGrade) {
        this.productDemandGrade = productDemandGrade;
    }
}
