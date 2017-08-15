package com.bms.order.fms.bean;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/5/9
 *
 * oms内部子系统-卖家产品的生产商
 */
public class OmsProducerProduct implements Serializable {
    private static final long serialVersionUID = -3560313765541101300L;
    //生产商编码
    private String entitySellerCode;
    //生产商名称
    private String fullName;

    public String getEntitySellerCode() {
        return entitySellerCode;
    }

    public void setEntitySellerCode(String entitySellerCode) {
        this.entitySellerCode = entitySellerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

