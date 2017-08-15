package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0203IResult",description = "修改卖家生产商接口出参")
public class SLIM0203IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "修改卖家生产商数量")
    private Integer count;
    @ApiModelProperty(value = "修改卖家生产商ID结果集")
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

    public List<Long> getProducerIds() {
        return producerIds;
    }

    public void setProducerIds(List<Long> producerIds) {
        this.producerIds = producerIds;
    }
}
