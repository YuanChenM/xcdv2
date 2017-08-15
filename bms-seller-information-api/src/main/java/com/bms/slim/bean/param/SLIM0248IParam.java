package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0248IParam",
        description = "查询卖方单位角色接口入参")
public class SLIM0248IParam extends BaseRestPaginationParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖方单位角色Id集合")
    private List<Long> sellerRoleIds;
    @ApiModelProperty(value = "实体卖家Id集合")
    private List<Long> entitySellerIds;
    @ApiModelProperty(value = "角色Id集合")
    private List<String> roleIds;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
