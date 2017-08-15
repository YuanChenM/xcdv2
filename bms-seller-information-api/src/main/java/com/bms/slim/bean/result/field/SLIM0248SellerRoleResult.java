package com.bms.slim.bean.result.field;

import com.framework.base.rest.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class SLIM0248SellerRoleResult extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "角色ID")
    private String roleId;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

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

    @Override
    public Boolean getDelFlg() {
        return delFlg;
    }

    @Override
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    @Override
    public String getCrtId() {
        return crtId;
    }

    @Override
    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    @Override
    public Date getCrtTime() {
        return crtTime;
    }

    @Override
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    @Override
    public String getUpdId() {
        return updId;
    }

    @Override
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    @Override
    public Date getUpdTime() {
        return updTime;
    }

    @Override
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }
}
