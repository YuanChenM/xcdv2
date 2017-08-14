package com.msk.sso.client.bean.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrgSystemResult implements Serializable{
    private String sysCode;
    private String sysName;
    private String sysLevel;
    private String parentCode;
    private String sysDesc;
    private List<OrgPageResult> pageList = new ArrayList<>();
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

    public String getSysLevel() {
        return sysLevel;
    }

    public void setSysLevel(String sysLevel) {
        this.sysLevel = sysLevel;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    public List<OrgPageResult> getPageList() {
        return pageList;
    }

    public void setPageList(List<OrgPageResult> pageList) {
        this.pageList = pageList;
    }
}
