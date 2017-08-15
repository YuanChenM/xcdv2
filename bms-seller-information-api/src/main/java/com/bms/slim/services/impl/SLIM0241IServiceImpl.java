package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.bms.slim.bean.param.SLIM024101IParam;
import com.bms.slim.bean.param.SLIM0241IParam;
import com.bms.slim.bean.param.wrapper.SlimContactParam;
import com.bms.slim.bean.result.SLIM0241IResult;
import com.bms.slim.constant.CodeMasterConstant;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0241IDao;
import com.bms.slim.services.SLIM0241IService;
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
public class SLIM0241IServiceImpl extends BaseServiceImpl implements SLIM0241IService {

    @Autowired
    private SLIM0241IDao slim0241IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0241IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERS = "producers";
        String CONTACTS = "contacts";
        String PRODUCER_IDS = "producer_ids";
    }

    @Override
    public SLIM0241IResult saveProducers(SLIM0241IParam slim0241IParam) {
        SLIM0241IResult result = new SLIM0241IResult();
        int producerCount = NumberConst.IntDef.INT_ZERO;
        List<Long> producerIds = new ArrayList<>();
        Map<String,Object> resultMap = handelProducerInfo(slim0241IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducer> producers = (List<SlimProducer>) resultMap.get(Macro.PRODUCERS);
            SlimContact contact = (SlimContact) resultMap.get(Macro.CONTACTS);
            producerCount = slim0241IDao.saveProducers(producers);
            //添加生产商联系人
            slim0241IDao.saveProducerContact(contact);
            //新增的生产商ID
            producerIds = (List<Long>) resultMap.get(Macro.PRODUCER_IDS);

        }
        result.setCount(producerCount);
        result.setProducerIds(producerIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0241IParam
     * @return
     */
    private Map<String,Object> handelProducerInfo(SLIM0241IParam slim0241IParam){
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM024101IParam> params = slim0241IParam.getProducers();
        List<Long> producerIds = new ArrayList<>();
        List<SlimProducer> producers = new ArrayList<>();
        SlimContact slimContact = null;
        for(SLIM024101IParam param : params){
            //生产商
            SlimProducer producer = BeanUtils.toBean(param, SlimProducer.class);
            Long producerId = this.maxId(TableConstant.Name.SLIM_PRODUCER);
            producer.setProducerCode("SCC" + producerId);//TODO 生产商编码规则
            producer.setAuditStu(CodeMasterConstant.ProducerAuditStu.PENDING);
            producer.setCrtId(userId);
            producer.setCrtTime(current);
            producer.setUpdId(userId);
            producer.setUpdTime(current);
            producer.setProducerId(producerId);
            producerIds.add(producerId);
            producers.add(producer);

            //生产商联系人
            Long contactId = this.maxId(TableConstant.Name.SLIM_CONTACT);
            SlimContactParam contactParam = new SlimContactParam();
            contactParam.setContactId(contactId);
            contactParam.setWorkunitId(producerId);
            contactParam.setContactName(param.getContactName());
            contactParam.setMobile(param.getMobile());
            contactParam.setEmail(param.getEmail());
            contactParam.setQq(param.getQq());
            contactParam.setWechat(param.getWechat());
            contactParam.setCrtId(userId);
            contactParam.setCrtTime(current);
            contactParam.setUpdId(userId);
            contactParam.setUpdTime(current);
            slimContact = BeanUtils.toBean(contactParam, SlimContact.class);
        }
        resultMap.put(Macro.CONTACTS,slimContact);
        resultMap.put(Macro.PRODUCER_IDS,producerIds);
        resultMap.put(Macro.PRODUCERS,producers);
        return  resultMap;
    }

}
