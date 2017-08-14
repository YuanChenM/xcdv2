package com.bms.puch.bean.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/4/1.
 */
@XmlRootElement(name = "puchResult")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class PuchReceiveXmlResult implements Serializable {

    private Integer result;

    private Long deliverId;

    private boolean pushFlg;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    public boolean isPushFlg() {
        return pushFlg;
    }

    public void setPushFlg(boolean pushFlg) {
        this.pushFlg = pushFlg;
    }
}
