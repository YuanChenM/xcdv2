package com.bms.slpd.bean.entity.target;


import com.bms.slpd.bean.BaseTarget;

import java.util.Date;


public class SlpdBrandItemPropertyTarget extends BaseTarget {
    /**
     * 品牌单品规格ID
     */
    private boolean brandItemPropertyIdFlg;
    /**
     * 品牌单品ID
     */
    private boolean brandItemIdFlg;
    /**
     * 产品ID
     */
    private boolean productIdFlg;
    /**
     * 质量等级，1：A1，2：A2
     */
    private boolean qualityGradeTypeFlg;
    /**
     * 货源，1：国产，2：进口
     */
    private boolean sourceTypeFlg;
    /**
     * 毛重（克）
     */
    private boolean grossWeightFlg;
    /**
     * 净重（克）
     */
    private boolean netWeightFlg;
    /**
     * 包装规格
     */
    private boolean packageSpecificationFlg;
    /**
     * 包装数量
     */
    private boolean packageQuantityFlg;
    /**
     * 纸箱尺寸（cm），长*宽*高
     */
    private boolean cartonDimensionFlg;
    /**
     * 纸箱长度（cm）
     */
    private boolean cartonLengthFlg;
    /**
     * 纸箱宽度（cm）
     */
    private boolean cartonWidthFlg;
    /**
     * 纸箱高度（cm）
     */
    private boolean cartonHeightFlg;
    /**
     * 托盘堆码数（箱）
     */
    private boolean palletStackingLimitFlg;

    public boolean isBrandItemPropertyIdFlg() {
        return brandItemPropertyIdFlg;
    }

    public void setBrandItemPropertyIdFlg(boolean brandItemPropertyIdFlg) {
        this.brandItemPropertyIdFlg = brandItemPropertyIdFlg;
    }

    public boolean isBrandItemIdFlg() {
        return brandItemIdFlg;
    }

    public void setBrandItemIdFlg(boolean brandItemIdFlg) {
        this.brandItemIdFlg = brandItemIdFlg;
    }

    public boolean isProductIdFlg() {
        return productIdFlg;
    }

    public void setProductIdFlg(boolean productIdFlg) {
        this.productIdFlg = productIdFlg;
    }

    public boolean isQualityGradeTypeFlg() {
        return qualityGradeTypeFlg;
    }

    public void setQualityGradeTypeFlg(boolean qualityGradeTypeFlg) {
        this.qualityGradeTypeFlg = qualityGradeTypeFlg;
    }

    public boolean isSourceTypeFlg() {
        return sourceTypeFlg;
    }

    public void setSourceTypeFlg(boolean sourceTypeFlg) {
        this.sourceTypeFlg = sourceTypeFlg;
    }

    public boolean isGrossWeightFlg() {
        return grossWeightFlg;
    }

    public void setGrossWeightFlg(boolean grossWeightFlg) {
        this.grossWeightFlg = grossWeightFlg;
    }

    public boolean isNetWeightFlg() {
        return netWeightFlg;
    }

    public void setNetWeightFlg(boolean netWeightFlg) {
        this.netWeightFlg = netWeightFlg;
    }

    public boolean isPackageSpecificationFlg() {
        return packageSpecificationFlg;
    }

    public void setPackageSpecificationFlg(boolean packageSpecificationFlg) {
        this.packageSpecificationFlg = packageSpecificationFlg;
    }

    public boolean isPackageQuantityFlg() {
        return packageQuantityFlg;
    }

    public void setPackageQuantityFlg(boolean packageQuantityFlg) {
        this.packageQuantityFlg = packageQuantityFlg;
    }

    public boolean isCartonDimensionFlg() {
        return cartonDimensionFlg;
    }

    public void setCartonDimensionFlg(boolean cartonDimensionFlg) {
        this.cartonDimensionFlg = cartonDimensionFlg;
    }

    public boolean isPalletStackingLimitFlg() {
        return palletStackingLimitFlg;
    }

    public void setPalletStackingLimitFlg(boolean palletStackingLimitFlg) {
        this.palletStackingLimitFlg = palletStackingLimitFlg;
    }

    public boolean isCartonLengthFlg() {
        return cartonLengthFlg;
    }

    public void setCartonLengthFlg(boolean cartonLengthFlg) {
        this.cartonLengthFlg = cartonLengthFlg;
    }

    public boolean isCartonWidthFlg() {
        return cartonWidthFlg;
    }

    public void setCartonWidthFlg(boolean cartonWidthFlg) {
        this.cartonWidthFlg = cartonWidthFlg;
    }

    public boolean isCartonHeightFlg() {
        return cartonHeightFlg;
    }

    public void setCartonHeightFlg(boolean cartonHeightFlg) {
        this.cartonHeightFlg = cartonHeightFlg;
    }
}
