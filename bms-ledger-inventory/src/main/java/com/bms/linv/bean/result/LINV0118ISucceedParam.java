package com.bms.linv.bean.result;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/5/4.
 */
@XmlRootElement(name="succeedDatas")
public class LINV0118ISucceedParam implements Serializable {
    @ApiModelProperty(value = "成功处理的AdjustCode")
    @XmlElement(name="succeedId")
    private String succeedId;
    @ApiModelProperty(value = "成功处理的系统的调整单号")
    @XmlElement(name="succeedCode")
    private String succeedCode;

    public String getSucceedId() {
        return succeedId;
    }

    public void setSucceedId(String succeedId) {
        this.succeedId = succeedId;
    }

    public String getSucceedCode() {
        return succeedCode;
    }

    public void setSucceedCode(String succeedCode) {
        this.succeedCode = succeedCode;
    }
}
