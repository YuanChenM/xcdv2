/*
 * 2017/03/16 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.puch.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;

/**
 * <p>表puch_detail对应的实体PuchDetail</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PuchDetail extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 入库明细ID
     */
    private Long deliverDetailId;
    /**
     * 入库ID
     */
    private Long deliverId;
    /**
     * 采购单号
     */
    private String orderCode;
    /**
     * 采购类型,CodeMaster
     */
    private String orderType;
    /**
     * 计划入库单号
     */
    private String scheduleCode;
    /**
     * 计划入库时间
     */
    private java.util.Date scheduleDate;
    /**
     * 仓库ID
     */
    private Long whId;
    /**
     * 仓库编码
     */
    private String whCode;
    /**
     * 仓库名称
     */
    private String whName;
    /**
     * 与仓库实物产品SKU一致
     */
    private String materialCode;
    /**
     * 与仓库实物产品名称一致
     */
    private String materialName;
    /**
     * 商品ID
     */
    private Long commodityId;
    /**
     * 商品编码
     */
    private String commodityCode;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 入库产品单位
     */
    private String unit;
    /**
     * 入库批次
     */
    private String lotNo;
    /**
     * 销售标签,默认值可考虑设常量，与商品管理中一致
     */
    private String salesLabel;
    /**
     * 入库仓库状态,默认值可考虑设常量，与库存管理中保持一致
     */
    private String inventoryStatus;
    /**
     * 入库数量
     */
    private java.math.BigDecimal receiveQty;
    /**
     * 入库价格
     */
    private java.math.BigDecimal receivePrice;
    /**
     * 入库时间
     */
    private java.util.Date inboundDate;

    /**
     * <p>默认构造函数</p>
     */
    public PuchDetail() {
    }

    /**
     * <p>入库明细ID</p>
     *
     * @return 入库明细ID
     */
    public Long getDeliverDetailId() {
        return deliverDetailId;
    }

    /**
     * <p>入库明细ID</p>
     *
     * @param deliverDetailId 入库明细ID
     */
    public void setDeliverDetailId(Long deliverDetailId) {
        this.deliverDetailId = deliverDetailId;
    }

    /**
     * <p>入库ID</p>
     *
     * @return 入库ID
     */
    public Long getDeliverId() {
        return deliverId;
    }

    /**
     * <p>入库ID</p>
     *
     * @param deliverId 入库ID
     */
    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    /**
     * <p>采购单号</p>
     *
     * @return 采购单号
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>采购单号</p>
     *
     * @param orderCode 采购单号
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * <p>采购类型,CodeMaster</p>
     *
     * @return 采购类型, CodeMaster
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * <p>采购类型,CodeMaster</p>
     *
     * @param orderType 采购类型,CodeMaster
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * <p>计划入库单号</p>
     *
     * @return 计划入库单号
     */
    public String getScheduleCode() {
        return scheduleCode;
    }

    /**
     * <p>计划入库单号</p>
     *
     * @param scheduleCode 计划入库单号
     */
    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    /**
     * <p>计划入库时间</p>
     *
     * @return 计划入库时间
     */
    public Date getScheduleDate() {
        return scheduleDate;
    }

    /**
     * <p>计划入库时间</p>
     *
     * @param scheduleDate 计划入库时间
     */
    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
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
     * <p>与仓库实物产品SKU一致</p>
     *
     * @return 与仓库实物产品SKU一致
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * <p>与仓库实物产品SKU一致</p>
     *
     * @param materialCode 与仓库实物产品SKU一致
     */
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    /**
     * <p>与仓库实物产品名称一致</p>
     *
     * @return 与仓库实物产品名称一致
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * <p>与仓库实物产品名称一致</p>
     *
     * @param materialName 与仓库实物产品名称一致
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * <p>商品编码</p>
     *
     * @return 商品编码
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * <p>商品编码</p>
     *
     * @param commodityCode 商品编码
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    /**
     * <p>商品名称</p>
     *
     * @return 商品名称
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * <p>商品名称</p>
     *
     * @param commodityName 商品名称
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * <p>入库产品单位</p>
     *
     * @return 入库产品单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * <p>入库产品单位</p>
     *
     * @param unit 入库产品单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
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
     * <p>销售标签,默认值可考虑设常量，与商品管理中一致</p>
     *
     * @return 销售标签, 默认值可考虑设常量，与商品管理中一致
     */
    public String getSalesLabel() {
        return salesLabel;
    }

    /**
     * <p>销售标签,默认值可考虑设常量，与商品管理中一致</p>
     *
     * @param salesLabel 销售标签,默认值可考虑设常量，与商品管理中一致
     */
    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }

    /**
     * <p>入库仓库状态,默认值可考虑设常量，与库存管理中保持一致</p>
     *
     * @return 入库仓库状态, 默认值可考虑设常量，与库存管理中保持一致
     */
    public String getInventoryStatus() {
        return inventoryStatus;
    }

    /**
     * <p>入库仓库状态,默认值可考虑设常量，与库存管理中保持一致</p>
     *
     * @param inventoryStatus 入库仓库状态,默认值可考虑设常量，与库存管理中保持一致
     */
    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    /**
     * <p>入库数量</p>
     *
     * @return 入库数量
     */
    public java.math.BigDecimal getReceiveQty() {
        return receiveQty;
    }

    /**
     * <p>入库数量</p>
     *
     * @param receiveQty 入库数量
     */
    public void setReceiveQty(java.math.BigDecimal receiveQty) {
        this.receiveQty = receiveQty;
    }

    /**
     * <p>入库价格</p>
     *
     * @return 入库价格
     */
    public java.math.BigDecimal getReceivePrice() {
        return receivePrice;
    }

    /**
     * <p>入库价格</p>
     *
     * @param receivePrice 入库价格
     */
    public void setReceivePrice(java.math.BigDecimal receivePrice) {
        this.receivePrice = receivePrice;
    }

    /**
     * <p>入库时间</p>
     *
     * @return 入库时间
     */
    public Date getInboundDate() {
        return inboundDate;
    }

    /**
     * <p>入库时间</p>
     *
     * @param inboundDate 入库时间
     */
    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }
}
