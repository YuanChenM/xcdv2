package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimProducerLaboratory;
import com.bms.slim.bean.param.SLIM0234IParam;
import com.bms.slim.bean.param.field.SLIM0234ProducerLaboratoryParam;
import com.bms.slim.bean.result.SLIM0234IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0234IDao;
import com.bms.slim.services.SLIM0234IService;
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
public class SLIM0234IServiceImpl extends BaseServiceImpl implements SLIM0234IService {

    @Autowired
    private SLIM0234IDao slim0234IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0234IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERLABORATORY = "producerLaboratory";
        String LABORATORY_IDS = "laboratory_ids";
    }

    @Override
    public SLIM0234IResult addProducerLaboratories(SLIM0234IParam slim0234IParam) {
        SLIM0234IResult result = new SLIM0234IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> laboratoryIds = new ArrayList<>();
        Map<String,Object> resultMap = handelParam(slim0234IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducerLaboratory> producerLaboratories = (List<SlimProducerLaboratory>) resultMap.get(Macro.PRODUCERLABORATORY);
            count = slim0234IDao.saveProducerLaboratories(producerLaboratories);
            laboratoryIds = (List<Long>) resultMap.get(Macro.LABORATORY_IDS);
        }
        result.setCount(count);
        result.setLaboratoryIds(laboratoryIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0234IParam
     * @return
     */
    private Map<String,Object> handelParam(SLIM0234IParam slim0234IParam){
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0234ProducerLaboratoryParam> params = slim0234IParam.getProducerLaboratories();
        List<Long> laboratoryIds = new ArrayList<>();
        List<SlimProducerLaboratory> producerLaboratories = new ArrayList<>();
        for(SLIM0234ProducerLaboratoryParam param : params){
            SlimProducerLaboratory producerLaboratory = BeanUtils.toBean(param,SlimProducerLaboratory.class);
            Long laboratoryId = this.maxId(TableConstant.Name.SLIM_PRODUCER_LABORATORY);
            producerLaboratory.setLaboratoryId(laboratoryId);
            producerLaboratory.setCrtId(userId);
            producerLaboratory.setCrtTime(current);
            producerLaboratory.setUpdId(userId);
            producerLaboratory.setUpdTime(current);

            producerLaboratories.add(producerLaboratory);
            laboratoryIds.add(laboratoryId);
        }
        resultMap.put(Macro.LABORATORY_IDS,laboratoryIds);
        resultMap.put(Macro.PRODUCERLABORATORY,producerLaboratories);
        return  resultMap;
    }

}
