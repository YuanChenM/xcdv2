/*
* 2017/03/23 自动生成 新規作成
*
* (c) 江苏润和.
*/
package com.bms.como;

import com.framework.boot.listener.ApplicationEventListener;
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
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>COMO/Application。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Configuration
@Import({DispatcherServletAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class, HttpEncodingAutoConfiguration.class, HttpMessageConvertersAutoConfiguration.class,
        JacksonAutoConfiguration.class, MultipartAutoConfiguration.class,
        PersistenceExceptionTranslationAutoConfiguration.class, PropertyPlaceholderAutoConfiguration.class,
        RedisAutoConfiguration.class, ServerPropertiesAutoConfiguration.class, WebMvcAutoConfiguration.class,
        WebSocketAutoConfiguration.class, AnnotationAwareAspectJAutoProxyCreator.class,
        ConfigClientAutoConfiguration.class})
@ComponentScan(basePackages = {"com.bms", "com.framework.aop", "com.framework.boot.plugin.*.properties",
        "com.framework.boot.base", "com.framework.boot.config", "com.framework.boot.plugin.async", "com.framework.i18n", "com.framework.redis"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new ApplicationEventListener());
        app.run(args);
    }
}