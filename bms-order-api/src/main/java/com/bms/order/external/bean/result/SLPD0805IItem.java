package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/23.
 */ // 单品信息
public class SLPD0805IItem implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8523840283814851270L;
    // 单品Id
    private Long itemId;
    // 单品编码
    private String itemCode;
    // 单品SKU
    private String itemSku;
    // 单品名称
    private String itemName;
    // 规格
    private String specification;
    // 品种
    private SLPD0805IBreed breed;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public SLPD0805IBreed getBreed() {
        return breed;
    }

    public void setBreed(SLPD0805IBreed breed) {
        this.breed = breed;
    }
}
