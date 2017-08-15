package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.param.SLIM0250IParam;
import com.bms.slim.bean.result.field.SLIM0250IEntitySellerResult;
import com.bms.slim.dao.SLIM0102IDao;
import com.bms.slim.dao.SLIM0250IDao;
import com.bms.slim.services.SLIM0250IService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLIM0250IServiceImpl extends BaseServiceImpl implements SLIM0250IService {

    @Autowired
    private SLIM0102IDao slim0102iDao;
    @Autowired
    private SLIM0250IDao slim0250iDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slim0250iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLIM0250IEntitySellerResult> findEntitySellers(SLIM0250IParam slim0250iParam) {
        BaseRestPaginationResult<SLIM0250IEntitySellerResult> restResult = super.findPageList(slim0250iParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLIM0250IEntitySellerResult> entitySellers) {
        if (CollectionUtils.isNotEmpty(entitySellers)) {
            this.fillContacts(entitySellers);
        }
    }

    /**
     * 实体卖家添加联系人
     */
    private void fillContacts(List<SLIM0250IEntitySellerResult> entitySellers) {
        Map<Long, List<SlimContact>> eidContactsMap = this.mappingEntitySellerIdToContacts(entitySellers);
        if (eidContactsMap == null || eidContactsMap.size() == NumberConst.IntDef.INT_ZERO) {
            return;
        }

        Long entitySellerId = null;
        for (SLIM0250IEntitySellerResult entitySeller : entitySellers) {
            entitySellerId = entitySeller.getEntitySellerId();
            entitySeller.setContactList(eidContactsMap.get(entitySellerId));
        }
    }

    /**
     * 实体卖家ID映射联系人
     */
    @SuppressWarnings("Duplicates")
    private Map<Long, List<SlimContact>> mappingEntitySellerIdToContacts(List<SLIM0250IEntitySellerResult> entitySellers) {
        List<SlimContact> contacts = this.findContactsByEntitySellerIds(entitySellers);
        if (CollectionUtils.isEmpty(contacts)) {
            return null;
        }

        Map<Long, List<SlimContact>> eidContactsMap = new HashMap<>();
        List<SlimContact> values = null;
        Long entitySellerId = null;

        for (SlimContact contact : contacts) {
            entitySellerId = contact.getWorkunitId();
            if (eidContactsMap.containsKey(entitySellerId)) {
                values = eidContactsMap.get(entitySellerId);
                values.add(contact);
            }
            else {
                values = new LinkedList<>();
                values.add(contact);
                eidContactsMap.put(entitySellerId, values);
            }
        }
        return eidContactsMap;
    }

    /**
     * 根据实体卖家ID，批量查询联系人
     */
    private List<SlimContact> findContactsByEntitySellerIds(List<SLIM0250IEntitySellerResult> entitySellers) {
        Set<Long> workunitIdSet = new HashSet<>();
        for (SLIM0250IEntitySellerResult entitySeller : entitySellers) {
            workunitIdSet.add(entitySeller.getEntitySellerId());
        }

        if (CollectionUtils.isEmpty(workunitIdSet)) {
            return null;
        }
        List<Long> workunitIdList = new ArrayList<>(workunitIdSet);
        return this.slim0102iDao.findContactsByEntitySellerIds(workunitIdList);
    }

}
