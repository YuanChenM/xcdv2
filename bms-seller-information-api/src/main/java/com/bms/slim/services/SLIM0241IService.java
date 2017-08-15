package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0241IParam;
import com.bms.slim.bean.result.SLIM0241IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0241IService extends BaseService {

    /**
     * 新增平台生产商
     */
    @Transactional
    SLIM0241IResult saveProducers(SLIM0241IParam slim0241IParam);

}
