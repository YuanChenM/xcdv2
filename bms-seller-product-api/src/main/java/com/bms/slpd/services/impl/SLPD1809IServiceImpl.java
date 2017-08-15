package com.bms.slpd.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.param.SLIM0250IParam;
import com.bms.slpd.bean.param.SLPD1806IParam;
import com.bms.slpd.bean.param.SLPD1809IParam;
import com.bms.slpd.bean.result.field.SLPD1806IManufacturerProducerProductResult;
import com.bms.slpd.bean.result.field.SLPD1809IAgentSupplyProductResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD1809IDao;
import com.bms.slpd.services.SLPD1806IService;
import com.bms.slpd.services.SLPD1809IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD1809IServiceImpl extends BaseServiceImpl implements SLPD1809IService {

    @Autowired
    private SLPD1809IDao slpd1809IDao;
    @Autowired
    private SLPD1806IService slpd1806IService;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd1809IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD1809IAgentSupplyProductResult> findAgentSupplyProducts(SLPD1809IParam slpd1809IParam) {
        BaseRestPaginationResult<SLPD1809IAgentSupplyProductResult> restResult = super.findPageList(slpd1809IParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }



    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD1809IAgentSupplyProductResult> agentSupplyProducts){
        if(CollectionUtils.isNotEmpty(agentSupplyProducts)){
            Set<Long> manufacturerProductIdSet = new HashSet<>();
            for(SLPD1809IAgentSupplyProductResult agentSupply : agentSupplyProducts){
                manufacturerProductIdSet.add(agentSupply.getManufacturerProductId());
            }
            List<Long> manufacturerProductIds = new ArrayList<>(manufacturerProductIdSet);
            //获取制造商信息
            SLPD1806IParam slpd1806IParam = new SLPD1806IParam();
            slpd1806IParam.setManufacturerProductIds(manufacturerProductIds);
            slpd1806IParam.setPagination(null);
            BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> manufacturerResult = slpd1806IService.findManufacturerProducts(slpd1806IParam);


            this.fillEntitySellerCodeAndName(agentSupplyProducts);
            this.fillManufacturerInfo(manufacturerResult,agentSupplyProducts);
        }
    }

    /**
     * 补充制造商信息
     */
    private void fillManufacturerInfo(BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> manufacturerResult,
                                      List<SLPD1809IAgentSupplyProductResult> agentSupplyProducts){
        if(null != manufacturerResult && CollectionUtils.isNotEmpty(manufacturerResult.getData())){
            Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.AuditStu.NODE);
            List<SLPD1806IManufacturerProducerProductResult> manufacturerProducerProducts = null;
            for(SLPD1809IAgentSupplyProductResult agentSupply : agentSupplyProducts){
                manufacturerProducerProducts = new ArrayList<>();
                for(SLPD1806IManufacturerProducerProductResult manufacutre : manufacturerResult.getData()){
                    if(agentSupply.getManufacturerProductId().equals(manufacutre.getManufacturerProductId())){
                        manufacturerProducerProducts.add(manufacutre);
                    }
                }
                agentSupply.setManufacturerProducerProducts(manufacturerProducerProducts);
                agentSupply.setAuditStuStr(auditStuMap.get(agentSupply.getAuditStu()));
            }
        }
    }


    /**
     * 补充entitySellerCode和name
     */
    private void fillEntitySellerCodeAndName(List<SLPD1809IAgentSupplyProductResult> agentSupplyProducts) {
        Set<Long> set = new HashSet<>();
        for (SLPD1809IAgentSupplyProductResult agentSupply : agentSupplyProducts) {
            set.add(agentSupply.getEntitySellerId());
        }
        List<Long> entitySellerIds = new ArrayList<>(set);
        SLIM0250IParam param = new SLIM0250IParam();
        param.setDelFlg(false);
        param.setPagination(null);
        param.setRoleId(CodeMasterConstant.SellerRoleType.AGENT);
        param.setEntitySellerIds(entitySellerIds);

        //API调API
        String url = RestApiUtils.getUrl(ApiUrlConstant.SLIM.CONTEXT_PATH, ApiUrlConstant.SLIM.API0250, ApiUrlConstant.SLIM.LOCAL_FLAG, ApiUrlConstant.SLIM.LOCALHOST);
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
        };
        HashMap<String, Object> data = this.restApiClientFactory.newApiRestClient().post(url, param, typeReference);
        if (null == data || !data.containsKey("data")) {
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
        for (SLPD1809IAgentSupplyProductResult agentSupply : agentSupplyProducts) {
            codeAndNameMap = entityMap.get(agentSupply.getEntitySellerId());
            if(null != codeAndNameMap){
                agentSupply.setEntitySellerCode(String.valueOf(codeAndNameMap.get("entitySellerCode")));
                agentSupply.setFullName(String.valueOf(codeAndNameMap.get("fullName")));
            }
        }
    }
}