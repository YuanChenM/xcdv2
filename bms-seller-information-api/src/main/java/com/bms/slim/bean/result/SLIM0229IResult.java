package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0229ProducerWorkShopResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0229IResult", description = "查询卖家经营团队接口出参")
public class SLIM0229IResult extends BaseRestPaginationResult<SLIM0229ProducerWorkShopResult> {
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
