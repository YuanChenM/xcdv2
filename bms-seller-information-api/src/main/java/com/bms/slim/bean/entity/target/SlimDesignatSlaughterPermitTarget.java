package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商生产资质-定点屠宰许可证指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimDesignatSlaughterPermitTarget extends BaseTarget {
    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 批准号 */
    private boolean approvalNoFlg;
    /** 定点屠宰代码 */
    private boolean dsgtSlgtPrmtCodeFlg;
    /** 定点屠宰许可证URL */
    private boolean dsgtSlgtPrmtUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isApprovalNoFlg() {
        return approvalNoFlg;
    }

    public void setApprovalNoFlg(boolean approvalNoFlg) {
        this.approvalNoFlg = approvalNoFlg;
    }

    public boolean isDsgtSlgtPrmtCodeFlg() {
        return dsgtSlgtPrmtCodeFlg;
    }

    public void setDsgtSlgtPrmtCodeFlg(boolean dsgtSlgtPrmtCodeFlg) {
        this.dsgtSlgtPrmtCodeFlg = dsgtSlgtPrmtCodeFlg;
    }

    public boolean isDsgtSlgtPrmtUrlFlg() {
        return dsgtSlgtPrmtUrlFlg;
    }

    public void setDsgtSlgtPrmtUrlFlg(boolean dsgtSlgtPrmtUrlFlg) {
        this.dsgtSlgtPrmtUrlFlg = dsgtSlgtPrmtUrlFlg;
    }
}
