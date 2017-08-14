package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;

/**
 * Created by zheng_xu on 2017/5/3.
 */
public class InvmLoadAdjust extends BaseEntity {

    private Long loadAdjustId;

    private String loadAdjustCode;

    private String wmsAdjustCode;

    private Date adjustDate;

    private String adjustPerson;

    private String reasonCode;

    private String reasonName;

    public Long getLoadAdjustId() {
        return loadAdjustId;
    }

    public void setLoadAdjustId(Long loadAdjustId) {
        this.loadAdjustId = loadAdjustId;
    }

    public String getLoadAdjustCode() {
        return loadAdjustCode;
    }

    public void setLoadAdjustCode(String loadAdjustCode) {
        this.loadAdjustCode = loadAdjustCode;
    }

    public String getWmsAdjustCode() {
        return wmsAdjustCode;
    }

    public void setWmsAdjustCode(String wmsAdjustCode) {
        this.wmsAdjustCode = wmsAdjustCode;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    public String getAdjustPerson() {
        return adjustPerson;
    }

    public void setAdjustPerson(String adjustPerson) {
        this.adjustPerson = adjustPerson;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }
}
