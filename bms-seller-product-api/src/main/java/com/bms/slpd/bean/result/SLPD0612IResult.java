package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0612IResult",description = "修改加工质量标准接口出参")
public class SLPD0612IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "更新数量")
    private int count;
    @ApiModelProperty(value = "加工技术标准指标表ID列表")
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
