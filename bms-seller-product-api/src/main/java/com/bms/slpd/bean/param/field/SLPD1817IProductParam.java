package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLPD1817IProductParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
