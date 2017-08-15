package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerBusinessTeam;
import com.bms.slim.bean.param.SLIM0119IParam;
import com.bms.slim.bean.param.field.SLIM0119SellerBusinessTeamParam;
import com.bms.slim.bean.result.SLIM0119IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0119IDao;
import com.bms.slim.services.SLIM0119IService;
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
public class SLIM0119IServiceImpl extends BaseServiceImpl implements SLIM0119IService {

    @Autowired
    private SLIM0119IDao slim0119IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0119IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String BUSINESSTEAMS = "businessTeams";
        String SBT_IDS = "sbt_ids";
    }

    @Override
    public SLIM0119IResult addSellerBusinessTeams(SLIM0119IParam slim0119IParam) {
        SLIM0119IResult result = new SLIM0119IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sbtIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0119IParam);
        if (MapUtils.isNotEmpty(resultMap)) {
            List<SlimSellerBusinessTeam> managementTeams = (List<SlimSellerBusinessTeam>) resultMap.get(Macro.BUSINESSTEAMS);
            count = slim0119IDao.saveSellerBusinessTeams(managementTeams);
            sbtIds = (List<Long>) resultMap.get(Macro.SBT_IDS);
        }
        result.setCount(count);
        result.setSbtIds(sbtIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0119IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0119IParam slim0119IParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String, Object> resultMap = new HashedMap();
        List<SLIM0119SellerBusinessTeamParam> params = slim0119IParam.getBusinessTeams();
        List<Long> sbtIds = new ArrayList<>();
        List<SlimSellerBusinessTeam> businessTeams = new ArrayList<>();
        for (SLIM0119SellerBusinessTeamParam param : params) {
            SlimSellerBusinessTeam businessTeam = BeanUtils.toBean(param, SlimSellerBusinessTeam.class);
            Long sbtId = this.maxId(TableConstant.Name.SLIM_SELLER_BUSINESS_TEAM);
            businessTeam.setSbtId(sbtId);
            businessTeam.setCrtId(userId);
            businessTeam.setCrtTime(current);
            businessTeam.setUpdId(userId);
            businessTeam.setUpdTime(current);

            businessTeams.add(businessTeam);
            sbtIds.add(sbtId);
        }
        resultMap.put(Macro.SBT_IDS, sbtIds);
        resultMap.put(Macro.BUSINESSTEAMS, businessTeams);
        return resultMap;
    }

}
