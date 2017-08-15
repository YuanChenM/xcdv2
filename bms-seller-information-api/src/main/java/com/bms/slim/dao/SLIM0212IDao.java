package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimDesignatSlaughterPermit;
import com.bms.slim.bean.entity.SlimHalalFoodProductionOperationLicense;
import com.framework.boot.base.BaseDao;

public interface SLIM0212IDao extends BaseDao {

    /**
     * 修改生产商生产资质-清真食品生产经营许可证
     */
    int updateHalalFoodProductionOperationLicense(UpdateEntity<SlimHalalFoodProductionOperationLicense, BaseTarget> updateEntity);

}
