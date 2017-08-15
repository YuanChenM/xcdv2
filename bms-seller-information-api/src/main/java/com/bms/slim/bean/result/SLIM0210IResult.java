package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0210IResult", description = "新增生产商生产资质-清真食品生产经营许可证接口出参")
public class SLIM0210IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增生产商生产资质-清真食品生产经营许可证数量")
    private Integer count;
    @ApiModelProperty(value = "新增生产商生产资质-清真食品生产经营许可证ID结果集")
    private List<Long> hfpolIds;

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

    public List<Long> getHfpolIds() {
        return hfpolIds;
    }

    public void setHfpolIds(List<Long> hfpolIds) {
        this.hfpolIds = hfpolIds;
    }
}
