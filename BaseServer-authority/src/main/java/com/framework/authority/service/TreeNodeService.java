package com.framework.authority.service;

import java.util.List;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.authority.bean.param.TreeNodeParam;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * Created by zhang_jian3 on 2016/11/18.
 */
public interface TreeNodeService {
    BaseRestPaginationResult<TreeNodeDoc> findList(TreeNodeParam request) throws Exception;

    boolean save(TreeNodeDoc entity);

    int update(TreeNodeDoc entity);

    int delete(List<String> entity);
}
