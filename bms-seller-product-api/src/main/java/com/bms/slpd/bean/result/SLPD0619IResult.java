package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0619IResult",
        description = "新增储存运输标准指标接口出参")
public class SLPD0619IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "储存运输标准指标ID列表")
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
