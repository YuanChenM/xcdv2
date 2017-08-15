package com.bms.slpd.bean.result;


import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.base.web.result.BasePagePagingResult;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "SLPD0405IResult",
        description = "查询品牌所有人接口出参")
public class SLPD0405IResult extends BaseRestPaginationResult {
    private String[] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
