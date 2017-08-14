package com.framework.base.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config.server")
public class ConfigServerProperties {
    private String environment;
    private String url;
    private String configConstantUrl;
    private String propertiesUrl;
    private String moduleName;

    private boolean ifDataSoure;
    private String ifDataSoureClassName;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConfigConstantUrl() {
        return configConstantUrl;
    }

    public void setConfigConstantUrl(String configConstantUrl) {
        this.configConstantUrl = configConstantUrl;
    }

    public String getPropertiesUrl() {
        return propertiesUrl;
    }

    public void setPropertiesUrl(String propertiesUrl) {
        this.propertiesUrl = propertiesUrl;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public boolean isIfDataSoure() {
        return ifDataSoure;
    }

    public void setIfDataSoure(boolean ifDataSoure) {
        this.ifDataSoure = ifDataSoure;
    }

    public String getIfDataSoureClassName() {
        return ifDataSoureClassName;
    }

    public void setIfDataSoureClassName(String ifDataSoureClassName) {
        this.ifDataSoureClassName = ifDataSoureClassName;
    }

    @Override
    public String toString() {
        return "ConfigServerProperties{" + "environment='" + environment + '\'' + ", url='" + url + '\''
                + ", configConstantUrl='" + configConstantUrl + '\'' + ", propertiesUrl='" + propertiesUrl + '\''
                + ", moduleName='" + moduleName + '\'' + ", ifDataSoure=" + ifDataSoure + ", ifDataSoureClassName='"
                + ifDataSoureClassName + '\'' + '}';
    }
}
