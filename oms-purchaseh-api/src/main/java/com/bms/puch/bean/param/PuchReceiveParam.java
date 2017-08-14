package com.bms.puch.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/3/16.
 */
@ApiModel(value = "PuchReceiveParam",
        description = "入库主表")
@XmlRootElement(name="orderBody")
public class PuchReceiveParam implements Serializable {

    @ApiModelProperty(value = "采购入库ID")
    @XmlElement(name="deliverId")
    private Long deliverId;

    @ApiModelProperty(value = "入库单号,SRM的入库单号")
    @XmlElement(name="deliverCode")
    private String deliverCode;

    @ApiModelProperty(value = "货权人类型，CodeMaster,平台卖家，买手")
    @XmlElement(name="ownerType")
    private String ownerType;

    @ApiModelProperty(value = "货权人ID")
    @XmlElement(name="ownerId")
    private String ownerId;

    @ApiModelProperty(value = "货权人编码")
    @XmlElement(name="ownerCode")
    private String ownerCode;

    @ApiModelProperty(value = "货权人名称")
    @XmlElement(name="deliverId")
    private String ownerName;

    @ApiModelProperty(value = "物流区域ID")
    @XmlElement(name="lgcsAreaId")
    private Long lgcsAreaId;

    @ApiModelProperty(value = "物流区域编码")
    @XmlElement(name="lgcsAreaCode")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "物流区域名称")
    @XmlElement(name="lgcsAreaName")
    private String lgcsAreaName;

    @ApiModelProperty(value = "供应商ID")
    @XmlElement(name="supplierId")
    private Long supplierId;

    @ApiModelProperty(value = "供应商编码")
    @XmlElement(name="supplierCode")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    @XmlElement(name="supplierName")
    private String supplierName;

    @ApiModelProperty(value = "订单列表")
    @XmlElement(name="orderList")
    private List<OrderParam> orderList;

    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<OrderParam> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderParam> orderList) {
        this.orderList = orderList;
    }
}
