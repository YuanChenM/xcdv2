package com.msk.common.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by zhu_kai1 on 2017/3/21.
 */
@Component
public class ConfigUtils {
    private static Environment environment;

    public static String getApiKey(){
      return   environment.getProperty("api_key");
    }

    public static String getSecurityKey(){
        return   environment.getProperty("security_key");
    }

    public static String getZuul(){
        return   environment.getProperty("config.server.gateWayUrl");
    }

    public static String getModelName(){
        return   environment.getProperty("oms.module.authority-server");
    }

    public static void setEnvironment(Environment environment) {
        ConfigUtils.environment = environment;
    }

}
