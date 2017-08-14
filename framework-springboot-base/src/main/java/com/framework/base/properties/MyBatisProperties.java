package com.framework.base.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mybatis")
public class MyBatisProperties {
    private String configPath;

    private String mapperLocations;

    private String daoBasePackageUrl;

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getDaoBasePackageUrl() {
        return daoBasePackageUrl;
    }

    public void setDaoBasePackageUrl(String daoBasePackageUrl) {
        this.daoBasePackageUrl = daoBasePackageUrl;
    }
}
