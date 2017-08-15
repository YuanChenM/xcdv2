package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0703IResult",
        description = "修改单品品牌(规格)生产商接口出参")
public class SLPD0703IResult implements Serializable {

    @ApiModelProperty(value = "提示信息")
    private String[] messages;
    @ApiModelProperty(value = "更新数量")
    private Integer count;
    @ApiModelProperty(value = "更新单品品牌(规格)生产商Id列表")
    private List<Long> producerProductIds;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getProducerProductIds() {
        return producerProductIds;
    }

    public void setProducerProductIds(List<Long> producerProductIds) {
        this.producerProductIds = producerProductIds;
    }

}
