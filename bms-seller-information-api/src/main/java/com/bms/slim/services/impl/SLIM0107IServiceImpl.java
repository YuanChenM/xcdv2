package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerManagementTeam;
import com.bms.slim.bean.param.SLIM0107IParam;
import com.bms.slim.bean.param.field.SLIM0107SellerManagementTeamParam;
import com.bms.slim.bean.result.SLIM0107IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0107IDao;
import com.bms.slim.services.SLIM0107IService;
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
public class SLIM0107IServiceImpl extends BaseServiceImpl implements SLIM0107IService {

    @Autowired
    private SLIM0107IDao slim0107IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0107IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String MANAGEMENTTEAMS = "managementTeams";
        String SMT_IDS = "smt_ids";
    }

    @Override
    public SLIM0107IResult addSellerManagementTeams(SLIM0107IParam slim0107IParam) {
        SLIM0107IResult result = new SLIM0107IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> smtIds = new ArrayList<>();
        Map<String,Object> resultMap = handelParam(slim0107IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimSellerManagementTeam> managementTeams = (List<SlimSellerManagementTeam>) resultMap.get(Macro.MANAGEMENTTEAMS);
            count = slim0107IDao.saveSellerManagementTeams(managementTeams);
            smtIds = (List<Long>) resultMap.get(Macro.SMT_IDS);
        }
        result.setCount(count);
        result.setSmtIds(smtIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0107IParam
     * @return
     */
    private Map<String,Object> handelParam(SLIM0107IParam slim0107IParam){
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0107SellerManagementTeamParam> params = slim0107IParam.getManagementTeams();
        List<Long> smtIds = new ArrayList<>();
        List<SlimSellerManagementTeam> managementTeams = new ArrayList<>();
        for(SLIM0107SellerManagementTeamParam param : params){
            SlimSellerManagementTeam managementTeam = BeanUtils.toBean(param,SlimSellerManagementTeam.class);
            Long smtId = this.maxId(TableConstant.Name.SLIM_SELLER_MANAGEMENT_TEAM);
            managementTeam.setSmtId(smtId);
            managementTeam.setCrtId(userId);
            managementTeam.setCrtTime(current);
            managementTeam.setUpdId(userId);
            managementTeam.setUpdTime(current);

            managementTeams.add(managementTeam);
            smtIds.add(smtId);
        }
        resultMap.put(Macro.SMT_IDS,smtIds);
        resultMap.put(Macro.MANAGEMENTTEAMS,managementTeams);
        return  resultMap;
    }

}
