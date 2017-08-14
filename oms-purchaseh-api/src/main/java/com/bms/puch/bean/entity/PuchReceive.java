/*
 * 2017/03/16 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.puch.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表puch_receive对应的实体PuchReceive</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PuchReceive extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 采购入库ID
     */
    private Long deliverId;
    /**
     * 入库单号,SRM的入库单号
     */
    private String deliverCode;
    /**
     * 货权人类型，CodeMaster,平台卖家，买手
     */
    private String ownerType;
    /**
     * 货权人ID
     */
    private String ownerId;
    /**
     * 货权人编码
     */
    private String ownerCode;
    /**
     * 货权人名称
     */
    private String ownerName;
    /**
     * 物流区域ID
     */
    private Long lgcsAreaId;
    /**
     * 物流区域编码
     */
    private String lgcsAreaCode;
    /**
     * 物流区域名称
     */
    private String lgcsAreaName;
    /**
     * 供应商ID
     */
    private Long supplierId;
    /**
     * 供应商编码
     */
    private String supplierCode;
    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * <p>默认构造函数</p>
     */
    public PuchReceive() {
    }

    /**
     * <p>采购入库ID</p>
     *
     * @return 采购入库ID
     */
    public Long getDeliverId() {
        return deliverId;
    }

    /**
     * <p>采购入库ID</p>
     *
     * @param deliverId 采购入库ID
     */
    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    /**
     * <p>入库单号,SRM的入库单号</p>
     *
     * @return 入库单号, SRM的入库单号
     */
    public String getDeliverCode() {
        return deliverCode;
    }

    /**
     * <p>入库单号,SRM的入库单号</p>
     *
     * @param deliverCode 入库单号,SRM的入库单号
     */
    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    /**
     * <p>货权人类型，CodeMaster,平台卖家，买手</p>
     *
     * @return 货权人类型，CodeMaster,平台卖家，买手
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * <p>货权人类型，CodeMaster,平台卖家，买手</p>
     *
     * @param ownerType 货权人类型，CodeMaster,平台卖家，买手
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * <p>货权人ID</p>
     *
     * @return 货权人ID
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * <p>货权人ID</p>
     *
     * @param ownerId 货权人ID
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * <p>货权人编码</p>
     *
     * @return 货权人编码
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * <p>货权人编码</p>
     *
     * @param ownerCode 货权人编码
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    /**
     * <p>货权人名称</p>
     *
     * @return 货权人名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * <p>货权人名称</p>
     *
     * @param ownerName 货权人名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @return 物流区域ID
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @param lgcsAreaId 物流区域ID
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    /**
     * <p>物流区域编码</p>
     *
     * @return 物流区域编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区域编码</p>
     *
     * @param lgcsAreaCode 物流区域编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * <p>物流区域名称</p>
     *
     * @return 物流区域名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区域名称</p>
     *
     * @param lgcsAreaName 物流区域名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * <p>供应商ID</p>
     *
     * @return 供应商ID
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * <p>供应商ID</p>
     *
     * @param supplierId 供应商ID
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * <p>供应商编码</p>
     *
     * @return 供应商编码
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * <p>供应商编码</p>
     *
     * @param supplierCode 供应商编码
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * <p>供应商名称</p>
     *
     * @return 供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * <p>供应商名称</p>
     *
     * @param supplierName 供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

}
