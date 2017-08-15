package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimProducerWorkshop;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0228IDao extends BaseDao {

    /**
     * 新增生产商车间
     */
    int saveProducerWorkShops(List<SlimProducerWorkshop> producerWorkshops);

}
