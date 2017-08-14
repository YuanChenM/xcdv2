package com.framework.core.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Json处理工具类
 *
 * @author li_huiqian
 */
public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 允许JSON非双引号的属性名
        objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        // 允许JSON带单引号的属性名和字符串
        objectMapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        // 允许JSON非引号的控制字符
        objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
        // 允许JSON整数以多个0开始
        objectMapper.enable(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS);

        // 使用BigDecimal序列化浮点数
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        // 当遇到未知属性时，不抛出异常
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // 不扫描注解
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);

        // 将Date序列化为timestamp数字式的值
        objectMapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 允许JSON非双引号的属性名
        objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        // 允许JSON带单引号的属性名和字符串
        objectMapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        // 允许JSON非引号的控制字符
        objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
        // 允许JSON整数以多个0开始
        objectMapper.enable(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS);

        // 使用BigDecimal序列化浮点数
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        // 当遇到未知属性时，不抛出异常
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // 不扫描注解
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);

        // 将Date序列化为timestamp数字式的值
        objectMapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }

    /**
     * 将对象序列化为JSON字符串
     *
     * @param bean 待序列化的对象
     * @return JSON字符串
     */
    public static String serialize(Object bean) {
        try {
            String json = objectMapper.writeValueAsString(bean);
            return (StringUtils.isEmpty(json) || ("null").equals(json)) ? "{}" : json;
        } catch (JsonProcessingException e) {
            logger.error("serialize(Object)", e);
        }
        return null;
    }

    /**
     * 将JSON字符串反序列化为对象
     *
     * @param json      JSON字符串
     * @param beanClass 待反序列化的类型
     * @return 反序列化后的对象
     */
    public static <T> T deserialize(String json, Class<T> beanClass) {
        try {
            return objectMapper.readValue(json, beanClass);
        } catch (IOException e) {
            logger.error("deserialize(String, Class<T>)", e);
        }
        return null;
    }

}