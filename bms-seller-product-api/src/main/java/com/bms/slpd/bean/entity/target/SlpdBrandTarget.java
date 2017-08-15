/*
 * 2016/12/12 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity.target;


import com.bms.slpd.bean.BaseTarget;


/**
 * <p>表SLPD_BRAND_ITEM_PROPERTY对应的实体SlpdBrandItemProperty</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdBrandTarget extends BaseTarget {

    /** 品牌名称 */
    private boolean brandNameFlg;
    /** 品牌分类，1：一线品牌，2：二线品牌，3：一二线外品牌 */
    private boolean brandTypeFlg;
    /** 商标注册证号 */
    private boolean trademarkRegNoFlg;
    /** 有效期开始时间 */
    private boolean startValidDateFlg;
    /** 有效期结束时间 */
    private boolean endValidDateFlg;
    /** 品牌证书URL */
    private boolean brandCertUrlFlg;

    private boolean productPackageUrlFlg;
    private boolean honorCertNoFlg;
    private boolean honorCertDateFlg;
    private boolean honorCertUnitFlg;
    private boolean honorCertUrlFlg;

    /** 审核状态，0：待审核，1：正式 */
    private boolean auditStu;

    private boolean delFlgFlg;
    private boolean crtIdFlg;
    private boolean crtTimeFlg;
    private boolean updIdFlg;
    private boolean updTimeFlg;
    private boolean versionFlg;

    public boolean isBrandNameFlg() {
        return brandNameFlg;
    }

    public void setBrandNameFlg(boolean brandNameFlg) {
        this.brandNameFlg = brandNameFlg;
    }

    public boolean isBrandTypeFlg() {
        return brandTypeFlg;
    }

    public void setBrandTypeFlg(boolean brandTypeFlg) {
        this.brandTypeFlg = brandTypeFlg;
    }

    public boolean isTrademarkRegNoFlg() {
        return trademarkRegNoFlg;
    }

    public void setTrademarkRegNoFlg(boolean trademarkRegNoFlg) {
        this.trademarkRegNoFlg = trademarkRegNoFlg;
    }

    public boolean isStartValidDateFlg() {
        return startValidDateFlg;
    }

    public void setStartValidDateFlg(boolean startValidDateFlg) {
        this.startValidDateFlg = startValidDateFlg;
    }

    public boolean isEndValidDateFlg() {
        return endValidDateFlg;
    }

    public void setEndValidDateFlg(boolean endValidDateFlg) {
        this.endValidDateFlg = endValidDateFlg;
    }

    public boolean isBrandCertUrlFlg() {
        return brandCertUrlFlg;
    }

    public void setBrandCertUrlFlg(boolean brandCertUrlFlg) {
        this.brandCertUrlFlg = brandCertUrlFlg;
    }

    public boolean isProductPackageUrlFlg() {
        return productPackageUrlFlg;
    }

    public void setProductPackageUrlFlg(boolean productPackageUrlFlg) {
        this.productPackageUrlFlg = productPackageUrlFlg;
    }

    public boolean isHonorCertNoFlg() {
        return honorCertNoFlg;
    }

    public void setHonorCertNoFlg(boolean honorCertNoFlg) {
        this.honorCertNoFlg = honorCertNoFlg;
    }

    public boolean isHonorCertDateFlg() {
        return honorCertDateFlg;
    }

    public void setHonorCertDateFlg(boolean honorCertDateFlg) {
        this.honorCertDateFlg = honorCertDateFlg;
    }

    public boolean isHonorCertUnitFlg() {
        return honorCertUnitFlg;
    }

    public void setHonorCertUnitFlg(boolean honorCertUnitFlg) {
        this.honorCertUnitFlg = honorCertUnitFlg;
    }

    public boolean isHonorCertUrlFlg() {
        return honorCertUrlFlg;
    }

    public void setHonorCertUrlFlg(boolean honorCertUrlFlg) {
        this.honorCertUrlFlg = honorCertUrlFlg;
    }

    public boolean isAuditStu() {
        return auditStu;
    }

    public void setAuditStu(boolean auditStu) {
        this.auditStu = auditStu;
    }

    @Override
    public boolean isDelFlgFlg() {
        return delFlgFlg;
    }

    @Override
    public void setDelFlgFlg(boolean delFlgFlg) {
        this.delFlgFlg = delFlgFlg;
    }

    public boolean isCrtIdFlg() {
        return crtIdFlg;
    }

    public void setCrtIdFlg(boolean crtIdFlg) {
        this.crtIdFlg = crtIdFlg;
    }

    public boolean isCrtTimeFlg() {
        return crtTimeFlg;
    }

    public void setCrtTimeFlg(boolean crtTimeFlg) {
        this.crtTimeFlg = crtTimeFlg;
    }

    @Override
    public boolean isUpdIdFlg() {
        return updIdFlg;
    }

    @Override
    public void setUpdIdFlg(boolean updIdFlg) {
        this.updIdFlg = updIdFlg;
    }

    @Override
    public boolean isUpdTimeFlg() {
        return updTimeFlg;
    }

    @Override
    public void setUpdTimeFlg(boolean updTimeFlg) {
        this.updTimeFlg = updTimeFlg;
    }

    @Override
    public boolean isVersionFlg() {
        return versionFlg;
    }

    @Override
    public void setVersionFlg(boolean versionFlg) {
        this.versionFlg = versionFlg;
    }
}
