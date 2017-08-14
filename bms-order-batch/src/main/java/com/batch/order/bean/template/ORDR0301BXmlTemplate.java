package com.batch.order.bean.template;

import com.batch.order.bean.result.ORDR0301BResult;
import com.framework.core.file.xml.jaxb.template.XmlTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by liutao on 2017/3/6.
 */
@XmlRootElement(name = "DATACOLLECTION")
public class ORDR0301BXmlTemplate implements XmlTemplate<ORDR0301BResult> {
    private List<ORDR0301BResult> data;

    @Override
    @XmlElement(name = "DATA")
    public List<ORDR0301BResult> getData() {
        return data;
    }

    public void setData(List<ORDR0301BResult> data) {
        this.data = data;
    }
}
