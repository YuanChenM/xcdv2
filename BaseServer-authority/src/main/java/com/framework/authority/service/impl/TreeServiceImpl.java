package com.framework.authority.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.authority.bean.entity.TreeDoc;
import com.framework.authority.bean.param.TreeParam;
import com.framework.authority.dao.TreeDao;
import com.framework.authority.service.TreeService;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * Created by zhang_jian3 on 2016/11/15.
 */
@Service
public class TreeServiceImpl implements TreeService {

    public static final Logger logger = LoggerFactory.getLogger(TreeServiceImpl.class);

    @Autowired
    private TreeDao treeDao;

    @Override
    public BaseRestPaginationResult<TreeDoc> findList(TreeParam request) {
        BaseRestPaginationResult<TreeDoc> baseRestPaginationResult = new BaseRestPaginationResult<>();
        List<TreeDoc> list = treeDao.findList(request);
        Long count = treeDao.findCount(request);
        baseRestPaginationResult.setData(list);
        baseRestPaginationResult.setTotal(count);
        return baseRestPaginationResult;
    }

    @Override
    public boolean save(TreeDoc entity) {
        boolean flag = false;
        TreeParam query = new TreeParam();
        query.setTreeCode(entity.getTreeCode());
        List<TreeDoc> list = treeDao.findAccurateList(query);
        if (null != list && list.size() > 0) {} else {
            treeDao.save(entity);
            flag = true;
        }
        return flag;
    }

    @Override
    public int update(TreeDoc entity) {
        return treeDao.update(entity);
    }

    @Override
    public int delete(List<String> entity) {
        return treeDao.delete(entity);
    }
}
