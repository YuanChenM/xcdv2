package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimProducerTestEquipment;
import com.bms.slim.bean.param.SLIM0237IParam;
import com.bms.slim.bean.param.field.SLIM0237ProducerTestEquipmentParam;
import com.bms.slim.bean.result.SLIM0237IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0237IDao;
import com.bms.slim.services.SLIM0237IService;
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
public class SLIM0237IServiceImpl extends BaseServiceImpl implements SLIM0237IService {

    @Autowired
    private SLIM0237IDao slim0237IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0237IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERTESTEQUIPMENTS = "producerTestEquipments";
        String TESTEQP_IDS = "testEqp_Ids";
    }

    @Override
    public SLIM0237IResult addProducerTestEquipments(SLIM0237IParam slim0237IParam) {
        SLIM0237IResult result = new SLIM0237IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> testEqpIds = new ArrayList<>();
        Map<String,Object> resultMap = handelParam(slim0237IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducerTestEquipment> producerTestEquipments = (List<SlimProducerTestEquipment>) resultMap.get(Macro.PRODUCERTESTEQUIPMENTS);
            count = slim0237IDao.saveProducerTestEquipments(producerTestEquipments);
            testEqpIds = (List<Long>) resultMap.get(Macro.TESTEQP_IDS);
        }
        result.setCount(count);
        result.setTestEqpIds(testEqpIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0237IParam
     * @return
     */
    private Map<String,Object> handelParam(SLIM0237IParam slim0237IParam){
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0237ProducerTestEquipmentParam> params = slim0237IParam.getProducerTestEquipments();
        List<Long> testEqpIds = new ArrayList<>();
        List<SlimProducerTestEquipment> producerTestEquipments = new ArrayList<>();
        for(SLIM0237ProducerTestEquipmentParam param : params){
            SlimProducerTestEquipment producerTestEquipment = BeanUtils.toBean(param,SlimProducerTestEquipment.class);
            Long testEqpId = this.maxId(TableConstant.Name.SLIM_PRODUCER_TEST_EQUIPMENT);
            producerTestEquipment.setTestEqpId(testEqpId);
            producerTestEquipment.setCrtId(userId);
            producerTestEquipment.setCrtTime(current);
            producerTestEquipment.setUpdId(userId);
            producerTestEquipment.setUpdTime(current);

            producerTestEquipments.add(producerTestEquipment);
            testEqpIds.add(testEqpId);
        }
        resultMap.put(Macro.TESTEQP_IDS,testEqpIds);
        resultMap.put(Macro.PRODUCERTESTEQUIPMENTS,producerTestEquipments);
        return  resultMap;
    }

}
