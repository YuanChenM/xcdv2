/*
 * 2017/03/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_seller_role对应的实体SlimSellerRole</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerRole extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 角色ID */
    private String roleId;
    /** 角色名称 */
    private String roleName;

    /**
     * <p>默认构造函数</p>
     */
    public SlimSellerRole() {
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @return 卖家角色ID
     */
    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @param sellerRoleId 卖家角色ID
     */
    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }
    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
    /**
     * <p>角色ID</p>
     *
     * @return 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * <p>角色ID</p>
     *
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    /**
     * <p>角色名称</p>
     *
     * @return 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * <p>角色名称</p>
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
