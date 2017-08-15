package com.bms.slim.bean.result;

import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0240IResult", description = "查询平台生产商接口出参")
public class SLIM0240IResult extends BaseRestPaginationResult<SlimProducerResult> {
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
