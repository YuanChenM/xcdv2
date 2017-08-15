package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimAgentSupplyQualification;
import com.bms.slim.bean.param.SLIM0110IParam;
import com.bms.slim.bean.param.field.SLIM0110AgentSupplyQualificationParam;
import com.bms.slim.bean.result.SLIM0110IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0110IDao;
import com.bms.slim.services.SLIM0110IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SLIM0110IServiceImpl extends BaseServiceImpl implements SLIM0110IService {

    @Autowired
    private SLIM0110IDao slim0110IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0110IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String ASQ_IDS = "asq_ids";
        String AGENT_SUPPLY_QUALIFICATION = "agent_supply_qualification";
    }

    @Override
    public SLIM0110IResult saveAgentSupplyQualification(SLIM0110IParam slim0110IParam) {
        SLIM0110IResult result = new SLIM0110IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> asqIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0110IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimAgentSupplyQualification> agentSupplyQualifications = (List<SlimAgentSupplyQualification>) resultMap.get(Macro.AGENT_SUPPLY_QUALIFICATION);
            count = slim0110IDao.saveAgentSupplyQualification(agentSupplyQualifications);
            asqIds = (List<Long>) resultMap.get(Macro.ASQ_IDS);
        }
        result.setCount(count);
        result.setAsqIds(asqIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0110IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0110IParam slim0110IParam) {
        //声明变量
        final String userId= super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0110AgentSupplyQualificationParam> params = slim0110IParam.getSlim0110AgentSupplyQualificationParams();
        List<Long> asqIds = new ArrayList<>();
        List<SlimAgentSupplyQualification> agentSupplyQualifications = new ArrayList<>();
        for(SLIM0110AgentSupplyQualificationParam param : params){
            SlimAgentSupplyQualification agentSupplyQualification = BeanUtils.toBean(param, SlimAgentSupplyQualification.class);
            Long asqId = this.maxId(TableConstant.Name.SLIM_AGENT_SUPPLY_QUALIFICATION);
            agentSupplyQualification.setAsqId(asqId);
            agentSupplyQualification.setCrtId(userId);
            agentSupplyQualification.setCrtTime(current);
            agentSupplyQualification.setUpdId(userId);
            agentSupplyQualification.setUpdTime(current);

            agentSupplyQualifications.add(agentSupplyQualification);
            asqIds.add(asqId);
        }
        resultMap.put(Macro.ASQ_IDS,asqIds);
        resultMap.put(Macro.AGENT_SUPPLY_QUALIFICATION,agentSupplyQualifications);
        return  resultMap;
    }

}
