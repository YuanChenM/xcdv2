package com.msk.comm.bean;

import java.io.Serializable;

/**
 * Created by zhu_kai1 on 2016/11/29.
 */
public class FindNodeParam implements Serializable {
    private String rootCode;
    private String parentCode;
    private String dictCode;
    private boolean detail;

    public String getRootCode() {
        return rootCode;
    }

    public void setRootCode(String rootCode) {
        this.rootCode = rootCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public boolean isDetail() {
        return detail;
    }

    public void setDetail(boolean detail) {
        this.detail = detail;
    }
}
