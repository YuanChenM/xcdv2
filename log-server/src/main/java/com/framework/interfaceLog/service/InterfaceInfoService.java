package com.framework.interfaceLog.service;

import java.util.List;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.interfaceLog.bean.entity.LogHistoryDoc;
import com.framework.interfaceLog.bean.entity.LogInterfaceDoc;
import com.framework.interfaceLog.bean.param.LogInterfaceParam;

/**
 * Created by 健 on 2017/4/27.
 */
public interface InterfaceInfoService {
    /**
     * 查询
     *
     * @param request
     * @return
     */
    BaseRestPaginationResult<LogInterfaceDoc> findList(LogInterfaceParam request) throws Exception;

    /**
     * 查询一条
     *
     * @param entity
     * @return
     */
    LogInterfaceDoc findOne(LogInterfaceDoc entity);

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    boolean save(LogInterfaceDoc entity);

    boolean saveHistory(LogHistoryDoc entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    int update(LogInterfaceDoc entity);

    /**
     * 删除（逻辑删除）
     *
     * @param entity
     * @return
     */
    int delete(List<String> entity);
}
