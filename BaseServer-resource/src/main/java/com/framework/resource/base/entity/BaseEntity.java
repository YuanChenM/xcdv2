package com.framework.resource.base.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 161154877841L;

    private Boolean delFlg;

    private String crtId;

    private Date crtTime;

    private String updId;

    private Date updTime;

    private Integer version;

    public BaseEntity() {}

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return this.crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return this.crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return this.updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
