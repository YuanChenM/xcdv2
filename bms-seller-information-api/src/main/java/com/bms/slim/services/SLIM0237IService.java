package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0237IParam;
import com.bms.slim.bean.result.SLIM0237IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0237IService extends BaseService {

    /**
     * 新增生产商检测设备
     */
    @Transactional
    SLIM0237IResult addProducerTestEquipments(SLIM0237IParam slim0237IParam);

}
