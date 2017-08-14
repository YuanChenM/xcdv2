package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ComoAddOffShelfInfoRsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品基本信息表
     * COMO_COMMODITY_INFO
     */
    @ApiModelProperty(value = "主键-商品ID")
    private Long commodityId;
    @ApiModelProperty(value = "销售状态描述")
    private String saleStatusDesc;
    @ApiModelProperty(value = "商品编码")
    private String commodityCode;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "是否为默认商品")
    private boolean isDefault;
//    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
//    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private String crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private String updTime;
    @ApiModelProperty(value = "版本")
    private Integer ver;

    /**
     * 物流区商品的上下架状态信息
     * COMO_SHELF_LIST
     */
//    @ApiModelProperty(value = "主键-上下架明细ID")
//    private Long shelfDetailId;
    @ApiModelProperty(value = "物流区ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "销售上架日期")
    private String addShelfTime;
    @ApiModelProperty(value = "销售下架日期")
    private String offShelfTime;
    /** 数据库不存在该字段 **/
    @ApiModelProperty(value = "上架状态，001-未上架，002-已上架，003-已下架")
    private String shelfStu;
    /** 数据库不存在该字段 **/

    /**
     * 销售状态信息表
     * COMO_SALE_STATUS
     */
    @ApiModelProperty(value = "主键-销售状态ID")
    private Long saleStatusId;
    @ApiModelProperty(value = "销售状态编码")
    private String saleStatusCode;
    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;

    /**
     * 产品信息表
     * COMO_PRODUCT_INFO
     */
    @ApiModelProperty(value = "主键-产品ID")
    private Long productPid;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "一级分类ID")
    private String classesId;
    @ApiModelProperty(value = "一级分类编码")
    private String classesCode;
    @ApiModelProperty(value = "一级分类名称")
    private String classesName;
    @ApiModelProperty(value = "二级分类ID")
    private String machiningId;
    @ApiModelProperty(value = "二级分类编码")
    private String machiningCode;
    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;
    @ApiModelProperty(value = "品种Id")
    private String breedId;
    @ApiModelProperty(value = "品种编码")
    private String breedCode;
    @ApiModelProperty(value = "品种名称")
    private String breedName;
    @ApiModelProperty(value = "单品ID")
    private String itemId;
    @ApiModelProperty(value = "单品编码")
    private String itemCode;
    @ApiModelProperty(value = "单品名称")
    private String itemName;
    @ApiModelProperty(value = "品牌ID")
    private String brandId;
    @ApiModelProperty(value = "品牌编码")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "质量等级编码")
    private String qualityGradeTypeCode;
    @ApiModelProperty(value = "质量等级名称")
    private String qualityGradeType;
    @ApiModelProperty(value = "毛重")
    private BigDecimal grossWeight;
    @ApiModelProperty(value = "净重编码")
    private String netWeightCode;
    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;
    @ApiModelProperty(value = "包装规格")
    private String packageSpecification;
    @ApiModelProperty(value = "包装数量")
    private Integer packageQuantity;
    @ApiModelProperty(value = "包装尺寸")
    private String cartonDimension;
    @ApiModelProperty(value = "托盘堆码数")
    private Integer palletStackingLimit;
    @ApiModelProperty(value = "单品品牌规格编码")
    private String brandItemPropertySku;
    @ApiModelProperty(value = "规格编码")
    private String itemPropertyCode;

    /**
     * 商品销售单位设定信息表
     * COMO_COMMODITY_UOM
     */
    @ApiModelProperty(value = "商品销售单位设定信息集合")
    private List<CommodityUomRsResult> uomList;
    /**
     * 商品组成明细表，
     * COMO_COMMODITY_DETAIL
     */
    @ApiModelProperty(value = "库存状态")
    private String inventoryStu;

    public String getItemPropertyCode() {
        return itemPropertyCode;
    }

    public void setItemPropertyCode(String itemPropertyCode) {
        this.itemPropertyCode = itemPropertyCode;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getMachiningId() {
        return machiningId;
    }

    public void setMachiningId(String machiningId) {
        this.machiningId = machiningId;
    }

    public String getBreedId() {
        return breedId;
    }

    public void setBreedId(String breedId) {
        this.breedId = breedId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getSaleStatusDesc() {
        return saleStatusDesc;
    }

    public void setSaleStatusDesc(String saleStatusDesc) {
        this.saleStatusDesc = saleStatusDesc;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
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

    public String getAddShelfTime() {
        return addShelfTime;
    }

    public void setAddShelfTime(String addShelfTime) {
        this.addShelfTime = addShelfTime;
    }

    public String getOffShelfTime() {
        return offShelfTime;
    }

    public void setOffShelfTime(String offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

    public String getShelfStu() {
        return shelfStu;
    }

    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
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

    public Long getProductPid() {
        return productPid;
    }

    public void setProductPid(Long productPid) {
        this.productPid = productPid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getQualityGradeTypeCode() {
        return qualityGradeTypeCode;
    }

    public void setQualityGradeTypeCode(String qualityGradeTypeCode) {
        this.qualityGradeTypeCode = qualityGradeTypeCode;
    }

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public String getInventoryStu() {
        return inventoryStu;
    }

    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getNetWeightCode() {
        return netWeightCode;
    }

    public void setNetWeightCode(String netWeightCode) {
        this.netWeightCode = netWeightCode;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getCartonDimension() {
        return cartonDimension;
    }

    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }

    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }

    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }

    public List<CommodityUomRsResult> getUomList() {
        return uomList;
    }

    public void setUomList(List<CommodityUomRsResult> uomList) {
        this.uomList = uomList;
    }

}
