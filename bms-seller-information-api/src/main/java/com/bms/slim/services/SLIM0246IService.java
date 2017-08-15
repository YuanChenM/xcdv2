package com.bms.slim.services;


import com.bms.slim.bean.param.SLIM0246IParam;
import com.bms.slim.bean.result.SLIM0246IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0246IService extends BaseService {

    /**
     * 根据contactId修改卖联系人
     */
    @Transactional
    SLIM0246IResult updateContact(SLIM0246IParam slim0246IParam);
}
