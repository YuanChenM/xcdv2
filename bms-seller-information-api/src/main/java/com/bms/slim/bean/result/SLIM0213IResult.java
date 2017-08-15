package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0213IResult", description = "新增生产商生产资质-进沪(京、津)登记信息接口出参")
public class SLIM0213IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增生产商生产资质-进沪(京、津)登记信息数量")
    private Integer count;
    @ApiModelProperty(value = "新增生产商生产资质-进沪(京、津)登记信息ID结果集")
    private List<Long> sbtRegIds;

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

    public List<Long> getSbtRegIds() {
        return sbtRegIds;
    }

    public void setSbtRegIds(List<Long> sbtRegIds) {
        this.sbtRegIds = sbtRegIds;
    }
}
