package com.bms.slim.services;


import com.bms.slim.bean.param.SLIM0118IParam;
import com.bms.slim.bean.result.SLIM0118IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0118IService extends BaseService {

    /**
     * 根据scpId修改卖家合同信息准入
     */
    @Transactional
    SLIM0118IResult updateSCP(SLIM0118IParam slim0118IParam);
}
