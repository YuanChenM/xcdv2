package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0207IParam;
import com.bms.slim.bean.result.SLIM0207IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0207IService extends BaseService {

    /**
     * 新增生产商生产资质-定点屠宰许可证
     */
    @Transactional
    SLIM0207IResult saveDesignatSlaughterPermits(SLIM0207IParam slim0207IParam);

}
