package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimAgentSupplyQualification;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0110IDao extends BaseDao {

    /**
     * 新增卖家代理商供应资质
     */
    int saveAgentSupplyQualification(List<SlimAgentSupplyQualification> slimAgentSupplyQualifications);

}
