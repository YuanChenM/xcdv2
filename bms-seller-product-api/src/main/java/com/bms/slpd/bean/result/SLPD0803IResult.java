package com.bms.slpd.bean.result;

import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0803IResult",
        description = "修改(卖家)单品品牌(规格)生产商接口出参")
public class SLPD0803IResult extends BaseRestResult {

    private String[] message;
    @ApiModelProperty(value = "更新条数")
    private int count;
    @ApiModelProperty(value = "卖家单品品牌生产商ID列表")
    private List<Long> sellerCommodityIds;
    @ApiModelProperty(value = "产品ID列表")
    private List<String> productIds;
    @ApiModelProperty(value = "单品品牌生产商ID列表")
    private List<Long> ProducerProductIds;


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

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public List<Long> getProducerProductIds() {
        return ProducerProductIds;
    }

    public void setProducerProductIds(List<Long> producerProductIds) {
        ProducerProductIds = producerProductIds;
    }
    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

}
