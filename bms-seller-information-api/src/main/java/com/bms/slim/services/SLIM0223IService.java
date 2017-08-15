package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0223IParam;
import com.bms.slim.bean.param.SLIM0232IParam;
import com.bms.slim.bean.result.field.SLIM0223ProducerHonorCertificateResult;
import com.bms.slim.bean.result.field.SLIM0232ProducerStorageCapacityResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0223IService extends BaseService {

    /**
     * 查询生产商荣誉证书
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0223ProducerHonorCertificateResult> findProducerHonorCertificate(SLIM0223IParam slim0223IParam);

}
