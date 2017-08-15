package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0116IParam;
import com.framework.base.rest.entity.BaseEntity;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLIM0116IService extends BaseService {

    /**
     * 批量新增卖家合同信息和合同联系人
     */
    @Transactional
    List<Long> addSCPsAndContacts(SLIM0116IParam slim0116iParam);


}
