package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerBusinessTeam;
import com.framework.boot.base.BaseDao;

public interface SLIM0121IDao extends BaseDao {

    /**
     * 修改卖家电商经营团队
     */
    int udpateSellerBusinessTeams(UpdateEntity<SlimSellerBusinessTeam, BaseTarget> updateEntity);

}
