package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0113IParam;
import com.bms.slim.bean.result.SLIM0113IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0113IService extends BaseService {

    /**
     * 新增卖家制造商供应资质
     */
    @Transactional
    SLIM0113IResult saveManufacturerSupplyQualification(SLIM0113IParam slim0113IParam);

}
