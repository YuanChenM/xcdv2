package com.framework.interfaceLog.service;

import java.util.List;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.interfaceLog.bean.entity.LogMstDoc;
import com.framework.interfaceLog.bean.param.LogMstParam;

public interface BaseInfoService {

    /**
     * 查询组相关数据
     * 
     * @param request
     * @return
     */
    BaseRestPaginationResult<LogMstDoc> findList(LogMstParam request) throws Exception;

    /**
     * 保存组相关数据
     * 
     * @param entity
     * @return
     */
    boolean save(LogMstDoc entity);

    /**
     * 更新组相关数据
     * 
     * @param entity
     * @return
     */
    int update(LogMstDoc entity);

    /**
     * 删除组相关数据（逻辑删除）
     * 
     * @param entity
     * @return
     */
    int delete(List<String> entity);
}
