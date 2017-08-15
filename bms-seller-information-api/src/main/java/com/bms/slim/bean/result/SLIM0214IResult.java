package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0214ShBjTjRegistrationResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0214IResult", description = "查询生产商生产资质-进沪(京、津)登记信息接口出参")
public class SLIM0214IResult extends BaseRestPaginationResult<SLIM0214ShBjTjRegistrationResult> {
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
