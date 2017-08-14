package com.bms.puch.bean.param;

import java.io.Serializable;

/**
 * Created by zhao_chen on 2016/12/2.
 */

public class LogisticsAreaParam implements Serializable {

    //物流区编码
    private String lgcsAreaCode;
    //物流区名称
    private String lgcsAreaName;
    //物流区ID
    private Long lgcsAreaId;
    //划分级别
    private Integer divisionLevel;
    //是否有效数据
    private String disableFlg;
    //删除标识
    private boolean delFlg;


    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public Integer getDivisionLevel() {
        return divisionLevel;
    }

    public void setDivisionLevel(Integer divisionLevel) {
        this.divisionLevel = divisionLevel;
    }

    public String getDisableFlg() {
        return disableFlg;
    }

    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
