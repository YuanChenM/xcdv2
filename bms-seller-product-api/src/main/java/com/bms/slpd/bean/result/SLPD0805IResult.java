package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0805ICommodityResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0805IResult", description = "批量查询商品清单API的出参")
public class SLPD0805IResult extends BaseRestPaginationResult<SLPD0805ICommodityResult> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示信息")
    private String[] messages;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}
