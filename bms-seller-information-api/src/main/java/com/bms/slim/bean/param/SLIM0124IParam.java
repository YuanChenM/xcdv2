package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0124SellerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0124IParam", description = "批量修改卖家角色API的入参")
public class SLIM0124IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "卖家角色参数集合")
    private List<SLIM0124SellerParam> sellerParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0124SellerParam> getSellerParams() {
        return sellerParams;
    }

    public void setSellerParams(List<SLIM0124SellerParam> sellerParams) {
        this.sellerParams = sellerParams;
    }
}
