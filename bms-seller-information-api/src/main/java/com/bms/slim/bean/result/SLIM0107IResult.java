package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0107IResult", description = "新增卖家经营团队接口出参")
public class SLIM0107IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增卖家经营团队数量")
    private Integer count;
    @ApiModelProperty(value = "新增卖家经营团队ID结果集")
    private List<Long> smtIds;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getSmtIds() {
        return smtIds;
    }

    public void setSmtIds(List<Long> smtIds) {
        this.smtIds = smtIds;
    }
}
