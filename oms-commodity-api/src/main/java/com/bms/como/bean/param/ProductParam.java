package com.bms.como.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/4/12.
 */
@ApiModel(value = "productParam", description = "产品集合")
public class ProductParam implements Serializable {
    @ApiModelProperty(value = "货主编码，对应CONSIGNEE")
    private String slCode;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsCode;
    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;
    @ApiModelProperty(value = "SKU编码")
    private String skuCode;
    @ApiModelProperty(value = "产品单位（箱或者包）")
    private String unit;
    @ApiModelProperty(value = "原销售标签")
    private String oldLabel;
    @ApiModelProperty(value = "新销售标签")
    private String newLabel;
    @ApiModelProperty(value = "仓库信息集合")
    private List<WarehouseRsParam> whList;

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOldLabel() {
        return oldLabel;
    }

    public void setOldLabel(String oldLabel) {
        this.oldLabel = oldLabel;
    }

    public String getNewLabel() {
        return newLabel;
    }

    public void setNewLabel(String newLabel) {
        this.newLabel = newLabel;
    }

    public List<WarehouseRsParam> getWhList() {
        return whList;
    }

    public void setWhList(List<WarehouseRsParam> whList) {
        this.whList = whList;
    }
}
