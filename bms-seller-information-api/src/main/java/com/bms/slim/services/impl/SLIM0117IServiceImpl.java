package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0117IParam;
import com.bms.slim.bean.param.SLIM0245IParam;
import com.bms.slim.bean.result.field.SLIM0117ISellerContractPermissionResult;
import com.bms.slim.bean.result.field.SLIM0245IContactResult;
import com.bms.slim.dao.SLIM0117IDao;
import com.bms.slim.services.SLIM0109IService;
import com.bms.slim.services.SLIM0117IService;
import com.bms.slim.services.SLIM0245IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class SLIM0117IServiceImpl extends BaseServiceImpl implements SLIM0117IService {
    private static final Logger logger = getLogger(SLIM0117IServiceImpl.class);

    @Autowired
    private SLIM0117IDao slim0117IDao;
    @Autowired
    private SLIM0245IService slim0245IService;

    @Override
    public BaseDao getBaseDao() {
        return slim0117IDao;
    }


    @Override
    public BaseRestPaginationResult<SLIM0117ISellerContractPermissionResult> findSCPs(SLIM0117IParam param) {
        BaseRestPaginationResult<SLIM0117ISellerContractPermissionResult> result = this.findPageList(param);
        this.fillContacts(result.getData());
        return result;
    }

    /**
     * 补充联系人信息集合
     */
    private void fillContacts(List<SLIM0117ISellerContractPermissionResult> resultList) {
        if (CollectionUtils.isNotEmpty(resultList)) {
            List<Long> workunitIds = new ArrayList<>();
            for (SLIM0117ISellerContractPermissionResult result : resultList) {
                workunitIds.add(result.getScpId());
            }
            SLIM0245IParam slim0245IParam = new SLIM0245IParam();
            slim0245IParam.setWorkunitIds(workunitIds);
            slim0245IParam.setPagination(null);
            slim0245IParam.setDelFlg(false);
            BaseRestPaginationResult<SLIM0245IContactResult> contactResults = this.slim0245IService.findContacts(slim0245IParam);

            Map<Long, List<SLIM0245IContactResult>> contactMap = new HashMap<>();
            List<SLIM0245IContactResult> contactList = contactResults.getData();
            if (CollectionUtils.isNotEmpty(contactList)) {
                List<SLIM0245IContactResult> contactResultList = null;
                Long workunitId = null;
                for (SLIM0245IContactResult contactResult : contactList) {
                    workunitId = contactResult.getWorkunitId();
                    if (!contactMap.containsKey(workunitId)) {
                        contactResultList = new ArrayList<>();
                        contactResultList.add(contactResult);
                        contactMap.put(workunitId, contactResultList);
                    } else {
                        contactMap.get(workunitId).add(contactResult);
                    }
                }
            }

            for (SLIM0117ISellerContractPermissionResult result : resultList) {
                result.setContacts(contactMap.get(result.getScpId()));
            }
        }
    }
}
