/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0112I批量修改卖家代理商供应资质指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimManufacturerSupplyQualificationTarget extends BaseTarget {

    /** 实体卖家ID */
    private boolean entitySellerIdFlg;
    /** 受托生产商名称 */
    private boolean entrustedProducerNameFlg;
    /** OEM生产商名称 */
    private boolean oemProducerNameFlg;
    /** OEM有效期限 */
    private boolean oemValidPeriodFlg;
    /** 生产商OEM协议URL */
    private boolean oemProtocolUrlFlg;
    /** 食品经营许可证编号 */
    private boolean foodBizLicNoFlg;
    /** 食品经营许可证有效期限 */
    private boolean fblValidPeriodFlg;
    /** 食品经营许可证URL */
    private boolean foodBizLicUrlFlg;

    public boolean isEntitySellerIdFlg() {
        return entitySellerIdFlg;
    }

    public void setEntitySellerIdFlg(boolean entitySellerIdFlg) {
        this.entitySellerIdFlg = entitySellerIdFlg;
    }

    public boolean isEntrustedProducerNameFlg() {
        return entrustedProducerNameFlg;
    }

    public void setEntrustedProducerNameFlg(boolean entrustedProducerNameFlg) {
        this.entrustedProducerNameFlg = entrustedProducerNameFlg;
    }

    public boolean isOemProducerNameFlg() {
        return oemProducerNameFlg;
    }

    public void setOemProducerNameFlg(boolean oemProducerNameFlg) {
        this.oemProducerNameFlg = oemProducerNameFlg;
    }

    public boolean isOemValidPeriodFlg() {
        return oemValidPeriodFlg;
    }

    public void setOemValidPeriodFlg(boolean oemValidPeriodFlg) {
        this.oemValidPeriodFlg = oemValidPeriodFlg;
    }

    public boolean isOemProtocolUrlFlg() {
        return oemProtocolUrlFlg;
    }

    public void setOemProtocolUrlFlg(boolean oemProtocolUrlFlg) {
        this.oemProtocolUrlFlg = oemProtocolUrlFlg;
    }

    public boolean isFoodBizLicNoFlg() {
        return foodBizLicNoFlg;
    }

    public void setFoodBizLicNoFlg(boolean foodBizLicNoFlg) {
        this.foodBizLicNoFlg = foodBizLicNoFlg;
    }

    public boolean isFblValidPeriodFlg() {
        return fblValidPeriodFlg;
    }

    public void setFblValidPeriodFlg(boolean fblValidPeriodFlg) {
        this.fblValidPeriodFlg = fblValidPeriodFlg;
    }

    public boolean isFoodBizLicUrlFlg() {
        return foodBizLicUrlFlg;
    }

    public void setFoodBizLicUrlFlg(boolean foodBizLicUrlFlg) {
        this.foodBizLicUrlFlg = foodBizLicUrlFlg;
    }
}
