package com.msk.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.framework.core.utils.StringUtils;
import com.msk.common.Md5Digest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
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

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * RestClientUtils
 * @author jiang_nan
 * @version 1.0
 **/
public final class RestClientUtils {
    /**ACCEPT:application/json*/
    private static final String ACCEPT = "application/json";
    /**CONTENT_TYPE:application/json; charset=utf-8*/
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    /**UTF8:UTF-8*/
    private static final String UTF8="UTF-8";
    /**logger*/
    private static Logger logger = LoggerFactory.getLogger(RestClientUtils.class);
    /**Http Client Builder*/
    private static HttpClientBuilder httpClientBuilder;

    static{
        // 长连接保持30秒
        PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
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
     * @param url 请求的URL
     * @param param 请求的参数
     * @param serializerFeature 可选序列化方法
     * @return resultType
     *
     */
    public static <T extends Serializable> T post(String url, Object param, TypeReference<T> typeReference, SerializerFeature ... serializerFeature){
        String jsonParam = null;
        if(serializerFeature!=null){
            jsonParam = JSON.toJSONString(param,serializerFeature);
        }else{
            jsonParam = JSON.toJSONString(param);
        }
        logger.info("请求URL:"+url+"请求参数:"+jsonParam.replace("\n","").replace("\r","").replace(" ",""));
        String body = post(url,jsonParam);
        return JSON.parseObject(body, typeReference);
    }

    /**
     * POST请求
     * @param url URL
     * @param jsonParam JSON参数
     * @return 返回JSON数据
     */
    private static String post(String url,String jsonParam){
        HttpClient httpclient = httpClientBuilder.build();
        String  timestamp = StringUtils.toString(new Date().getTime());
        HttpPost method = new HttpPost(url);
        method.addHeader("Content-type",CONTENT_TYPE);
        method.addHeader("sign", "admin");//TODO userID
        method.addHeader("api_key", ConfigUtils.getApiKey());
        method.addHeader("timestamp",timestamp);
        method.addHeader("security_key", Md5Digest.digest("admin"+timestamp+ConfigUtils.getSecurityKey()));
        method.setHeader("Accept", ACCEPT);
        method.setEntity(new StringEntity(jsonParam, Charset.forName(UTF8)));
        long startTime = System.currentTimeMillis();
        try {
            HttpResponse response = httpclient.execute(method);
            long endTime = System.currentTimeMillis();
            logger.debug("请求花费时间为:"+(endTime-startTime));
            String body = EntityUtils.toString(response.getEntity());
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_NOT_FOUND){
                logger.error("异常原因:"+statusCode+" 请求URL:"+url+" 请求参数:"+jsonParam.replace("\n","").replace("\r","").replace(" ",""));
                logger.debug("Http 返回失败，Http失败状态为："+statusCode);
                throw new RuntimeException("Http 返回失败，Http失败状态为："+statusCode);
            }

            if(statusCode != HttpStatus.SC_OK){
                logger.error("异常原因:"+statusCode+" 请求URL:"+url+" 请求参数:"+jsonParam.replace("\n","").replace("\r","").replace(" ",""));
                logger.debug("Http 返回失败，Http失败状态为："+statusCode);
                throw new RuntimeException("Http 返回失败，Http失败状态为："+statusCode);
            }
            logger.info("请求URL:"+url+"请求参数:"+jsonParam.replace("\n","").replace("\r","").replace(" ","")+"响应时间:"+(endTime-startTime)+"返回数据:"+body.replace("\n","").replace("\r","").replace(" ",""));
            return body;
        } catch (IOException e) {
            logger.error("异常原因:"+e.getMessage()+" 请求URL:"+url+" 请求参数:"+jsonParam.replace("\n","").replace("\r","").replace(" ",""));
            throw new RuntimeException(e.getMessage());
        }
    }

}
