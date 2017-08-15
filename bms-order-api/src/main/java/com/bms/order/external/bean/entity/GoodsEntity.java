package com.bms.order.external.bean.entity;

import java.math.BigDecimal;

/**
 * 商品Entity
 * 
 * @author li_huiqian
 *
 */
public final class GoodsEntity {
    /*商品ID*/
    private String goodsId;
    /*产品ID*/
    private String productId;
    /*生产商ID*/
    private Long manufacturerId;
    /*卖家ID*/
    private String sellerId;
    /*批次ID*/
    private Long batchId;
    /*商品：销售标签ID*/
    private Long saleLabelId;
    /*单品ID*/
    private String itemId;
    /*单品编码*/
    private String itemCode;
    /*单品名称*/
    private String itemName;
    /*品牌编码*/
    private String brandCode;
    /*品牌ID*/
    private String brandId;
    /*品牌名称*/
    private String brandName;
    /*单品品牌编码*/
    private String itemBrandCode;
    /*生产商编码*/
    private String manufacturerCode;
    /*生产商名称*/
    private String manufacturerName;
    /*卖家编码*/
    private String sellerCode;
    /*卖家名称*/
    private String sellerName;
    /*批次编码*/
    private String batchCode;
    /*销售标签编码*/
    private String saleLabelCode;
    /*销售标签名称*/
    private String saleLabelName;
    /*小包装特征*/
    private String smallPackageFeature;
    /* 小包装件数/大包装个数 */
    private Integer quantityPerPackage;
    /* 净重（克） */
    private BigDecimal netWeight;
    /*毛重（克）*/
    private BigDecimal grossWeight;
    /*纸箱尺寸*/
    private String cartonSize;
    /*产品等级*/
    private String productLevel;
    /*产品等级1：A1，2：A2，3：A3*/
    private String productLevelName;
    /* 托盘标准堆码数（箱） */
    private Integer palletStandardStackQuantity;
    /* 供货主体ID/销售方ID */
    private String sellSideId;
    /*销售方编码*/
    private String sellSideCode;
    /*销售方名称*/
    private String sellSideName;
    /*商品SKU*/
    private String sku;
    /*单品编码*/
    private String goodsCode;
    /*单品名称*/
    private String goodsName;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getSaleLabelId() {
        return saleLabelId;
    }

    public void setSaleLabelId(Long saleLabelId) {
        this.saleLabelId = saleLabelId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getItemBrandCode() {
        return itemBrandCode;
    }

    public void setItemBrandCode(String itemBrandCode) {
        this.itemBrandCode = itemBrandCode;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getSaleLabelCode() {
        return saleLabelCode;
    }

    public void setSaleLabelCode(String saleLabelCode) {
        this.saleLabelCode = saleLabelCode;
    }

    public String getSaleLabelName() {
        return saleLabelName;
    }

    public void setSaleLabelName(String saleLabelName) {
        this.saleLabelName = saleLabelName;
    }

    public String getSmallPackageFeature() {
        return smallPackageFeature;
    }

    public void setSmallPackageFeature(String smallPackageFeature) {
        this.smallPackageFeature = smallPackageFeature;
    }

    public Integer getQuantityPerPackage() {
        return quantityPerPackage;
    }

    public void setQuantityPerPackage(Integer quantityPerPackage) {
        this.quantityPerPackage = quantityPerPackage;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(String cartonSize) {
        this.cartonSize = cartonSize;
    }

    public String getProductLevel() {
        return productLevel;
    }

    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    public Integer getPalletStandardStackQuantity() {
        return palletStandardStackQuantity;
    }

    public void setPalletStandardStackQuantity(Integer palletStandardStackQuantity) {
        this.palletStandardStackQuantity = palletStandardStackQuantity;
    }

    public String getSellSideId() {
        return sellSideId;
    }

    public void setSellSideId(String sellSideId) {
        this.sellSideId = sellSideId;
    }

    public String getSellSideCode() {
        return sellSideCode;
    }

    public void setSellSideCode(String sellSideCode) {
        this.sellSideCode = sellSideCode;
    }

    public String getSellSideName() {
        return sellSideName;
    }

    public void setSellSideName(String sellSideName) {
        this.sellSideName = sellSideName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductLevelName() {
        return productLevelName;
    }

    public void setProductLevelName(String productLevelName) {
        this.productLevelName = productLevelName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
