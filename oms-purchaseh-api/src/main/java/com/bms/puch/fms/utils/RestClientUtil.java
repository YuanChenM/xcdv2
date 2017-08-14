package com.bms.puch.fms.utils;

import com.bms.constant.FmsUrlDef;
import com.bms.puch.fms.bean.FmsUrlBean;
import com.framework.core.utils.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuan_chen on 2017/4/18 0018.
 * <p>
 * fms推送接口的调用工具类
 */
public final class RestClientUtil {
    /**
     * ACCEPT:application/xml
     */
    private static final String ACCEPT = "application/xml";
    /**
     * CONTENT_TYPE:application/xml; charset=utf-8
     */
    private static final String CONTENT_TYPE = "application/xml; charset=utf-8";
    /**
     * UTF8:UTF-8
     */
    private static final String UTF8 = "UTF-8";
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RestClientUtil.class);
    /**
     * Http Client Builder
     */
    private static HttpClientBuilder httpClientBuilder;

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

    public static String post(String xmlParam) {
        FmsUrlBean fmsUrlBean = new FmsUrlBean();
        fmsUrlBean.setPostUrl(FmsUrlDef.postUrl);
        fmsUrlBean.setPostHost(FmsUrlDef.postHost);
        fmsUrlBean.setFmsUser(FmsUrlDef.fmsUser);
        fmsUrlBean.setFmsPsd(FmsUrlDef.fmsPsd);
        return RestClientUtil.post(xmlParam, fmsUrlBean);
    }

    /**
     * POST请求
     *
     * @param xmlParam xml参数
     * @return 返回xml数据
     */
    public static String post(String xmlParam, FmsUrlBean fmsUrlBean) {
        String url = fmsUrlBean.getPostUrl();
        HttpClient httpclient = httpClientBuilder.build();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(fmsUrlBean.getFmsUser(), fmsUrlBean.getFmsPsd());
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope(fmsUrlBean.getPostHost(), AuthScope.ANY_PORT),
                credentials);
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credentialsProvider);

        HttpPost method = new HttpPost(url);
        method.addHeader("Content-type", CONTENT_TYPE);
        method.setHeader("Accept", ACCEPT);
        method.setEntity(new StringEntity(xmlParam, Charset.forName(UTF8)));
        long startTime = System.currentTimeMillis();

        try {
            HttpResponse response = httpclient.execute(method, context);
            long endTime = System.currentTimeMillis();
            logger.debug("请求花费时间为:" + (endTime - startTime));
            String body = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_NOT_FOUND) {
                logger.error("异常原因:" + statusCode
                        + " 请求URL:" + url
                        + " 请求参数:" + xmlParam.replace("\n", "").replace("\r", "").replace(" ", ""));
                logger.debug("Http 返回失败，Http失败状态为：" + statusCode);
            }

            if (statusCode != HttpStatus.SC_OK) {
                logger.error("异常原因:" + statusCode
                        + " 请求URL:" + url
                        + " 请求参数:" + xmlParam.replace("\n", "").replace("\r", "").replace(" ", ""));
                logger.debug("Http 返回失败，Http失败状态为：" + statusCode);
            }
            logger.info("请求URL:" + url
                    + "请求参数:" + xmlParam.replace("\n", "").replace("\r", "").replace(" ", "")
                    + "响应时间:" + (endTime - startTime)
                    + "返回数据:" + body.replace("\n", "").replace("\r", "").replace(" ", ""));
            return body;
        } catch (IOException e) {
            logger.error("异常原因:" + e.getMessage()
                    + " 请求URL:" + url
                    + " 请求参数:" + xmlParam.replace("\n", "").replace("\r", "").replace(" ", ""));
            return StringUtils.EMPTY;
        }
    }

}
