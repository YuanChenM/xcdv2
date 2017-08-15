package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD1817IProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1817IParam",
        description = "修改产品接口入参")
public class SLPD1817IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "产品集合")
    private List<SLPD1817IProductParam> productParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLPD1817IProductParam> getProductParams() {
        return productParams;
    }

    public void setProductParams(List<SLPD1817IProductParam> productParams) {
        this.productParams = productParams;
    }
}
