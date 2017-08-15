package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0234IParam;
import com.bms.slim.bean.result.SLIM0234IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0234IService extends BaseService {

    /**
     * 新增生产商实验室
     */
    @Transactional
    SLIM0234IResult addProducerLaboratories(SLIM0234IParam slim0234IParam);

}
