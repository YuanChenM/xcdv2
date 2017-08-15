package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0238IParam;
import com.bms.slim.bean.result.field.SLIM0238ProducerTestEquipmentyResult;
import com.bms.slim.dao.SLIM0238IDao;
import com.bms.slim.services.SLIM0238IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0238IServiceImpl extends BaseServiceImpl implements SLIM0238IService {

    @Autowired
    private SLIM0238IDao slim0238IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0238IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0238ProducerTestEquipmentyResult> findProducerTestEquipments(SLIM0238IParam slim0238IParam) {
        BaseRestPaginationResult<SLIM0238ProducerTestEquipmentyResult> pagingResult = findPageList(slim0238IParam);
        return pagingResult;
    }

}
