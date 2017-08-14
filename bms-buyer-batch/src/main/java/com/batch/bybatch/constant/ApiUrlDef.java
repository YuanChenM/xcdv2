package com.batch.bybatch.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public interface ApiUrlDef {

    String ORDER_MODULE = ConfigServerPropertyLoad.getModelName("order-api");
    String SLPD_MODULE = ConfigServerPropertyLoad.getModelName("slpd-api");
    String BYIM_MODULE = ConfigServerPropertyLoad.getModelName("byim-api");
    String BYPO_MODULE = ConfigServerPropertyLoad.getModelName("bypo-api");

    interface ORDER {
        String ORDER_BY_SEARCH = "api/order/by/_search";
    }

    interface SLPD {
        String productSearchByProductId = "api/classes/machinings/breeds/brands/items/properties/_find";
    }

    interface BYIM {
        String buyerInfoSearch = "api/buyers/basic/_search";
        String buyerBuyerPoolAdd = "api/buyers/buyerpool/_add";
        String buyerPoolRelationSearch = "api/buyers/buyerpool/_search";
    }

    interface bypo {
        String buyerPoolProductSearch = "api/buyerPoolAndProduct/_search";
    }

}
