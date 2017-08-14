package com.batch.order.bean.template;

import com.batch.order.bean.result.ORDR0801BResult;
import com.framework.core.file.xml.jaxb.template.XmlTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by liutao on 2017/3/6.
 */
@XmlRootElement(name = "DATACOLLECTION")
public class ORDR0801BXmlTemplate implements XmlTemplate<ORDR0801BResult> {
    private List<ORDR0801BResult> data;

    @Override
    @XmlElement(name = "DATA")
    public List<ORDR0801BResult> getData() {
        return data;
    }

    public void setData(List<ORDR0801BResult> data) {
        this.data = data;
    }
}
