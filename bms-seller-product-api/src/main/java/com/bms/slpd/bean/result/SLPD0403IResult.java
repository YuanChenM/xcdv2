package com.bms.slpd.bean.result;


import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "SLPD0403IResult",
        description = "查询品牌接口出参")
public class SLPD0403IResult extends BaseRestPaginationResult<SlpdBrandResult> {
    private String[] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
