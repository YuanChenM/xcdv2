package com.bms.order.fms.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.order.fms.bean.*;
import com.bms.order.fms.constant.OmsUrlDef;
import com.bms.order.fms.services.OmsCommonService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * oms内部系统间接口调用共通services
 */
@Service
public class OmsCommonServiceImpl implements OmsCommonService {

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    Logger logger = LoggerFactory.getLogger(OmsCommonServiceImpl.class);

    @Override
    public OmsBuyer getBuyer(OmsBuyer param){
        logger.debug("buyerId：" + param.getBuyerId());
        OmsBuyer omsBuyer = new OmsBuyer();

        String url = ConfigServerUtils.getAPIUrl(OmsUrlDef.BYIM_MODULE, OmsUrlDef.BUYER.searchBuyer);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        BaseRestPaginationResult<OmsBuyer> buyerResult = restApiClient.post(url, param, new TypeReference<BaseRestPaginationResult<OmsBuyer>>() {});
        if(buyerResult != null && buyerResult.getData() != null){
            List<OmsBuyer> omsBuyers = buyerResult.getData();
            if(omsBuyers.size() > 0){
                omsBuyer = omsBuyers.get(0);
            }
        }

        return omsBuyer;
    }

    @Override
    public OmsAgent getAgent(OmsAgent param){
        logger.debug("agentId：" + param.getAgentId());
        OmsAgent omsAgent = new OmsAgent();

        String url = ConfigServerUtils.getAPIUrl(OmsUrlDef.AGIF_MODULE, OmsUrlDef.AGENT.searchAgent);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        BaseRestPaginationResult<OmsAgent> result = restApiClient.post(url, param, new TypeReference<BaseRestPaginationResult<OmsAgent>>() {});
        if(result != null && result.getData() != null){
            List<OmsAgent> omsAgents = result.getData();
            if(omsAgents.size() > 0){
                omsAgent = omsAgents.get(0);
            }
        }
        return omsAgent;
    }

    @Override
    public OmsAgentDistribution getAgentDistribution(OmsAgentDistribution param){
        logger.debug("agentId：" + param.getAgentId());
        OmsAgentDistribution omsAgentDistribution = new OmsAgentDistribution();

        String url = ConfigServerUtils.getAPIUrl(OmsUrlDef.AGIF_MODULE, OmsUrlDef.AGENT.searchAgentDistribution);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        BaseRestPaginationResult<OmsAgentDistribution> agentDistributionResult = restApiClient.post(url, param, new TypeReference<BaseRestPaginationResult<OmsAgentDistribution>>() {});
        if(agentDistributionResult != null && agentDistributionResult.getData() != null){
            List<OmsAgentDistribution> omsAgentDistributions = agentDistributionResult.getData();
            if(omsAgentDistributions.size() > 0){
                omsAgentDistribution = omsAgentDistributions.get(0);
            }
        }

        return omsAgentDistribution;
    }

    @Override
    public OmsProductInventoryBean getOrderStock(OmsProductInventoryParam param){
        OmsProductInventoryBean omsProductInventoryBean = new OmsProductInventoryBean();

        String url = ConfigServerUtils.getAPIUrl(OmsUrlDef.LINV_MODULE, OmsUrlDef.INVENTORY.searchLoadInvAllocation);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        ArrayList<OmsProductInventoryParam> params = new ArrayList<>();
        params.add(param);
        BaseRestPaginationResult<OmsProductInventoryBean> result = restApiClient.post(url, params, new TypeReference<BaseRestPaginationResult<OmsProductInventoryBean>>() {});
        if(result != null && result.getData() != null){
            List<OmsProductInventoryBean> omsAgentDistributions = result.getData();
            if(omsAgentDistributions.size() > 0){
                omsProductInventoryBean = omsAgentDistributions.get(0);
            }
        }

        return omsProductInventoryBean;
    }

    @Override
    public OmsManufacturerProduct getManufacturer(OmsManufacturerSkuParam param){
        OmsManufacturerProduct omsManufacturerProduct = new OmsManufacturerProduct();

        String url = ConfigServerUtils.getAPIUrl(OmsUrlDef.SLPD_MODULE, OmsUrlDef.PRODUCT.searchManufacturer);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();

        BaseRestPaginationResult<OmsManufacturerProduct> result = restApiClient.post(url, param, new TypeReference<BaseRestPaginationResult<OmsManufacturerProduct>>() {});
        if(result != null && result.getData() != null){
            List<OmsManufacturerProduct> omsManufacturerProducts = result.getData();
            if(omsManufacturerProducts.size() > 0){
                omsManufacturerProduct = omsManufacturerProducts.get(0);
            }
        }

        return omsManufacturerProduct;
    }

}

