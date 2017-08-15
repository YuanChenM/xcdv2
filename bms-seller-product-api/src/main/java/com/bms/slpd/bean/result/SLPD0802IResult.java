package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0802ISellerCommodityResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0802IResult", description = "批量查询卖家单品品牌(规格)生产商API的出参")
public class SLPD0802IResult extends BaseRestPaginationResult<SLPD0802ISellerCommodityResult> {
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
