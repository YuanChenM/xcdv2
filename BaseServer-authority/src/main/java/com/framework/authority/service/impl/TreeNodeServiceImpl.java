package com.framework.authority.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.param.TreeNodeParam;
import com.framework.authority.dao.TreeNodeDao;
import com.framework.authority.service.TreeNodeService;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * Created by zhang_jian3 on 2016/11/15.
 */
@Service
public class TreeNodeServiceImpl implements TreeNodeService {

    public static final Logger logger = LoggerFactory.getLogger(TreeNodeServiceImpl.class);

    @Autowired
    private TreeNodeDao treeNodeDao;

    @Override
    public BaseRestPaginationResult<TreeNodeDoc> findList(TreeNodeParam request) throws Exception {
        BaseRestPaginationResult<TreeNodeDoc> baseRestPaginationResult = new BaseRestPaginationResult<>();
        baseRestPaginationResult.setData(treeNodeDao.findList(request));
        baseRestPaginationResult.setTotal(treeNodeDao.findCount(request));
        return baseRestPaginationResult;
    }

    @Override
    public boolean save(TreeNodeDoc entity) {
        boolean flag = false;
        TreeNodeParam query = new TreeNodeParam();
        query.setNodeCode(entity.getNodeCode());
        List<TreeNodeDoc> list = treeNodeDao.findAccurateList(query);
        if (null != list && list.size() > 0) {} else {
            treeNodeDao.save(entity);
            flag = true;
        }
        return flag;
    }

    @Override
    public int update(TreeNodeDoc entity) {
        return treeNodeDao.update(entity);
    }

    @Override
    public int delete(List<String> entity) {
        return treeNodeDao.delete(entity);
    }
}
