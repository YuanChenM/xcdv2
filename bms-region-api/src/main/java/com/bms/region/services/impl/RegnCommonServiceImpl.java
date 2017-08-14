package com.bms.region.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.region.constant.ApiUrlDef;
import com.bms.region.services.RegnCommonService;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by guan_zhongheng on 2017/4/14.
 */
@Service
public class RegnCommonServiceImpl implements RegnCommonService {

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Override
    public void checkSystemUse(HashMap<String,Long> param) {
        RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
        if(param.get("lgcsAreaId") !=null || param.get("zoneId") !=null || param.get("distributionId") !=null || param.get("demesneId") !=null){
            String agifLgcsRegnUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.AGIF_MODULE,ApiUrlDef.AGIF.agifLgcsRegionCheck);
            String byimLgcsRegnUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE,ApiUrlDef.BYIM.byimLgcsRegionCheck);
            String bymtLgcsRegnUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYMT_MODULE,ApiUrlDef.BYMT.bymtRegionCheck);
            Integer agifCount =  restApiClient.post(agifLgcsRegnUrl,param,new TypeReference<Integer>(){});
            if(agifCount != null && agifCount > 0){
                throw new BusinessException("AGIF","REGN.E00015");
            }
            if(param.get("lgcsAreaId") !=null){
                Integer byimCount =  restApiClient.post(byimLgcsRegnUrl,param,new TypeReference<Integer>(){});
                if(byimCount != null && byimCount > 0){
                    throw new BusinessException("BYIM","REGN.E00015");
                }
            }
            if(param.get("zoneId") !=null ||param.get("lgcsAreaId") !=null) {
                Integer bymtCount = restApiClient.post(bymtLgcsRegnUrl, param, new TypeReference<Integer>() {
                });
                if (bymtCount != null && bymtCount > 0) {
                    throw new BusinessException("BYMT", "REGN.E00015");
                }
            }
        }else{
            String agifRegnUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.AGIF_MODULE,ApiUrlDef.AGIF.agifRegionCheck);
            String byimRegnUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE,ApiUrlDef.BYIM.byimRegionCheck);
            String bymtRegnUrl = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYMT_MODULE,ApiUrlDef.BYMT.bymtRegionCheck);
            Integer agifCount =  restApiClient.post(agifRegnUrl,param,new TypeReference<Integer>(){});
            if(agifCount != null && agifCount > 0){
                throw new BusinessException("AGIF","REGN.E00015");
            }
            Integer byimCount =  restApiClient.post(byimRegnUrl,param,new TypeReference<Integer>(){});
            if(byimCount != null && byimCount > 0){
                throw new BusinessException("BYIM","REGN.E00015");
            }
            if(param.get("districtId") != null){
                Integer bymtCount =  restApiClient.post(bymtRegnUrl,param,new TypeReference<Integer>(){});
                if(bymtCount != null && bymtCount > 0){
                    throw new BusinessException("BYMT","REGN.E00015");
                }
            }
        }
    }
}
