package com.bms.bymt.constant;

import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public interface ApiUrlDef {

    String BYIM_MODULE = ConfigServerPropertyLoad.getModelName("byim-api");

    interface STORE {
        String storeSearch = "api/buyers/Store/_search";

        String storeUpdate = "api/buyers/Store/_update";
    }
}
