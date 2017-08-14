package com.framework.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.resource.bean.entity.ActionResourceDoc;
import com.framework.resource.bean.param.ActionResourceParam;
import com.framework.resource.dao.ActionResourceDao;
import com.framework.resource.service.ActionResourceService;

/**
 * Created by zhang_jian3 on 2016/11/25.
 */
@Service
public class ActionResourceServiceImpl implements ActionResourceService {

    @Autowired
    private ActionResourceDao actionResourceDao;

    @Override
    public BaseRestPaginationResult<ActionResourceDoc> findList(ActionResourceParam request) {
        BaseRestPaginationResult<ActionResourceDoc> baseRestPaginationResult = new BaseRestPaginationResult<>();
        baseRestPaginationResult.setData(actionResourceDao.findList(request));
        baseRestPaginationResult.setTotal(actionResourceDao.findCount(request));
        return baseRestPaginationResult;
    }

    @Override
    public boolean save(ActionResourceDoc entity) {
        return actionResourceDao.save(entity);
    }

    @Override
    public int update(ActionResourceDoc entity) {
        return actionResourceDao.update(entity);
    }

    @Override
    public int delete(List<String> entity) {
        return actionResourceDao.delete(entity);
    }
}
