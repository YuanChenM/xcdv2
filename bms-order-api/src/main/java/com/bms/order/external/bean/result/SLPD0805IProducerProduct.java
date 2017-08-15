package com.bms.order.external.bean.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */ // 产品生产商
public class SLPD0805IProducerProduct implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 2542223681201657493L;
    // 单品品牌(规格)生产商ID
    private Long producerProductId;
    // 单品品牌(规格)生产商SKU
    private String producerProductSku;
    // 生产商ID
    private Long producerId;
    // 生产商编码
    private String producerCode;
    // 生产商名称
    private String producerName;
    // 卖家集合
    private List<SLPD0805ISeller> sellerList;

    public Long getProducerProductId() {
        return producerProductId;
    }

    public void setProducerProductId(Long producerProductId) {
        this.producerProductId = producerProductId;
    }

    public String getProducerProductSku() {
        return producerProductSku;
    }

    public void setProducerProductSku(String producerProductSku) {
        this.producerProductSku = producerProductSku;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public List<SLPD0805ISeller> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<SLPD0805ISeller> sellerList) {
        this.sellerList = sellerList;
    }
}
