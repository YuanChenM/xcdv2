package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "SLPD1202ILgcsAreaCommodityResult", description = "物流区产品")
public class SLPD1202ILgcsAreaCommodityResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物流区产品ID")
    private Long lacId;
    @ApiModelProperty(value = "物流区ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "产品需求等级")
    private String productDemandGrade;
    @ApiModelProperty(value = "产品需求等级")
    private String productDemandGradeStr;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "单品品牌规格Sku")
    private String brandItemPropertySku;
    @ApiModelProperty(value = "上下架状态，1：上架，2：下架")
    private String shelfStu;
    @ApiModelProperty(value = "上下架状态")
    private String shelfStuStr;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品种名称")
    private String breedSalesName;
    @ApiModelProperty(value = "单品名称")
    private String itemName;
    @ApiModelProperty(value = "小包装特征")
    private String packageSpecification;
    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;
    @ApiModelProperty(value = "质量等级")
    private String qualityGradeType;
    @ApiModelProperty(value = "质量等级")
    private String qualityGradeTypeStr;


    public Long getLacId() {
        return lacId;
    }

    public void setLacId(Long lacId) {
        this.lacId = lacId;
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

    public String getProductDemandGrade() {
        return productDemandGrade;
    }

    public void setProductDemandGrade(String productDemandGrade) {
        this.productDemandGrade = productDemandGrade;
    }

    public String getProductDemandGradeStr() {
        return productDemandGradeStr;
    }

    public void setProductDemandGradeStr(String productDemandGradeStr) {
        this.productDemandGradeStr = productDemandGradeStr;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getShelfStu() {
        return shelfStu;
    }

    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }

    public String getShelfStuStr() {
        return shelfStuStr;
    }

    public void setShelfStuStr(String shelfStuStr) {
        this.shelfStuStr = shelfStuStr;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public String getQualityGradeTypeStr() {
        return qualityGradeTypeStr;
    }

    public void setQualityGradeTypeStr(String qualityGradeTypeStr) {
        this.qualityGradeTypeStr = qualityGradeTypeStr;
    }
}
