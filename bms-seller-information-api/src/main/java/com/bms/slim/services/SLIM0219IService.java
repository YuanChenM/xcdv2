package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0219IParam;
import com.bms.slim.bean.result.SLIM0219IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0219IService extends BaseService {

    /**
     * 新增生产商生产资质-管理体系认证证书
     */
    @Transactional
    SLIM0219IResult saveIsoManagementSystemCertification(SLIM0219IParam slim0219IParam);

}
