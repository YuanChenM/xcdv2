package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0101IEntitySellerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0101IParam", description = "批量新增卖家实体API的入参")
public class SLIM0101IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实体卖家参数集合")
    private List<SLIM0101IEntitySellerParam> entitySellerParams;

    public List<SLIM0101IEntitySellerParam> getEntitySellerParams() {
        return entitySellerParams;
    }

    public void setEntitySellerParams(List<SLIM0101IEntitySellerParam> entitySellerParams) {
        this.entitySellerParams = entitySellerParams;
    }
}
