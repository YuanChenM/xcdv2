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
public class SlpdBrandOwnerTarget extends BaseTarget {

    /** 品牌所有人名称（版权人） */
    private boolean ownerNameFlg;
    /** 品牌所有人类型，1：生产商，2：制造商，3：卖家 */
    private boolean ownerTypeFlg;

    private boolean delFlgFlg;
    private boolean crtIdFlg;
    private boolean crtTimeFlg;
    private boolean updIdFlg;
    private boolean updTimeFlg;
    private boolean versionFlg;


    public boolean isOwnerNameFlg() {
        return ownerNameFlg;
    }

    public void setOwnerNameFlg(boolean ownerNameFlg) {
        this.ownerNameFlg = ownerNameFlg;
    }

    public boolean isOwnerTypeFlg() {
        return ownerTypeFlg;
    }

    public void setOwnerTypeFlg(boolean ownerTypeFlg) {
        this.ownerTypeFlg = ownerTypeFlg;
    }

    public boolean isDelFlgFlg() {
        return delFlgFlg;
    }

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

    public boolean isUpdIdFlg() {
        return updIdFlg;
    }

    public void setUpdIdFlg(boolean updIdFlg) {
        this.updIdFlg = updIdFlg;
    }

    public boolean isUpdTimeFlg() {
        return updTimeFlg;
    }

    public void setUpdTimeFlg(boolean updTimeFlg) {
        this.updTimeFlg = updTimeFlg;
    }

    public boolean isVersionFlg() {
        return versionFlg;
    }

    public void setVersionFlg(boolean versionFlg) {
        this.versionFlg = versionFlg;
    }
}
