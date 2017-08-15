package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0701IProducerProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLPD0701IResult", description = "批量查询单品品牌(规格)生产商API的出参")
public class SLPD0701IResult extends BaseRestPaginationResult<SLPD0701IProducerProductResult> {
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
