package com.bms.slpd.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.param.SLIM0250IParam;
import com.bms.slpd.bean.param.SLPD1805IParam;
import com.bms.slpd.bean.param.SLPD1806IParam;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.bms.slpd.bean.result.field.SLPD1806IManufacturerProducerProductResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD1806IDao;
import com.bms.slpd.services.SLPD1805IService;
import com.bms.slpd.services.SLPD1806IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD1806IServiceImpl extends BaseServiceImpl implements SLPD1806IService {

    @Autowired
    private SLPD1805IService slpd1805IService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD1806IDao slpd1806iDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd1806iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> findManufacturerProducts(SLPD1806IParam slpd1806iParam) {
        BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> restResult = super.findPageList(slpd1806iParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD1806IManufacturerProducerProductResult> manufacturerProducts) {
        if (CollectionUtils.isNotEmpty(manufacturerProducts)) {
            this.fillEntitySellerCodeAndName(manufacturerProducts);
            this.fillProducerProducts(manufacturerProducts);
        }
    }

    /**
     * 添加产品生产商信息
     */
    private void fillProducerProducts(List<SLPD1806IManufacturerProducerProductResult> manufacturerProducts) {
        Map<Long, List<SLPD1805IProductProducerResult>> producerResultMap = this.mappingPPidToProducerProdcut(manufacturerProducts);
        if (null == producerResultMap || NumberConst.IntDef.INT_ZERO == producerResultMap.size()) {
            return;
        }
        Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.AuditStu.NODE);

        Long producerProductId = null;
        for (SLPD1806IManufacturerProducerProductResult manufacturer : manufacturerProducts) {
            producerProductId = manufacturer.getProducerProductId();
            manufacturer.setProducerProducts(producerResultMap.get(producerProductId));
            manufacturer.setAuditStuStr(auditStuMap.get(manufacturer.getAuditStu()));
        }
    }

    /**
     * 产品生产商Id映射产品生产商
     */
    private Map<Long, List<SLPD1805IProductProducerResult>> mappingPPidToProducerProdcut(List<SLPD1806IManufacturerProducerProductResult> manufacturerProducerProducts) {
        List<SLPD1805IProductProducerResult> producerProducts = this.findProducerProducts(manufacturerProducerProducts);
        if (CollectionUtils.isEmpty(producerProducts)) {
            return null;
        }

        Map<Long, List<SLPD1805IProductProducerResult>> resultMap = new HashMap<>();
        List<SLPD1805IProductProducerResult> producerList = null;
        Long producerId = null;
        for (SLPD1805IProductProducerResult producerResult : producerProducts) {
            producerId = producerResult.getProducerProductId();
            if (!resultMap.containsKey(producerId)) {
                producerList = new ArrayList<>();
                producerList.add(producerResult);
                resultMap.put(producerId, producerList);
            } else {
                resultMap.get(producerId).add(producerResult);
            }
        }
        return resultMap;
    }

    /**
     * 根据产品生产商Ids查询产品生产商
     */
    private List<SLPD1805IProductProducerResult> findProducerProducts(List<SLPD1806IManufacturerProducerProductResult> manufacturerProducerProducts) {
        Set<Long> producerPrductIdSet = new HashSet<>();
        for (SLPD1806IManufacturerProducerProductResult manufacturer : manufacturerProducerProducts) {
            producerPrductIdSet.add(manufacturer.getProducerProductId());
        }

        if (CollectionUtils.isEmpty(producerPrductIdSet)) {
            return null;
        }
        List<Long> producerProdcutIds = new ArrayList<>(producerPrductIdSet);
        SLPD1805IParam slpd1805IParam = new SLPD1805IParam();
        slpd1805IParam.setPagination(null);
        slpd1805IParam.setDelFlg(false);
        slpd1805IParam.setProducerProductIds(producerProdcutIds);
        BaseRestPaginationResult<SLPD1805IProductProducerResult> restResult = this.slpd1805IService.findProductProducers(slpd1805IParam);
        return restResult.getData();
    }

    /**
     * 补充entitySellerCode和name
     */
    private void fillEntitySellerCodeAndName(List<SLPD1806IManufacturerProducerProductResult> manufacturerProducts) {
        List<Long> entitySellerIds = new ArrayList<>();
        for (SLPD1806IManufacturerProducerProductResult manufacturer : manufacturerProducts) {
            entitySellerIds.add(manufacturer.getEntitySellerId());
        }

        SLIM0250IParam param = new SLIM0250IParam();
        param.setDelFlg(false);
        param.setPagination(null);
        param.setRoleId(CodeMasterConstant.SellerRoleType.MANUFACTURER);
        param.setEntitySellerIds(entitySellerIds);

        //API调API
        String url = RestApiUtils.getUrl(ApiUrlConstant.SLIM.CONTEXT_PATH, ApiUrlConstant.SLIM.API0250, ApiUrlConstant.SLIM.LOCAL_FLAG, ApiUrlConstant.SLIM.LOCALHOST);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        if (null == data || data.size() <= NumberConst.IntDef.INT_ZERO || null == data.get("data")) {
            return;
        }
        List<Map<String, Object>> entitySellerList = (List<Map<String, Object>>) data.get("data");
        if (CollectionUtils.isEmpty(entitySellerList)) {
            return;
        }
        Map<Long, Map<String, Object>> entityMap = new HashMap<>();
        for (Map<String, Object> entitySeller : entitySellerList) {
            entityMap.put(Long.valueOf(entitySeller.get("entitySellerId").toString()), entitySeller);
        }
        Map<String, Object> codeAndNameMap = null;
        for (SLPD1806IManufacturerProducerProductResult manufacturer : manufacturerProducts) {
            codeAndNameMap = entityMap.get(manufacturer.getEntitySellerId());
            manufacturer.setEntitySellerCode((String) codeAndNameMap.get("entitySellerCode"));
            manufacturer.setFullName((String) codeAndNameMap.get("fullName"));
        }
    }

}