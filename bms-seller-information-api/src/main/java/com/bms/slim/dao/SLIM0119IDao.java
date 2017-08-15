package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimSellerBusinessTeam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0119IDao extends BaseDao {

    /**
     * 新增卖家电商经营团队
     */
    int saveSellerBusinessTeams(List<SlimSellerBusinessTeam> managementTeams);

}
