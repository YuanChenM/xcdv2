package com.batch.order.bean.template;

import com.batch.order.bean.result.ORDR0303BResult;
import com.framework.core.file.xml.jaxb.template.XmlTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by liutao on 2017/3/6.
 */
@XmlRootElement(name = "DATACOLLECTION")
public class ORDR0303BXmlTemplate implements XmlTemplate<ORDR0303BResult> {
    private List<ORDR0303BResult> data;

    @Override
    @XmlElement(name = "DATA")
    public List<ORDR0303BResult> getData() {
        return data;
    }

    public void setData(List<ORDR0303BResult> data) {
        this.data = data;
    }
}
