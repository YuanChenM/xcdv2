package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0248SellerRoleResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0248IResult", description = "查询卖方单位角色接口出参")
public class SLIM0248IResult extends BaseRestPaginationResult<SLIM0248SellerRoleResult> {
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
