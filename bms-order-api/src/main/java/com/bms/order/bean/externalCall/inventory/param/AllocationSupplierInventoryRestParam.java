package com.bms.order.bean.externalCall.inventory.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/11.
 */
public class AllocationSupplierInventoryRestParam implements Serializable {

    private List<Recouce> invLists;

    public List<Recouce> getInvLists() {
        return invLists;
    }

    public void setInvLists(List<Recouce> invLists) {
        this.invLists = invLists;
    }


    @Override
    public String toString() {
        return "AllocationSupplierInventoryRestParam{" +
                "invLists=" + invLists +
                '}';
    }

    public static class Recouce {
        private Long partId;
        private Long logicAreaId;
        private Long ownerId;
        private String ownerType;
        private String ownerdType;
        private String salePlatform;
        private Long brandId;
        private Long producerId;
        private Long supplierId;
        private Long commodityId;
        private String productId;
        private String ivType;

        private String refNo;
        private Long transactionId;
        private String transactionNo;
        private String transactionSource;
        private String transactionDetailId;
        private Long targetId;
        private String targetCode;
        private String targetType;
        private BigDecimal allocatedQty;
        private String allocatedType;
        private Boolean isFirstOrder;

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

        public Long getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Long ownerId) {
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

        public String getSalePlatform() {
            return salePlatform;
        }

        public void setSalePlatform(String salePlatform) {
            this.salePlatform = salePlatform;
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

        public Long getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(Long commodityId) {
            this.commodityId = commodityId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getIvType() {
            return ivType;
        }

        public void setIvType(String ivType) {
            this.ivType = ivType;
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

        public String getTransactionSource() {
            return transactionSource;
        }

        public void setTransactionSource(String transactionSource) {
            this.transactionSource = transactionSource;
        }

        public String getTransactionDetailId() {
            return transactionDetailId;
        }

        public void setTransactionDetailId(String transactionDetailId) {
            this.transactionDetailId = transactionDetailId;
        }

        public Long getTargetId() {
            return targetId;
        }

        public void setTargetId(Long targetId) {
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

        public BigDecimal getAllocatedQty() {
            return allocatedQty;
        }

        public void setAllocatedQty(BigDecimal allocatedQty) {
            this.allocatedQty = allocatedQty;
        }

        public String getAllocatedType() {
            return allocatedType;
        }

        public void setAllocatedType(String allocatedType) {
            this.allocatedType = allocatedType;
        }

        public Boolean getIsFirstOrder() {
            return isFirstOrder;
        }

        public void setIsFirstOrder(Boolean isFirstOrder) {
            this.isFirstOrder = isFirstOrder;
        }

        @Override
        public String toString() {
            return "Recouce{" +
                    "partId=" + partId +
                    ", logicAreaId=" + logicAreaId +
                    ", ownerId=" + ownerId +
                    ", ownerType='" + ownerType + '\'' +
                    ", ownerdType='" + ownerdType + '\'' +
                    ", salePlatform='" + salePlatform + '\'' +
                    ", brandId=" + brandId +
                    ", producerId=" + producerId +
                    ", supplierId=" + supplierId +
                    ", commodityId=" + commodityId +
                    ", productId='" + productId + '\'' +
                    ", ivType='" + ivType + '\'' +
                    ", refNo='" + refNo + '\'' +
                    ", transactionId=" + transactionId +
                    ", transactionNo='" + transactionNo + '\'' +
                    ", transactionSource='" + transactionSource + '\'' +
                    ", transactionDetailId='" + transactionDetailId + '\'' +
                    ", targetId=" + targetId +
                    ", targetCode='" + targetCode + '\'' +
                    ", targetType='" + targetType + '\'' +
                    ", allocatedQty=" + allocatedQty +
                    ", allocatedType='" + allocatedType + '\'' +
                    ", isFirstOrder=" + isFirstOrder +
                    '}';
        }
    }




}


