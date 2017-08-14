/*
 * 2017/02/21 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.batch.bybatch;

import com.framework.boot.listener.ApplicationEventListener;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
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
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>
 * BYBATCH/Application。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Configuration
@Import({ DispatcherServletAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class,
    ErrorMvcAutoConfiguration.class, HttpEncodingAutoConfiguration.class, HttpMessageConvertersAutoConfiguration.class,
    JacksonAutoConfiguration.class, MultipartAutoConfiguration.class,
    PersistenceExceptionTranslationAutoConfiguration.class, PropertyPlaceholderAutoConfiguration.class,
    RedisAutoConfiguration.class, ServerPropertiesAutoConfiguration.class, WebMvcAutoConfiguration.class,
    WebSocketAutoConfiguration.class, AnnotationAwareAspectJAutoProxyCreator.class,
    ConfigClientAutoConfiguration.class })
@ComponentScan(basePackages = { "com.batch.bybatch.*", "com.framework.batch", "com.bms", "com.framework.aop",
        "com.framework.boot.plugin.*.properties", "com.framework.boot.base","com.framework.boot.handler", "com.framework.boot.config",
        "com.framework.boot.plugin.async", "com.framework.i18n", "com.framework.redis"})
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableBatchProcessing
@EnableScheduling
public class Application {

    public static void main(String[] args) throws Exception {

        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationEventListener());
        application.run(args);

        /** 本地测试 */
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        SimpleJobExecutor jobExecutor = (SimpleJobExecutor) context.getBean(SimpleJobExecutor.class);
//        BYIM0101BJobConfiger jobConfiger = (BYIM0101BJobConfiger) context.getBean(BYIM0101BJobConfiger.class);
//        jobExecutor.execute(jobConfiger.Byim0101bJob());
//        System.exit(0);
    }
}