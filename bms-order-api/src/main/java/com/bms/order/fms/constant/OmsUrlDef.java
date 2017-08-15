package com.bms.order.fms.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 *
 * oms接口用常量定义
 */
public interface OmsUrlDef {

    String BYIM_MODULE = ConfigServerPropertyLoad.getModelName("byim-api");
    String AGIF_MODULE = ConfigServerPropertyLoad.getModelName("agif-api");
    String LINV_MODULE = ConfigServerPropertyLoad.getModelName("linv-api");
    String SLPD_MODULE = ConfigServerPropertyLoad.getModelName("slpd-api");

    interface BUYER {
        String searchBuyer = "api/buyers/basic/_search";
    }
    interface AGENT {
        String searchAgent = "api/agent/partner/qualification/_search";
        String searchAgentDistribution = "api/agent/demesne/_search";
    }
    interface INVENTORY {
        String searchLoadInvAllocation = "api/linv/loadInv/allocation/_search";
    }
    interface PRODUCT {
        String searchManufacturer = "api/classes/machinings/breeds/brands/items/properties/manufacturer/_find";
    }

}
