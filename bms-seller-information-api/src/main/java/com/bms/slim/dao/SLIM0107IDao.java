package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimSellerManagementTeam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0107IDao extends BaseDao {

    /**
     * 新增卖家经营团队
     */
    int saveSellerManagementTeams(List<SlimSellerManagementTeam> managementTeams);

}
