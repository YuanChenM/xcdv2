package com.bms.order.external.bean.result;

import java.io.Serializable;

public class LINV0114IResult implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long logisticsId;
    private Long whId;
    private String whCode;
    private String whName;
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
