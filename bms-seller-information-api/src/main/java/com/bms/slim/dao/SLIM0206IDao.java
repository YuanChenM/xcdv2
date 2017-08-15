package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimAnimalEpidemicPreventionConditionCertificate;
import com.bms.slim.bean.entity.SlimProducerHonorCertificate;
import com.framework.boot.base.BaseDao;

public interface SLIM0206IDao extends BaseDao {

    /**
     * 修改生产商生产资质-动物防疫条件合格证
     */
    int updateAnimalEpidemicPreventionConditionCertificate(UpdateEntity<SlimAnimalEpidemicPreventionConditionCertificate, BaseTarget> updateEntity);

}
