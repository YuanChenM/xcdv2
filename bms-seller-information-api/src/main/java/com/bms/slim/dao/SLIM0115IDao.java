package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimManufacturerSupplyQualification;
import com.framework.boot.base.BaseDao;

public interface SLIM0115IDao extends BaseDao {

    /**
     * 修改卖家制造商供应资质
     */
    int updateManufacturerSupplyQualification(UpdateEntity<SlimManufacturerSupplyQualification, BaseTarget> updateEntity);

}
