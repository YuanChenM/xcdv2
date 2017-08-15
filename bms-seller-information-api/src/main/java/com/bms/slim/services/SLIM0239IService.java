package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0239IParam;
import com.bms.slim.bean.result.SLIM0239IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0239IService extends BaseService {

    /**
     * 修改生产商检测设备
     */
    @Transactional
    SLIM0239IResult updateProducerTestEquipments(SLIM0239IParam slim0239IParam);

}
