package com.framework.authority.service;

import java.util.List;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.entity.UserDoc;
import com.framework.authority.bean.param.UserParam;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * Created by zhang_jian3 on 2016/11/15.
 */
public interface UserService {
    BaseRestPaginationResult<UserDoc> findList(UserParam request);

    boolean save(UserDoc entity);

    int update(UserDoc entity);

    int delete(List<String> entity);

    List<TreeNodeDoc> findUserPermissionList(UserParam request);
}
