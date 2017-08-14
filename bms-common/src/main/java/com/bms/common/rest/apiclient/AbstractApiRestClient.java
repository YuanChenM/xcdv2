package com.bms.common.rest.apiclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.client.RestResponseErrorHandler;
import com.bms.common.rest.config.Md5RestDigest;
import com.framework.core.utils.JsonUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * 抽象RestClient
 *
 * @author li_huiqian
 */
public abstract class AbstractApiRestClient {
    private int connectTimeout;
    private int readTimeout;
    private int asyncConnectTimeout;
    private int asyncReadTimeout;
    private String apiKey;
    private String securityKey;

    protected AbstractApiRestClient(int connectTimeout, int readTimeout, int asyncConnectTimeout, int asyncReadTimeout, String apiKey, String securityKey) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.asyncConnectTimeout = asyncConnectTimeout;
        this.asyncReadTimeout = asyncReadTimeout;
        this.apiKey = apiKey;
        this.securityKey = securityKey;
    }

    /**
     * 执行Post请求
     *
     * @param url
     * @param requestEntity
     */
    protected abstract void executePost(String url, Object requestEntity, String[] showField, String[] hideField);

    /**
     * 执行Get请求
     *
     * @param url
     * @param map
     */
    protected abstract void executeGet(String url, HashMap<String, Object> map);

    /**
     * 获取结果
     *
     * @param typeReference
     * @return
     */
    protected abstract <T extends Serializable> T getResult(TypeReference<T> typeReference);

    /**
     * 获取RestTemplate
     *
     * @return
     */
    protected RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestResponseErrorHandler());
        restTemplate.setRequestFactory(getRequestFactory());
        return restTemplate;
    }

    /**
     * 获取AsyncRestTemplate
     *
     * @return
     */
    protected AsyncRestTemplate getAsyncRestTemplate() {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate();
        restTemplate.setErrorHandler(new RestResponseErrorHandler());
        restTemplate.setAsyncRequestFactory(getAsyncRequestFactory());

        return restTemplate;
    }

    /**
     * 获取SimpleClientHttpRequestFactory
     *
     * @return
     */
    private SimpleClientHttpRequestFactory getRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        return requestFactory;
    }

    /**
     * 获取SimpleClientHttpRequestFactory
     *
     * @return
     */
    private SimpleClientHttpRequestFactory getAsyncRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setTaskExecutor(new SimpleAsyncTaskExecutor());
        requestFactory.setConnectTimeout(asyncConnectTimeout);
        requestFactory.setReadTimeout(asyncReadTimeout);

        /*System.out.println(connectTimeout);
        System.out.println(readTimeout);
        System.out.println(asyncConnectTimeout);
        System.out.println(asyncReadTimeout);*/

        return requestFactory;
    }


    /**
     * 构造表单数据
     *
     * @param requestEntity
     * @param showField
     * @param hideField
     * @return
     */
    protected HttpEntity<String> createFormData(Object requestEntity, String[] showField, String... hideField) {
        /* 构造表单数据 */
        String json = JsonUtil.serialize(requestEntity);
        return new HttpEntity<String>(json, createRequestHeaders(showField, hideField));
    }


    /**
     * 构造http请求头部
     *
     * @return
     */
    private HttpHeaders createRequestHeaders(String[] showField, String... hideField) {
        /* HTTP头部 */
        HttpHeaders headers = new HttpHeaders();
        // 请求类型
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 响应类型
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String ssoUser = request.getHeader("sign");
//        Assert.notNull(ssoUser);
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime());
        headers.add("sign", ssoUser);
        headers.add("api_key", this.apiKey);
        headers.add("timestamp", timestamp);
        headers.add("security_key", Md5RestDigest.digest(ssoUser,this.securityKey,timestamp));
        if (!ArrayUtils.isEmpty(showField)) {
            headers.add("showFields", getString(showField));
        }
        if (!ArrayUtils.isEmpty(hideField)) {
            headers.add("hiddenFields", getString(hideField));
        }

        return headers;
    }

    /**
     * 处理Response
     *
     * @param response
     * @return
     */
    protected <T extends Serializable> T processResponse(ResponseEntity<String> response,
                                                         TypeReference<T> typeReference) {
        String json = (String) response.getBody();
        return JSON.parseObject(json, typeReference);
    }

    protected String getString(String[] fields) {
        return StringUtils.join(fields, ",");
    }
}
