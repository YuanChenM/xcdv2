package com.bms.linv.bean.result;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/5/4.
 */
@XmlRootElement(name="failedDatas")
public class LINV0118IFailedParam implements Serializable {
    @ApiModelProperty(value = "失败数据的AdjustCode")
    @XmlElement(name="failedId")
    private String failedId;
    @ApiModelProperty(value = "错误编码")
    @XmlElement(name="errorCode")
    private String errorCode;
    @ApiModelProperty(value = "错误信息")
    @XmlElement(name="errorMessage")
    private String errorMessage;

    public String getFailedId() {
        return failedId;
    }

    public void setFailedId(String failedId) {
        this.failedId = failedId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
