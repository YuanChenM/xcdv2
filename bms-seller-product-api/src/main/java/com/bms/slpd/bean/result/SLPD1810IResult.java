package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1810IResult", description = "批量新增单品品牌规格代理商接口出参")
public class SLPD1810IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示信息")
    private String[] messages;
    @ApiModelProperty(value = "成功条数")
    private int count;
    @ApiModelProperty(value = "新增单品品牌规格代理商Id集合")
    private List<Long> asProductIds;

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

    public List<Long> getAsProductIds() {
        return asProductIds;
    }

    public void setAsProductIds(List<Long> asProductIds) {
        this.asProductIds = asProductIds;
    }
}
