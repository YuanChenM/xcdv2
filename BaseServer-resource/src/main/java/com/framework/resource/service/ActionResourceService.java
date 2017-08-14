package com.framework.resource.service;

import java.util.List;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.resource.bean.entity.ActionResourceDoc;
import com.framework.resource.bean.param.ActionResourceParam;

/**
 * Created by zhang_jian3 on 2016/11/25.
 */
public interface ActionResourceService {

    BaseRestPaginationResult<ActionResourceDoc> findList(ActionResourceParam request);

    boolean save(ActionResourceDoc entity);

    int update(ActionResourceDoc entity);

    int delete(List<String> entity);
}
