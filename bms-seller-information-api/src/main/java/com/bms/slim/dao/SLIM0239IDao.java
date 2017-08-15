package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerTestEquipment;
import com.framework.boot.base.BaseDao;

public interface SLIM0239IDao extends BaseDao {

    /**
     * 修改生产商检测设备
     */
    int updateProducerTestEquipments(UpdateEntity<SlimProducerTestEquipment, BaseTarget> updateEntity);

}
