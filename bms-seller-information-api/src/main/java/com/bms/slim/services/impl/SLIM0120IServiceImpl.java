package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0120IParam;
import com.bms.slim.bean.result.field.SLIM0120SellerBusinessTeamResult;
import com.bms.slim.dao.SLIM0120IDao;
import com.bms.slim.services.SLIM0120IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0120IServiceImpl extends BaseServiceImpl implements SLIM0120IService {

    @Autowired
    private SLIM0120IDao slim0120IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0120IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0120SellerBusinessTeamResult> findSellerBusinessTeams(SLIM0120IParam slim0120IParam) {
        if (StringUtils.isNotBlank(slim0120IParam.getName()))
            slim0120IParam.setName(DbUtils.buildLikeCondition(slim0120IParam.getName().trim(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<SLIM0120SellerBusinessTeamResult> pagingResult = findPageList(slim0120IParam);
        return pagingResult;
    }

}
