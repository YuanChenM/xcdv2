package com.bms.order.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by guan_zhongheng on 2017/4/27.
 */
public class LINV0113IResult implements Serializable {

    /** 物流区域ID */
    private String logisticsId;
    /** 物流区域编码 */
    private String logisticsCode;
    /** 物流区域名称 */
    private String logisticsName;
    /** 销售平台 */
    private String salePlatform;
    /** 货主ID */
    private String ownerId;
    /** 货主编码 */
    private String ownerCode;
    /** 货主名称 */
    private String ownerName;
    /** 货主类型 */
    private String ownerType;
    /** 商品Id */
    private String commodityId;
    /** 库存类型 */
    private String ivType;
    /** 商品库存类型 */
    private String comoIvType;
    /** 销售状态ID */
    private Long saleStatusId;
    /** 销售状态编码 */
    private String saleStatusCode;
    /** 销售状态名称 */
    private String saleStatusName;
    /** 单位 */
    private String uom;
    /** 总数量 */
    private BigDecimal totalQty;
    /** 在库数量 */
    private BigDecimal onhandQty;
    /** 虚拟数量 */
    private BigDecimal bufferQty;
    /** 占用数量 */
    private BigDecimal allocatedQty;
    /** 可用数量 */
    private BigDecimal availableQty;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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

    public String getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String comoIvType) {
        this.comoIvType = comoIvType;
    }

    public Long getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
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
}
