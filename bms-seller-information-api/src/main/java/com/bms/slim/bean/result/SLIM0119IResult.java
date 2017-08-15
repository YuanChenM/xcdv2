package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0119IResult", description = "新增卖家电商经营团队接口出参")
public class SLIM0119IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增卖家电商经营团队数量")
    private Integer count;
    @ApiModelProperty(value = "新增卖家电商经营团队ID结果集")
    private List<Long> sbtIds;

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

    public List<Long> getSbtIds() {
        return sbtIds;
    }

    public void setSbtIds(List<Long> sbtIds) {
        this.sbtIds = sbtIds;
    }
}
