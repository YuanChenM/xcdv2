package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0606IResult",
        description = "修改饲养指标标准接口出参")
public class SLPD0606IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改的Id列表")
    private List<Long> fedStdIds;
    @ApiModelProperty(value = "修改数量")
    private Integer count;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public List<Long> getFedStdIds() {
        return fedStdIds;
    }

    public void setFedStdIds(List<Long> fedStdIds) {
        this.fedStdIds = fedStdIds;
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
