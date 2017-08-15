package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimProducerFactory;
import com.bms.slim.bean.entity.SlimProducerHonorCertificate;
import com.bms.slim.bean.param.SLIM0222IParam;
import com.bms.slim.bean.param.SLIM0225IParam;
import com.bms.slim.bean.param.field.SLIM0222ProducerHonorCertificateParam;
import com.bms.slim.bean.param.field.SLIM0225ProducerFactoryParam;
import com.bms.slim.bean.result.SLIM0222IResult;
import com.bms.slim.bean.result.SLIM0225IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0222IDao;
import com.bms.slim.dao.SLIM0225IDao;
import com.bms.slim.services.SLIM0222IService;
import com.bms.slim.services.SLIM0225IService;
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
public class SLIM0225IServiceImpl extends BaseServiceImpl implements SLIM0225IService {

    @Autowired
    private SLIM0225IDao slim0225IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0225IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERFACTORY = "producerFactory";
        String FACTORY_IDS = "factory_Ids";
    }

    @Override
    public SLIM0225IResult addProducerFactory(SLIM0225IParam slim0225IParam) {
        SLIM0225IResult result = new SLIM0225IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> facotryIds = new ArrayList<>();
        Map<String,Object> resultMap = handelParam(slim0225IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducerFactory> producerFactories = (List<SlimProducerFactory>) resultMap.get(Macro.PRODUCERFACTORY);
            count = slim0225IDao.saveProducerFactories(producerFactories);
            facotryIds = (List<Long>) resultMap.get(Macro.FACTORY_IDS);
        }
        result.setCount(count);
        result.setFactoryIds(facotryIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0225IParam
     * @return
     */
    private Map<String,Object> handelParam(SLIM0225IParam slim0225IParam){
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0225ProducerFactoryParam> params = slim0225IParam.getProducerFactoryParams();
        List<Long> factoryIds = new ArrayList<>();
        List<SlimProducerFactory> producerFactories = new ArrayList<>();
        for(SLIM0225ProducerFactoryParam param : params){
            SlimProducerFactory producerFactory = BeanUtils.toBean(param,SlimProducerFactory.class);
            Long factoryId = this.maxId(TableConstant.Name.SLIM_PRODUCER_FACTORY);
            producerFactory.setFactoryId(factoryId);
            producerFactory.setCrtId(userId);
            producerFactory.setCrtTime(current);
            producerFactory.setUpdId(userId);
            producerFactory.setUpdTime(current);

            producerFactories.add(producerFactory);
            factoryIds.add(factoryId);
        }
        resultMap.put(Macro.FACTORY_IDS,factoryIds);
        resultMap.put(Macro.PRODUCERFACTORY,producerFactories);
        return  resultMap;
    }

}
