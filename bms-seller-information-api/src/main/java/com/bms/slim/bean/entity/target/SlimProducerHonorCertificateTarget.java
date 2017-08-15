package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商荣誉证书指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimProducerHonorCertificateTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 发证机关 */
    private boolean issueAuthorityFlg;
    /** 发证日期 */
    private boolean issueDateFlg;
    /** 荣誉证书 */
    private boolean honorCertUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isIssueAuthorityFlg() {
        return issueAuthorityFlg;
    }

    public void setIssueAuthorityFlg(boolean issueAuthorityFlg) {
        this.issueAuthorityFlg = issueAuthorityFlg;
    }

    public boolean isIssueDateFlg() {
        return issueDateFlg;
    }

    public void setIssueDateFlg(boolean issueDateFlg) {
        this.issueDateFlg = issueDateFlg;
    }

    public boolean isHonorCertUrlFlg() {
        return honorCertUrlFlg;
    }

    public void setHonorCertUrlFlg(boolean honorCertUrlFlg) {
        this.honorCertUrlFlg = honorCertUrlFlg;
    }
}
