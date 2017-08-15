package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0213IParam;
import com.bms.slim.bean.result.SLIM0213IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0213IService extends BaseService {

    /**
     * 新增生产商生产资质-进沪(京、津)登记信息
     */
    @Transactional
    SLIM0213IResult saveShBjTjRegistrations(SLIM0213IParam slim0213IParam);

}
