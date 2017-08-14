package com.bms.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by mao_yejun on 2017/4/21.
 */
public abstract class AbstractTemplate {
    public static RestTemplate restTemplate = new RestTemplate();
    public static AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
    private static Logger logger = LoggerFactory.getLogger(AbstractTemplate.class);
    private static ResponseErrorHandler responseErrorHandler = new DefaultResponseErrorHandler();


    static {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        list.add(stringHttpMessageConverter);
        restTemplate.setMessageConverters(list);
        restTemplate.setErrorHandler(responseErrorHandler);
        asyncRestTemplate.setMessageConverters(list);
        asyncRestTemplate.setErrorHandler(responseErrorHandler);

    }

    protected abstract ListenableFutureCallback<ResponseEntity<String>> asyncCallback(String url,String param);
    /**
     * 构建请求头信息l
     *
     * @return
     */
    protected HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }


    /**
     * @param url
     * @param param
     * @return
     */
    public String post(String url, String param) {
        HttpHeaders headers = this.createHeaders();
        logger.info("开始调用,url" + url + " 参数：" + param);
        HttpEntity<String> requestEntity = new HttpEntity<String>(param, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        String json = response.getBody();
        logger.info("成功调用,返回" + json);
        return json;

    }
    /**
     * 异步调用
     * @param url
     * @param param
     * @return
     */
    public void asyncPost(String url, String param) {
        HttpHeaders headers = this.createHeaders();
        logger.info("开始调用,url" + url + " 参数：" + param);
        HttpEntity<String> requestEntity = new HttpEntity<String>(param, headers);
        ListenableFuture<ResponseEntity<String>> response = asyncRestTemplate.postForEntity(url, requestEntity, String.class);
        response.addCallback(asyncCallback(url,param));
    }
    public abstract boolean confirmResult(String result);

}