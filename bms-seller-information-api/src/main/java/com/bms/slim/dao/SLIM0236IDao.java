package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimProducerLaboratory;
import com.framework.boot.base.BaseDao;

public interface SLIM0236IDao extends BaseDao {

    /**
     * 修改生产商实验室
     */
    int updateProducerLaboratories(UpdateEntity<SlimProducerLaboratory, BaseTarget> updateEntity);

}
