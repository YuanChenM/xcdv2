package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimSellerRole;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0247IDao extends BaseDao {

    /**
     * 新增卖方单位角色
     */
    int saveSellerRoles(List<SlimSellerRole> producers);

}
