package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0628IResult",description = "新增饲养标准指标差异接口出参")
public class SLPD0628IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "饲养标准指标差异主键Id列表")
    private List<Long> fedDifStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getFedDifStdIds() {
        return fedDifStdIds;
    }

    public void setFedDifStdIds(List<Long> fedDifStdIds) {
        this.fedDifStdIds = fedDifStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
