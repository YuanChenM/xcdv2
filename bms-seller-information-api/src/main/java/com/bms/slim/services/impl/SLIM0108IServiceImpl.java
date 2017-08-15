package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0108IParam;
import com.bms.slim.bean.result.field.SLIM0108SellerManagementTeamResult;
import com.bms.slim.dao.SLIM0108IDao;
import com.bms.slim.services.SLIM0108IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0108IServiceImpl extends BaseServiceImpl implements SLIM0108IService {

    @Autowired
    private SLIM0108IDao slim0108IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0108IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0108SellerManagementTeamResult> findSellerManagementTeams(SLIM0108IParam slim0108IParam) {
        if (StringUtils.isNotBlank(slim0108IParam.getName()))
            slim0108IParam.setName(DbUtils.buildLikeCondition(slim0108IParam.getName().trim(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<SLIM0108SellerManagementTeamResult> pagingResult = findPageList(slim0108IParam);
        return pagingResult;
    }

}
