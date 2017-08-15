package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0216IParam;
import com.bms.slim.bean.result.SLIM0216IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0216IService extends BaseService {

    /**
     * 新增生产商生产资质-食品生产许可证
     */
    @Transactional
    SLIM0216IResult saveFoodProductionLicense(SLIM0216IParam slim0216IParam);

}
