package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0104ISBQParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0104IParam", description = "新增卖家经营资质API的入参")
public class SLIM0104IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家经营资质参数集合")
    private List<SLIM0104ISBQParam> sbqParams;

    public List<SLIM0104ISBQParam> getSbqParams() {
        return sbqParams;
    }

    public void setSbqParams(List<SLIM0104ISBQParam> sbqParams) {
        this.sbqParams = sbqParams;
    }
}
