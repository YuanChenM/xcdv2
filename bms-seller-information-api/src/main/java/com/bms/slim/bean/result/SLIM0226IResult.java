package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0226ProducerFactoryResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0226IResult", description = "查询生产商工厂接口出参")
public class SLIM0226IResult extends BaseRestPaginationResult<SLIM0226ProducerFactoryResult> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
