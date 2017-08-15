package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.param.SLIM0243IParam;
import com.bms.slim.bean.result.SLIM0243IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0243IDao;
import com.bms.slim.services.SLIM0243IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
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
public class SLIM0243IServiceImpl extends BaseServiceImpl implements SLIM0243IService {

    @Autowired
    private SLIM0243IDao slim0243IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0243IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCER_IDS = "producer_ids";
        String SELLER_PRODUCER_IDS = "seller_producer_ids";
        String RELATIONS = "relations";
    }

    @Override
    public SLIM0243IResult saveSellerProducers(SLIM0243IParam slim0243IParam) {
        SLIM0243IResult result = new SLIM0243IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sellerProducerIds = new ArrayList<>();
        List<Long> producerIds = new ArrayList<>();
        Map<String, Object> resultMap = handelProducerInfo(slim0243IParam);
        if (MapUtils.isNotEmpty(resultMap)) {
            List<SlimSellerProducer> slimSellerProducerRelations = (List<SlimSellerProducer>) resultMap.get(Macro.RELATIONS);
            //添加卖家生产商关联
            Map<String, Object> map = new HashedMap();
            map.put("li", slimSellerProducerRelations);
            count = slim0243IDao.saveSellerProducers(map);
            //新增卖家生产商关联ID
            sellerProducerIds = (List<Long>) resultMap.get(Macro.SELLER_PRODUCER_IDS);
            //关联生产商ID
            producerIds = (List<Long>) resultMap.get(Macro.PRODUCER_IDS);
        }
        result.setCount(count);
        result.setProducerIds(producerIds);
        result.setSellerProducerIds(sellerProducerIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0243IParam
     * @return
     */
    private Map<String, Object> handelProducerInfo(SLIM0243IParam slim0243IParam) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String, Object> resultMap = new HashedMap();
        List<SlimSellerProducer> params = slim0243IParam.getSellerProducers();
        List<Long> producerIds = new ArrayList<>();
        List<Long> sellerProducerIds = new ArrayList<>();
        List<SlimSellerProducer> slimSellerProducers = new ArrayList<>();
        for (SlimSellerProducer sellerProducer : params) {
            //卖家生产商关联
            Long sellerProducerId = this.maxId(TableConstant.Name.SLIM_SELLER_PRODUCER);
            sellerProducer.setSellerProducerId(sellerProducerId);
            sellerProducer.setCrtId(userId);
            sellerProducer.setCrtTime(current);
            sellerProducer.setUpdId(userId);
            sellerProducer.setUpdTime(current);
            producerIds.add(sellerProducer.getProducerId());
            sellerProducerIds.add(sellerProducerId);
            slimSellerProducers.add(sellerProducer);
        }
        resultMap.put(Macro.PRODUCER_IDS, producerIds);
        resultMap.put(Macro.SELLER_PRODUCER_IDS, sellerProducerIds);
        resultMap.put(Macro.RELATIONS, slimSellerProducers);
        return resultMap;
    }

}
