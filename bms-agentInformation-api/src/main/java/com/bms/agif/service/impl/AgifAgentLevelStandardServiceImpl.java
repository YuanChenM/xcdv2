/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifAgentLevelStandard;
import com.bms.agif.bean.param.AgentLevelStandardPageParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.result.AgentLevelStandardResult;
import com.bms.agif.dao.AgifAgentLevelStandardDao;
import com.bms.agif.service.AgifAgentLevelStandardService;
import com.bms.agif.util.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>AgifAgentLevelStandardService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifAgentLevelStandardServiceImpl extends BaseServiceImpl implements AgifAgentLevelStandardService {

    @Autowired
    private AgifAgentLevelStandardDao AgifAgentLevelStandardDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifAgentLevelStandardDao;
    }

    @Override
    public AgentLevelStandardResult saveAgentLevelStandard(List<AgentLevelStandardPageParam> param) {
        AgentLevelStandardResult result = new AgentLevelStandardResult();
        List<AgifAgentLevelStandard> entityList = new ArrayList<>();
        Date curTime = DateUtils.getCurrent();
        if (CollectionUtils.isNotEmpty(param)) {
            for (int i = 0; i < param.size(); i++) {
                AgifAgentLevelStandard entity = BeanUtils.toBean(param.get(i), AgifAgentLevelStandard.class);
                Long id = this.maxId("AGIF_AGENT_LEVEL_STANDARD");
                entity.setLevelId(id);
                entity.setCrtId(this.getLoginUserId());
                entity.setUpdId(this.getLoginUserId());
                entity.setCrtTime(curTime);
                entity.setUpdTime(curTime);
                entity.setVersion(NumberConst.IntDef.INT_ONE);
                entity.setDelFlg(false);
                entityList.add(entity);
            }
        }
        int count = NumberConst.IntDef.INT_ZERO;
        List<List<AgifAgentLevelStandard>> toolList = RestCommUtil.insertRanking(entityList);
        if (CollectionUtils.isNotEmpty(toolList)) {
            for (int i = 0; i < toolList.size(); i++) {
                count += batchSave(toolList.get(i));
            }
        }
        result.setCount(count);
        result.setLevelStandardList(entityList);
        return result;
    }

    @Override
    public AgentLevelStandardResult modifyAgentLevelStandard(List<BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam>> param) {

        AgentLevelStandardResult result = new AgentLevelStandardResult();
        int listSize = param.size();
        Date curTime = DateUtils.getCurrent();
        int resultLine = NumberConst.IntDef.INT_ZERO;
        BaseBean<AgifAgentLevelStandard, AgifAgentLevelStandard> beanEntity;

        List<AgifAgentLevelStandard> targetEntityList = new ArrayList<>();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            beanEntity = new BaseBean<>();
            AgifAgentLevelStandard filterEntity = BeanUtils.toBean(param.get(i).getFilter(), AgifAgentLevelStandard.class);
            AgifAgentLevelStandard targetEntity = BeanUtils.toBean(param.get(i).getTarget(), AgifAgentLevelStandard.class);

            targetEntity.setUpdTime(curTime);
            targetEntity.setUpdId(getLoginUserId());
            beanEntity.setFilter(filterEntity);
            beanEntity.setTarget(targetEntity);

            targetEntityList.add(targetEntity);
            int line = AgifAgentLevelStandardDao.modify(beanEntity);
            resultLine += line;
        }
        result.setLevelStandardList(targetEntityList);
        result.setCount(resultLine);
        return result;
    }
}