package com.framework.base.rest.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author mao_yejun
 * @version 1.0
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 删除标志
     */
    private Boolean delFlg;
    /**
     * 作成者
     */
    private String crtId;
    /**
     * 作成时间
     */
    private Date crtTime;
    /**
     * 最后更新者
     */
    private String updId;
    /**
     * 更新时间
     */
    private Date updTime;
    /**
     * 版本
     */
    private Integer version;

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
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
