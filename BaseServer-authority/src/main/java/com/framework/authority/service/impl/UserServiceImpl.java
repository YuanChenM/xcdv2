package com.framework.authority.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.authority.bean.entity.TreeNodeBean;
import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.entity.UserDoc;
import com.framework.authority.bean.param.UserParam;
import com.framework.authority.dao.GroupDao;
import com.framework.authority.dao.TreeNodeDao;
import com.framework.authority.dao.UserDao;
import com.framework.authority.service.UserService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.CollectionUtils;

/**
 * Created by zhang_jian3 on 2016/11/15.
 */
@Service
public class UserServiceImpl implements UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private TreeNodeDao treeNodeDao;

    /**
     * 查询方法
     *
     * @param request 参数
     * @return 返回
     */
    @Override
    public BaseRestPaginationResult<UserDoc> findList(UserParam request) {
        BaseRestPaginationResult<UserDoc> baseRestPaginationResult = new BaseRestPaginationResult();
        List<UserDoc> list = userDao.findList(request);
        Long count = userDao.findCount(request);
        baseRestPaginationResult.setData(list);
        baseRestPaginationResult.setTotal(count);
        return baseRestPaginationResult;
    }

    /**
     * 保存数据
     *
     * @param entity
     * @return
     */
    @Override
    public boolean save(UserDoc entity) {
        boolean flag = false;
        UserParam query = new UserParam();
        query.setUserLogin(entity.getUserLogin());
        List<UserDoc> list = userDao.findAccurateList(query);
        if (null != list && list.size() > 0) {} else {
            userDao.save(entity);
            flag = true;
        }
        return flag;
    }

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    @Override
    public int update(UserDoc entity) {
        return userDao.update(entity);
    }

    /**
     * 批量删除数据
     *
     * @param entity
     * @return
     */
    @Override
    public int delete(List<String> entity) {
        return userDao.delete(entity);
    }

    @Override
    public List<TreeNodeDoc> findUserPermissionList(UserParam request) {
        List<String> nodeCodeList = new ArrayList<>();
        List<UserDoc> list = userDao.findAccurateList(request);
        for (UserDoc userDoc : list) {
            List<String> groupId = userDoc.getGroup();
            if (CollectionUtils.isNotEmpty(groupId)) {
                List<TreeNodeBean> nodeList = groupDao.findTreeNode(groupId);
                nodeCodeList.addAll(check(nodeList));
            }
            List<TreeNodeBean> treeList = userDoc.getTreeNode();
            if (CollectionUtils.isNotEmpty(treeList)) {
                nodeCodeList.addAll(check(treeList));
            }
        }
        List<TreeNodeDoc> returnList = new ArrayList<>();
        if (nodeCodeList != null && nodeCodeList.size() > 0) {
            returnList = treeNodeDao.findTreeNodeDetail(nodeCodeList);
        }
        return returnList;
    }

    private List<String> check(List<TreeNodeBean> nodeList) {
        List<String> nodeCodeList = new ArrayList<>();
        for (TreeNodeBean treeNodeBean : nodeList) {
            nodeCodeList.add(treeNodeBean.getTreeCode());
            String[] beans = treeNodeBean.getNode().split(",");
            for (int i = 0; i < beans.length; i++) {
                nodeCodeList.add(beans[i]);
            }
        }
        return nodeCodeList;

    }
}
