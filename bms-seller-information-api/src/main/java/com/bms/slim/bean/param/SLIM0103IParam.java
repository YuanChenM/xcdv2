package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0103IEntitySellerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0103IParam", description = "批量修改卖家API的入参")
public class SLIM0103IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "实体卖家参数集合")
    private List<SLIM0103IEntitySellerParam> entitySellerParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0103IEntitySellerParam> getEntitySellerParams() {
        return entitySellerParams;
    }

    public void setEntitySellerParams(List<SLIM0103IEntitySellerParam> entitySellerParams) {
        this.entitySellerParams = entitySellerParams;
    }
}
