package com.bms.order.bean.template;


import com.bms.order.bean.result.ORDR0302IXMLResult;
import com.framework.core.file.xml.jaxb.template.XmlTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by liutao on 2017/3/6.
 */
@XmlRootElement(name = "DATACOLLECTION")
public class ORDR0302IXmlTemplate implements XmlTemplate<ORDR0302IXMLResult> {
    private List<ORDR0302IXMLResult> data;

    @Override
    @XmlElement(name = "DATA")
    public List<ORDR0302IXMLResult> getData() {
        return data;
    }

    public void setData(List<ORDR0302IXMLResult> data) {
        this.data = data;
    }
}
