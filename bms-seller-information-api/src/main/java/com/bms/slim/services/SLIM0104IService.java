package com.bms.slim.services;


import com.bms.slim.bean.param.SLIM0104IParam;
import com.bms.slim.bean.result.SLIM0104IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0104IService extends BaseService {

    /**
     * 新增卖家经营资质
     */
    @Transactional
    SLIM0104IResult addSellerBusinessQualifications(SLIM0104IParam param);
}
