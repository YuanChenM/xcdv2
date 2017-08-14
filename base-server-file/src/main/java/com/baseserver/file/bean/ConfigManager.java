package com.baseserver.file.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件服务配置bean
 *
 * @author shi_yuxi
 *
 */
@Component
@ConfigurationProperties(prefix = "fileConfig")
public class ConfigManager {
    /**
     * 文件服务器上传url
     */
    private String fileServerPath;
    /**
     * 文件服务器下载url
     */
    private String fileDownloadPath;

    public String getFileServerPath() {
        return fileServerPath;
    }

    public void setFileServerPath(String fileServerPath) {
        this.fileServerPath = fileServerPath;
    }

    public String getFileDownloadPath() {
        return fileDownloadPath;
    }

    public void setFileDownloadPath(String fileDownloadPath) {
        this.fileDownloadPath = fileDownloadPath;
    }
}
