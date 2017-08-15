package com.bms.order.external.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

/**
 *
 */
public class COMO0307ProductDetailIRestResult extends RestSearchData {
    /**
     * 制造商产品SKU，和仓库实物SKU编码一致
     */
    private String skuCode;
    /**
     * 生产商ID
     */
    private String producerId;

    /**
     * 生产商编码
     */
    private String producerCode;
    /**
     * 生产商名称
     */
    private String producerName;
    /**
     * 库存状态
     */
    private String inventoryStu;
    /**
     * 指定的入库批次
     */
    private String lotNo;
    /**
     * 货权人类型
     */
    private String ownerType;
    /**
     * 货权人Id
     */
    private Long ownerId;

    /**
     * 货权人编码
     */
    private String ownerCode;
    /**
     * 货权人名称
     */
    private String ownerName;


    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
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

    public String getInventoryStu() {
        return inventoryStu;
    }

    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
