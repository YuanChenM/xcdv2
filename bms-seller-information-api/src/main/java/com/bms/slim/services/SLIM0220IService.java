package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0220IParam;
import com.bms.slim.bean.result.field.SLIM0220IsoManagementSystemCertificationResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0220IService extends BaseService {

    /**
     * 查询生产商生产资质-管理体系认证证书
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0220IsoManagementSystemCertificationResult> findIsoManagementSystemCertification(SLIM0220IParam slim0220IParam);

}
