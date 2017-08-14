package com.bms.byim.bean.param;

/**
 * Created by zhang_jian4 on 2016/12/23.
 */
public class CityLgcsAreaParam extends CityParam {
    /**
     * 物流区ID
     */
    private Long lgcsAreaId;
    /**
     * 物流区编码
     */
    private String lgcsAreaCode;
    /**
     * 物流区名称
     */
    private String lgcsAreaName;

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

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
}
