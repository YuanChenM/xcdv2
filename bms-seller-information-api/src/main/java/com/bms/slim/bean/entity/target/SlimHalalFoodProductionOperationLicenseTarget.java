package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商生产资质-清真食品生产经营许可证指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimHalalFoodProductionOperationLicenseTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 证书编号 */
    private boolean certNoFlg;
    /** 商检证书号码 */
    private boolean commInspCertNoFlg;
    /** 签发日期 */
    private boolean issueDateBeginFlg;
    /** 签发截止日期 */
    private boolean issueDateEndFlg;
    /** 签发机构 */
    private boolean issueAuthorityFlg;
    /** 清真食品生产经营许可证URL */
    private boolean halalFoodProdOptLicUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isCertNoFlg() {
        return certNoFlg;
    }

    public void setCertNoFlg(boolean certNoFlg) {
        this.certNoFlg = certNoFlg;
    }

    public boolean isCommInspCertNoFlg() {
        return commInspCertNoFlg;
    }

    public void setCommInspCertNoFlg(boolean commInspCertNoFlg) {
        this.commInspCertNoFlg = commInspCertNoFlg;
    }

    public boolean isIssueDateBeginFlg() {
        return issueDateBeginFlg;
    }

    public void setIssueDateBeginFlg(boolean issueDateBeginFlg) {
        this.issueDateBeginFlg = issueDateBeginFlg;
    }

    public boolean isIssueDateEndFlg() {
        return issueDateEndFlg;
    }

    public void setIssueDateEndFlg(boolean issueDateEndFlg) {
        this.issueDateEndFlg = issueDateEndFlg;
    }

    public boolean isIssueAuthorityFlg() {
        return issueAuthorityFlg;
    }

    public void setIssueAuthorityFlg(boolean issueAuthorityFlg) {
        this.issueAuthorityFlg = issueAuthorityFlg;
    }

    public boolean isHalalFoodProdOptLicUrlFlg() {
        return halalFoodProdOptLicUrlFlg;
    }

    public void setHalalFoodProdOptLicUrlFlg(boolean halalFoodProdOptLicUrlFlg) {
        this.halalFoodProdOptLicUrlFlg = halalFoodProdOptLicUrlFlg;
    }
}
