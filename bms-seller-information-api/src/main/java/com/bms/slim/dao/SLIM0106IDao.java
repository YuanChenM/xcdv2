package com.bms.slim.dao;

import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.entity.target.SlimSellerBusinessQualificationTarget;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0106IDao extends BaseDao {

    /**
     * 修改卖家经营资质
     */
    int updateSBQ(UpdateEntity<SlimSellerBusinessQualification, SlimSellerBusinessQualificationTarget> updateEntity);

}
