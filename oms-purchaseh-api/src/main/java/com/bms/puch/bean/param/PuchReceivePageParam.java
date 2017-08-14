package com.bms.puch.bean.param;

import com.bms.puch.bean.BasePageParam;
import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by guan_zhongheng on 2017/3/20.
 */
@ApiModel(value = "PuchReceivePageParam",
        description = "采购入库单请求接口")
public class PuchReceivePageParam extends BasePageParam {

    @ApiModelProperty(value = "采购入库ID")
    private Long deliverId;
    @ApiModelProperty(value = "入库单号,SRM的入库单号")
    private String deliverCode;
    @ApiModelProperty(value = "货权人类型，CodeMaster,平台卖家，买手")
    private String ownerType;
    @ApiModelProperty(value = "货权人ID")
    private String ownerId;
    @ApiModelProperty(value = "货权人编码")
    private String ownerCode;
    @ApiModelProperty(value = "货权人名称")
    private String ownerName;
    @ApiModelProperty(value = "物流区域ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区域编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区域名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "供应商ID")
    private Long supplierId;
    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
    @ApiModelProperty(value = "创建开始时间（yyyy-MM-dd）")
    private String crtTimeFrom;
    @ApiModelProperty(value = "创建截止时间（yyyy-MM-dd）")
    private String crtTimeTo;

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

    public String getCrtTimeFrom() {
        return crtTimeFrom;
    }

    public void setCrtTimeFrom(String crtTimeFrom) {
        this.crtTimeFrom = crtTimeFrom;
    }

    public String getCrtTimeTo() {
        return crtTimeTo;
    }

    public void setCrtTimeTo(String crtTimeTo) {
        this.crtTimeTo = crtTimeTo;
    }
}
