package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0636IResult",
        description = "修改加工质量标准指标差异接口出参")
public class SLPD0636IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "更新数量")
    private Integer count;
    @ApiModelProperty(value = "更新加工质量标准指标差异Id列表")
    private List<Long> tncDifStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getTncDifStdIds() {
        return tncDifStdIds;
    }

    public void setTncDifStdIds(List<Long> tncDifStdIds) {
        this.tncDifStdIds = tncDifStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
