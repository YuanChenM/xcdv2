package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0202IParam;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.bms.slim.dao.SLIM0202IDao;
import com.bms.slim.services.SLIM0202IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0202IServiceImpl extends BaseServiceImpl implements SLIM0202IService {

    @Autowired
    private SLIM0202IDao slim0202IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0202IDao;
    }

    @Override
    public BaseRestPaginationResult<SlimProducerResult> findSellerProducers(SLIM0202IParam slim0202IParam) {
        if (StringUtils.isNotBlank(slim0202IParam.getProducerCode()))
            slim0202IParam.setProducerCode(DbUtils.buildLikeCondition(slim0202IParam.getProducerCode(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<SlimProducerResult> pagingResult = findPageList(slim0202IParam);
        return pagingResult;
    }

}
