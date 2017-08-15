package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0249SellerRoleParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0249IParam",description = "修改卖方单位角色接口入参")
public class SLIM0249IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "修改字段标识集合")
    private String[] targets;
    @ApiModelProperty(value = "卖方单位角色集合")
    private List<SLIM0249SellerRoleParam> sellerRoles;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0249SellerRoleParam> getSellerRoles() {
        return sellerRoles;
    }

    public void setSellerRoles(List<SLIM0249SellerRoleParam> sellerRoles) {
        this.sellerRoles = sellerRoles;
    }
}
