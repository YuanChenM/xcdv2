package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0221IParam;
import com.bms.slim.bean.result.SLIM0221IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0221IService extends BaseService {

    /**
     * 修改生产商生产资质-管理体系认证证书
     */
    @Transactional
    SLIM0221IResult updateIsoManagementSystemCertification(SLIM0221IParam slim0221IParam);

}
