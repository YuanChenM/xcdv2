package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0117ISellerContractPermissionResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0117IResult", description = "批量查询卖家合同信息准入API的返回对象")
public class SLIM0117IResult extends BaseRestPaginationResult<SLIM0117ISellerContractPermissionResult> {

    @ApiModelProperty(value = "提示信息")
    private String[] messages;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}
