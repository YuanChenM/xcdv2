package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.wrapper.SlpdBrandItemResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "SLPD0506IResult",
        description = "查询品牌单品关系接口出参")
public class SLPD0506IResult extends BaseRestPaginationResult<SlpdBrandItemResult> {
    private String[] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
