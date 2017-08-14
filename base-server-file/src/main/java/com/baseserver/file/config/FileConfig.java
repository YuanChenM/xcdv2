package com.baseserver.file.config;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * <p>
 * 文件服务器相关配置
 * </p>
 *
 * @author shi_yuxi
 * @version 1.0
 */
@Configuration
public class FileConfig {
    /**
     * 限制上传文件大小40M
     *
     * @return MultipartConfigElement
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize( 1024 * 40 + "KB");
        factory.setMaxRequestSize(1024 * 40 + "KB");
        return factory.createMultipartConfig();
    }
}
