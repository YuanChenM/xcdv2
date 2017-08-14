package com.framework.base.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * 加载fasterxml Configuration
 * </p>
 *
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/25
 */
@Configuration
public class ResultParamConfig {

    @Bean(name = "jacksonObjectMapper")
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(MappingJackson2HttpMessageConverter jsonConverter,
        MappingJackson2XmlHttpMessageConverter xmlConverter) {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> messageConvertersList = new ArrayList<>();
        messageConvertersList.add(jsonConverter);
        messageConvertersList.add(xmlConverter);
        requestMappingHandlerAdapter.setMessageConverters(messageConvertersList);

        return requestMappingHandlerAdapter;
    }

    @Bean(name = "jsonConverter")
    public MappingJackson2HttpMessageConverter jsonConverter(ObjectMapper jacksonObjectMapper) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
        jsonConverter.setPrettyPrint(Boolean.TRUE);
        jsonConverter.setObjectMapper(jacksonObjectMapper);
        return jsonConverter;
    }

    @Bean(name = "xmlConverter")
    public MappingJackson2XmlHttpMessageConverter xmlConverter() {
        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        xmlConverter.setSupportedMediaTypes(supportedMediaTypes);
        return xmlConverter;
    }

}
