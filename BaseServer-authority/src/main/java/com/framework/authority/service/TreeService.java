package com.framework.authority.service;

import java.util.List;

import com.framework.authority.bean.entity.TreeDoc;
import com.framework.authority.bean.param.TreeParam;
import com.framework.base.rest.result.BaseRestPaginationResult;

/**
 * Created by zhang_jian3 on 2016/11/15.
 */
public interface TreeService {
    BaseRestPaginationResult<TreeDoc> findList(TreeParam request);

    boolean save(TreeDoc entity);

    int update(TreeDoc entity);

    int delete(List<String> entity);
}
