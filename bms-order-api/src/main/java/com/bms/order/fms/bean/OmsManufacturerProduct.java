package com.bms.order.fms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_chen on 2017/5/9
 *
 * oms内部子系统-卖家制造商
 */
public class OmsManufacturerProduct implements Serializable {
    private static final long serialVersionUID = -1618308099934663989L;
    //制造商编码
    private String entitySellerCode;
    //制造商名称
    private String fullName;
    //生产商
    private List<OmsProducerProduct> producerProducts;

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

    public List<OmsProducerProduct> getProducerProducts() {
        return producerProducts;
    }

    public void setProducerProducts(List<OmsProducerProduct> producerProducts) {
        this.producerProducts = producerProducts;
    }
}

