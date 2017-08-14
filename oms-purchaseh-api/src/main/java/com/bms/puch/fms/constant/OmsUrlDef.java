package com.bms.puch.fms.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 * <p>
 * oms接口用常量定义
 */
public interface OmsUrlDef {

    String REGN_MODULE = ConfigServerPropertyLoad.getModelName("region-api");
    String BYIM_MODULE = ConfigServerPropertyLoad.getModelName("byim-api");
    String AGIF_MODULE = ConfigServerPropertyLoad.getModelName("agif-api");

    interface REGION {
        String distributionUpdate = "api/region/distribution/_update";
        String distributionSearch = "api/region/distribution/_search";
        String demesneUpdate = "api/region/demesne/_update";
    }

    interface BUYER {
        String searchBuyerByBuyerIds = "api/buyers/byBuyerIds/_search";
    }

    interface AGENT {
        String searchAgent = "api/agent/basic/_search";
        String searchPartner = "api/partner/basic/_search";
    }
}
