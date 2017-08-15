package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0102IEntitySellerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0102IResult", description = "批量查询卖家API的出参")
public class SLIM0102IResult extends BaseRestPaginationResult<SLIM0102IEntitySellerResult> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示信息")
    private String[] messages;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}
