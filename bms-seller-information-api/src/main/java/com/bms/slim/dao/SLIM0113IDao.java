package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimManufacturerSupplyQualification;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0113IDao extends BaseDao {

    /**
     * 新增卖家制造商供应资质
     */
    int saveManufacturerSupplyQualification(List<SlimManufacturerSupplyQualification> slimManufacturerSupplyQualifications);

}
