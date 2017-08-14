package com.framework.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.resource.bean.entity.PageResourceDoc;
import com.framework.resource.bean.param.PageResourceDocParam;
import com.framework.resource.dao.PageResourceDao;
import com.framework.resource.service.PageResourceService;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */
@Service
public class PageResourceServiceImpl implements PageResourceService {

    @Autowired
    private PageResourceDao pageResourceDao;

    @Override
    public void insert(PageResourceDoc param) {
        pageResourceDao.insert(param);
    }

    @Override
    public int delete(List<String> pageIdList) {
        return pageResourceDao.delete(pageIdList);
    }

    @Override
    public int update(PageResourceDoc param) {
        return this.pageResourceDao.update(param);
    }

    @Override
    public BaseRestPaginationResult<PageResourceDoc> findList(PageResourceDocParam request) {
        BaseRestPaginationResult<PageResourceDoc> baseRestPaginationResult = new BaseRestPaginationResult<>();
        baseRestPaginationResult.setData(pageResourceDao.findList(request));
        baseRestPaginationResult.setTotal(pageResourceDao.findCount(request));
        return baseRestPaginationResult;
    }
}
