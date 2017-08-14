/*
 * 2017/03/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.AgentLevelRsParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.result.AgentLevelRsResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * AgifAgentService接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifAgentLevelService extends BaseService {
    @Transactional
    AgentLevelRsResult addAgentLevel(AgentLevelRsParam levelRsParam);

    @Transactional
    int updateAgentLevel(BaseBean<AgentLevelRsParam, AgentLevelRsParam> baseBean);
}