package com.bms.order.external.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * /*单品品牌规格 Created by Administrator on 2017/2/23.
 */
public class SLPD0805IBrandItemProperty implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4752941337295404079L;
    // 单品品牌规格ID
    private Long brandItemPropertyId;
    // 货源，1：国产，2：进口
    private String sourceType;
    private String sourceTypeStr;
    /* 毛重（克） */
    private BigDecimal grossWeight;
    // 净重（克）
    private BigDecimal netWeight;
    // 包装规格
    private String packageSpecification;
    // 包装数量
    private Integer packageQuantity;
    // 纸箱尺寸（cm），长*宽*高
    private String cartonDimension;
    // 托盘堆码数（箱）
    private Integer palletStackingLimit;
    // 单品品牌ID
    private Long brandItemId;
    // 单品品牌SKU
    private String brandItemSku;
    // 品牌信息
    private SLPD0805IBrand brand;
    // 单品
    private SLPD0805IItem item;

    public Long getBrandItemPropertyId() {
        return brandItemPropertyId;
    }

    public void setBrandItemPropertyId(Long brandItemPropertyId) {
        this.brandItemPropertyId = brandItemPropertyId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceTypeStr() {
        return sourceTypeStr;
    }

    public void setSourceTypeStr(String sourceTypeStr) {
        this.sourceTypeStr = sourceTypeStr;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getCartonDimension() {
        return cartonDimension;
    }

    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }

    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }

    public Long getBrandItemId() {
        return brandItemId;
    }

    public void setBrandItemId(Long brandItemId) {
        this.brandItemId = brandItemId;
    }

    public String getBrandItemSku() {
        return brandItemSku;
    }

    public void setBrandItemSku(String brandItemSku) {
        this.brandItemSku = brandItemSku;
    }

    public SLPD0805IBrand getBrand() {
        return brand;
    }

    public void setBrand(SLPD0805IBrand brand) {
        this.brand = brand;
    }

    public SLPD0805IItem getItem() {
        return item;
    }

    public void setItem(SLPD0805IItem item) {
        this.item = item;
    }
}
