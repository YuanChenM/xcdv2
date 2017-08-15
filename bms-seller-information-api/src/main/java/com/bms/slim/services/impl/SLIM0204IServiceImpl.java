package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimAnimalEpidemicPreventionConditionCertificate;
import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.param.SLIM0204IParam;
import com.bms.slim.bean.param.field.SLIM0204AnimalEpidemicPreventionConditionCertificateParam;
import com.bms.slim.bean.result.SLIM0204IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0204IDao;
import com.bms.slim.services.SLIM0204IService;
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
public class SLIM0204IServiceImpl extends BaseServiceImpl implements SLIM0204IService {

    @Autowired
    private SLIM0204IDao slim0204IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0204IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String AEPCC_IDS = "aepcc_ids";
        String ANIMAL_EPIDEMIC_PREVENTION_CONDITION_CERTIFICATE = "animal_epidemic_prevention_condition_certificate";
    }

    @Override
    public SLIM0204IResult saveAnimalEpidemicPreventionConditionCertificates(SLIM0204IParam slim0204IParam) {
        SLIM0204IResult result = new SLIM0204IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> aepccIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0204IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimAnimalEpidemicPreventionConditionCertificate> animalEpidemicPreventionConditionCertificates = (List<SlimAnimalEpidemicPreventionConditionCertificate>) resultMap.get(Macro.ANIMAL_EPIDEMIC_PREVENTION_CONDITION_CERTIFICATE);
            count = slim0204IDao.saveAnimalEpidemicPreventionConditionCertificates(animalEpidemicPreventionConditionCertificates);
            aepccIds = (List<Long>) resultMap.get(Macro.AEPCC_IDS);
        }
        result.setCount(count);
        result.setAepccIds(aepccIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0204IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0204IParam slim0204IParam) {
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0204AnimalEpidemicPreventionConditionCertificateParam> params = slim0204IParam.getSlim0204AnimalEpidemicPreventionConditionCertificateParams();
        List<Long> aepccIds = new ArrayList<>();
        List<SlimAnimalEpidemicPreventionConditionCertificate> animalEpidemicPreventionConditionCertificates = new ArrayList<>();
        for(SLIM0204AnimalEpidemicPreventionConditionCertificateParam param : params){
            SlimAnimalEpidemicPreventionConditionCertificate animalEpidemicPreventionConditionCertificate = BeanUtils.toBean(param, SlimAnimalEpidemicPreventionConditionCertificate.class);
            Long aepccId = this.maxId(TableConstant.Name.SLIM_ANIMAL_EPIDEMIC_PREVENTION_CONDITION_CERTIFICATE);
            animalEpidemicPreventionConditionCertificate.setAepccId(aepccId);
            animalEpidemicPreventionConditionCertificate.setCrtId(userId);
            animalEpidemicPreventionConditionCertificate.setCrtTime(current);
            animalEpidemicPreventionConditionCertificate.setUpdId(userId);
            animalEpidemicPreventionConditionCertificate.setUpdTime(current);

            animalEpidemicPreventionConditionCertificates.add(animalEpidemicPreventionConditionCertificate);
            aepccIds.add(aepccId);
        }
        resultMap.put(Macro.AEPCC_IDS,aepccIds);
        resultMap.put(Macro.ANIMAL_EPIDEMIC_PREVENTION_CONDITION_CERTIFICATE,animalEpidemicPreventionConditionCertificates);
        return  resultMap;
    }

}
