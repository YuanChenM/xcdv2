package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimProducerStorageCapacity;
import com.bms.slim.bean.param.SLIM0231IParam;
import com.bms.slim.bean.param.field.SLIM0231ProducerStorageCapacityParam;
import com.bms.slim.bean.result.SLIM0231IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0231IDao;
import com.bms.slim.services.SLIM0231IService;
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
public class SLIM0231IServiceImpl extends BaseServiceImpl implements SLIM0231IService {

    @Autowired
    private SLIM0231IDao slim0231IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0231IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERSTORAGECAPACITIES = "producerStorageCapacities";
        String STORAGECAPACITY_IDS = "storageCapacity_Ids";
    }

    @Override
    public SLIM0231IResult addProducerStorageCapacities(SLIM0231IParam slim0231IParam) {
        SLIM0231IResult result = new SLIM0231IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> storageCapacityIds = new ArrayList<>();
        Map<String,Object> resultMap = handelParam(slim0231IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducerStorageCapacity> producerStorageCapacities = (List<SlimProducerStorageCapacity>) resultMap.get(Macro.PRODUCERSTORAGECAPACITIES);
            count = slim0231IDao.saveProducerStorageCapacities(producerStorageCapacities);
            storageCapacityIds = (List<Long>) resultMap.get(Macro.STORAGECAPACITY_IDS);
        }
        result.setCount(count);
        result.setStorageCapacityIds(storageCapacityIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0231IParam
     * @return
     */
    private Map<String,Object> handelParam(SLIM0231IParam slim0231IParam){
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0231ProducerStorageCapacityParam> params = slim0231IParam.getProducerStorageCapacitys();
        List<Long> storageCapacityIds = new ArrayList<>();
        List<SlimProducerStorageCapacity> producerStorageCapacities = new ArrayList<>();
        for(SLIM0231ProducerStorageCapacityParam param : params){
            SlimProducerStorageCapacity producerStorageCapacity = BeanUtils.toBean(param,SlimProducerStorageCapacity.class);
            Long storageCapacityId = this.maxId(TableConstant.Name.SLIM_PRODUCER_STORAGE_CAPACITY);
            producerStorageCapacity.setStorageCapacityId(storageCapacityId);
            producerStorageCapacity.setCrtId(userId);
            producerStorageCapacity.setCrtTime(current);
            producerStorageCapacity.setUpdId(userId);
            producerStorageCapacity.setUpdTime(current);

            producerStorageCapacities.add(producerStorageCapacity);
            storageCapacityIds.add(storageCapacityId);
        }
        resultMap.put(Macro.STORAGECAPACITY_IDS,storageCapacityIds);
        resultMap.put(Macro.PRODUCERSTORAGECAPACITIES,producerStorageCapacities);
        return  resultMap;
    }

}
