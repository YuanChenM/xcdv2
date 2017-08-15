package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商生产资质-管理体系认证证书指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimIsoManagementSystemCertificationTarget extends BaseTarget {
    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 类型 */
    private boolean certTypeFlg;
    /** 资质证书类型（1：ISO9001  2：ISO22000  3：ISO14001） */
    private boolean isoTypeFlg;
    /** 证书编号 */
    private boolean certNoFlg;
    /** 认证标准 */
    private boolean certificationStandardFlg;
    /** 认证范围 */
    private boolean certificationScopeFlg;
    /** 发证日期及有效期 */
    private boolean issueDateValidPeriodFlg;
    /** 认证机构 */
    private boolean certificationAuthorityFlg;
    /** 认证证书URL */
    private boolean certUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isCertTypeFlg() {
        return certTypeFlg;
    }

    public void setCertTypeFlg(boolean certTypeFlg) {
        this.certTypeFlg = certTypeFlg;
    }

    public boolean isIsoTypeFlg() {
        return isoTypeFlg;
    }

    public void setIsoTypeFlg(boolean isoTypeFlg) {
        this.isoTypeFlg = isoTypeFlg;
    }

    public boolean isCertNoFlg() {
        return certNoFlg;
    }

    public void setCertNoFlg(boolean certNoFlg) {
        this.certNoFlg = certNoFlg;
    }

    public boolean isCertificationStandardFlg() {
        return certificationStandardFlg;
    }

    public void setCertificationStandardFlg(boolean certificationStandardFlg) {
        this.certificationStandardFlg = certificationStandardFlg;
    }

    public boolean isCertificationScopeFlg() {
        return certificationScopeFlg;
    }

    public void setCertificationScopeFlg(boolean certificationScopeFlg) {
        this.certificationScopeFlg = certificationScopeFlg;
    }

    public boolean isIssueDateValidPeriodFlg() {
        return issueDateValidPeriodFlg;
    }

    public void setIssueDateValidPeriodFlg(boolean issueDateValidPeriodFlg) {
        this.issueDateValidPeriodFlg = issueDateValidPeriodFlg;
    }

    public boolean isCertificationAuthorityFlg() {
        return certificationAuthorityFlg;
    }

    public void setCertificationAuthorityFlg(boolean certificationAuthorityFlg) {
        this.certificationAuthorityFlg = certificationAuthorityFlg;
    }

    public boolean isCertUrlFlg() {
        return certUrlFlg;
    }

    public void setCertUrlFlg(boolean certUrlFlg) {
        this.certUrlFlg = certUrlFlg;
    }
}
