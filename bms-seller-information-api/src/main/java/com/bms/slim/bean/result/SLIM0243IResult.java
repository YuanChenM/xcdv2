package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0243IResult", description = "新增卖家生产商关联接口出参")
public class SLIM0243IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增卖家生产商关联数量")
    private Integer count;
    @ApiModelProperty(value = "新增卖家生产商关联ID结果集")
    private List<Long> sellerProducerIds;
    @ApiModelProperty(value = "关联生产商ID结果集")
    private List<Long> producerIds;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getSellerProducerIds() {
        return sellerProducerIds;
    }

    public void setSellerProducerIds(List<Long> sellerProducerIds) {
        this.sellerProducerIds = sellerProducerIds;
    }

    public List<Long> getProducerIds() {
        return producerIds;
    }

    public void setProducerIds(List<Long> producerIds) {
        this.producerIds = producerIds;
    }
}
