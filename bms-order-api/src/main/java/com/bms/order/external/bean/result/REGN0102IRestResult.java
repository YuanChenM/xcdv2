package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * 买家基本信息查询接口，出参
 * 
 * @author li_huiqian
 *
 */
public class REGN0102IRestResult implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6146457357360626365L;
    /** 物流区ID */
    private Long lgcsAreaId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区名称 */
    private String lgcsAreaName;
    /** 是否有效数据 */
    private String disableFlg;
    /** 删除标识 */
    private Boolean delFlg;

    /**
     * @return the lgcsAreaId
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * @param lgcsAreaId
     *            the lgcsAreaId to set
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    /**
     * @return the lgcsAreaCode
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * @param lgcsAreaCode
     *            the lgcsAreaCode to set
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * @return the lgcsAreaName
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * @param lgcsAreaName
     *            the lgcsAreaName to set
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * @return the disableFlg
     */
    public String getDisableFlg() {
        return disableFlg;
    }

    /**
     * @param disableFlg
     *            the disableFlg to set
     */
    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

    /**
     * @return the delFlg
     */
    public Boolean getDelFlg() {
        return delFlg;
    }

    /**
     * @param delFlg
     *            the delFlg to set
     */
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

}
