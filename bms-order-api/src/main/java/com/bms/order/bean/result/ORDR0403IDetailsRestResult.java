package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
public class ORDR0403IDetailsRestResult extends RestSearchData {

    private String disBatchCode;

    private String goodsId;

    private String sku;

    private String batch;

    private BigDecimal realSendQuantity;

    private Long buyerForcastDeliverDetailId;

    private String itemName;

    private String brandName;

    private String sellSideType;

    private String manufacturerName;

    private String batchCode;

    private String saleLabelName;

    private String smallPackageFeature;

    private Integer quantityPerPackage;

    private BigDecimal netWeight;

    private BigDecimal grossWeight;

    private String cartonSize;

    private String productLevel;

    private Integer palletStandardStackQuantity;

    private String priceWay;

    private BigDecimal realUnitPrice;

    private BigDecimal realKgPrice;

    private String goodsUnit;

    private BigDecimal planSendQuantity;

    public String getDisBatchCode() {
        return disBatchCode;
    }

    public void setDisBatchCode(String disBatchCode) {
        this.disBatchCode = disBatchCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSellSideType() {
        return sellSideType;
    }

    public void setSellSideType(String sellSideType) {
        this.sellSideType = sellSideType;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
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

    public String getPriceWay() {
        return priceWay;
    }

    public void setPriceWay(String priceWay) {
        this.priceWay = priceWay;
    }

    public BigDecimal getRealUnitPrice() {
        return realUnitPrice;
    }

    public void setRealUnitPrice(BigDecimal realUnitPrice) {
        this.realUnitPrice = realUnitPrice;
    }

    public BigDecimal getRealKgPrice() {
        return realKgPrice;
    }

    public void setRealKgPrice(BigDecimal realKgPrice) {
        this.realKgPrice = realKgPrice;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public BigDecimal getPlanSendQuantity() {
        return planSendQuantity;
    }

    public void setPlanSendQuantity(BigDecimal planSendQuantity) {
        this.planSendQuantity = planSendQuantity;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public BigDecimal getRealSendQuantity() {
        return realSendQuantity;
    }

    public void setRealSendQuantity(BigDecimal realSendQuantity) {
        this.realSendQuantity = realSendQuantity;
    }

    public Long getBuyerForcastDeliverDetailId() {
        return buyerForcastDeliverDetailId;
    }

    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
    }
}
