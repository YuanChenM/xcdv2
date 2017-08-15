package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimSeller;
import com.bms.slim.bean.param.SLIM0102IParam;
import com.bms.slim.bean.result.field.SLIM0102IEntitySellerResult;
import com.bms.slim.dao.SLIM0102IDao;
import com.bms.slim.services.SLIM0102IService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLIM0102IServiceImpl extends BaseServiceImpl implements SLIM0102IService {

    @Autowired
    private SLIM0102IDao slim0102iDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slim0102iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLIM0102IEntitySellerResult> findEntitySellers(SLIM0102IParam slim0102iParam) {
        BaseRestPaginationResult<SLIM0102IEntitySellerResult> restResult = super.findPageList(slim0102iParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLIM0102IEntitySellerResult> entitySellers) {
        if (CollectionUtils.isNotEmpty(entitySellers)) {
            this.fillContacts(entitySellers);
        }
    }

    /**
     * 实体卖家添加联系人
     */
    private void fillContacts(List<SLIM0102IEntitySellerResult> entitySellers) {
        Map<Long, List<SlimContact>> eidContactsMap = this.mappingEntitySellerIdToContacts(entitySellers);
        if (eidContactsMap == null || eidContactsMap.size() == NumberConst.IntDef.INT_ZERO) {
            return;
        }

        Long entitySellerId = null;
        for (SLIM0102IEntitySellerResult entitySeller : entitySellers) {
            entitySellerId = entitySeller.getEntitySellerId();
            entitySeller.setContactList(eidContactsMap.get(entitySellerId));
        }
    }

    /**
     * 实体卖家ID映射联系人
     */
    @SuppressWarnings("Duplicates")
    private Map<Long, List<SlimContact>> mappingEntitySellerIdToContacts(List<SLIM0102IEntitySellerResult> entitySellers) {
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
    private List<SlimContact> findContactsByEntitySellerIds(List<SLIM0102IEntitySellerResult> entitySellers) {
        Set<Long> workunitIdSet = new HashSet<>();
        for (SLIM0102IEntitySellerResult entitySeller : entitySellers) {
            workunitIdSet.add(entitySeller.getEntitySellerId());
        }

        if (CollectionUtils.isEmpty(workunitIdSet)) {
            return null;
        }
        List<Long> workunitIdList = new ArrayList<>(workunitIdSet);
        return this.slim0102iDao.findContactsByEntitySellerIds(workunitIdList);
    }

}
