package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0505IResult",
        description = "修改单品规格接口出参")
public class SLPD0505IResult implements Serializable {

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "修改的Id列表")
    private List<Long> itemPropertyIds;
    @ApiModelProperty(value = "修改数量")
    private Integer count;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public List<Long> getItemPropertyIds() {
        return itemPropertyIds;
    }

    public void setItemPropertyIds(List<Long> itemPropertyIds) {
        this.itemPropertyIds = itemPropertyIds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
