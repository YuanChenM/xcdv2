package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0210IParam;
import com.bms.slim.bean.result.SLIM0210IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0210IService extends BaseService {

    /**
     * 新增生产商生产资质-清真食品生产经营许可证
     */
    @Transactional
    SLIM0210IResult saveHalalFoodProductionOperationLicenses(SLIM0210IParam slim0210IParam);

}
