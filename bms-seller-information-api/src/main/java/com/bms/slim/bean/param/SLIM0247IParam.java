package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0247SellerRoleParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0247IParam", description = "新增卖方单位角色接口入参")
public class SLIM0247IParam implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @ApiModelProperty(value = "卖方单位角色集合")
    private List<SLIM0247SellerRoleParam> sellerRoles;

    public List<SLIM0247SellerRoleParam> getSellerRoles() {
        return sellerRoles;
    }

    public void setSellerRoles(List<SLIM0247SellerRoleParam> sellerRoles) {
        this.sellerRoles = sellerRoles;
    }
}
