package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0236IParam;
import com.bms.slim.bean.result.SLIM0236IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0236IService extends BaseService {

    /**
     * 修改生产商实验室
     */
    @Transactional
    SLIM0236IResult updateProducerLaboratories(SLIM0236IParam slim0236IParam);

}
