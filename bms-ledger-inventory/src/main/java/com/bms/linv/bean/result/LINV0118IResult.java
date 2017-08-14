package com.bms.linv.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/5/4.
 */
@ApiModel(value = "LINV0118IResult",
    description = "业务返回值")
@XmlRootElement(name="result")
public class LINV0118IResult implements Serializable {

    @ApiModelProperty(value = "1-成功，0-失败")
    @XmlElement(name="resultCode")
    private String resultCode;

    @ApiModelProperty(value = "处理失败的数据")
    @XmlElement(name="failedDatas")
    private LINV0118IFailedParam failedDatas;

    @ApiModelProperty(value = "处理成功的数据")
    @XmlElement(name="succeedDatas")
    private LINV0118ISucceedParam succeedDatas;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public LINV0118IFailedParam getFailedDatas() {
        return failedDatas;
    }

    public void setFailedDatas(LINV0118IFailedParam failedDatas) {
        this.failedDatas = failedDatas;
    }

    public LINV0118ISucceedParam getSucceedDatas() {
        return succeedDatas;
    }

    public void setSucceedDatas(LINV0118ISucceedParam succeedDatas) {
        this.succeedDatas = succeedDatas;
    }
}
