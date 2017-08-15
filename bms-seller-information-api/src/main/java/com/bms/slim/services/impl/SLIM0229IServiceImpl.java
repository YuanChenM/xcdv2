package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0229IParam;
import com.bms.slim.bean.result.field.SLIM0229ProducerWorkShopResult;
import com.bms.slim.dao.SLIM0229IDao;
import com.bms.slim.services.SLIM0229IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0229IServiceImpl extends BaseServiceImpl implements SLIM0229IService {

    @Autowired
    private SLIM0229IDao slim0229IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0229IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0229ProducerWorkShopResult> findProducerWorkShops(SLIM0229IParam slim0229IParam) {
        BaseRestPaginationResult<SLIM0229ProducerWorkShopResult> pagingResult = findPageList(slim0229IParam);
        return pagingResult;
    }

}
