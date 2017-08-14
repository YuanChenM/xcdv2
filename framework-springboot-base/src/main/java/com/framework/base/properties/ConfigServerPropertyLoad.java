package com.framework.base.properties;

import org.springframework.core.env.Environment;

public class ConfigServerPropertyLoad {
    private static Environment environment;

    public static void setEnvironment(Environment environment) {
        ConfigServerPropertyLoad.environment = environment;
    }

    public static String getDaoBasePackagePath() {
        return environment.getProperty("mybatis.daoBasePackagePath");
    }

    public static boolean getIfDataSource() {
        String check = environment.getProperty("config.server.ifDataSource");
        if ("true".equals(check.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static boolean getIfSwagger() {
        String check = environment.getProperty("config.server.ifSwagger");
        if ("true".equals(check.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static String getIfDataSourceClassName() {
        return environment.getProperty("config.server.ifDataSourceClassName");
    }

    // public static Map<String, String> getProperty() {
    // String configUrl = getPropertiesUrl();
    // RestRequest<ConfigParam> requestBody = new RestRequest<>();
    // requestBody.setAuth(getModuleName());
    // requestBody.setLoginId(getModuleName());
    // requestBody.setParam(createPropertyParam());
    // requestBody.setSiteCode("405");
    // RestResponse<String> response = RestClientUtils.post(configUrl, requestBody,
    // new TypeReference<RestResponse<String>>() {});
    // String result = response.getResult();
    // Map<String, String> resultMap = JSONArray.parseObject(result, Map.class);
    // return resultMap;
    // }

    // public static ConfigParam createPropertyParam() {
    // ConfigParam param = new ConfigParam();
    // param.setModelName(getModuleName());
    // param.setEnvironment(getConfigServerEnvironment());
    // param.setType("Properties");
    // return param;
    // }

}
