package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0212IParam;
import com.bms.slim.bean.result.SLIM0212IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0212IService extends BaseService {

    /**
     * 修改生产商生产资质-清真食品生产经营许可证
     */
    @Transactional
    SLIM0212IResult updateHalalFoodProductionOperationLicenses(SLIM0212IParam slim0212IParam);

}
