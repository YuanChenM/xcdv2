package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */
public class SLIM0250IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;

    //卖家ID
    private List<Long> entitySellerIds;

    private String entitySellerCode;

    //角色
    private String roleId;

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getEntitySellerCode() {
        return entitySellerCode;
    }

    public void setEntitySellerCode(String entitySellerCode) {
        this.entitySellerCode = entitySellerCode;
    }
}
