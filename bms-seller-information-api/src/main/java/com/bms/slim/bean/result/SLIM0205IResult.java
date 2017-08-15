package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0205AnimalEpidemicPreventionConditionCertificateResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0205IResult", description = "查询生产商生产资质-动物防疫条件合格证接口出参")
public class SLIM0205IResult extends BaseRestPaginationResult<SLIM0205AnimalEpidemicPreventionConditionCertificateResult> {
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
