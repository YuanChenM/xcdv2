package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0240IParam;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.bms.slim.dao.SLIM0240IDao;
import com.bms.slim.services.SLIM0240IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0240IServiceImpl extends BaseServiceImpl implements SLIM0240IService {

    @Autowired
    private SLIM0240IDao slim0240IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0240IDao;
    }

    @Override
    public BaseRestPaginationResult<SlimProducerResult> findProducers(SLIM0240IParam slim0240IParam) {
        if (StringUtils.isNotBlank(slim0240IParam.getProducerCode()))
            slim0240IParam.setProducerCode(DbUtils.buildLikeCondition(slim0240IParam.getProducerCode(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<SlimProducerResult> pagingResult = findPageList(slim0240IParam);
        return pagingResult;
    }

}
