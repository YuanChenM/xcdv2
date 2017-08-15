package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimFoodProductionLicense;
import com.bms.slim.bean.param.SLIM0216IParam;
import com.bms.slim.bean.param.field.SLIM0216FoodProductionLicenseParam;
import com.bms.slim.bean.result.SLIM0216IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0216IDao;
import com.bms.slim.services.SLIM0216IService;
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
public class SLIM0216IServiceImpl extends BaseServiceImpl implements SLIM0216IService {

    @Autowired
    private SLIM0216IDao slim0216IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0216IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String FPL_IDS = "fplIds";
        String FOOD_PRODUCTION_LICENSE = "FoodProductionLicense";
    }

    @Override
    public SLIM0216IResult saveFoodProductionLicense(SLIM0216IParam slim0216IParam) {
        SLIM0216IResult result = new SLIM0216IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> fplIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0216IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimFoodProductionLicense> foodProductionLicenses = (List<SlimFoodProductionLicense>) resultMap.get(Macro.FOOD_PRODUCTION_LICENSE);
            count = slim0216IDao.saveFoodProductionLicense(foodProductionLicenses);
            fplIds = (List<Long>) resultMap.get(Macro.FPL_IDS);
        }
        result.setCount(count);
        result.setFplIds(fplIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0216IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0216IParam slim0216IParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0216FoodProductionLicenseParam> params = slim0216IParam.getSlim0216FoodProductionLicenseParams();
        List<Long> fplIds = new ArrayList<>();
        List<SlimFoodProductionLicense> slimFoodProductionLicenses = new ArrayList<>();
        for(SLIM0216FoodProductionLicenseParam param : params){
            SlimFoodProductionLicense slimFoodProductionLicense = BeanUtils.toBean(param, SlimFoodProductionLicense.class);
            Long fplId = this.maxId(TableConstant.Name.SLIM_FOOD_PRODUCTION_LICENSE);
            slimFoodProductionLicense.setFplId(fplId);
            slimFoodProductionLicense.setCrtId(userId);
            slimFoodProductionLicense.setCrtTime(current);
            slimFoodProductionLicense.setUpdId(userId);
            slimFoodProductionLicense.setUpdTime(current);

            slimFoodProductionLicenses.add(slimFoodProductionLicense);
            fplIds.add(fplId);
        }
        resultMap.put(Macro.FPL_IDS,fplIds);
        resultMap.put(Macro.FOOD_PRODUCTION_LICENSE,slimFoodProductionLicenses);
        return  resultMap;
    }

}
