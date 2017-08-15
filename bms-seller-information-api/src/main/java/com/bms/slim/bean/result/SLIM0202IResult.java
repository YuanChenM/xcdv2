package com.bms.slim.bean.result;

import com.bms.slim.bean.result.wrapper.SlimSellerProducerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0202IResult", description = "查询卖家生产商接口出参")
public class SLIM0202IResult extends BaseRestPaginationResult<SlimSellerProducerResult> {
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
