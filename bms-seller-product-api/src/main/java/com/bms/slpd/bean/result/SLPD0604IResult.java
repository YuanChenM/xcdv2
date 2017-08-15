package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0604IResult",description = "新增饲养指标标准接口出参")
public class SLPD0604IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增饲养指标标准Id列表")
    private List<Long> fedStdIds;
    @ApiModelProperty(value = "新增饲养指标标准数量")
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
