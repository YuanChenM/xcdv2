package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0204IResult", description = "新增生产商生产资质-动物防疫条件合格证接口出参")
public class SLIM0204IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增生产商生产资质-动物防疫条件合格证数量")
    private Integer count;
    @ApiModelProperty(value = "新增生产商生产资质-动物防疫条件合格证ID结果集")
    private List<Long> aepccIds;

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

    public List<Long> getAepccIds() {
        return aepccIds;
    }

    public void setAepccIds(List<Long> aepccIds) {
        this.aepccIds = aepccIds;
    }

}
