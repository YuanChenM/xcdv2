package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD1202ILgcsAreaCommodityResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD1202IResult", description = "批量查询物流区产品接口出参")
public class SLPD1202IResult extends BaseRestPaginationResult<SLPD1202ILgcsAreaCommodityResult> {
    @ApiModelProperty(value = "提示信息")
    private String[] messages;


    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

}
