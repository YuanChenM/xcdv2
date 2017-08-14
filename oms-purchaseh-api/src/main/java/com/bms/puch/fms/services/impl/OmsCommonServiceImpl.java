package com.bms.puch.fms.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.puch.fms.bean.OmsAgent;
import com.bms.puch.fms.bean.OmsPartner;
import com.bms.puch.fms.constant.OmsUrlDef;
import com.bms.puch.fms.services.OmsCommonService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuan_zhifei on 2017/5/4.
 */
@Service
public class OmsCommonServiceImpl implements OmsCommonService {
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    Logger logger = LoggerFactory.getLogger(OmsCommonServiceImpl.class);

    @Override
    public OmsAgent getAgent(OmsAgent param) {
        logger.debug("agentId：" + param.getAgentId());
        OmsAgent omsAgent = new OmsAgent();
        String url = ConfigServerUtils.getAPIUrl(OmsUrlDef.AGIF_MODULE, OmsUrlDef.AGENT.searchAgent);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        BaseRestPaginationResult<OmsAgent> agentResult = restApiClient.post(url, param, new TypeReference<BaseRestPaginationResult<OmsAgent>>() {
        });
        if (agentResult != null && agentResult.getData() != null) {
            List<OmsAgent> omsAgents = agentResult.getData();
            if (omsAgents.size() > 0) {
                omsAgent = omsAgents.get(0);
            }
        }
        return omsAgent;
    }

    @Override
    public OmsPartner getPartner(OmsPartner param) {
        logger.debug("partnerId：" + param.getPartnerId());
        OmsPartner omsPartner = new OmsPartner();
        String url = ConfigServerUtils.getAPIUrl(OmsUrlDef.AGIF_MODULE, OmsUrlDef.AGENT.searchPartner);
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        BaseRestPaginationResult<OmsPartner> partnerResult = restApiClient.post(url, param, new TypeReference<BaseRestPaginationResult<OmsPartner>>() {
        });
        if (partnerResult != null && partnerResult.getData() != null) {
            List<OmsPartner> omsPartners = partnerResult.getData();
            if (omsPartners.size() > 0) {
                omsPartner = omsPartners.get(0);
            }
        }
        return omsPartner;
    }
}
