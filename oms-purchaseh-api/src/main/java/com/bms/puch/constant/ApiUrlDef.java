package com.bms.puch.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * Created by guan_zhongheng on 2017/3/24.
 */
public interface ApiUrlDef {

    String SLIM_MODEL = ConfigServerPropertyLoad.getModelName("slim-api");//"oms-slim-api";

    String SLPD_MODEL = ConfigServerPropertyLoad.getModelName("slpd-api");//"oms-slim-api";

    String REGION_MODEL = ConfigServerPropertyLoad.getModelName("region-api");//"oms-slim-api";

    String LINV_MODEL = ConfigServerPropertyLoad.getModelName("linv-api");//"oms-slim-api";

    String COMO_MODEL = ConfigServerPropertyLoad.getModelName("como-api");//"oms-slim-api";

    String AGIF_MODEL = ConfigServerPropertyLoad.getModelName("agif-api");//"oms-slim-api";

    String PUCH_MODEL = ConfigServerPropertyLoad.getModelName("puch-api");//"oms-puch-api";

    interface SLIM {
        String sellerSearch = "api/sellers/entity/_find";
    }

    interface SLPD {
        String productSearch = "api/classes/machinings/breeds/brands/items/properties/manufacturer/_find";
    }

    interface REGION {
        String logisticsSearch = "api/region/logistics/_search";
    }

    interface LINV {
        String receiveLoad = "api/linv/_inbound";
        String whSearch = "api/linv/wh/_search";
    }

    interface AGIF {

        String agifBasicSearch = "api/agent/basic/_search";

        String agentPartnerSearch = "api/agent/partner/qualification/_search";
    }

    interface COMO {
        String commodityInfo = "api/commodity/info/_search";
        String commodityInfoCreate = "api/commodity/info/_create";
        String productInfoCreate= "api/product/info/_create";
    }

    interface PUCHFMS {
        String agentBidOrderPush = "api/omsToFms/agentBidOrder/push";
    }
}
