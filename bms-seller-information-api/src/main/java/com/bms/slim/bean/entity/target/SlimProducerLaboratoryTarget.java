package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0236I批量修改生产商实验室指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimProducerLaboratoryTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 面积 */
    private boolean acreageFlg;
    /** 功能 */
    private boolean effectFlg;
    /** 投资 */
    private boolean inverstnentFlg;
    /** 人员 */
    private boolean memberFlg;
    /** 实验室照片URL */
    private boolean labPicUrlFlg;
    /** 品控组织架构图URL */
    private boolean orgFrameImgUrlFlg;
    /** 质量控制系统图URL */
    private boolean qualityCtrlImgUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isAcreageFlg() {
        return acreageFlg;
    }

    public void setAcreageFlg(boolean acreageFlg) {
        this.acreageFlg = acreageFlg;
    }

    public boolean isEffectFlg() {
        return effectFlg;
    }

    public void setEffectFlg(boolean effectFlg) {
        this.effectFlg = effectFlg;
    }

    public boolean isInverstnentFlg() {
        return inverstnentFlg;
    }

    public void setInverstnentFlg(boolean inverstnentFlg) {
        this.inverstnentFlg = inverstnentFlg;
    }

    public boolean isMemberFlg() {
        return memberFlg;
    }

    public void setMemberFlg(boolean memberFlg) {
        this.memberFlg = memberFlg;
    }

    public boolean isLabPicUrlFlg() {
        return labPicUrlFlg;
    }

    public void setLabPicUrlFlg(boolean labPicUrlFlg) {
        this.labPicUrlFlg = labPicUrlFlg;
    }

    public boolean isOrgFrameImgUrlFlg() {
        return orgFrameImgUrlFlg;
    }

    public void setOrgFrameImgUrlFlg(boolean orgFrameImgUrlFlg) {
        this.orgFrameImgUrlFlg = orgFrameImgUrlFlg;
    }

    public boolean isQualityCtrlImgUrlFlg() {
        return qualityCtrlImgUrlFlg;
    }

    public void setQualityCtrlImgUrlFlg(boolean qualityCtrlImgUrlFlg) {
        this.qualityCtrlImgUrlFlg = qualityCtrlImgUrlFlg;
    }
}
