package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdItemPropertyTarget extends BaseTarget {
    /**
     * 单品规格ID
     */
    private boolean itemPropertyIdFlg;
    /**
     * 货源，1：国产，2：进口
     */
    private boolean sourceTypeFlg;
    /**
     * 毛重（克）
     */
    private boolean grossWeightFlg;
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

    public boolean isItemPropertyIdFlg() {
        return itemPropertyIdFlg;
    }

    public void setItemPropertyIdFlg(boolean itemPropertyIdFlg) {
        this.itemPropertyIdFlg = itemPropertyIdFlg;
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

    public boolean isPalletStackingLimitFlg() {
        return palletStackingLimitFlg;
    }

    public void setPalletStackingLimitFlg(boolean palletStackingLimitFlg) {
        this.palletStackingLimitFlg = palletStackingLimitFlg;
    }
}
