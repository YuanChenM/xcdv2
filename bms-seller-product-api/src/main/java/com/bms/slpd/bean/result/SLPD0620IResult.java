package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0620IResult",
        description = "修改储存运输标准指标接口出参")
public class SLPD0620IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "更新数量")
    private int count;
    @ApiModelProperty(value = "存储运输标准指标表ID")
    private List<Long> tspStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getTspStdIds() {
        return tspStdIds;
    }

    public void setTspStdIds(List<Long> tspStdIds) {
        this.tspStdIds = tspStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
