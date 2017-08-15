package com.bms.order.bean.result;

import java.math.BigDecimal;

import com.bms.order.common.rest.result.RestSearchData;

/**
 * 配送通知单查询接口Result
 *
 * @author li_huiqian
 */
public class ORDR0303IL2RestResult extends RestSearchData {
    /**
     *
     */
    private static final long serialVersionUID = 7133855561176583542L;
    /**
     * 明细：配送明细ID
     */
    private Long distributionNotificationDetailId;

    /**
     * 获取明细：配送明细ID
     *
     * @return 明细：配送明细ID
     */
    public Long getDistributionNotificationDetailId() {
        return this.distributionNotificationDetailId;
    }

    /**
     * 设置明细：配送明细ID
     *
     * @param distributionNotificationDetailId
     */
    public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
        this.distributionNotificationDetailId = distributionNotificationDetailId;
    }

    /**
     * 明细：配送单ID
     */
    private Long distributionNotificationId;

    /**
     * 获取明细：配送单ID
     *
     * @return 明细：配送单ID
     */
    public Long getDistributionNotificationId() {
        return this.distributionNotificationId;
    }

    /**
     * 设置明细：配送单ID
     *
     * @param distributionNotificationId
     */
    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    /**
     * 明细：买家订单预配送明细ID
     */
    private Long buyerForcastDeliverDetailId;

    /**
     * 获取明细：买家订单预配送明细ID
     *
     * @return 明细：买家订单预配送明细ID
     */
    public Long getBuyerForcastDeliverDetailId() {
        return this.buyerForcastDeliverDetailId;
    }

    /**
     * 设置明细：买家订单预配送明细ID
     *
     * @param buyerForcastDeliverDetailId
     */
    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
    }

    /**
     * 商品：商品ID
     */
    private String goodsId;

    /**
     * 获取商品：商品ID
     *
     * @return 商品：商品ID
     */
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置商品：商品ID
     *
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 商品：商品SKU [【精确到生产商和卖家的SKU】]
     */
    private String sku;

    /**
     * 获取商品：商品SKU [【精确到生产商和卖家的SKU】]
     *
     * @return 商品：商品SKU [【精确到生产商和卖家的SKU】]
     */
    public String getSku() {
        return this.sku;
    }

    /**
     * 设置商品：商品SKU [【精确到生产商和卖家的SKU】]
     *
     * @param sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * 商品：批次编码 [【产品处无批次】]
     */
    private String batchCode;

    /**
     * 获取商品：批次编码 [【产品处无批次】]
     *
     * @return 商品：批次编码 [【产品处无批次】]
     */
    public String getBatchCode() {
        return this.batchCode;
    }

    /**
     * 设置商品：批次编码 [【产品处无批次】]
     *
     * @param batchCode
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    /**
     * 商品：商品单位
     */
    private String goodsUnit;

    /**
     * 获取商品：商品单位
     *
     * @return 商品：商品单位
     */
    public String getGoodsUnit() {
        return this.goodsUnit;
    }

    /**
     * 设置商品：商品单位
     *
     * @param goodsUnit
     */
    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    /**
     * 商品：卖家编码
     */
    private String sellerCode;

    /**
     * 获取商品：卖家编码
     *
     * @return 商品：卖家编码
     */
    public String getSellerCode() {
        return this.sellerCode;
    }

    /**
     * 设置商品：卖家编码
     *
     * @param sellerCode
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * 配送：配送数量 [需发货数量]
     */
    private BigDecimal distributionQuantity;

    /**
     * 获取配送：配送数量 [需发货数量]
     *
     * @return 配送：配送数量 [需发货数量]
     */
    public BigDecimal getDistributionQuantity() {
        return this.distributionQuantity;
    }

    /**
     * 设置配送：配送数量 [需发货数量]
     *
     * @param distributionQuantity
     */
    public void setDistributionQuantity(BigDecimal distributionQuantity) {
        this.distributionQuantity = distributionQuantity;
    }

    /**
     * 销售方：销售方编码
     */
    private String sellSideCode;

    /**
     * 获取销售方：销售方编码
     *
     * @return 销售方：销售方编码
     */
    public String getSellSideCode() {
        return this.sellSideCode;
    }

    /**
     * 设置销售方：销售方编码
     *
     * @param sellSideCode
     */
    public void setSellSideCode(String sellSideCode) {
        this.sellSideCode = sellSideCode;
    }

    /**
     * 区域：物流区名称
     */
    private String logisticsZoneName;

    /**
     * 获取区域：物流区名称
     *
     * @return 区域：物流区名称
     */
    public String getLogisticsZoneName() {
        return this.logisticsZoneName;
    }

    /**
     * 设置区域：物流区名称
     *
     * @param logisticsZoneName
     */
    public void setLogisticsZoneName(String logisticsZoneName) {
        this.logisticsZoneName = logisticsZoneName;
    }

    private Integer sortSeq;

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    private String itemName;
    private String brandName;
    private String sellSideType;
    private String manufacturerName;
    private String saleLabelName;
    private String smallPackageFeature;
    private String quantityPerPackage;
    private String netWeight;
    private String grossWeight;
    private String cartonSize;
    private String productLevel;
    private String sellSideName;
    private String sellerName;
    private String saleLabelCode;
    private String palletStandardStackQuantity;
    private String priceWay;
    private BigDecimal unitPrice;
    private BigDecimal kgPrice;
    private BigDecimal cancelQuantity;
    private BigDecimal receiveQuantity;
    private BigDecimal rejectQuantity;
    private BigDecimal returnQuantity;
    private BigDecimal planSendQuantity;
    private BigDecimal delayQuantity;
    private BigDecimal realSendQuantity;




    public BigDecimal getDelayQuantity() {
        return delayQuantity;
    }

    public void setDelayQuantity(BigDecimal delayQuantity) {
        this.delayQuantity = delayQuantity;
    }

    public BigDecimal getRealSendQuantity() {
        return realSendQuantity;
    }

    public void setRealSendQuantity(BigDecimal realSendQuantity) {
        this.realSendQuantity = realSendQuantity;
    }

    public String getSaleLabelCode() {
        return saleLabelCode;
    }

    public void setSaleLabelCode(String saleLabelCode) {
        this.saleLabelCode = saleLabelCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellSideName() {
        return sellSideName;
    }

    public void setSellSideName(String sellSideName) {
        this.sellSideName = sellSideName;
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

    public String getQuantityPerPackage() {
        return quantityPerPackage;
    }

    public void setQuantityPerPackage(String quantityPerPackage) {
        this.quantityPerPackage = quantityPerPackage;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
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

    public String getPalletStandardStackQuantity() {
        return palletStandardStackQuantity;
    }

    public void setPalletStandardStackQuantity(String palletStandardStackQuantity) {
        this.palletStandardStackQuantity = palletStandardStackQuantity;
    }

    public BigDecimal getCancelQuantity() {
        return cancelQuantity;
    }

    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    public BigDecimal getReceiveQuantity() {
        return receiveQuantity;
    }

    public void setReceiveQuantity(BigDecimal receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    public BigDecimal getRejectQuantity() {
        return rejectQuantity;
    }

    public void setRejectQuantity(BigDecimal rejectQuantity) {
        this.rejectQuantity = rejectQuantity;
    }

    public BigDecimal getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public BigDecimal getPlanSendQuantity() {
        return planSendQuantity;
    }

    public void setPlanSendQuantity(BigDecimal planSendQuantity) {
        this.planSendQuantity = planSendQuantity;
    }

    public String getPriceWay() {
        return priceWay;
    }

    public void setPriceWay(String priceWay) {
        this.priceWay = priceWay;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getKgPrice() {
        return kgPrice;
    }

    public void setKgPrice(BigDecimal kgPrice) {
        this.kgPrice = kgPrice;
    }
}
