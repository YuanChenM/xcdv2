package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0702IResult", description = "新增单品品牌(规格)生产商接口出参")
public class SLPD0702IResult implements Serializable {
    private static final long serialVersionUID = 5857181584010533655L;

    @ApiModelProperty(value = "新增单品品牌(规格)生产商数量")
    private int count;
    @ApiModelProperty(value = "新增单品品牌(规格)生产商Id列表")
    private List<Long> producerProductIds;

    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getProducerProductIds() {
        return producerProductIds;
    }

    public void setProducerProductIds(List<Long> producerProductIds) {
        this.producerProductIds = producerProductIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
