package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0218IParam;
import com.bms.slim.bean.result.SLIM0218IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0218IService extends BaseService {

    /**
     * 修改生产商生产资质-食品生产许可证
     */
    @Transactional
    SLIM0218IResult updateFoodProductionLicense(SLIM0218IParam slim0218IParam);

}
