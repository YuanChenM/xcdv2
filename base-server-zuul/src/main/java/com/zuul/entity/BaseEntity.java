package com.zuul.entity;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mao_yejun
 * @version 1.0
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 删除标志
     */
    @Column(name = "DEL_FLG")
    private Boolean delFlg;
    /**
     * 作成者
     */
    @Column(name = "CRT_ID")
    private String crtId;
    /**
     * 作成时间
     */
    @Column(name = "CRT_TIME")
    private Date crtTime;
    /**
     * 最后更新者
     */
    @Column(name = "UPD_ID")
    private String updId;
    /**
     * 更新时间
     */
    @Column(name = "UPD_TIME")
    private Date updTime;
    /**
     * 版本
     */
    @Column(name = "VERSION")
    private Integer version;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
