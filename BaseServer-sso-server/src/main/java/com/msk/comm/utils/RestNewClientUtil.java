package com.msk.comm.utils;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * RestClientUtil
 * 
 * @author jiang_nan
 * @version 1.0
 **/
public final class RestNewClientUtil {
    /** ACCEPT:application/json */
    private static final String ACCEPT = "application/json";
    /** CONTENT_TYPE:application/json; charset=utf-8 */
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    /** UTF8:UTF-8 */
    private static final String UTF8 = "UTF-8";
    /** Http Client Builder */
    private static HttpClientBuilder httpClientBuilder;

    private static final String sign = "sso";

    private static Logger logger = LoggerFactory.getLogger(RestNewClientUtil.class);

    static {
        // 长连接保持30秒
        PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager(30,
            TimeUnit.SECONDS);
        // 总连接数
        pollingConnectionManager.setMaxTotal(1000);
        // 同路由的并发数
        pollingConnectionManager.setDefaultMaxPerRoute(1000);
        httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setConnectionManager(pollingConnectionManager);
        // 重试次数，默认是3次，没有开启
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
        // 保持长连接配置，需要在头添加Keep-Alive
        httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
    }

    /**
     * Rest Http Post 请求
     * 
     * @param url 请求的URL
     * @param param 请求的参数
     * @param serializerFeature 可选序列化方法
     * @return resultType
     *
     */
    public static <T extends Serializable> T post(String url, Object param, TypeReference<T> typeReference,
        SerializerFeature... serializerFeature) {
        String jsonParam = null;
        if (serializerFeature != null) {
            jsonParam = JSON.toJSONString(param, serializerFeature);
        } else {
            jsonParam = JSON.toJSONString(param);
        }
        String body = post(url, jsonParam);
        return JSON.parseObject(body, typeReference);
    }

    /**
     * POST请求
     * 
     * @param url URL
     * @param jsonParam JSON参数
     * @return 返回JSON数据
     */
    private static String post(String url, String jsonParam) {
        logger.info("请求URL:" + url + "请求参数:" + jsonParam.replace("\n", "").replace("\r", "").replace(" ", ""));
        HttpClient httpclient = httpClientBuilder.build();
        HttpPost method = new HttpPost(url);
        method.addHeader("Content-type", CONTENT_TYPE);
        method.setHeader("Accept", ACCEPT);

        String timestamp = String.valueOf(new Date().getTime());

        method.addHeader("sign", sign);
        method.addHeader("api_key", ConfigInfo.newConfigInfo().getApiKey()); // TODO apiKey
        method.addHeader("timestamp", timestamp);
        method.addHeader("security_key",
            Md5Digest.digest(sign + timestamp + ConfigInfo.newConfigInfo().getSecurityKey())); // TODO securityKey

        method.setEntity(new StringEntity(jsonParam, Charset.forName(UTF8)));
        long startTime = System.currentTimeMillis();
        try {
            HttpResponse response = httpclient.execute(method);
            long endTime = System.currentTimeMillis();
            String body = EntityUtils.toString(response.getEntity());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_NOT_FOUND) {
                throw new RuntimeException("Http 返回失败，Http失败状态为：" + statusCode);
            }

            if (statusCode != HttpStatus.SC_OK) {
                throw new RuntimeException("Http 返回失败，Http失败状态为：" + statusCode);
            }
            return body;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String get(String url) {
        HttpClient httpclient = httpClientBuilder.build();
        HttpGet method = new HttpGet(url);
        method.addHeader("Content-type", CONTENT_TYPE);
        method.setHeader("Accept", ACCEPT);

        // 身份认证
        String timestamp = String.valueOf(new Date().getTime());
        method.addHeader("sign", sign);
        method.addHeader("api_key", ConfigInfo.newConfigInfo().getApiKey()); // TODO apiKey
        method.addHeader("timestamp", timestamp);
        method.addHeader("security_key",
            Md5Digest.digest(sign + timestamp + ConfigInfo.newConfigInfo().getSecurityKey())); // TODO securityKey
        // method.setEntity(new StringEntity(jsonParam, Charset.forName(UTF8)));
        long startTime = System.currentTimeMillis();
        try {
            HttpResponse response = httpclient.execute(method);
            long endTime = System.currentTimeMillis();
            String body = EntityUtils.toString(response.getEntity());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_NOT_FOUND) {
                throw new RuntimeException("Http 返回失败，Http失败状态为：" + statusCode);
            }

            if (statusCode != HttpStatus.SC_OK) {
                throw new RuntimeException("Http 返回失败，Http失败状态为：" + statusCode);
            }
            return body;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 异步Rest调用
     * 
     * @param url 请求URL
     * @param param 请求参数
     */
    public static void asyncPost(final String url, final Object param) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String jsonParam = JSON.toJSONString(param);
                post(url, jsonParam);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
