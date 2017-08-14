package com.batch.linv.bean.entity;

import java.io.Serializable;
import java.util.Date;

import com.framework.base.rest.entity.BaseEntity;

import io.swagger.annotations.ApiModel;

/**
 * Created by wang_fan on 2017/4/14.
 */
@ApiModel(value = "LINV0117ISourceParam",
    description = "参数")
public class LINV0117IResultParam extends BaseEntity implements Serializable {

    private Long syncId;
    private Date syncTime;
    private String laCode;
    private String skuCode;
    private String skuName;
    private String lotNo;
    private String unit;
    private String inboundQty;
    private String status;
    private String salesLabel;
    private String consignee;
    private String whCode;
    private String whName;

    public String getLaCode() {
        return laCode;
    }

    public void setLaCode(String laCode) {
        this.laCode = laCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getInboundQty() {
        return inboundQty;
    }

    public void setInboundQty(String inboundQty) {
        this.inboundQty = inboundQty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalesLabel() {
        return salesLabel;
    }

    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public Long getSyncId() {
        return syncId;
    }

    public void setSyncId(Long syncId) {
        this.syncId = syncId;
    }
}