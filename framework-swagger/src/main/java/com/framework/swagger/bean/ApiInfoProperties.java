package com.framework.swagger.bean;

import com.framework.swagger.SwaggerDocFactory;

/**
 * @author liu_tao2
 * @version 1.0
 */
public class ApiInfoProperties extends ApiInfoContactProperties{
    /**
     * 主题
     */
    private String title = null;
    /**
     * 描述
     */
    private String description = null;
    /**
     * 版本
     */
    private String version = null;
    /**
     * 服务url
     */
    private String termsOfServiceUrl = null;
    /**
     * 证书
     */
    private String license = null;
    /**
     * 证书url
     */
    private String licenseUrl = null;

    public ApiInfoProperties() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTermsOfServiceUrl() {
        return this.termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return this.licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }
}
