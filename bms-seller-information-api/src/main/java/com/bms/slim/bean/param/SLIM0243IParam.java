package com.bms.slim.bean.param;

import com.bms.slim.bean.entity.SlimSellerProducer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0243IParam", description = "新增卖家生产商关联接口入参")
public class SLIM0243IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "卖家生产商关联集合")
    private List<SlimSellerProducer> sellerProducers;

    public List<SlimSellerProducer> getSellerProducers() {
        return sellerProducers;
    }

    public void setSellerProducers(List<SlimSellerProducer> sellerProducers) {
        this.sellerProducers = sellerProducers;
    }
}
