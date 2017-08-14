package com.bms.byim.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public interface ApiUrlDef {

    String REGN_MODULE = ConfigServerPropertyLoad.getModelName("region-api");//"oms-region-api";
    String BYPO_MODULE = ConfigServerPropertyLoad.getModelName("bypo-api");
    String AGIF_MODULE = ConfigServerPropertyLoad.getModelName("agif-api");

    String REGION_ENV = "http://localhost:9001/oms-region/";

    interface REGION {
        String cityLgcsSearch = "api/region/city/Logistics/_search";
        String relationSearch = "api/region/relation/_search";
    }

    interface BUYERPOOL {
        String buyerPoolSearch = "api/buyerPool/_search";
    }

    interface AGIF{
        String buyerButlerAgentSearch= "api/relation/buyer/butler/agent/_search";
        String  buyerButlerRelation = "api/relation/buyer/butler/_release";
    }
}
