package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimManufacturerSupplyQualification;
import com.bms.slim.bean.param.SLIM0113IParam;
import com.bms.slim.bean.param.field.SLIM0113ManufacturerSupplyQualificationParam;
import com.bms.slim.bean.result.SLIM0113IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0113IDao;
import com.bms.slim.services.SLIM0113IService;
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
public class SLIM0113IServiceImpl extends BaseServiceImpl implements SLIM0113IService {

    @Autowired
    private SLIM0113IDao slim0113IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0113IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String MSQ_IDS = "msq_ids";
        String MANUFACTURER_SUPPLY_QUALIFICATION = "manufacturer_supply_qualification";
    }

    @Override
    public SLIM0113IResult saveManufacturerSupplyQualification(SLIM0113IParam slim0113IParam) {
        SLIM0113IResult result = new SLIM0113IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> msqIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0113IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimManufacturerSupplyQualification> manufacturerSupplyQualifications = (List<SlimManufacturerSupplyQualification>) resultMap.get(Macro.MANUFACTURER_SUPPLY_QUALIFICATION);
            count = slim0113IDao.saveManufacturerSupplyQualification(manufacturerSupplyQualifications);
            msqIds = (List<Long>) resultMap.get(Macro.MSQ_IDS);
        }
        result.setCount(count);
        result.setMsqIds(msqIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0113IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0113IParam slim0113IParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0113ManufacturerSupplyQualificationParam> params = slim0113IParam.getSlim0113ManufacturerSupplyQualificationParams();
        List<Long> msqIds = new ArrayList<>();
        List<SlimManufacturerSupplyQualification> manufacturerSupplyQualifications = new ArrayList<>();
        for(SLIM0113ManufacturerSupplyQualificationParam param : params){
            SlimManufacturerSupplyQualification manufacturerSupplyQualification = BeanUtils.toBean(param, SlimManufacturerSupplyQualification.class);
            Long msqId = this.maxId(TableConstant.Name.SLIM_MANUFACTURER_SUPPLY_QUALIFICATION);
            manufacturerSupplyQualification.setMsqId(msqId);
            manufacturerSupplyQualification.setCrtId(userId);
            manufacturerSupplyQualification.setCrtTime(current);
            manufacturerSupplyQualification.setUpdId(userId);
            manufacturerSupplyQualification.setUpdTime(current);

            manufacturerSupplyQualifications.add(manufacturerSupplyQualification);
            msqIds.add(msqId);
        }
        resultMap.put(Macro.MSQ_IDS,msqIds);
        resultMap.put(Macro.MANUFACTURER_SUPPLY_QUALIFICATION,manufacturerSupplyQualifications);
        return  resultMap;
    }

}
