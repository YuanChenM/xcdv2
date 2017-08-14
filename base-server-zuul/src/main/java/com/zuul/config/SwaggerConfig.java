package com.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by mao_yejun on 2017/02/21.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2).
                groupName("消息通知API").
                genericModelSubstitutes(DeferredResult.class).
                useDefaultResponseMessages(false).
                forCodeGeneration(true).
                select().
                paths(or(regex("/api/.*"))).
                build().
                apiInfo(apiInfo());
        return docket;
    }
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("xx",//大标题
                "xx",//小标题
                "1.0",//版本
                "没有服务条款",
                new Contact("xxx", "", ""),//作者
                "xxx",//链接显示文字
                "xx"//网站链接
        );
        return apiInfo;
    }
}
