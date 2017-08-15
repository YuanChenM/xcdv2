package com.bms.slpd.bean.result.wrapper;

import java.io.Serializable;


public class LogisticsAreaRsParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean delFlg;
    private String disableFlg;
    private Integer divisionLevel;
    private String lgcsAreaCode;
    private Integer lgcsAreaId;
    private String lgcsAreaName;

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getDisableFlg() {
        return disableFlg;
    }

    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

    public Integer getDivisionLevel() {
        return divisionLevel;
    }

    public void setDivisionLevel(Integer divisionLevel) {
        this.divisionLevel = divisionLevel;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public Integer getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Integer lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
}
