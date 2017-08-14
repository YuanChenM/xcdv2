package com.batch.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liutao on 2017/1/5.
 */
public class ORDR0201BOrderBatchDetailResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long buyerOrderId;

    private String buyerId;

    private String buyerType;

    private Long logisticsZoneId;

    private String bsId;

    private String bsType;

    private Long buyerBatchOrderId;

    private String goodsId;

    private String productId;

    private Long batchId;

    private Long saleLabelId;

    private String itemCode;

    private String itemName;

    private String brandCode;

    private String brandName;

    private String batchCode;

    private String saleLabelCode;

    private String saleLabelName;

    private String smallPackageFeature;

    private Integer quantityPerPackage;

    private BigDecimal netWeight;

    private BigDecimal grossWeight;

    private String cartonSize;

    private String productLevel;

    private Integer palletStandardStackQuantity;

    private Long buyerBatchOrderDetailId;

    private Boolean buyerBatchOrderFlg;

    private Boolean splitFlg;

    private BigDecimal goodsQuantity;

    private String sellSideCode;

    private String sellSideName;

    private String sellSideType;

    private String sellSideId;

    private String regionalBsId;

    private String regionalBsCode;

    private String regionalBsName;

    private String nonRegionalBsId;

    private String nonRegionalBsCode;

    private String nonRegionalBsName;

    private String regionalDistributionBsId;

    private String regionalDistributionBsCode;

    private String regionalDistributionBsName;

    private String netUserBsId;

    private String goodsCode;

    private String goodsName;

    private String sellerId;

    private String sellerCode;

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

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getRegionalBsId() {
        return regionalBsId;
    }

    public void setRegionalBsId(String regionalBsId) {
        this.regionalBsId = regionalBsId;
    }

    public void setNonRegionalBsId(String nonRegionalBsId) {
        this.nonRegionalBsId = nonRegionalBsId;
    }

    public void setRegionalDistributionBsId(String regionalDistributionBsId) {
        this.regionalDistributionBsId = regionalDistributionBsId;
    }

    public void setNetUserBsId(String netUserBsId) {
        this.netUserBsId = netUserBsId;
    }

    private String netUserBsCode;

    private String netUserBsName;

    public String getRegionalBsCode() {
        return regionalBsCode;
    }

    public void setRegionalBsCode(String regionalBsCode) {
        this.regionalBsCode = regionalBsCode;
    }

    public String getRegionalBsName() {
        return regionalBsName;
    }

    public void setRegionalBsName(String regionalBsName) {
        this.regionalBsName = regionalBsName;
    }


    public String getNonRegionalBsCode() {
        return nonRegionalBsCode;
    }

    public void setNonRegionalBsCode(String nonRegionalBsCode) {
        this.nonRegionalBsCode = nonRegionalBsCode;
    }

    public String getNonRegionalBsName() {
        return nonRegionalBsName;
    }

    public void setNonRegionalBsName(String nonRegionalBsName) {
        this.nonRegionalBsName = nonRegionalBsName;
    }

    public String getRegionalDistributionBsCode() {
        return regionalDistributionBsCode;
    }

    public void setRegionalDistributionBsCode(String regionalDistributionBsCode) {
        this.regionalDistributionBsCode = regionalDistributionBsCode;
    }

    public String getRegionalDistributionBsName() {
        return regionalDistributionBsName;
    }

    public void setRegionalDistributionBsName(String regionalDistributionBsName) {
        this.regionalDistributionBsName = regionalDistributionBsName;
    }

    public String getNonRegionalBsId() {
        return nonRegionalBsId;
    }

    public String getNetUserBsId() {
        return netUserBsId;
    }

    public String getRegionalDistributionBsId() {
        return regionalDistributionBsId;
    }

    public String getNetUserBsCode() {
        return netUserBsCode;
    }

    public void setNetUserBsCode(String netUserBsCode) {
        this.netUserBsCode = netUserBsCode;
    }

    public String getNetUserBsName() {
        return netUserBsName;
    }

    public void setNetUserBsName(String netUserBsName) {
        this.netUserBsName = netUserBsName;
    }

    public String getSellSideName() {
        return sellSideName;
    }

    public void setSellSideName(String sellSideName) {
        this.sellSideName = sellSideName;
    }

    public String getSellSideType() {
        return sellSideType;
    }

    public void setSellSideType(String sellSideType) {
        this.sellSideType = sellSideType;
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

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public Long getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    public String getBsType() {
        return bsType;
    }

    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    public Long getBuyerBatchOrderId() {
        return buyerBatchOrderId;
    }

    public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
        this.buyerBatchOrderId = buyerBatchOrderId;
    }

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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public Long getBuyerBatchOrderDetailId() {
        return buyerBatchOrderDetailId;
    }

    public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
        this.buyerBatchOrderDetailId = buyerBatchOrderDetailId;
    }

    public Boolean getBuyerBatchOrderFlg() {
        return buyerBatchOrderFlg;
    }

    public void setBuyerBatchOrderFlg(Boolean buyerBatchOrderFlg) {
        this.buyerBatchOrderFlg = buyerBatchOrderFlg;
    }

    public Boolean getSplitFlg() {
        return splitFlg;
    }

    public void setSplitFlg(Boolean splitFlg) {
        this.splitFlg = splitFlg;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
}
