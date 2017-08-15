package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * 买家配送地址信息查询接口，入参
 * 
 * @author li_huiqian
 *
 */
public class BYIM0113IRestParam implements Serializable {

    private static final long serialVersionUID = -7080945951696437056L;

    /**
     * 买家ID
     */
    private String buyerId;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

}
