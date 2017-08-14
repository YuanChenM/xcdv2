/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifAccount;
import com.bms.agif.bean.entity.AgifAgent;
import com.bms.agif.bean.entity.AgifAgentAccount;
import com.bms.agif.bean.entity.AgifAgentLevel;
import com.bms.agif.bean.param.*;
import com.bms.agif.bean.result.AgentLevelRsResult;
import com.bms.agif.dao.AgifAgentDao;
import com.bms.agif.dao.AgifAgentLevelDao;
import com.bms.agif.dao.AgifButlerDao;
import com.bms.agif.dao.AgifPartnerDao;
import com.bms.agif.service.AgifAccountService;
import com.bms.agif.service.AgifAgentDemesneService;
import com.bms.agif.service.AgifAgentLevelService;
import com.bms.agif.service.AgifAgentService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.*;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * <p>AgifAgentService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifAgentLevelServiceImpl extends BaseServiceImpl implements AgifAgentLevelService {

    @Autowired
    private AgifAgentLevelDao agifAgentLevelDao;

    @Override
    public BaseDao getBaseDao() {
        return agifAgentLevelDao;
    }

    @Override
    public AgentLevelRsResult addAgentLevel(AgentLevelRsParam levelRsParam) {
        AgifAgentLevel agentLevel = BeanUtils.toBean(levelRsParam, AgifAgentLevel.class);
        Date currentDate = DateUtils.getCurrent();
        String loginUserId = this.getLoginUserId();
        Long id = this.maxId("AGIF_AGENT_LEVEL");
        agentLevel.setId(id);
        agentLevel.setCrtId(loginUserId);
        agentLevel.setLevelTime(currentDate);
        agentLevel.setCrtTime(currentDate);
        agentLevel.setUpdId(loginUserId);
        agentLevel.setUpdTime(currentDate);
        agentLevel.setDelFlg(false);
        agentLevel.setVersion(NumberConst.IntDef.INT_ONE);
        this.agifAgentLevelDao.save(agentLevel);
        AgentLevelRsResult levelRsResult = BeanUtils.toBean(levelRsParam, AgentLevelRsResult.class);
        return levelRsResult;
    }

    @Override
    public int updateAgentLevel(BaseBean<AgentLevelRsParam, AgentLevelRsParam> baseBean) {
        Date currentDate = DateUtils.getCurrent();
        String loginUserId = this.getLoginUserId();
        BaseBean<AgifAgentLevel, AgifAgentLevel> levelBaseBean = new BaseBean<>();
        AgifAgentLevel agentLevelTarget = BeanUtils.toBean(baseBean.getTarget(), AgifAgentLevel.class);
        AgifAgentLevel agentLevelFilter = BeanUtils.toBean(baseBean.getFilter(), AgifAgentLevel.class);
        agentLevelTarget.setUpdId(loginUserId);
        agentLevelTarget.setUpdTime(currentDate);
        agentLevelTarget.setVersion(agentLevelTarget.getVersion() + NumberConst.IntDef.INT_ONE);
        levelBaseBean.setTarget(agentLevelTarget);
        levelBaseBean.setFilter(agentLevelFilter);
        return agifAgentLevelDao.modify(levelBaseBean);
    }
}