package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerRole;
import com.framework.boot.base.BaseDao;

public interface SLIM0249IDao extends BaseDao {

    /**
     * 修改卖方单位角色
     */
    int udpateSellerRoles(UpdateEntity<SlimSellerRole, BaseTarget> updateEntity);

}
