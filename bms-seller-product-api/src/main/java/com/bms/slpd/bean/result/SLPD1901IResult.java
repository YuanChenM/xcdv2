package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.wrapper.SLPD1901INetWeightResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD1901IResult", description = "批量查询净重列表API的出参")
public class SLPD1901IResult extends BaseRestPaginationResult<SLPD1901INetWeightResult> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示消息")
    private String[] messages;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}
