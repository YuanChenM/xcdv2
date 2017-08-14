package com.bms.fms.notice;

import com.bms.constant.FmsUrlDef;
import com.bms.constant.ThirdPartSys;
import com.bms.template.AbstractTemplate;
import com.bms.template.TemplateFactory;
import com.bms.fms.bean.NoticeParam;
import com.framework.core.utils.StringUtils;
import com.log.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yuan_chen on 2017/5/10 0010.
 *
 */
public abstract class AbstractNotice {
    @Autowired
    private TemplateFactory templateFactory;

    protected void push(NoticeParam param){
        if(FmsUrlDef.getFmsPushFlg()){
            return;
        }
        if(StringUtils.isEmpty(param.getNoticeKey())){
            return;
        }
        String url = FmsUrlDef.getNoticeUrl();
        AbstractTemplate fmsTemplate = templateFactory.getTemplete(ThirdPartSys.FMS.name());
        String xmlParam = createFmsXmlParam(param);
        fmsTemplate.asyncPost(url, xmlParam);
    }


    private String createFmsXmlParam(NoticeParam param) {
        String xmlParam = "<Input xmlns:ns=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/rest/cux_ws_notification_prg/\">";
        xmlParam = xmlParam + "<ns1:RESTHeader xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/rest/cux_ws_notification_prg/\">";
        xmlParam = xmlParam + "<ns1:Responsibility></ns1:Responsibility>";
        xmlParam = xmlParam + "<ns1:RespApplication></ns1:RespApplication>";
        xmlParam = xmlParam + "<ns1:SecurityGroup></ns1:SecurityGroup>";
        xmlParam = xmlParam + "<ns1:NLSLanguage>SIMPLIFIED CHINESE</ns1:NLSLanguage>";
        xmlParam = xmlParam + "<ns1:Org_Id>81</ns1:Org_Id>";
        xmlParam = xmlParam + "</ns1:RESTHeader>";
        xmlParam = xmlParam + "<InputParameters>";
        xmlParam = xmlParam + "<ns:P_IFACE_CODE>";
        xmlParam = xmlParam + param.getNoticeType();
        xmlParam = xmlParam + "</ns:P_IFACE_CODE>";
        xmlParam = xmlParam + "<ns:P_DOCUMENTS_ID>";
        xmlParam = xmlParam + param.getNoticeKey();
        xmlParam = xmlParam + "</ns:P_DOCUMENTS_ID>";
        xmlParam = xmlParam + "</InputParameters>";
        xmlParam = xmlParam + "</Input>";

        return xmlParam;
    }

}
