package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LinvRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    //SKU编码
    private String skuCode;
    private String targetName;
    //批次
    private String lotNo;
    //销售价格
    private BigDecimal sellPrice;
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
    private String commodityId;
    //产品Id
    private String productId;
    //参考号
    private String refNo;
    //销售标签
    private String salesLabel;
    //业务单ID
    private Long releaseTransactionId;
    //业务单号
    private String releaseTransactionNo;
    //业务明细ID
    private Long releaseTransactionDetailId;

    public Long getReleaseTransactionId() {
        return releaseTransactionId;
    }

    public void setReleaseTransactionId(Long releaseTransactionId) {
        this.releaseTransactionId = releaseTransactionId;
    }

    public String getReleaseTransactionNo() {
        return releaseTransactionNo;
    }

    public void setReleaseTransactionNo(String releaseTransactionNo) {
        this.releaseTransactionNo = releaseTransactionNo;
    }

    public Long getReleaseTransactionDetailId() {
        return releaseTransactionDetailId;
    }

    public void setReleaseTransactionDetailId(Long releaseTransactionDetailId) {
        this.releaseTransactionDetailId = releaseTransactionDetailId;
    }
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
    //交易数量
    private BigDecimal dealQty;
    //释放数量
    private BigDecimal releaseQty;
    // 业务类型
    private String bizType;

    // 仓库Id
    private Long whId;

    private Boolean deductSrcInv;

    private Boolean addTargetInv;

    private String comoIvType;

    private Long srcTransactionId;

    private String srcTransactionNo;

    private Long srcTransactionDetailId;


    //业务单ID
    private Long transactionId;
    //业务单号
    private String transactionNo;
    //业务明细ID
    private Long transactionDetailId;

    public String getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String comoIvType) {
        this.comoIvType = comoIvType;
    }

    public Boolean getDeductSrcInv() {
        return deductSrcInv;
    }

    public void setDeductSrcInv(Boolean deductSrcInv) {
        this.deductSrcInv = deductSrcInv;
    }

    public Boolean getAddTargetInv() {
        return addTargetInv;
    }

    public void setAddTargetInv(Boolean addTargetInv) {
        this.addTargetInv = addTargetInv;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

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

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
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

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
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

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public BigDecimal getDealQty() {
        return dealQty;
    }

    public void setDealQty(BigDecimal dealQty) {
        this.dealQty = dealQty;
    }

    public Long getSrcTransactionId() {
        return srcTransactionId;
    }

    public void setSrcTransactionId(Long srcTransactionId) {
        this.srcTransactionId = srcTransactionId;
    }

    public String getSrcTransactionNo() {
        return srcTransactionNo;
    }

    public void setSrcTransactionNo(String srcTransactionNo) {
        this.srcTransactionNo = srcTransactionNo;
    }

    public Long getSrcTransactionDetailId() {
        return srcTransactionDetailId;
    }

    public void setSrcTransactionDetailId(Long srcTransactionDetailId) {
        this.srcTransactionDetailId = srcTransactionDetailId;
    }
}
