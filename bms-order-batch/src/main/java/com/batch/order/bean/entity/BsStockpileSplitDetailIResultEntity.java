package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by wu_honglei on 2017/1/10. 买手囤货分拆单明细
 */
public class BsStockpileSplitDetailIResultEntity extends BaseEntity {
    private Long bsStockpileSplitDetailId;// 买手囤货分拆单明细ID
    private String sellSideId;// 销售方ID
    private Long privategoodsId;// 商品ID
    private Long bsOrderDetailId;// 买手订单明细id
    private String productId;// 产品ID
    private Long manufacturerId;// 生产商ID
    private String sellerId;// 卖家ID
    private Long batchId;// 批次ID
    private Long saleLabelId;// 销售标签ID
    private BigDecimal planSendQuantity;// 商品数量
    private BigDecimal returnQuantity;// 退货数量
    private String sellSideName;// 销售方名称
    private String sellSideCode;// 销售方编码
    private String itemCode;// 单品编码
    private String itemName;// 单品名称
    private String brandCode;// 品牌编码
    private String brandName;// 品牌名称
    private String itemBrandCode;// 单品品牌编码
    private String manufacturerCode;// 生产商编码
    private String manufacturerName;// 生产商名称
    private String sellerCode;// 卖家编码
    private String sellerName;// 卖家名称
    private String batchCode;// 批次编码
    private String saleLabelCode;// 销售标签编码
    private String saleLabelName;// 销售标签名称
    private String smallPackageFeature;// 小包装特征
    private Integer quantityPerPackage;// 小包装件数/大包装个数
    private BigDecimal netWeight;// 净重
    private BigDecimal grossWeight;// 毛重
    private String cartonSize;// 纸箱尺寸
    private String productLevel;// 产品等级
    private Integer palletStandardStackQuantity;// 托盘标准堆码数（箱）
    private Integer sortSeq;// 排序序列号

    public Long getBsStockpileSplitDetailId() {
        return bsStockpileSplitDetailId;
    }

    public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
        this.bsStockpileSplitDetailId = bsStockpileSplitDetailId;
    }

    public String getSellSideId() {
        return sellSideId;
    }

    public void setSellSideId(String sellSideId) {
        this.sellSideId = sellSideId;
    }

    public Long getPrivategoodsId() {
        return privategoodsId;
    }

    public void setPrivategoodsId(Long privategoodsId) {
        this.privategoodsId = privategoodsId;
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

    public BigDecimal getPlanSendQuantity() {
        return planSendQuantity;
    }

    public void setPlanSendQuantity(BigDecimal planSendQuantity) {
        this.planSendQuantity = planSendQuantity;
    }

    public BigDecimal getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public String getSellSideName() {
        return sellSideName;
    }

    public void setSellSideName(String sellSideName) {
        this.sellSideName = sellSideName;
    }

    public String getSellSideCode() {
        return sellSideCode;
    }

    public void setSellSideCode(String sellSideCode) {
        this.sellSideCode = sellSideCode;
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

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    public Long getBsOrderDetailId() {
        return bsOrderDetailId;
    }

    public void setBsOrderDetailId(Long bsOrderDetailId) {
        this.bsOrderDetailId = bsOrderDetailId;
    }
}
