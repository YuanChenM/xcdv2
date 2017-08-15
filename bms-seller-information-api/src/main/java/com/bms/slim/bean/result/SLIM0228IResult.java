package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0228IResult", description = "新增生产商车间接口出参")
public class SLIM0228IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增生产商车间数量")
    private Integer count;
    @ApiModelProperty(value = "新增生产商车间ID结果集")
    private List<Long> workshopIds;

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

    public List<Long> getWorkshopIds() {
        return workshopIds;
    }

    public void setWorkshopIds(List<Long> workshopIds) {
        this.workshopIds = workshopIds;
    }
}
