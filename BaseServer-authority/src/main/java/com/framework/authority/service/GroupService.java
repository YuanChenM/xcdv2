package com.framework.authority.service;

import java.util.List;

import com.framework.authority.bean.entity.GroupDoc;
import com.framework.authority.bean.param.GroupParam;
import com.framework.authority.bean.result.GroupInUserResult;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * Created by rong_ting on 2016/11/15.
 */
public interface GroupService {

    /**
     * 查询组相关数据
     * 
     * @param request
     * @return
     */
    BaseRestPaginationResult<GroupDoc> findList(GroupParam request) throws Exception;

    /**
     * 保存组相关数据
     * 
     * @param entity
     * @return
     */
    boolean save(GroupDoc entity);

    /**
     * 更新组相关数据
     * 
     * @param entity
     * @return
     */
    int update(GroupDoc entity);

    /**
     * 删除组相关数据（逻辑删除）
     * 
     * @param entity
     * @return
     */
    int delete(List<String> entity);

    List<GroupInUserResult> searchGroupInUser(List<String> entity);
}
