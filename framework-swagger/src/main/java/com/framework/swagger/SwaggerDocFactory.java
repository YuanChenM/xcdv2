package com.framework.swagger;

import com.framework.swagger.bean.ApiInfoProperties;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author liu_tao2
 * @version 1.0
 */
public class SwaggerDocFactory {

    private static SwaggerDocFactory factory;
    private SwaggerDocFactory(){

    }

    /**
     * swagger工厂类单例模式
     * @return
     */
    public static SwaggerDocFactory createSwaggerDocFactory(){
        if(factory==null){
            factory = new SwaggerDocFactory();
        }
        return factory;
    }

    /**
     * 创建swaggerApi<br/>
     * Demo :<br/>
     * SwaggerDocFactory swaggerDocFactory = SwaggerDocFactory.createSwaggerDocFactory();<br/>
     * swaggerDocFactory.createApiInfo(new ApiInfoProperties,new String());<br/>
     *
     * @param apiInfoProperties api配置文件
     * @param groupName 模块名
     * @return
     */
    public Docket createApiInfo(ApiInfoProperties apiInfoProperties,String groupName) {
        Docket docket = (new Docket(DocumentationType.SWAGGER_2))
                .groupName(groupName)
                .genericModelSubstitutes(new Class[]{DeferredResult.class})
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                .paths(Predicates.or(new Predicate[]{PathSelectors.regex("/api/.*")}))
                .build()
                .apiInfo(this.apiInfo(apiInfoProperties));
        return docket;
    }

    private ApiInfo apiInfo(ApiInfoProperties apiInfoProperties) {
        String title = apiInfoProperties.getTitle();
        String description = apiInfoProperties.getDescription();
        String version = apiInfoProperties.getVersion();
        String termsOfServiceUrl = apiInfoProperties.getTermsOfServiceUrl();
        String name = apiInfoProperties.getName();
        String url = apiInfoProperties.getUrl();
        String email = apiInfoProperties.getEmail();
        String license = apiInfoProperties.getLicense();
        String licenseUrl = apiInfoProperties.getLicenseUrl();
        ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, new Contact(name, url, email), license, licenseUrl);
        return apiInfo;
    }

}
