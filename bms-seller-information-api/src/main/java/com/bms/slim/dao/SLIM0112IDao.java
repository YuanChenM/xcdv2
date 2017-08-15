package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimAgentSupplyQualification;
import com.framework.boot.base.BaseDao;

public interface SLIM0112IDao extends BaseDao {

    /**
     * 修改卖家代理商供应资质
     */
    int updateAgentSupplyQualification(UpdateEntity<SlimAgentSupplyQualification, BaseTarget> updateEntity);

}
