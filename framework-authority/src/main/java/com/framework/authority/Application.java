package com.framework.authority;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.cloud.config.client.ConfigClientAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DispatcherServletAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class,
    ErrorMvcAutoConfiguration.class, HttpEncodingAutoConfiguration.class, HttpMessageConvertersAutoConfiguration.class,
    JacksonAutoConfiguration.class, MultipartAutoConfiguration.class,
    PersistenceExceptionTranslationAutoConfiguration.class, PropertyPlaceholderAutoConfiguration.class,
    RedisAutoConfiguration.class, ServerPropertiesAutoConfiguration.class, WebMvcAutoConfiguration.class,
    WebSocketAutoConfiguration.class, AnnotationAwareAspectJAutoProxyCreator.class,
    ConfigClientAutoConfiguration.class })
@ComponentScan(basePackages = { "com.framework.authority", "com.framework.aop", "com.framework.base.properties",
    "com.framework.base.dao", "com.framework.base.service", "com.framework.base.controller", "com.framework.i18n" })
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
