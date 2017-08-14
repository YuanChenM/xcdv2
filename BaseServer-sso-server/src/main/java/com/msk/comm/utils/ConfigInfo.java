package com.msk.comm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.msk.comm.constant.Constant;

/**
 * Created by zhang_jian3 on 17/4/13.
 */
public class ConfigInfo {
    private static ConfigInfo configInfo;
    private static Properties properties;
    private static String configPropName = "configInfo.properties";

    private ConfigInfo() {

    }

    public static ConfigInfo newConfigInfo() {
        if (configInfo == null) {
            configInfo = new ConfigInfo();
            properties = new Properties();
            String env = System.getProperty("env");
            if (null != env && !"".equals(env)) {
                configPropName = String.format("configInfo_%s.properties", env);
            }
            InputStream in = ConfigInfo.class.getResourceAsStream("/" + configPropName);
            try {
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null)
                        in.close();
                } catch (IOException ex) {}
            }
        }
        return configInfo;
    }

    public String getEnvironment() {
        return properties.getProperty("ENVIRONMENT");
    }
    //
    // public String getConfigServerUrl() {
    // return properties.getProperty("CONFIG.SERVER.URL");
    // }
    //
    // public String getConfigLoadConfigConstant() {
    // return properties.getProperty("CONFIG.LOAD.CONFIG.CONSTANT");
    // }

    public String getZuul() {
        return properties.getProperty("zuul.url");
    }

    public String getApiKey() {
        return properties.getProperty("oms.interface.apiKey");
    }

    public String getSecurityKey() {
        return properties.getProperty("oms.interface.securityKey");
    }

    public String getDictApi() {
        return properties.getProperty("dict.rest.api");
    }

    // public String getConfigLoadCodeMaster() {
    // return properties.getProperty("CODE.LOAD.CODE.MASTER");
    // }

    public String getDictRestUrl() {
        return getZuul() + "/" + Constant.DictUrl.MODEL_NAME + "/" + Constant.DictUrl.FIND_CATALOG;
    }

    // public Map<String, Object> getConfigConstantServerUrl(ConfigParam param) {
    // ConfigInfo configInfo = ConfigInfo.newConfigInfo();
    // param.setEnvironment(configInfo.getEnvironment());
    // param.setType("ConfigConstant");
    // RestRequest<ConfigParam> requestBody = new RestRequest<>();
    // String configConstantUrl = configInfo.getConfigServerUrl() + configInfo.getConfigLoadConfigConstant();
    //
    // return null;
    // }

}
