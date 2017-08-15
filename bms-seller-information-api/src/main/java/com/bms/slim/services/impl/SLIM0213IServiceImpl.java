package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimShBjTjRegistration;
import com.bms.slim.bean.param.SLIM0213IParam;
import com.bms.slim.bean.param.field.SLIM0213ShBjTjRegistrationParam;
import com.bms.slim.bean.result.SLIM0213IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0213IDao;
import com.bms.slim.services.SLIM0213IService;
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
public class SLIM0213IServiceImpl extends BaseServiceImpl implements SLIM0213IService {

    @Autowired
    private SLIM0213IDao slim0213IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0213IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String SBT_REG_IDS = "sbtRegIds";
        String SH_BJ_TJ_REGISTRATION = "ShBjTjRegistration";
    }

    @Override
    public SLIM0213IResult saveShBjTjRegistrations(SLIM0213IParam slim0213IParam) {
        SLIM0213IResult result = new SLIM0213IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sbtRegIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0213IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimShBjTjRegistration> shBjTjRegistrations = (List<SlimShBjTjRegistration>) resultMap.get(Macro.SH_BJ_TJ_REGISTRATION);
            count = slim0213IDao.saveShBjTjRegistrations(shBjTjRegistrations);
            sbtRegIds = (List<Long>) resultMap.get(Macro.SBT_REG_IDS);
        }
        result.setCount(count);
        result.setSbtRegIds(sbtRegIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0213IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0213IParam slim0213IParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0213ShBjTjRegistrationParam> params = slim0213IParam.getSlim0213ShBjTjRegistrationParams();
        List<Long> sbtRegIds = new ArrayList<>();
        List<SlimShBjTjRegistration> slimShBjTjRegistrations = new ArrayList<>();
        for(SLIM0213ShBjTjRegistrationParam param : params){
            SlimShBjTjRegistration slimShBjTjRegistration = BeanUtils.toBean(param, SlimShBjTjRegistration.class);
            Long sbtRegId = this.maxId(TableConstant.Name.SLIM_SH_BJ_TJ_REGISTRATION);
            slimShBjTjRegistration.setSbtRegId(sbtRegId);
            slimShBjTjRegistration.setCrtId(userId);
            slimShBjTjRegistration.setCrtTime(current);
            slimShBjTjRegistration.setUpdId(userId);
            slimShBjTjRegistration.setUpdTime(current);

            slimShBjTjRegistrations.add(slimShBjTjRegistration);
            sbtRegIds.add(sbtRegId);
        }
        resultMap.put(Macro.SBT_REG_IDS,sbtRegIds);
        resultMap.put(Macro.SH_BJ_TJ_REGISTRATION,slimShBjTjRegistrations);
        return  resultMap;
    }

}
