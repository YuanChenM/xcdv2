/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.AgentLevelStandardPageParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.result.AgentLevelStandardResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>AgifAgentLevelStandardService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifAgentLevelStandardService extends BaseService {

    @Transactional
    AgentLevelStandardResult saveAgentLevelStandard(List<AgentLevelStandardPageParam> param);
    @Transactional
    AgentLevelStandardResult modifyAgentLevelStandard(List<BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam>> param);
}