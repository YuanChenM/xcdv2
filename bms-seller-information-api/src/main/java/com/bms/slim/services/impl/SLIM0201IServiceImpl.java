package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.param.SLIM0201IParam;
import com.bms.slim.bean.param.wrapper.SlimContactParam;
import com.bms.slim.bean.result.SLIM0201IResult;
import com.bms.slim.constant.CodeMasterConstant;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0201IDao;
import com.bms.slim.services.SLIM0201IService;
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
public class SLIM0201IServiceImpl extends BaseServiceImpl implements SLIM0201IService {

    private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SLIM0201IServiceImpl.class);

    @Autowired
    private SLIM0201IDao slim0201IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0201IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERS = "producers";
        String CONTACTS = "contacts";
        String PRODUCER_IDS = "producer_ids";
        String RELATIONS = "relations";
    }

    @Override
    public SLIM0201IResult saveSellerProducers(SLIM0201IParam slim0201IParam) {
        logger.debug("新增卖家生产商开始: 入参=" + slim0201IParam);
        SLIM0201IResult result = new SLIM0201IResult();
        int producerCount = NumberConst.IntDef.INT_ZERO;
        List<Long> producerIds = new ArrayList<>();
        Map<String,Object> resultMap = handelProducerInfo(slim0201IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducer> producers = (List<SlimProducer>) resultMap.get(Macro.PRODUCERS);
            SlimContact contact = (SlimContact) resultMap.get(Macro.CONTACTS);
            List<SlimSellerProducer> slimSellerProducerRelations = (List<SlimSellerProducer>) resultMap.get(Macro.RELATIONS);
            producerCount = slim0201IDao.saveSellerProducers(producers);
            logger.debug("新增卖家生产商数量: " + producerCount);
            //添加生产商联系人
            saveProducerContacts(contact);
            //添加卖家生产商关联
            Map<String,Object> li = new HashedMap();
            li.put("li",slimSellerProducerRelations);
            saveSellerProducerRelations(li);
            //新增的生产商ID
            producerIds = (List<Long>) resultMap.get(Macro.PRODUCER_IDS);

        }
        result.setCount(producerCount);
        result.setProducerIds(producerIds);
        logger.debug("新增卖家生产商结束");
        return result;
    }


    /**
     * 处理数据
     * @param slim0201IParam
     * @return
     */
    private Map<String,Object> handelProducerInfo(SLIM0201IParam slim0201IParam){
        Date current = DateUtils.getCurrent();
        String userId = super.getLoginUserId();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0201IParam> params = slim0201IParam.getProducers();
        List<Long> producerIds = new ArrayList<>();
        List<SlimProducer> producers = new ArrayList<>();
        List<SlimSellerProducer> slimSellerProducerRelations = new ArrayList<>();
        for(SLIM0201IParam param : params){
            //生产商
            SlimProducer producer = BeanUtils.toBean(param, SlimProducer.class);
            Long producerId = this.maxId(TableConstant.Name.SLIM_PRODUCER);
            producer.setProducerCode("SCC" + producerId);//TODO 生产商编码规则
            producer.setAuditStu(CodeMasterConstant.ProducerAuditStu.PENDING);
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
            SlimContact slimContact = BeanUtils.toBean(contactParam, SlimContact.class);
            //卖家生产商关联
            Long relationId = this.maxId(TableConstant.Name.SLIM_SELLER_PRODUCER);
            SlimSellerProducer sellerProducer = BeanUtils.toBean(param, SlimSellerProducer.class);
            sellerProducer.setSellerProducerId(relationId);
            sellerProducer.setProducerId(producerId);
            sellerProducer.setUpdId(userId);
            sellerProducer.setUpdTime(current);
            slimSellerProducerRelations.add(sellerProducer);

            resultMap.put(Macro.CONTACTS,slimContact);
            resultMap.put(Macro.PRODUCER_IDS,producerIds);
            resultMap.put(Macro.RELATIONS,slimSellerProducerRelations);
            resultMap.put(Macro.PRODUCERS,producers);
        }
        return  resultMap;
    }

    /**
     * 新增卖家生产商关联
     * @param map
     * @return
     */
    public void saveSellerProducerRelations(Map<String,Object> map) {
        logger.debug("新增卖家生产商关联开始");
        slim0201IDao.saveSellerProducerRelations(map);
        logger.debug("新增卖家生产商关联结束");
    }


    /**
     * 新增生产商联系人
     * @param contact
     * @return
     */
    public int saveProducerContacts(SlimContact contact) {
        logger.debug("新增生产商联系人开始");
        int count = slim0201IDao.saveProducerContact(contact);
        logger.debug("新增生产商联系人关联结束");
        return count;
    }

}
