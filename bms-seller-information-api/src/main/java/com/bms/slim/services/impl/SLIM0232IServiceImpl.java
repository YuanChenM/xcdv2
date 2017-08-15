package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0232IParam;
import com.bms.slim.bean.result.field.SLIM0232ProducerStorageCapacityResult;
import com.bms.slim.dao.SLIM0232IDao;
import com.bms.slim.services.SLIM0232IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0232IServiceImpl extends BaseServiceImpl implements SLIM0232IService {

    @Autowired
    private SLIM0232IDao slim0232IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0232IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0232ProducerStorageCapacityResult> findProducerStorageCapacities(SLIM0232IParam slim0232IParam) {
        BaseRestPaginationResult<SLIM0232ProducerStorageCapacityResult> pagingResult = findPageList(slim0232IParam);
        return pagingResult;
    }

}
