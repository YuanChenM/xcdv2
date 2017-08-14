package com.msk.sso.client.bean.entity;

import java.io.Serializable;

public class SysResource implements Serializable {
    private String sysId;
    private String sysCode;
    private String sysName;
    private String sysUrl;
    private Integer sysSort;
    private String imagePath;

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl;
    }

    public Integer getSysSort() {
        return sysSort;
    }

    public void setSysSort(Integer sysSort) {
        this.sysSort = sysSort;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "SysResource{" + "sysId='" + sysId + '\'' + ", sysCode='" + sysCode + '\'' + ", sysName='" + sysName
                + '\'' + ", sysUrl='" + sysUrl + '\'' + ", sysSort=" + sysSort + ", imagePath='" + imagePath + '\''
                + '}';
    }
}
