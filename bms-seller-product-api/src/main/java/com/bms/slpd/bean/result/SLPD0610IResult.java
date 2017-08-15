package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0610IResult",
        description = "新增加工质量标准接口出参")
public class SLPD0610IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "加工质量标准指标表ID列表")
    private List<Long> tncStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getTncStdIds() {
        return tncStdIds;
    }

    public void setTncStdIds(List<Long> tncStdIds) {
        this.tncStdIds = tncStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
