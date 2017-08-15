package com.bms.order.fms.utils;

import com.alibaba.fastjson.JSON;
import com.bms.order.fms.bean.FmsRequestData;
import com.bms.order.fms.bean.FmsResult;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 *
 * fms推送接口处理工具类
 */
public final class FmsUtil {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RestClientUtil.class);

    public static <T extends Serializable> FmsRequestData<T> CreateFmsRequestData(List<T> beans) {
        FmsRequestData<T> fmsRequestData = new FmsRequestData<>();
        fmsRequestData.setTotal(beans.size());
        fmsRequestData.setHead(beans);
        return fmsRequestData;
    }

    public static FmsResult CreateFmsResult(String xml){
        FmsResult fmsResult = new FmsResult();
        SAXReader saxReader = new SAXReader();
        Document document;
        ByteArrayInputStream stream;
        try {
            stream = new ByteArrayInputStream(xml.getBytes());
            document = saxReader.read(stream);
            Element root = document.getRootElement();
            fmsResult.setReturnCode((String) root.element("X_RETURN_CODE").getData());
            fmsResult.setReturnMessage((String) root.element("X_RETURN_MESG").getData());
            return fmsResult;
        }catch (DocumentException e) {
            logger.error("异常原因:" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


    public static String CreateFmsXmlParam(String pushOrderType, FmsRequestData param) {
        String jsonParam = JSON.toJSONString(param);
        return CreateFmsXmlParam(pushOrderType, jsonParam);
    }

    public static String CreateFmsXmlParam(String pushOrderType, Object param) {
        String jsonParam = JSON.toJSONString(param);
        return CreateFmsXmlParam(pushOrderType, jsonParam);
    }

    public static String CreateFmsXmlParam(String pushOrderType, String jsonParam) {
        String xmlParam = "<Input xmlns:ns=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/rest/cux_ws_server_prg/\">";
        xmlParam = xmlParam + "<ns1:RESTHeader xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/rest/cux_ws_server_prg/\">";
        xmlParam = xmlParam + "<ns1:Responsibility></ns1:Responsibility>";
        xmlParam = xmlParam + "<ns1:RespApplication></ns1:RespApplication>";
        xmlParam = xmlParam + "<ns1:SecurityGroup></ns1:SecurityGroup>";
        xmlParam = xmlParam + "<ns1:NLSLanguage>SIMPLIFIED CHINESE</ns1:NLSLanguage>";
        xmlParam = xmlParam + "<ns1:Org_Id>81</ns1:Org_Id>";
        xmlParam = xmlParam + "</ns1:RESTHeader>";
        xmlParam = xmlParam + "<InputParameters>";
        xmlParam = xmlParam + "<ns:P_IFACE_CODE>";
        xmlParam = xmlParam + pushOrderType;
        xmlParam = xmlParam + "</ns:P_IFACE_CODE>";
        xmlParam = xmlParam + "<ns:P_BATCH_NUMBER></ns:P_BATCH_NUMBER>";
        xmlParam = xmlParam + "<ns:P_REQUEST_DATA>";
        xmlParam = xmlParam + jsonParam;
        xmlParam = xmlParam + "</ns:P_REQUEST_DATA>";
        xmlParam = xmlParam + "</InputParameters>";
        xmlParam = xmlParam + "</Input>";

        return xmlParam;
    }

}
