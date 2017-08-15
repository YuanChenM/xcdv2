package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD1816IProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1816IParam",
        description = "新增产品接口入参")
public class SLPD1816IParam implements Serializable {

    @ApiModelProperty(value = "产品列表")
    private List<SLPD1816IProductParam> productParams;

    public List<SLPD1816IProductParam> getProductParams() {
        return productParams;
    }

    public void setProductParams(List<SLPD1816IProductParam> productParams) {
        this.productParams = productParams;
    }
}
