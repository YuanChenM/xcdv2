package com.msk.comm.bean;

import java.io.Serializable;

/**
 * Created by zhu_kai1 on 2016/11/29.
 */
public class DictNodeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dataId;
    private String dataValue;
    private String dataCN;
    private String dataEN;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataCN() {
        return dataCN;
    }

    public void setDataCN(String dataCN) {
        this.dataCN = dataCN;
    }

    public String getDataEN() {
        return dataEN;
    }

    public void setDataEN(String dataEN) {
        this.dataEN = dataEN;
    }
}
