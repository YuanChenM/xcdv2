/*
 * 2017/04/14 自动生成 新规作成
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;

/**
 * <p>
 * 表invm_como_inventory_adjust对应的实体InvmComoInventoryAdjust
 * </p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmComoInventoryAdjust extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 调整ID */
    private Long comoAdjustId;
    /** 调整单号 */
    private String comoAdjustCode;
    /** 物流区ID */
    private Long laId;
    /** 物流区编码 */
    private String laCode;
    /** 货权人ID */
    private String ownerId;
    /** 货权人编码 */
    private String ownerCode;
    /** 货权人类型，Master平台卖家，买手 */
    private String ownerType;
    /** 调整日期 */
    private Date adjustDate;
    /** 调整人 */
    private String adjustPerson;
    /** 备注 */
    private String remark;

    public InvmComoInventoryAdjust() {}

    public Long getComoAdjustId() {
        return comoAdjustId;
    }

    public void setComoAdjustId(Long comoAdjustId) {
        this.comoAdjustId = comoAdjustId;
    }

    public String getComoAdjustCode() {
        return comoAdjustCode;
    }

    public void setComoAdjustCode(String comoAdjustCode) {
        this.comoAdjustCode = comoAdjustCode;
    }

    public Long getLaId() {
        return laId;
    }

    public void setLaId(Long laId) {
        this.laId = laId;
    }

    public String getLaCode() {
        return laCode;
    }

    public void setLaCode(String laCode) {
        this.laCode = laCode;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    public String getAdjustPerson() {
        return adjustPerson;
    }

    public void setAdjustPerson(String adjustPerson) {
        this.adjustPerson = adjustPerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
