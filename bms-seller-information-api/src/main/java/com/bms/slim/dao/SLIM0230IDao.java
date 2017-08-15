package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerWorkshop;
import com.framework.boot.base.BaseDao;

public interface SLIM0230IDao extends BaseDao {

    /**
     * 修改生产商车间
     */
    int updateProducerWorkShops(UpdateEntity<SlimProducerWorkshop, BaseTarget> updateEntity);

}
