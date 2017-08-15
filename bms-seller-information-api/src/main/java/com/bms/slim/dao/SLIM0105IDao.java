package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.param.SLIM0105IParam;
import com.framework.boot.base.BaseDao;

public interface SLIM0105IDao extends BaseDao {

    /**
     * 查询卖家经营资质
     */
    SlimSellerBusinessQualification findSBQ(SLIM0105IParam entitySellerId);


}
