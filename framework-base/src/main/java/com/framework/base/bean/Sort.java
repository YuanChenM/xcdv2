package com.framework.base.bean;

import java.io.Serializable;

/**
 * 排序设置
 *
 * @author mao_yejun
 * @version 1.0
 */
public class Sort implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 是否倒序
     */
    private Boolean descFlag;
    /**
     * 排序字段
     */
    private String sortField;

    public Sort() {
    }

    public Boolean getDescFlag() {
        return descFlag;
    }

    public void setDescFlag(Boolean descFlag) {
        this.descFlag = descFlag;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }
}
