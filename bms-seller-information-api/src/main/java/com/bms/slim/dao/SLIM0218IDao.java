package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimFoodProductionLicense;
import com.framework.boot.base.BaseDao;

public interface SLIM0218IDao extends BaseDao {

    /**
     * 修改生产商生产资质-食品生产许可证
     */
    int updateFoodProductionLicense(UpdateEntity<SlimFoodProductionLicense, BaseTarget> updateEntity);

}
