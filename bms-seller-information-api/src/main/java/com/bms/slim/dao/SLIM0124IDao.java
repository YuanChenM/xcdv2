package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSeller;
import com.framework.boot.base.BaseDao;

public interface SLIM0124IDao extends BaseDao {

    /**
     * 修改卖家角色
     */
    int udpateSellers(UpdateEntity<SlimSeller, BaseTarget> updateEntity);

}
