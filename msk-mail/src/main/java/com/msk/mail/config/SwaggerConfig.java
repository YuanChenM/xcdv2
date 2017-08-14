package com.msk.mail.config;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2).
                groupName("邮件服务API").
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
        ApiInfo apiInfo = new ApiInfo("邮件服务API",//大标题
                "江苏润和开发和提供给XCD项目有关邮件操作的Restful API",//小标题
                "1.0",//版本
                "没有服务条款",
                new Contact("江苏润和软件股份有限公司", "", ""),//作者
                "江苏润和软件股份有限公司",//链接显示文字
                ""//网站链接
        );
        return apiInfo;
    }

}
