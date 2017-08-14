package com.bms.puch.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/4/24.
 */
public class LINV0114IResult implements Serializable {

    /** 物流区ID */
    private Long logisticsId;
    /** 仓库ID */
    private Long whId;
    /** 仓库编码 */
    private String whCode;
    /** 仓库名称 */
    private String whName;
    /** 仓库地址 */
    private String whAddr;

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getWhAddr() {
        return whAddr;
    }

    public void setWhAddr(String whAddr) {
        this.whAddr = whAddr;
    }
}
