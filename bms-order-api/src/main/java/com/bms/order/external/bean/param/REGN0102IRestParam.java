package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * 买家基本信息查询接口，入参
 * 
 * @author li_huiqian
 *
 */
public class REGN0102IRestParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3225961797742866804L;

    private String lgcsAreaCode;

    private Boolean delFlg;

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
