package com.batch.bybatch.bean.result;

import com.framework.core.utils.StringUtils;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/26.
 */
public class BuyerProductResult implements Serializable {
    //买家ID
    private String buyerId;
    //产品ID
    private String productId;
    //产品一级分类
    private Long classesId;
    //产品二级分类
    private Long machiningId;
    //品种ID
    private Long breedId;
    //单品ID
    private Long itemId;
    //单品品牌ID
    private Long brandId;
    //生产商ID
    private Long entitySellerId;

    public BuyerProductResult() {
    }

    public BuyerProductResult(String buyerId, String productId) {
        this.buyerId = buyerId;
        this.productId = productId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public Long getMachiningId() {
        return machiningId;
    }

    public void setMachiningId(Long machiningId) {
        this.machiningId = machiningId;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    @Override
    public boolean equals(Object obj) {
        BuyerProductResult s = (BuyerProductResult) obj;
        return buyerId.equals(s.buyerId) && productId.equals(s.productId);
    }

    @Override
    public int hashCode() {
        String in = buyerId + productId;
        return in.hashCode();
    }
}
