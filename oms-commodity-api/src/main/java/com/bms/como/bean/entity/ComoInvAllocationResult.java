/*
 * 2017/04/12 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_inv_allocation_result对应的实体ComoInvAllocationResult</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoInvAllocationResult extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 结果明细ID */
    private String resultId;
    /** 划拨单ID */
    private Long allocationId;
    /** 美迪福货主编码 */
    private String consignee;
    /** 供应商ID */
    private Long supplierId;
    /** 供应商编码 */
    private String supplierCode;
    /** 供应商名称 */
    private String supplierName;
    /** 仓库ID */
    private Long whId;
    /** 仓库编码 */
    private String whCode;
    /** 仓库名称 */
    private String whName;
    /** SKU编码 */
    private String skuCode;
    /** 单位 */
    private String uom;
    /** 旧销售状态编码 */
    private String oldSaleStatus;
    /** 新销售状态编码 */
    private String newSaleStatus;
    /** 入库批次 */
    private String lotNo;
    /** 库存状态 */
    private String inventoryStu;
    /** 失败原因描述 */
    private String failReason;
    /** 计划数量 */
    private java.math.BigDecimal planQty;
    /** 执行数量 */
    private java.math.BigDecimal factQty;

    /**
     * <p>默认构造函数</p>
     */
    public ComoInvAllocationResult() {
    }

    /**
     * <p>结果明细ID</p>
     *
     * @return 结果明细ID
     */
    public String getResultId() {
        return resultId;
    }

    /**
     * <p>结果明细ID</p>
     *
     * @param resultId 结果明细ID
     */
    public void setResultId(String resultId) {
        this.resultId = resultId;
    }
    /**
     * <p>划拨单ID</p>
     *
     * @return 划拨单ID
     */
    public Long getAllocationId() {
        return allocationId;
    }

    /**
     * <p>划拨单ID</p>
     *
     * @param allocationId 划拨单ID
     */
    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }
    /**
     * <p>美迪福货主编码</p>
     *
     * @return 美迪福货主编码
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * <p>美迪福货主编码</p>
     *
     * @param consignee 美迪福货主编码
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
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
    /**
     * <p>仓库ID</p>
     *
     * @return 仓库ID
     */
    public Long getWhId() {
        return whId;
    }

    /**
     * <p>仓库ID</p>
     *
     * @param whId 仓库ID
     */
    public void setWhId(Long whId) {
        this.whId = whId;
    }
    /**
     * <p>仓库编码</p>
     *
     * @return 仓库编码
     */
    public String getWhCode() {
        return whCode;
    }

    /**
     * <p>仓库编码</p>
     *
     * @param whCode 仓库编码
     */
    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }
    /**
     * <p>仓库名称</p>
     *
     * @return 仓库名称
     */
    public String getWhName() {
        return whName;
    }

    /**
     * <p>仓库名称</p>
     *
     * @param whName 仓库名称
     */
    public void setWhName(String whName) {
        this.whName = whName;
    }
    /**
     * <p>SKU编码</p>
     *
     * @return SKU编码
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU编码</p>
     *
     * @param skuCode SKU编码
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>单位</p>
     *
     * @return 单位
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>单位</p>
     *
     * @param uom 单位
     */
    public void setUom(String uom) {
        this.uom = uom;
    }
    /**
     * <p>旧销售状态编码</p>
     *
     * @return 旧销售状态编码
     */
    public String getOldSaleStatus() {
        return oldSaleStatus;
    }

    /**
     * <p>旧销售状态编码</p>
     *
     * @param oldSaleStatus 旧销售状态编码
     */
    public void setOldSaleStatus(String oldSaleStatus) {
        this.oldSaleStatus = oldSaleStatus;
    }
    /**
     * <p>新销售状态编码</p>
     *
     * @return 新销售状态编码
     */
    public String getNewSaleStatus() {
        return newSaleStatus;
    }

    /**
     * <p>新销售状态编码</p>
     *
     * @param newSaleStatus 新销售状态编码
     */
    public void setNewSaleStatus(String newSaleStatus) {
        this.newSaleStatus = newSaleStatus;
    }
    /**
     * <p>入库批次</p>
     *
     * @return 入库批次
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>入库批次</p>
     *
     * @param lotNo 入库批次
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }
    /**
     * <p>库存状态</p>
     *
     * @return 库存状态
     */
    public String getInventoryStu() {
        return inventoryStu;
    }

    /**
     * <p>库存状态</p>
     *
     * @param inventoryStu 库存状态
     */
    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }
    /**
     * <p>失败原因描述</p>
     *
     * @return 失败原因描述
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * <p>失败原因描述</p>
     *
     * @param failReason 失败原因描述
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
    /**
     * <p>计划数量</p>
     *
     * @return 计划数量
     */
    public java.math.BigDecimal getPlanQty() {
        return planQty;
    }

    /**
     * <p>计划数量</p>
     *
     * @param planQty 计划数量
     */
    public void setPlanQty(java.math.BigDecimal planQty) {
        this.planQty = planQty;
    }
    /**
     * <p>执行数量</p>
     *
     * @return 执行数量
     */
    public java.math.BigDecimal getFactQty() {
        return factQty;
    }

    /**
     * <p>执行数量</p>
     *
     * @param factQty 执行数量
     */
    public void setFactQty(java.math.BigDecimal factQty) {
        this.factQty = factQty;
    }

}
