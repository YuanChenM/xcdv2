/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.dao;

import com.bms.agif.bean.param.AccountParam;
import com.bms.agif.bean.param.AgentAndPartnerPageParam;
import com.bms.agif.bean.result.AgentAndPartnerResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>AgifAgentDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifAgentRelationDao extends BaseDao {

    AccountParam selectAgentTel(AccountParam param);

    List<AgentAndPartnerResult> findAgentPartnerPageList(AgentAndPartnerPageParam param);

    int findAgentPartnerCount(AgentAndPartnerPageParam param);
}