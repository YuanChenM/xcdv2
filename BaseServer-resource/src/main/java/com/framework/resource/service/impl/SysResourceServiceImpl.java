package com.framework.resource.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.resource.bean.entity.SysResourceDoc;
import com.framework.resource.bean.param.SysResourceParam;
import com.framework.resource.dao.SysResourceDao;
import com.framework.resource.service.SysResourceService;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
    /**
     * logger
     */
    public static final Logger logger = LoggerFactory.getLogger(SysResourceService.class);

    @Autowired
    private SysResourceDao sysResourceDao;

    @Override
    public BaseRestPaginationResult<SysResourceDoc> findList(SysResourceParam request) {
        BaseRestPaginationResult<SysResourceDoc> baseRestPagingResult = new BaseRestPaginationResult<>();
        List<SysResourceDoc> list = this.sysResourceDao.findList(request);
        Long count = this.sysResourceDao.findCount(request);
        baseRestPagingResult.setData(list);
        baseRestPagingResult.setTotal(count);
        return baseRestPagingResult;
    }

    @Override
    public int delete(List<String> sysResourceParam) {
        return this.sysResourceDao.delete(sysResourceParam);
    }

    @Override
    public int update(SysResourceParam sysResourceParam) {
        return this.sysResourceDao.update(sysResourceParam);
    }

    @Override
    public boolean insert(SysResourceDoc sysResourceDoc) {
        return this.sysResourceDao.insert(sysResourceDoc);
    }

}
