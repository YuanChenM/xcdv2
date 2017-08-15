package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0504IResult",
        description = "新增单品规格接口出参")
public class SLPD0504IResult implements Serializable {

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "插入条数")
    private Integer count;
    @ApiModelProperty(value = "单品规格ID列表")
    private List<Long> itemPropertyIds;

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

    public List<Long> getItemPropertyIds() {
        return itemPropertyIds;
    }

    public void setItemPropertyIds(List<Long> itemPropertyIds) {
        this.itemPropertyIds = itemPropertyIds;
    }
}
