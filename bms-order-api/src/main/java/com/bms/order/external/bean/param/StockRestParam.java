package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class StockRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    //SKU编码
    private String skuCode;
    //批次
    private String lotNo;
    //否涉及实货囤货
    private String isStoreFlag;
    //销售价格
    private BigDecimal sellPrice;
    //单据数量
    private BigDecimal orderQty;
    //发货数量
    private BigDecimal dispatchedQty;
    //单品Id
    private Long partId;
    //物流区域Id
    private Long logicAreaId;
    //物流区域编码
    private String LogicAreaCode;
    //货主Id
    private String ownerId;
    //货主编码
    private String ownerCode;
    //货主类型
    private String ownerType;
    //货主细分类
    private String ownerdType;
    //品牌Id
    private Long brandId;
    //生产商Id
    private Long producerId;
    //供应商Id
    private Long supplierId;
    //商品Id
    private String goodsId;
    //产品Id
    private String productId;
    //参考号
    private String refNo;
    //销售标签
    private String salesLabel;
    //业务单ID
    private Long transactionId;
    //业务单号
    private String transactionNo;
    //业务明细ID
    private Long transactionDetailId;
    //业务校验序列
    private Integer transactionSequence;
    //占用数量/囤货数量
    private BigDecimal allocatedQty;
    //目标方Id
    private String targetId;
    //目标方编码
    private String targetCode;
    //目标方类型
    private String targetType;
    //占用类型
    private String allocatedType;
    //买手ID
    private String bsId;
    //买手编码
    private String bsCode;
    //买手名称
    private String bsName;
    //买手类型
    private String bsType;
    //囤货单价
    private BigDecimal buyPrice;
    //取消数量
    private BigDecimal cancelQty;
    //释放数量
    private BigDecimal releaseQty;
    // 占用类型
    private String alocType;

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getBsType() {
        return bsType;
    }

    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getAllocatedType() {
        return allocatedType;
    }

    public void setAllocatedType(String allocatedType) {
        this.allocatedType = allocatedType;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getIsStoreFlag() {
        return isStoreFlag;
    }

    public void setIsStoreFlag(String isStoreFlag) {
        this.isStoreFlag = isStoreFlag;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getDispatchedQty() {
        return dispatchedQty;
    }

    public void setDispatchedQty(BigDecimal dispatchedQty) {
        this.dispatchedQty = dispatchedQty;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getLogicAreaId() {
        return logicAreaId;
    }

    public void setLogicAreaId(Long logicAreaId) {
        this.logicAreaId = logicAreaId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerdType() {
        return ownerdType;
    }

    public void setOwnerdType(String ownerdType) {
        this.ownerdType = ownerdType;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Long getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(Long transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    public Integer getTransactionSequence() {
        return transactionSequence;
    }

    public void setTransactionSequence(Integer transactionSequence) {
        this.transactionSequence = transactionSequence;
    }

    public BigDecimal getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(BigDecimal allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getLogicAreaCode() {
        return LogicAreaCode;
    }

    public void setLogicAreaCode(String logicAreaCode) {
        LogicAreaCode = logicAreaCode;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getSalesLabel() {
        return salesLabel;
    }

    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }

    public BigDecimal getCancelQty() {
        return cancelQty;
    }

    public void setCancelQty(BigDecimal cancelQty) {
        this.cancelQty = cancelQty;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }

    public String getAlocType() {
        return alocType;
    }

    public void setAlocType(String alocType) {
        this.alocType = alocType;
    }

}
