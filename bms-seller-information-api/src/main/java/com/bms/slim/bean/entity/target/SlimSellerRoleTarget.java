package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

public class SlimSellerRoleTarget extends BaseTarget {

    /** 实体卖家ID */
    private boolean entitySellerIdFlg;
    /** 角色ID */
    private boolean roleIdFlg;
    /** 角色名称 */
    private boolean roleNameFlg;

    public boolean isEntitySellerIdFlg() {
        return entitySellerIdFlg;
    }

    public void setEntitySellerIdFlg(boolean entitySellerIdFlg) {
        this.entitySellerIdFlg = entitySellerIdFlg;
    }

    public boolean isRoleIdFlg() {
        return roleIdFlg;
    }

    public void setRoleIdFlg(boolean roleIdFlg) {
        this.roleIdFlg = roleIdFlg;
    }

    public boolean isRoleNameFlg() {
        return roleNameFlg;
    }

    public void setRoleNameFlg(boolean roleNameFlg) {
        this.roleNameFlg = roleNameFlg;
    }
}
