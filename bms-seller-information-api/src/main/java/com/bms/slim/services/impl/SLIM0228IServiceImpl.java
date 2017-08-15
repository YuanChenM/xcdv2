package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimProducerWorkshop;
import com.bms.slim.bean.param.SLIM0228IParam;
import com.bms.slim.bean.param.field.SLIM0228ProducerWorkShopParam;
import com.bms.slim.bean.result.SLIM0228IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0228IDao;
import com.bms.slim.services.SLIM0228IService;
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
public class SLIM0228IServiceImpl extends BaseServiceImpl implements SLIM0228IService {

    @Autowired
    private SLIM0228IDao slim0228IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0228IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERWORKSHOPS = "producerWorkshops";
        String WORK_SHOPIDS = "work_shopIds";
    }

    @Override
    public SLIM0228IResult addProducerWorkShops(SLIM0228IParam slim0228IParam) {
        SLIM0228IResult result = new SLIM0228IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> workshopIds = new ArrayList<>();
        Map<String,Object> resultMap = handelParam(slim0228IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducerWorkshop> producerWorkshops = (List<SlimProducerWorkshop>) resultMap.get(Macro.PRODUCERWORKSHOPS);
            count = slim0228IDao.saveProducerWorkShops(producerWorkshops);
            workshopIds = (List<Long>) resultMap.get(Macro.WORK_SHOPIDS);
        }
        result.setCount(count);
        result.setWorkshopIds(workshopIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0228IParam
     * @return
     */
    private Map<String,Object> handelParam(SLIM0228IParam slim0228IParam){
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0228ProducerWorkShopParam> params = slim0228IParam.getProducerWorkShops();
        List<Long> workshopIds = new ArrayList<>();
        List<SlimProducerWorkshop> producerWorkshops = new ArrayList<>();
        for(SLIM0228ProducerWorkShopParam param : params){
            SlimProducerWorkshop producerWorkshop = BeanUtils.toBean(param,SlimProducerWorkshop.class);
            Long workshopId = this.maxId(TableConstant.Name.SLIM_PRODUCER_WORKSHOP);
            producerWorkshop.setWorkshopId(workshopId);
            producerWorkshop.setCrtId(userId);
            producerWorkshop.setCrtTime(current);
            producerWorkshop.setUpdId(userId);
            producerWorkshop.setUpdTime(current);

            producerWorkshops.add(producerWorkshop);
            workshopIds.add(workshopId);
        }
        resultMap.put(Macro.WORK_SHOPIDS,workshopIds);
        resultMap.put(Macro.PRODUCERWORKSHOPS,producerWorkshops);
        return  resultMap;
    }

}
