package com.bms.region.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * Created by guan_zhongheng on 2017/4/7.
 */
public interface ApiUrlDef {

    String AGIF_MODULE = ConfigServerPropertyLoad.getModelName("agif-api");//"oms-region-api";
    String BYIM_MODULE = ConfigServerPropertyLoad.getModelName("byim-api");//"oms-region-api";
    String BYMT_MODULE = ConfigServerPropertyLoad.getModelName("bymt-api");//"oms-region-api";

    interface AGIF {

        String addPartnerDistribution = "api/partner/distribution/_add";

        String addAgentDemesneInfo = "api/agent/demesne/_add";

        String agifLgcsRegionCheck = "api/agif/lgcsRegion/_check";

        String agifRegionCheck = "api/agif/region/_check";

    }

    interface BYIM {

        String byimLgcsRegionCheck = "api/byim/lgcsRegion/_check";

        String byimRegionCheck = "api/byim/region/_check";
    }

    interface BYMT {

        String bymtRegionCheck = "api/bymt/region/_check";
    }

}
