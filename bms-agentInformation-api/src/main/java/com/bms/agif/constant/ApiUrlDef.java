package com.bms.agif.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public interface ApiUrlDef {

    String REGN_MODULE = ConfigServerPropertyLoad.getModelName("region-api");//"oms-region-api";
    String BYIM_MODULE = ConfigServerPropertyLoad.getModelName("byim-api");
    String REGION_ENV = "http://localhost:8090/bms-region-api/api";

    interface REGION {
        String distributionUpdate = "api/region/distribution/_update";
        String distributionSearch = "api/region/distribution/_search";
        String demesneUpdate = "api/region/demesne/_update";
    }

    interface BUYER {
        String searchBuyerByBuyerIds = "api/buyers/byBuyerIds/_search";
        String buyerBasicSearch = "api/buyers/basic/_search";
    }
}
