package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimShBjTjRegistration;
import com.framework.boot.base.BaseDao;

public interface SLIM0215IDao extends BaseDao {

    /**
     * 修改生产商生产资质-进沪(京、津)登记信息
     */
    int updateShBjTjRegistration(UpdateEntity<SlimShBjTjRegistration, BaseTarget> updateEntity);

}
