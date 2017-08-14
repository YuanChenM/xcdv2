package com.bms.template;

import com.bms.constant.FmsUrlDef;
import com.bms.constant.ThirdPartSys;
import com.framework.core.utils.StringUtils;
import com.log.LogUtil;
import org.apache.commons.codec.binary.Base64;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by mao_yejun on 2017/4/21.
 */
@Service
public class FmsTemplate extends AbstractTemplate {
    private static Logger logger = LoggerFactory.getLogger(FmsTemplate.class);

    @Override
    protected ListenableFutureCallback<ResponseEntity<String>> asyncCallback(final String url, final String param) {
        ListenableFutureCallback<ResponseEntity<String>> callback = new ListenableFutureCallback<ResponseEntity<String>>(){
            @Override
            public void onSuccess(ResponseEntity<String> result) {
                String rs =result.getBody();
                SAXReader saxReader = new SAXReader();
                Document document = null;
                try {
                    document = saxReader.read(new ByteArrayInputStream(rs.getBytes()));
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                Element root = document.getRootElement();
                String returnCode = ((String) root.element("X_RETURN_CODE").getData());
                if (StringUtils.equals(returnCode, "S")) {
                    LogUtil.doSuccessLog(url, param, rs, ThirdPartSys.FMS);
                }else{
                    LogUtil.doFailLog(url, param, rs, ThirdPartSys.FMS);
                }
            }

            @Override
            public void onFailure(Throwable ex) {
                LogUtil.doExceptionLog(url, param,ex.getMessage(), ThirdPartSys.FMS);
                 ex.printStackTrace();
            }
        };
        return callback;
    }

    protected HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_XML_VALUE));
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML_VALUE);
        String auth = FmsUrlDef.fmsUser + ":" + FmsUrlDef.fmsPsd;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }

    @Override
    public boolean confirmResult(String result) {
        if (StringUtils.isEmpty(result)) {
            return false;
        }
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(new ByteArrayInputStream(result.getBytes()));
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
        Element root = document.getRootElement();
        String returnCode = ((String) root.element("X_RETURN_CODE").getData());
        if (StringUtils.equals(returnCode, "S")) {
            return true;
        } else {
            return false;
        }

    }

    public String post(String url, String param) {

        HttpHeaders headers = this.createHeaders();
        logger.info("开始调用,url" + url + " 参数：" + param);
        String json = "";
        HttpEntity<String> requestEntity = new HttpEntity<String>(param, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            json = response.getBody();
            logger.info("成功调用,返回" + json);
        } catch (HttpClientErrorException e) {
            LogUtil.doExceptionLog(url, param,e.getStatusText(), ThirdPartSys.FMS,e.getStatusCode().toString());
            logger.error("调用异常：" + e.getMessage());

        }catch (RestClientException ex){
            LogUtil.doExceptionLog(url, param,ex.getMessage(), ThirdPartSys.FMS);
            logger.error("调用异常：" + ex.getMessage());
        }
        return json;

    }

}