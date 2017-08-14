package com.bms.linv.bean.param;

import com.bms.linv.bean.entity.InvmLoad;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/5/3.
 */
@ApiModel(value = "LINV0118IProductParam",
    description = "库存调整产品列表")
@XmlRootElement(name="productList")
public class LINV0118IProductParam implements Serializable {
    @ApiModelProperty(value = "货主编码")
    @XmlElement(name="slCode")
    private String slCode;
    @ApiModelProperty(value = "物流区编码")
    @XmlElement(name="lgcsCode")
    private String lgcsCode;
    @ApiModelProperty(value = "供应商编码")
    @XmlElement(name="supplierCode")
    private String supplierCode;
    @ApiModelProperty(value = "仓库编码")
    @XmlElement(name="whCode")
    private String whCode;
    @ApiModelProperty(value = "仓库名称")
    @XmlElement(name="whName")
    private String whName;
    @ApiModelProperty(value = "SKU编码")
    @XmlElement(name="skuCode")
    private String skuCode;
    @ApiModelProperty(value = "采购入库批次")
    @XmlElement(name="lotNo")
    private String lotNo;
    @ApiModelProperty(value = "产品单位")
    @XmlElement(name="unit")
    private String unit;
    @ApiModelProperty(value = "产品数量")
    @XmlElement(name="adjustQty")
    private String adjustQty;
    @ApiModelProperty(value = "销售标签")
    @XmlElement(name="salesLabel")
    private String salesLabel;
    @ApiModelProperty(value = "出仓仓库的库存类型，减少库存的仓库")
    @XmlElement(name="fromInventoryStatus")
    private String fromInventoryStatus;
    @ApiModelProperty(value = "入仓仓库的库存类型，增加库存的仓库")
    @XmlElement(name="toInventoryStatus")
    private String toInventoryStatus;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAdjustQty() {
        return adjustQty;
    }

    public void setAdjustQty(String adjustQty) {
        this.adjustQty = adjustQty;
    }

    public String getSalesLabel() {
        return salesLabel;
    }

    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }

    public String getFromInventoryStatus() {
        return fromInventoryStatus;
    }

    public void setFromInventoryStatus(String fromInventoryStatus) {
        this.fromInventoryStatus = fromInventoryStatus;
    }

    public String getToInventoryStatus() {
        return toInventoryStatus;
    }

    public void setToInventoryStatus(String toInventoryStatus) {
        this.toInventoryStatus = toInventoryStatus;
    }

    /**
     * load表查询对象
     * 
     * @return
     */
    public InvmLoad searchLoadParam() {
        InvmLoad loadParam = new InvmLoad();
            loadParam.setWhCode("0000");
        loadParam.setLaCode(this.getLgcsCode());
        loadParam.setOwnerCode(this.getSlCode());
        loadParam.setSkuCode(this.getSkuCode());
        loadParam.setLotNo(this.getLotNo());
        loadParam.setUom(this.getUnit());
        loadParam.setSaleStatusCode(this.getSalesLabel());
        return loadParam;
    }
}
