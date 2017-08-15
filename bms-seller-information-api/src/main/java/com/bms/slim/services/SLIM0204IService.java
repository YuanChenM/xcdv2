package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0204IParam;
import com.bms.slim.bean.result.SLIM0204IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0204IService extends BaseService {

    /**
     * 新增生产商生产资质-动物防疫条件合格证
     */
    @Transactional
    SLIM0204IResult saveAnimalEpidemicPreventionConditionCertificates(SLIM0204IParam slim0204IParam);

}
