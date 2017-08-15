package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0245IContactResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0245IResult", description = "批量查询卖家合同信息准入API的返回对象")
public class SLIM0245IResult extends BaseRestPaginationResult<SLIM0245IContactResult> {

    @ApiModelProperty(value = "提示信息")
    private String[] messages;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}
