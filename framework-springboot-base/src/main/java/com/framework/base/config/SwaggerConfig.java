package com.framework.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.framework.base.properties.ApiInfoContactProperties;
import com.framework.base.properties.ApiInfoProperties;
import com.framework.core.utils.BeanUtils;
import com.framework.swagger.SwaggerDocFactory;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * 加载Swagger Configuration
 * </p>
 *
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/24
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties({ ApiInfoProperties.class, ApiInfoContactProperties.class })
public class SwaggerConfig {
    @Autowired
    private ApiInfoProperties apiInfoProperties;
    @Autowired
    private ApiInfoContactProperties apiInfoContactProperties;

    /**
     * <p>
     * 加载beanName=api
     * </p>
     *
     * @return Docket
     */
    @Bean
    public Docket api() {
        com.framework.swagger.bean.ApiInfoProperties api = BeanUtils.toBean(apiInfoProperties,
            com.framework.swagger.bean.ApiInfoProperties.class);
        api.setEmail(apiInfoContactProperties.getEmail());
        api.setUrl(apiInfoContactProperties.getUrl());
        api.setName(apiInfoContactProperties.getName());
        return SwaggerDocFactory.createSwaggerDocFactory().createApiInfo(api, apiInfoProperties.getGroupName());
    }
}
