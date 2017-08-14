package com.bms.common.rest.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.bms.common.constant.CommonConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.exception.SystemException;
import com.framework.exception.ValidatorException;
import com.framework.exception.VersionException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.exception.bean.ExceptionMessage;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.exception.bean.VersionExceptionMessage;

/**
 * Rest Template 错误处理类
 * 
 * @author li_huiqian
 *
 */
public class RestResponseErrorHandler implements ResponseErrorHandler {

    private static Logger logger = LoggerFactory.getLogger(RestResponseErrorHandler.class);

    /**
     * 根据Response判断是否有Error
     */
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return hasError(getHttpStatusCode(response));
    }

    private boolean hasError(HttpStatus statusCode) {
        return (statusCode.series() == HttpStatus.Series.CLIENT_ERROR
                || statusCode.series() == HttpStatus.Series.SERVER_ERROR);
    }

    /**
     * 获取Http Status Code
     * 
     * @param response
     * @return
     * @throws java.io.IOException
     */
    private HttpStatus getHttpStatusCode(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode;
        try {
            statusCode = response.getStatusCode();
        } catch (IllegalArgumentException ex) {
            throw new UnknownHttpStatusCodeException(response.getRawStatusCode(), response.getStatusText(),
                response.getHeaders(), getResponseBody(response), getCharset(response));
        }
        return statusCode;
    }

    /**
     * 获取Response Body
     * 
     * @param response
     * @return
     */
    private byte[] getResponseBody(ClientHttpResponse response) {
        try {
            InputStream responseBody = response.getBody();
            if (responseBody != null) {
                return FileCopyUtils.copyToByteArray(responseBody);
            }
        } catch (IOException ex) {
            // ignore
        }
        return new byte[0];
    }

    private Charset getCharset(ClientHttpResponse response) {
        HttpHeaders headers = response.getHeaders();
        MediaType contentType = headers.getContentType();
        return contentType != null ? contentType.getCharset() : null;
    }

    /**
     * 处理Error
     */
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = getHttpStatusCode(response);
        switch (statusCode.series()) {
            case CLIENT_ERROR:
                throw new HttpClientErrorException(statusCode, response.getStatusText(), response.getHeaders(),
                    getResponseBody(response), getCharset(response));
            case SERVER_ERROR:
                Map<String, Object> map = new HashMap<>();
                String OS = System.getProperties().getProperty("os.name");
                logger.info("当前操作系统为：{}", OS);

                byte[] buffer = new byte[2048];
                int readBytes = 0;
                StringBuilder stringBuilder = new StringBuilder();
                while ((readBytes = response.getBody().read(buffer)) > 0) {
                    if (StringUtils.isNotEmpty(OS) && OS.toLowerCase().indexOf("linux") > -1) {
                        stringBuilder.append(new String(buffer, 0, readBytes));
                    } else {
                        stringBuilder.append(new String(buffer, 0, readBytes, "UTF-8"));
                    }

                }
                logger.info("异常信息:{}", stringBuilder.toString());
                map = JSON.parseObject(stringBuilder.toString(), new TypeReference<HashMap<String, Object>>() {});
                List<ExceptionMessage> messages = new ArrayList<>();
                ObjectMapper objectMapper = new ObjectMapper();
                List<ValidatorExceptionMessage> validatorExceptionMessages = new ArrayList<>();
                List<BusinessExceptionMessage> businessExceptionMessageList = new ArrayList<>();
                List<VersionExceptionMessage> versionExceptionMessageList = new ArrayList<>();
                for (String key : map.keySet()) {
                    if (map.get(key) instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) map.get(key);
                        for (Object arrayObj : jsonArray) {
                            ExceptionMessage exceptionMessage = null;
                            try {
                                exceptionMessage = JSON.parseObject(JSON.toJSONString(arrayObj),
                                    ExceptionMessage.class);
                            } catch (Exception e) {
                                exceptionMessage = new ExceptionMessage();
                                exceptionMessage.setMessageCode(e.getMessage());
                                messages.add(exceptionMessage);
                            }
                            if (StringUtils.isNotEmpty(exceptionMessage.getErrorCode())) {
                                if (exceptionMessage.getErrorCode()
                                    .equals(StringUtils.toString(CommonConstant.exceptionCode.validatorCode))) {
                                    ValidatorExceptionMessage validatorExceptionMessage = objectMapper
                                        .readValue(arrayObj.toString(), ValidatorExceptionMessage.class);
                                    validatorExceptionMessages.add(validatorExceptionMessage);
                                    logger.info("获取的ValidatorException为：{}", validatorExceptionMessages.toString());
                                } else if (exceptionMessage.getErrorCode()
                                    .equals(StringUtils.toString(CommonConstant.exceptionCode.businessCode))) {
                                    BusinessExceptionMessage businessExceptionMessage = objectMapper
                                        .readValue(arrayObj.toString(), BusinessExceptionMessage.class);
                                    businessExceptionMessageList.add(businessExceptionMessage);
                                    logger.info("获取的BusinessException为：{}", businessExceptionMessageList.toString());
                                } else if (exceptionMessage.getErrorCode()
                                    .equals(StringUtils.toString(CommonConstant.exceptionCode.versionCode))) {
                                    VersionExceptionMessage versionExceptionMessage = objectMapper
                                        .readValue(arrayObj.toString(), VersionExceptionMessage.class);
                                    versionExceptionMessageList.add(versionExceptionMessage);
                                    logger.info("获取的VersionException为：{}", versionExceptionMessageList.toString());
                                } else if (exceptionMessage.getErrorCode()
                                    .equals(StringUtils.toString(CommonConstant.exceptionCode.systemCode))) {
                                    ExceptionMessage systemExceptionMessage = objectMapper
                                        .readValue(arrayObj.toString(), ExceptionMessage.class);
                                    messages.add(systemExceptionMessage);
                                    logger.info("获取的systemException为：{}", messages.toString());
                                }
                            } else {
                                messages.add(exceptionMessage);
                                logger.info("获取的Exception为：{}", messages.toString());
                            }
                        }
                    } else {
                        messages.add(new ExceptionMessage(map.get(key).toString()));
                        logger.info("获取的Exception为：{}", messages.toString());
                    }
                }

                if (CollectionUtils.isNotEmpty(businessExceptionMessageList)) {
                    throw new BusinessException(businessExceptionMessageList);
                } else if (CollectionUtils.isNotEmpty(validatorExceptionMessages)) {
                    List<ExceptionMessage> exceptionMessageList = new ArrayList<>();
                    for (ValidatorExceptionMessage message : validatorExceptionMessages) {
                        ExceptionMessage exceptionMessage = (ExceptionMessage) message;
                        exceptionMessageList.add(exceptionMessage);
                    }
                    throw new ValidatorException(exceptionMessageList);
                } else if (CollectionUtils.isNotEmpty(versionExceptionMessageList)) {
                    throw new VersionException(versionExceptionMessageList);
                }
                throw new SystemException(messages);
            default:
                throw new RestClientException("Unknown status code [" + statusCode + "]");
        }
    }

}
