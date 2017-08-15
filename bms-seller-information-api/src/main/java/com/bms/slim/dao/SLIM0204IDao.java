package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimAnimalEpidemicPreventionConditionCertificate;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0204IDao extends BaseDao {

    /**
     * 新增生产商生产资质-动物防疫条件合格证
     */
    int saveAnimalEpidemicPreventionConditionCertificates(List<SlimAnimalEpidemicPreventionConditionCertificate> slimAnimalEpidemicPreventionConditionCertificateList);

}
