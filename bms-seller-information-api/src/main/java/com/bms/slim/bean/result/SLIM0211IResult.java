package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0211HalalFoodProductionOperationLicenseResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0211IResult", description = "查询生产商生产资质-清真食品生产经营许可证接口出参")
public class SLIM0211IResult extends BaseRestPaginationResult<SLIM0211HalalFoodProductionOperationLicenseResult> {
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
