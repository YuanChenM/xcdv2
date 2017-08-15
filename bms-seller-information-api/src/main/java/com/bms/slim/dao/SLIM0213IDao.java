package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimShBjTjRegistration;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0213IDao extends BaseDao {

    /**
     * 新增生产商生产资质-进沪(京、津)登记信息
     */
    int saveShBjTjRegistrations(List<SlimShBjTjRegistration> slimShBjTjRegistrations);

}
