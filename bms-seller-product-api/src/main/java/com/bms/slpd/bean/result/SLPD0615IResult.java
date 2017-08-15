package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0615IResult",
        description = "修改通用质量标准卡接口出参")
public class SLPD0615IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改通用质量标准卡Id列表")
    private List<Long> gnqStdIds;
    @ApiModelProperty(value = "修改通用质量标准卡数量")
    private Integer count;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public List<Long> getGnqStdIds() {
        return gnqStdIds;
    }

    public void setGnqStdIds(List<Long> gnqStdIds) {
        this.gnqStdIds = gnqStdIds;
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
