package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0112IResult",description = "修改卖家代理商供应资质接口出参")
public class SLIM0112IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "修改卖家代理商供应资质数量")
    private Integer count;
    @ApiModelProperty(value = "修改卖家代理商供应资质ID结果集")
    private List<Long> asqIds;

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

    public List<Long> getAsqIds() {
        return asqIds;
    }

    public void setAsqIds(List<Long> asqIds) {
        this.asqIds = asqIds;
    }
}
