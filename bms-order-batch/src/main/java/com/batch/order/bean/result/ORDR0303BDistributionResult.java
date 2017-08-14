package com.batch.order.bean.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/3/10.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"orderline","sku","inboundBatch","uom","consignee","area", "saleLabelCode", "qtyoriginal","inputQty","attributes","inventoryStatus"})
public class ORDR0303BDistributionResult {

    private Long orderline;

    private String sku;

    private String inboundBatch;

    private String uom;

    private String consignee;

    private String area;

    private String saleLabelCode;

    private BigDecimal qtyoriginal;

    private BigDecimal inputQty;

    private String attributes;

    private String inventoryStatus;

    @XmlElement(name = "ORDERLINE",defaultValue = "")
    public Long getOrderline() {
        return orderline;
    }

    public void setOrderline(Long orderline) {
        this.orderline = orderline;
    }

    @XmlElement(name = "SKU",defaultValue = "")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @XmlElement(name = "INBOUNDBATCH",defaultValue = "")
    public String getInboundBatch() {
        return inboundBatch;
    }

    public void setInboundBatch(String inboundBatch) {
        this.inboundBatch = inboundBatch;
    }

    @XmlElement(name = "UOM",defaultValue = "")
    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    @XmlElement(name = "CONSIGNEE",defaultValue = "")
    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @XmlElement(name = "AREA",defaultValue = "")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlElement(name = "QTYORIGINAL",defaultValue = "")
    public BigDecimal getQtyoriginal() {
        return qtyoriginal;
    }

    public void setQtyoriginal(BigDecimal qtyoriginal) {
        this.qtyoriginal = qtyoriginal;
    }

    @XmlElement(name = "INPUTQTY",defaultValue = "")
    public BigDecimal getInputQty() {
        return inputQty;
    }

    public void setInputQty(BigDecimal inputQty) {
        this.inputQty = inputQty;
    }

    @XmlElement(name = "ATTRIBUTES",defaultValue = "")
    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @XmlElement(name = "INVENTORYSTATUS",defaultValue = "")
    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    @XmlElement(name = "SALESTAG",defaultValue = "")
    public String getSaleLabelCode() {
        return saleLabelCode;
    }

    public void setSaleLabelCode(String saleLabelCode) {
        this.saleLabelCode = saleLabelCode;
    }
}
