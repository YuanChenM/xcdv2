package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimIsoManagementSystemCertification;
import com.bms.slim.bean.param.SLIM0219IParam;
import com.bms.slim.bean.param.field.SLIM0219IsoManagementSystemCertificationParam;
import com.bms.slim.bean.result.SLIM0219IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0219IDao;
import com.bms.slim.services.SLIM0219IService;
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
public class SLIM0219IServiceImpl extends BaseServiceImpl implements SLIM0219IService {

    @Autowired
    private SLIM0219IDao slim0219IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0219IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String ISO_MSC_IDS = "isoMscIds";
        String ISO_MANAGEMENT_SYSTEM_CERTIFICATION = "IsoManagementSystemCertification";
    }

    @Override
    public SLIM0219IResult saveIsoManagementSystemCertification(SLIM0219IParam slim0219IParam) {
        SLIM0219IResult result = new SLIM0219IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> isoMscIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0219IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimIsoManagementSystemCertification> isoManagementSystemCertifications = (List<SlimIsoManagementSystemCertification>) resultMap.get(Macro.ISO_MANAGEMENT_SYSTEM_CERTIFICATION);
            count = slim0219IDao.saveIsoManagementSystemCertification(isoManagementSystemCertifications);
            isoMscIds = (List<Long>) resultMap.get(Macro.ISO_MSC_IDS);
        }
        result.setCount(count);
        result.setIsoMscIds(isoMscIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0219IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0219IParam slim0219IParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0219IsoManagementSystemCertificationParam> params = slim0219IParam.getSlim0219IsoManagementSystemCertificationParams();
        List<Long> isoMscIds = new ArrayList<>();
        List<SlimIsoManagementSystemCertification> slimIsoManagementSystemCertifications = new ArrayList<>();
        for(SLIM0219IsoManagementSystemCertificationParam param : params){
            SlimIsoManagementSystemCertification slimIsoManagementSystemCertification = BeanUtils.toBean(param, SlimIsoManagementSystemCertification.class);
            Long isoMscId = this.maxId(TableConstant.Name.SLIM_ISO_MANAGEMENT_SYSTEM_CERTIFICATION);
            slimIsoManagementSystemCertification.setIsoMscId(isoMscId);
            slimIsoManagementSystemCertification.setCrtId(userId);
            slimIsoManagementSystemCertification.setCrtTime(current);
            slimIsoManagementSystemCertification.setUpdId(userId);
            slimIsoManagementSystemCertification.setUpdTime(current);

            slimIsoManagementSystemCertifications.add(slimIsoManagementSystemCertification);
            isoMscIds.add(isoMscId);
        }
        resultMap.put(Macro.ISO_MSC_IDS,isoMscIds);
        resultMap.put(Macro.ISO_MANAGEMENT_SYSTEM_CERTIFICATION,slimIsoManagementSystemCertifications);
        return  resultMap;
    }

}
