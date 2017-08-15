package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0238IParam;
import com.bms.slim.bean.result.field.SLIM0238ProducerTestEquipmentyResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0238IService extends BaseService {

    /**
     * 查询生产商检测设备
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0238ProducerTestEquipmentyResult> findProducerTestEquipments(SLIM0238IParam slim0238IParam);

}
