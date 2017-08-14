package com.log;

import com.bms.bean.log.LogParam;
import com.bms.config.Md5RestDigest;
import com.bms.config.SignAuthKeys;
import com.bms.constant.ThirdPartSys;
import com.framework.core.utils.JsonUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mao_yejun on 2017/4/28.
 */
public class LogUtil {
    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);
    private static String zuul;
    private static String uri = "/base-log/api/log/interface/_save";
    private static RestTemplate restTemplate = new RestTemplate();
    private static HttpHeaders headers = new HttpHeaders();
    private static ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            HttpStatus statusCode = response.getStatusCode();
            return (statusCode.series() == HttpStatus.Series.CLIENT_ERROR
                    || statusCode.series() == HttpStatus.Series.SERVER_ERROR);
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {

            try {
                String error = IOUtils.toString(response.getBody());
                logger.error("日志保存失败：" + error);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    static {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        list.add(stringHttpMessageConverter);
        restTemplate.setMessageConverters(list);
        restTemplate.setErrorHandler(responseErrorHandler);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("sign","logger");
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime());
        headers.add("sign", "logger");
        headers.add("api_key", SignAuthKeys.getApiKey());
        headers.add("timestamp", timestamp);
        headers.add("security_key", Md5RestDigest.digest("logger", SignAuthKeys.getSecurityKey(), timestamp));

    }

    /**
     * 创建调用失败日志
     *
     * @param url
     * @param param
     * @param result
     * @param sys
     */
    public static void doFailLog(String url, String param, String result, ThirdPartSys sys) {
        doLog(url, param, result, sys, false);
    }

    /**
     * 创建调用失败日志
     *
     * @param url
     * @param param
     * @param sys
     */
    public static void doExceptionLog(String url, String param, String exceptionMessage, ThirdPartSys sys,String status) {
        doLog(url, param, sys, false, exceptionMessage,status);
    }
    /**
     * 创建调用失败日志
     *
     * @param url
     * @param param
     * @param sys
     */
    public static void doExceptionLog(String url, String param, String exceptionMessage, ThirdPartSys sys) {
        doLog(url, param, sys, false, exceptionMessage,null);
    }
    /**
     * 调用成功日志
     *
     * @param url
     * @param param
     * @param result
     * @param sys
     */
    public static void doSuccessLog(String url, String param, String result, ThirdPartSys sys) {
        doLog(url, param, result, sys, true);
    }

    protected static void doLog(String url, String param, String result, ThirdPartSys sys, boolean success) {
        LogParam logParam = new LogParam();
        logParam.setResponseBody(param);
        logParam.setUrl(url);
        logParam.setRequestBody(param);
        logParam.setSystemName(sys.name());
        logParam.setResponseBody(result);
        logParam.setResponseState(String.valueOf(success));
        logParam.setRequestType("post");
        logParam.setRequestTime(new Date());
        logParam.setHttpState("200");
        post(JsonUtil.serialize(logParam));
    }

    /**
     * 记录异常信息
     *
     * @param url
     * @param param
     * @param sys
     * @param success
     * @param exceptionMessage
     */
    protected static void doLog(String url, String param, ThirdPartSys sys, boolean success, String exceptionMessage,String status) {
        LogParam logParam = new LogParam();
        logParam.setResponseBody(param);
        logParam.setUrl(url);
        logParam.setRequestBody(param);
        logParam.setSystemName(sys.name());
        logParam.setResponseState(String.valueOf(success));
        logParam.setExceptionMessage(exceptionMessage);
        logParam.setRequestTime(new Date());
        logParam.setHttpState(status);
        logParam.setRequestType("post");
        post(JsonUtil.serialize(logParam));
    }

    protected static void post(String param) {
        HttpEntity<String> requestEntity = new HttpEntity<String>(param, headers);
        String url = zuul + uri;
        logger.info("开始保存第三方调用情况:" + param + "保存地址：" + url);
            restTemplate.postForEntity(url, requestEntity, String.class);
    }

    public static String getZuul() {
        return zuul;
    }

    public static void setZuul(String zuul) {
        LogUtil.zuul = zuul;
    }
}
