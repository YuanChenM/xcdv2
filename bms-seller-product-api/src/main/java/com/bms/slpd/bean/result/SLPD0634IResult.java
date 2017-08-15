package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0634IResult",
        description = "新增加工质量标准指标差异接口出参")
public class SLPD0634IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增数量")
    private Integer count;
    @ApiModelProperty(value = "新增加工质量标准指标差异Id列表")
    private List<Long> tncDifStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;


    public List<Long> getTncDifStdIds() {
        return tncDifStdIds;
    }

    public void setTncDifStdIds(List<Long> tncDifStdIds) {
        this.tncDifStdIds = tncDifStdIds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
