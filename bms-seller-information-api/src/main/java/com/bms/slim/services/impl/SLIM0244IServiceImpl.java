package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.param.SLIM0244IParam;
import com.bms.slim.bean.param.field.SLIM0244IContactParam;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0244IDao;
import com.bms.slim.services.SLIM0244IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class SLIM0244IServiceImpl extends BaseServiceImpl implements SLIM0244IService {
    private static final Logger logger = getLogger(SLIM0244IServiceImpl.class);

    @Autowired
    private SLIM0244IDao slim0244IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0244IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> addContacts(SLIM0244IParam slim0244iParam) {
        List<SLIM0244IContactParam> params = slim0244iParam.getContactParams();
        List<Long> contactIds = null;
        if (CollectionUtils.isNotEmpty(params)) {
            Map<String, Object> paramMap = this.mappingParam(params);
            List<SlimContact> contacts = (List<SlimContact>) paramMap.get("list");
            contactIds = (List<Long>) paramMap.get("ids");
            this.slim0244IDao.saveContacts(contacts);
        }
        return contactIds;
    }

    /**
     * 重组新增卖家合同信息参数
     */
    private Map<String, Object> mappingParam(List<SLIM0244IContactParam> list) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        List<SlimContact> slimContacts = new ArrayList<>();
        SlimContact contact = null;
        List<Long> contactIds = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            for (SLIM0244IContactParam contactParam : list) {
                contact = BeanUtils.toBean(contactParam, SlimContact.class);
                contact.setContactId(this.maxId(TableConstant.Name.SLIM_CONTACT));
                contact.setCrtId(userId);
                contact.setUpdId(userId);
                contact.setCrtTime(current);
                contact.setUpdTime(current);
                slimContacts.add(contact);
                contactIds.add(contact.getContactId());
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("list", slimContacts);
        result.put("ids", contactIds);
        return result;
    }
}
