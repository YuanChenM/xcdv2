package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerManagementTeam;
import com.framework.boot.base.BaseDao;

public interface SLIM0109IDao extends BaseDao {

    /**
     * 修改卖家经营团队
     */
    int udpateSellerManagementTeams(UpdateEntity<SlimSellerManagementTeam, BaseTarget> updateEntity);

}
