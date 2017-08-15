package com.bms.slim.bean.result;

import com.bms.slim.bean.result.field.SLIM0238ProducerTestEquipmentyResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SLIM0238IResult", description = "查询生产商检测设备接口出参")
public class SLIM0238IResult extends BaseRestPaginationResult<SLIM0238ProducerTestEquipmentyResult> {
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
