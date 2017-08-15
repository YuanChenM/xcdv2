package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0644IResult",
        description = "修改储存运输标准指标差异接口出参")
public class SLPD0644IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "更新数量")
    private Integer count;
    @ApiModelProperty(value = "更新储存运输标准指标差异Id列表")
    private List<Long> tspDifStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getTspDifStdIds() {
        return tspDifStdIds;
    }

    public void setTspDifStdIds(List<Long> tspDifStdIds) {
        this.tspDifStdIds = tspDifStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
