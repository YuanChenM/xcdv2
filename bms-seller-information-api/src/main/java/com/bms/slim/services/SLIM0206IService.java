package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0206IParam;
import com.bms.slim.bean.result.SLIM0206IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0206IService extends BaseService {

    /**
     * 修改生产商生产资质-动物防疫条件合格证
     */
    @Transactional
    SLIM0206IResult updateAnimalEpidemicPreventionConditionCertificate(SLIM0206IParam slim0206IParam);

}
