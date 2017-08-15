package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.wrapper.SlpdSellerCommodityParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0801IParam",
        description = "新增(卖家)单品品牌(规格)生产商接口入参")
public class SLPD0801IParam implements Serializable {

    @ApiModelProperty(value = "对象列表")
    private List<SlpdSellerCommodityParam> slpdSellerCommodities;

    public List<SlpdSellerCommodityParam> getSlpdSellerCommodities() {
        return slpdSellerCommodities;
    }

    public void setSlpdSellerCommodities(List<SlpdSellerCommodityParam> slpdSellerCommodities) {
        this.slpdSellerCommodities = slpdSellerCommodities;
    }
}
