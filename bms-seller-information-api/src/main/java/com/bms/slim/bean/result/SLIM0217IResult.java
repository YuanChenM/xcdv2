package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0217FoodProductionLicenseResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0217IResult", description = "查询生产商生产资质-食品生产许可证接口出参")
public class SLIM0217IResult extends BaseRestPaginationResult<SLIM0217FoodProductionLicenseResult> {
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
