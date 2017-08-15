package com.bms.slim.bean.result;

import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;

/**
 * Created by wang_haichun on 2017/1/12.
 */
@ApiModel(value = "SLIM0302IResult",
        description = "查询卖家品牌接口出参")
public class SLIM0302IResult extends BaseRestPaginationResult {

    private String[] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
