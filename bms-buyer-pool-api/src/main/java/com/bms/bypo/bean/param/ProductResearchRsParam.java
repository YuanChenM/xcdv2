package com.bms.bypo.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by zhang_jian4 on 2017/01/05.
 */

@ApiModel(value = "ProductResearchRsParam", description = "买家产品销售调研产品信息")
//public class ProductResearchRsParam extends BaseRestParam {
public class ProductResearchRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "调研ID")
    private Long researchId;
    @ApiModelProperty(value = "调研产品ID")
    private Long researchProductId;
    @ApiModelProperty(value = "产品需求等级")
    private String demandLevel;
    @ApiModelProperty(value = "品种编码")
    private String breedCode;
    @ApiModelProperty(value = "品种标准市场销售名")
    private String breedSalesName;
    @ApiModelProperty(value = "品种学名")
    private String breedScientificName;
    @ApiModelProperty(value = "品种俗名")
    private String breedLocalName;
    @ApiModelProperty(value = "单品特征编码")
    private String featureCode;
    @ApiModelProperty(value = "单品特征名称")
    private String featureName;
    @ApiModelProperty(value = "品牌编码")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品牌所有人编码")
    private String brandOwnerCode;
    @ApiModelProperty(value = "品牌所有人名称")
    private String ownerName;
    @ApiModelProperty(value = "生产商编码")
    private String producerCode;
    @ApiModelProperty(value = "生产商名称")
    private String producerName;
    @ApiModelProperty(value = "小包装特征")
    private String packageSpecification;
    @ApiModelProperty(value = "小包装件数/大包装个数")
    private Integer packageQuantity;
    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;
    @ApiModelProperty(value = "毛重")
    private BigDecimal grossWeight;
    @ApiModelProperty(value = "纸箱尺寸")
    private String cartonDimension;
    @ApiModelProperty(value = "产品等级")
    private String productLevel;
    @ApiModelProperty(value = "托盘堆码数")
    private Integer pallerNo;
    @ApiModelProperty(value = "是否标准产品")
    private boolean isStandardFlg;
    @ApiModelProperty(value = "删除标志")
    private boolean delFlg;

    public Long getResearchId() {
        return researchId;
    }

    public void setResearchId(Long researchId) {
        this.researchId = researchId;
    }

    public Long getResearchProductId() {
        return researchProductId;
    }

    public void setResearchProductId(Long researchProductId) {
        this.researchProductId = researchProductId;
    }

    public String getDemandLevel() {
        return demandLevel;
    }

    public void setDemandLevel(String demandLevel) {
        this.demandLevel = demandLevel;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public String getBreedScientificName() {
        return breedScientificName;
    }

    public void setBreedScientificName(String breedScientificName) {
        this.breedScientificName = breedScientificName;
    }

    public String getBreedLocalName() {
        return breedLocalName;
    }

    public void setBreedLocalName(String breedLocalName) {
        this.breedLocalName = breedLocalName;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
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

    public String getBrandOwnerCode() {
        return brandOwnerCode;
    }

    public void setBrandOwnerCode(String brandOwnerCode) {
        this.brandOwnerCode = brandOwnerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
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

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getCartonDimension() {
        return cartonDimension;
    }

    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }

    public String getProductLevel() {
        return productLevel;
    }

    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    public Integer getPallerNo() {
        return pallerNo;
    }

    public void setPallerNo(Integer pallerNo) {
        this.pallerNo = pallerNo;
    }

    public boolean isStandardFlg() {
        return isStandardFlg;
    }

    public void setStandardFlg(boolean isStandardFlg) {
        this.isStandardFlg = isStandardFlg;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
