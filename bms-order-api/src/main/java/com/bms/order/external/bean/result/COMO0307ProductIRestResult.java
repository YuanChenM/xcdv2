package com.bms.order.external.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品信息
 */
public class COMO0307ProductIRestResult extends RestSearchData {

    /**
     * 商品ID
     */
    private Long commodityId;
    /**
     * 物流区ID
     */
    private Long lgcsAreaId;
    /**
     * 物流区编码
     */
    private String lgcsAreaCode;
    /**
     * 物流区名称
     */
    private String lgcsAreaName;

    /**
     * 销售状态ID
     */
    private Long saleStatusId;
    /**
     * 销售状态编码
     */
    private String saleStatusCode;
    /**
     * 销售状态名称
     */
    private String saleStatusName;
    /**
     * 销售状态描述
     */
    private String saleStatusDesc;

    /**
     * 商品编码
     */
    private String commodityCode;
    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 销售上架日期
     */
    private String addShelfTime;
    /**
     * 销售下架日期
     */
    private String offShelfTime;
    /**
     * 上架状态，001-未上架，002-已上架，003-已下架
     */
    private String shelfStu;
    /**
     * 是否为默认商品
     */
    private Boolean isDefault;
    /**
     * 产品主键ID
     */
    private Long productPid;
    /**
     * 产品ID
     */
    private String productId;
    /**
     * 一级分类编码
     */
    private String classesCode;
    /**
     * 一级分类名称
     */
    private String classesName;
    /**
     * 二级分类编码
     */
    private String machiningCode;
    /**
     * 二级分类名称
     */
    private String machiningName;
    /**
     * 品种编码
     */
    private String breedCode;

    /**
     * 品种名称
     */
    private String breedName;

    /**
     * 单品ID
     */
    private String itemId ;

    /**
     * 单品编码
     */
    private String itemCode;
    /**
     * 单品名称
     */
    private String itemName;
    /**
     * 品牌编码
     */
    private String brandCode;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 质量等级编码
     */
    private String qualityGradeTypeCode;
    /**
     * 质量等级名称
     */
    private String qualityGradeTypeName;
    /**
     * 毛重
     */
    private BigDecimal grossWeight;
    /**
     * 净重编码
     */
    private String netWeightCode;

    /**
     * 净重
     */
    private BigDecimal netWeight;
    /**
     * 包装规格
     */
    private String packageSpecification;
    /**
     * 包装数量
     */
    private Integer packageQuantity;
    /**
     * 包装尺寸
     */
    private String cartonDimension;
    /**
     *托盘堆码数
     */
    private Integer palletStackingLimit;
    /**
     * 单品品牌规格编码
     */
  private  String brandItemPropertySku ;



    private List<COMO0307ProductDetailIRestResult> detailList;

    private List<COMO0307ProductUomIRestResult> uomList;

    public List<COMO0307ProductDetailIRestResult> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<COMO0307ProductDetailIRestResult> detailList) {
        this.detailList = detailList;
    }

    public List<COMO0307ProductUomIRestResult> getUomList() {
        return uomList;
    }

    public void setUomList(List<COMO0307ProductUomIRestResult> uomList) {
        this.uomList = uomList;
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

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
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

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
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
}
