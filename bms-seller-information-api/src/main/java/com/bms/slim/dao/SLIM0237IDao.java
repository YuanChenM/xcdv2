package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimProducerTestEquipment;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0237IDao extends BaseDao {

    /**
     * 新增生产商检测设备
     */
    int saveProducerTestEquipments(List<SlimProducerTestEquipment> producerTestEquipments);

}
