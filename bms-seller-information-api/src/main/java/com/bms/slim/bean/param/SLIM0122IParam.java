package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0122SellerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0122IParam", description = "新增卖家角色接口入参")
public class SLIM0122IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家角色集合")
    private List<SLIM0122SellerParam> sellerParams;

    public List<SLIM0122SellerParam> getSellerParams() {
        return sellerParams;
    }

    public void setSellerParams(List<SLIM0122SellerParam> sellerParams) {
        this.sellerParams = sellerParams;
    }
}
