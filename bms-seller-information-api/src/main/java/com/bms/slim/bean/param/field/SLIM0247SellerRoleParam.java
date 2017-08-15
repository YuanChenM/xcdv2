package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0247SellerRoleParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "角色ID")
    private String roleId;
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
