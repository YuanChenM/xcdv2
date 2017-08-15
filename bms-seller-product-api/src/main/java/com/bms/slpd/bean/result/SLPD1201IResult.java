package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1201IResult", description = "批量新增物流区产品接口出参")
public class SLPD1201IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示信息")
    private String[] messages;
    @ApiModelProperty(value = "成功条数")
    private int count;
    @ApiModelProperty(value = "新增物流区产品Id集合")
    private List<Long> lacIds;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getLacIds() {
        return lacIds;
    }

    public void setLacIds(List<Long> lacIds) {
        this.lacIds = lacIds;
    }
}
