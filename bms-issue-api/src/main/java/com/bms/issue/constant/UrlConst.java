package com.bms.issue.constant;

import com.bms.issue.util.ApplicationContextHelper;
import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * URL常量类
 *
 * @author li_huiqian
 *
 */
//@Component
public class UrlConst {

//    @Value("${oms.module.order-api}")
//    private String modalName;
    /**
     * 买家订单URL
     */
    public static final String API_ORDR_NAME = ConfigServerPropertyLoad.getModelName("order-api");
//    public static final String API_ORDR_NAME = ApplicationContextHelper.get_applicationContext().getEnvironment().getProperty("oms.module.order-api");
    public static final String API_ORDR_URL = /* "http://10.30.10.51:8091/bms-ordr-api/api"; */ConfigServerUtils
            .getAPIUrl(API_ORDR_NAME, "api");
    // public static final String API_ORDR_URL = "http://localhost:9020/oms-order/api";

    /**
     * 买家订单查询接口
     */
    public static final String ACTION_ORDR0105I = "/order/by/_search";

}
