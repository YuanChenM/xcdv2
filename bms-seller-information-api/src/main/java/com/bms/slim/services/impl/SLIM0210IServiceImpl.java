package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimHalalFoodProductionOperationLicense;
import com.bms.slim.bean.param.SLIM0210IParam;
import com.bms.slim.bean.param.field.SLIM0210HalalFoodProductionOperationLicenseParam;
import com.bms.slim.bean.result.SLIM0210IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0210IDao;
import com.bms.slim.services.SLIM0210IService;
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
public class SLIM0210IServiceImpl extends BaseServiceImpl implements SLIM0210IService {

    @Autowired
    private SLIM0210IDao slim0210IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0210IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String HFPOL_IDS = "hfpolIds";
        String HALAL_FOOD_PRODUCTION_OPERATION_LICENSE = "halalFoodProductionOperationLicense";
    }

    @Override
    public SLIM0210IResult saveHalalFoodProductionOperationLicenses(SLIM0210IParam slim0210IParam) {
        SLIM0210IResult result = new SLIM0210IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> hfpolIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0210IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimHalalFoodProductionOperationLicense> halalFoodProductionOperationLicenses = (List<SlimHalalFoodProductionOperationLicense>) resultMap.get(Macro.HALAL_FOOD_PRODUCTION_OPERATION_LICENSE);
            count = slim0210IDao.saveHalalFoodProductionOperationLicenses(halalFoodProductionOperationLicenses);
            hfpolIds = (List<Long>) resultMap.get(Macro.HFPOL_IDS);
        }
        result.setCount(count);
        result.setHfpolIds(hfpolIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0210IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0210IParam slim0210IParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0210HalalFoodProductionOperationLicenseParam> params = slim0210IParam.getSlim0210HalalFoodProductionOperationLicenseParams();
        List<Long> hfpolIds = new ArrayList<>();
        List<SlimHalalFoodProductionOperationLicense> halalFoodProductionOperationLicenses = new ArrayList<>();
        for(SLIM0210HalalFoodProductionOperationLicenseParam param : params){
            SlimHalalFoodProductionOperationLicense halalFoodProductionOperationLicense = BeanUtils.toBean(param, SlimHalalFoodProductionOperationLicense.class);
            Long hfpolId = this.maxId(TableConstant.Name.SLIM_HALAL_FOOD_PRODUCTION_OPERATION_LICENSE);
            halalFoodProductionOperationLicense.setHfpolId(hfpolId);
            halalFoodProductionOperationLicense.setCrtId(userId);
            halalFoodProductionOperationLicense.setCrtTime(current);
            halalFoodProductionOperationLicense.setUpdId(userId);
            halalFoodProductionOperationLicense.setUpdTime(current);

            halalFoodProductionOperationLicenses.add(halalFoodProductionOperationLicense);
            hfpolIds.add(hfpolId);
        }
        resultMap.put(Macro.HFPOL_IDS,hfpolIds);
        resultMap.put(Macro.HALAL_FOOD_PRODUCTION_OPERATION_LICENSE,halalFoodProductionOperationLicenses);
        return  resultMap;
    }

}
