package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimProducerLaboratory;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0234IDao extends BaseDao {

    /**
     * 新增生产商实验室
     */
    int saveProducerLaboratories(List<SlimProducerLaboratory> producerLaboratories);

}
