package com.batch.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**单品品牌规格生产商供应商库存查询
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class QuerySupplierInvRestResult implements Serializable {


    List<Inventory> invList;

    public List<Inventory> getInvList() {
        return invList;
    }

    public void setInvList(List<Inventory> invList) {
        this.invList = invList;
    }


    @Override
    public String toString() {
        return "QuerySupplierInvRestResult{" +
                "invList=" + invList +
                '}';
    }

    public static class Inventory implements Serializable {
        private String logisticsId;//物流区域ID
        private String salesPlatform;//销售平台
        private String ownerId;//货主Id
        private String ownerType;//货主类型
        private String ownerDType;//货主细分类
        private String partId;//单品Id
        private String brandId;//品牌Id
        private String pdId;//产品Id
        private String producerId;//制造商Id
        private String supplierId;//供应商Id
        private String commodityId;//商品Id
        private String ivType;//库存类型
        private String uom;//单位
        private BigDecimal totalQty;//总数量
        private BigDecimal onhandQty;//在库数量
        private BigDecimal bufferQty;//虚拟数量
        private BigDecimal allocatedQty;//占用数量
        private BigDecimal availableQty;//可用数量
        private BigDecimal canOrderQty;//可下单数量


        public String getLogisticsId() {
            return logisticsId;
        }

        public void setLogisticsId(String logisticsId) {
            this.logisticsId = logisticsId;
        }

        public String getSalesPlatform() {
            return salesPlatform;
        }

        public void setSalesPlatform(String salesPlatform) {
            this.salesPlatform = salesPlatform;
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

        public String getOwnerDType() {
            return ownerDType;
        }

        public void setOwnerDType(String ownerDType) {
            this.ownerDType = ownerDType;
        }

        public String getPartId() {
            return partId;
        }

        public void setPartId(String partId) {
            this.partId = partId;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getPdId() {
            return pdId;
        }

        public void setPdId(String pdId) {
            this.pdId = pdId;
        }

        public String getProducerId() {
            return producerId;
        }

        public void setProducerId(String producerId) {
            this.producerId = producerId;
        }

        public String getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(String supplierId) {
            this.supplierId = supplierId;
        }

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getIvType() {
            return ivType;
        }

        public void setIvType(String ivType) {
            this.ivType = ivType;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public BigDecimal getTotalQty() {
            return totalQty;
        }

        public void setTotalQty(BigDecimal totalQty) {
            this.totalQty = totalQty;
        }

        public BigDecimal getOnhandQty() {
            return onhandQty;
        }

        public void setOnhandQty(BigDecimal onhandQty) {
            this.onhandQty = onhandQty;
        }

        public BigDecimal getBufferQty() {
            return bufferQty;
        }

        public void setBufferQty(BigDecimal bufferQty) {
            this.bufferQty = bufferQty;
        }

        public BigDecimal getAllocatedQty() {
            return allocatedQty;
        }

        public void setAllocatedQty(BigDecimal allocatedQty) {
            this.allocatedQty = allocatedQty;
        }

        public BigDecimal getAvailableQty() {
            return availableQty;
        }

        public void setAvailableQty(BigDecimal availableQty) {
            this.availableQty = availableQty;
        }

        public BigDecimal getCanOrderQty() {
            return canOrderQty;
        }

        public void setCanOrderQty(BigDecimal canOrderQty) {
            this.canOrderQty = canOrderQty;
        }

        @Override
        public String toString() {
            return "Inventory{" +
                    "logisticsId='" + logisticsId + '\'' +
                    ", salesPlatform='" + salesPlatform + '\'' +
                    ", ownerId='" + ownerId + '\'' +
                    ", ownerType='" + ownerType + '\'' +
                    ", ownerDType='" + ownerDType + '\'' +
                    ", partId='" + partId + '\'' +
                    ", brandId='" + brandId + '\'' +
                    ", pdId='" + pdId + '\'' +
                    ", producerId='" + producerId + '\'' +
                    ", supplierId='" + supplierId + '\'' +
                    ", commodityId='" + commodityId + '\'' +
                    ", ivType='" + ivType + '\'' +
                    ", uom='" + uom + '\'' +
                    ", totalQty=" + totalQty +
                    ", onhandQty=" + onhandQty +
                    ", bufferQty=" + bufferQty +
                    ", allocatedQty=" + allocatedQty +
                    ", availableQty=" + availableQty +
                    ", canOrderQty=" + canOrderQty +
                    '}';
        }
    }
}
