package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0244IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLIM0244IService extends BaseService {

    /**
     * 批量新增联系人
     */
    @Transactional
    List<Long> addContacts(SLIM0244IParam slim0244IParam);
}
