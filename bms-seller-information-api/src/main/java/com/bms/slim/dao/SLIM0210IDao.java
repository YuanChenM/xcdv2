package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimHalalFoodProductionOperationLicense;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0210IDao extends BaseDao {

    /**
     * 新增生产商生产资质-清真食品生产经营许可证
     */
    int saveHalalFoodProductionOperationLicenses(List<SlimHalalFoodProductionOperationLicense> slimHalalFoodProductionOperationLicenses);

}
