package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0215IParam;
import com.bms.slim.bean.result.SLIM0215IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0215IService extends BaseService {

    /**
     * 修改生产商生产资质-进沪(京、津)登记信息
     */
    @Transactional
    SLIM0215IResult updateShBjTjRegistrations(SLIM0215IParam slim0215IParam);

}
