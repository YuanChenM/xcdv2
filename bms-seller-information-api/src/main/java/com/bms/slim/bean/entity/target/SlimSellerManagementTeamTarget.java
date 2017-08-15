package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0109I批量修改卖家经营团队指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimSellerManagementTeamTarget extends BaseTarget {

    /** 实体卖家ID */
    private boolean entitySellerIdFlg;
    /** 职务类型 */
    private boolean positionTypeFlg;
    /** 姓名 */
    private boolean nameFlg;
    /** 年龄 */
    private boolean ageFlg;
    /** 文化程度 */
    private boolean educationalLevelFlg;
    /** 联系方式 */
    private boolean contactWayFlg;
    /** 头像 */
    private boolean avatarUrlFlg;

    public boolean isEntitySellerIdFlg() {
        return entitySellerIdFlg;
    }

    public void setEntitySellerIdFlg(boolean entitySellerIdFlg) {
        this.entitySellerIdFlg = entitySellerIdFlg;
    }

    public boolean isPositionTypeFlg() {
        return positionTypeFlg;
    }

    public void setPositionTypeFlg(boolean positionTypeFlg) {
        this.positionTypeFlg = positionTypeFlg;
    }

    public boolean isNameFlg() {
        return nameFlg;
    }

    public void setNameFlg(boolean nameFlg) {
        this.nameFlg = nameFlg;
    }

    public boolean isAgeFlg() {
        return ageFlg;
    }

    public void setAgeFlg(boolean ageFlg) {
        this.ageFlg = ageFlg;
    }

    public boolean isEducationalLevelFlg() {
        return educationalLevelFlg;
    }

    public void setEducationalLevelFlg(boolean educationalLevelFlg) {
        this.educationalLevelFlg = educationalLevelFlg;
    }

    public boolean isContactWayFlg() {
        return contactWayFlg;
    }

    public void setContactWayFlg(boolean contactWayFlg) {
        this.contactWayFlg = contactWayFlg;
    }

    public boolean isAvatarUrlFlg() {
        return avatarUrlFlg;
    }

    public void setAvatarUrlFlg(boolean avatarUrlFlg) {
        this.avatarUrlFlg = avatarUrlFlg;
    }
}
