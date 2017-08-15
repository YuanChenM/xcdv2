package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimFoodProductionLicense;
import com.bms.slim.bean.entity.SlimShBjTjRegistration;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0216IDao extends BaseDao {

    /**
     * 新增生产商生产资质-食品生产许可证
     */
    int saveFoodProductionLicense(List<SlimFoodProductionLicense> slimFoodProductionLicenses);

}
