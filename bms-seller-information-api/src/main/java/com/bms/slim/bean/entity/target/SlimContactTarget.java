package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0103I批量修改卖家联系人指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimContactTarget extends BaseTarget {
    /** 联系人名称 */
    private boolean contactNameFlg;
    /** 联系人类型 */
    private boolean contactTypeFlg;
    /** 手机号 */
    private boolean mobileFlg;
    /** 微信号 */
    private boolean wechatFlg;
    /** QQ号 */
    private boolean qqFlg;
    /** EMAIL地址 */
    private boolean emailFlg;

    public boolean isContactNameFlg() {
        return contactNameFlg;
    }

    public void setContactNameFlg(boolean contactNameFlg) {
        this.contactNameFlg = contactNameFlg;
    }

    public boolean isMobileFlg() {
        return mobileFlg;
    }

    public void setMobileFlg(boolean mobileFlg) {
        this.mobileFlg = mobileFlg;
    }

    public boolean isWechatFlg() {
        return wechatFlg;
    }

    public void setWechatFlg(boolean wechatFlg) {
        this.wechatFlg = wechatFlg;
    }

    public boolean isQqFlg() {
        return qqFlg;
    }

    public void setQqFlg(boolean qqFlg) {
        this.qqFlg = qqFlg;
    }

    public boolean isEmailFlg() {
        return emailFlg;
    }

    public void setEmailFlg(boolean emailFlg) {
        this.emailFlg = emailFlg;
    }

    public boolean isContactTypeFlg() {
        return contactTypeFlg;
    }

    public void setContactTypeFlg(boolean contactTypeFlg) {
        this.contactTypeFlg = contactTypeFlg;
    }
}
