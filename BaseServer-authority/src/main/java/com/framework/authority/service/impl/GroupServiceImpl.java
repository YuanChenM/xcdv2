package com.framework.authority.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.authority.bean.entity.GroupDoc;
import com.framework.authority.bean.entity.UserDoc;
import com.framework.authority.bean.param.GroupParam;
import com.framework.authority.bean.param.UserParam;
import com.framework.authority.bean.result.GroupInUserResult;
import com.framework.authority.dao.GroupDao;
import com.framework.authority.dao.UserDao;
import com.framework.authority.service.GroupService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.UUIDUtils;

/**
 * 组Service实现类
 * Created by rong_ting on 2016/11/15.
 */
@Service
public class GroupServiceImpl implements GroupService {

    /**
     * logger
     */
    public static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private UserDao userDao;

    /**
     * 查询方法
     *
     * @param request 参数
     * @return 返回
     */
    @Override
    public BaseRestPaginationResult<GroupDoc> findList(GroupParam request) throws Exception {
        BaseRestPaginationResult<GroupDoc> result = new BaseRestPaginationResult();
        List<GroupDoc> list = groupDao.findList(request);
        Long count = groupDao.findCount(request);
        result.setData(list);
        result.setTotal(count);
        return result;
    }

    /**
     * 保存数据
     *
     * @param entity
     * @return
     */
    @Override
    public boolean save(GroupDoc entity) {
        GroupParam groupDoc = new GroupParam();
        groupDoc.setGroupCode(entity.getGroupCode());
        List<GroupDoc> list = groupDao.findAccurateList(groupDoc);
        if (CollectionUtils.isEmpty(list)) {
            return groupDao.save(entity);
        }
        return false;
    }

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    @Override
    public int update(GroupDoc entity) {
        int state = 0;
        state = groupDao.update(entity);
        return state;
    }

    /**
     * 批量删除数据(逻辑删除)
     *
     * @param entity
     * @return
     */
    @Override
    public int delete(List<String> entity) {
        return groupDao.delete(entity);
    }

    @Override
    public List searchGroupInUser(List<String> entity) {
        List<GroupInUserResult> resultList = new ArrayList();
        List<GroupDoc> groupDocList = new ArrayList();
        List<UserDoc> otherList = new ArrayList();
        UserParam userParam = new UserParam();
        GroupParam groupParam = new GroupParam();
        List<UserDoc> userList = userDao.findList(userParam);
        if (CollectionUtils.isNotEmpty(entity)) {
            for (String code : entity) {
                groupParam.setGroupCode(code);
                groupDocList.addAll(groupDao.findAccurateList(groupParam));
            }
        } else {
            groupDocList.addAll(groupDao.findAccurateList(groupParam));
        }
        for (GroupDoc groupDoc : groupDocList) {
            String groupCode = groupDoc.getGroupCode();
            GroupInUserResult groupInUserResult = new GroupInUserResult();
            groupInUserResult.setId(groupDoc.getGroupId());
            groupInUserResult.setName(groupDoc.getGroupName());
            groupInUserResult.setCode(groupCode);
            for (UserDoc userDoc : userList) {
                List<String> userGroup = userDoc.getGroup();
                if (CollectionUtils.isNotEmpty(userGroup)) {
                    for (String checkCode : userGroup) {
                        if (groupCode.equals(checkCode)) {
                            GroupInUserResult userToBean = new GroupInUserResult();
                            userToBean.setName(userDoc.getUserName());
                            userToBean.setCode(userDoc.getUserCode());
                            userToBean.setId(userDoc.getUserId());
                            userToBean.setUserLogin(userDoc.getUserLogin());
                            userToBean.setUserType(userDoc.getUserType());
                            groupInUserResult.addChildren(userToBean);
                        }
                    }
                }
            }
            resultList.add(groupInUserResult);
        }
        // resultList.add(OtherGroupInUser(userList));
        return resultList;
    }

    private GroupInUserResult OtherGroupInUser(List<UserDoc> userList) {
        GroupInUserResult groupInUserResult = new GroupInUserResult();
        groupInUserResult.setId(UUIDUtils.genPrimaryKey());
        groupInUserResult.setName("其他");
        groupInUserResult.setCode("other999999");
        for (UserDoc userDoc : userList) {
            List<String> userGroup = userDoc.getGroup();
            if (CollectionUtils.isEmpty(userGroup)) {
                GroupInUserResult userToBean = new GroupInUserResult();
                userToBean.setName(userDoc.getUserName());
                userToBean.setCode(userDoc.getUserCode());
                userToBean.setId(userDoc.getUserId());
                userToBean.setUserLogin(userDoc.getUserLogin());
                userToBean.setUserType(userDoc.getUserType());
                groupInUserResult.addChildren(userToBean);
            }
        }
        return groupInUserResult;
    }
}
