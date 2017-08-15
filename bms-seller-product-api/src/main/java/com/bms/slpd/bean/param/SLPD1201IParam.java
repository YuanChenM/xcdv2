package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD1201ILgcsAreaProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1201IParam", description = "批量新增物流区产品接口入参")
public class SLPD1201IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流区产品集合")
    private List<SLPD1201ILgcsAreaProduct> lgcsAreaProducts;

    public List<SLPD1201ILgcsAreaProduct> getLgcsAreaCommodities() {
        return lgcsAreaProducts;
    }

    public void setLgcsAreaCommodities(List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodities) {
        this.lgcsAreaProducts = lgcsAreaCommodities;
    }
}
