package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0115IParam;
import com.bms.slim.bean.result.SLIM0115IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0115IService extends BaseService {

    /**
     * 修改卖家制造商供应资质
     */
    @Transactional
    SLIM0115IResult updateManufacturerSupplyQualification(SLIM0115IParam slim0115IParam);

}
