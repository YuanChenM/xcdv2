package com.framework.resource.service;

import java.util.List;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.resource.bean.entity.SysResourceDoc;
import com.framework.resource.bean.param.SysResourceParam;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
public interface SysResourceService {
    BaseRestPaginationResult<SysResourceDoc> findList(SysResourceParam request);

    int delete(List<String> sysResourceParam);

    boolean insert(SysResourceDoc sysResourceDoc);

    int update(SysResourceParam sysResourceParam);
}
