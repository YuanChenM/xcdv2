package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0639IResult",
        description = "修改通用质量标准指标差异接口出参")
public class SLPD0639IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "更新数量")
    private int count;
    @ApiModelProperty(value = "通用质量标准指标差异ID列表")
    private List<Long> gnqDifStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getGnqDifStdIds() {
        return gnqDifStdIds;
    }

    public void setGnqDifStdIds(List<Long> gnqDifStdIds) {
        this.gnqDifStdIds = gnqDifStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
