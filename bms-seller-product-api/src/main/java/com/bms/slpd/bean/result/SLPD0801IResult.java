package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0801IResult",
        description = "新增(卖家)单品品牌(规格)生产商接口出参")
public class SLPD0801IResult implements Serializable {

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "卖家单品品牌生产商ID列表")
    private List<Long> sellerCommodityIds;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getSellerCommodityIds() {
        return sellerCommodityIds;
    }

    public void setSellerCommodityIds(List<Long> sellerCommodityIds) {
        this.sellerCommodityIds = sellerCommodityIds;
    }
}
