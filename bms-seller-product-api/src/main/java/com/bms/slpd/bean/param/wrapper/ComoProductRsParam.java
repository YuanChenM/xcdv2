package com.bms.slpd.bean.param.wrapper;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class ComoProductRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "产品主键ID")
    private Long productPid;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "商品ID")
    private List<Long> commodityIds;
    @ApiModelProperty(value = "销售状态ID")
    private List<Long> saleStatusIds;
    @ApiModelProperty(value = "商品有效状态")
    private Boolean isValid;
    @ApiModelProperty(value = "是否开放给买手")
    private Boolean isOpenToAgent;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "一级分类ID")
    private List<Long> classesIds;
    @ApiModelProperty(value = "二级分类ID")
    private List<Long> machiningIds;
    @ApiModelProperty(value = "品种ID")
    private List<Long> breedIds;
    @ApiModelProperty(value = "品种名称")
    private String breedName;
    @ApiModelProperty(value = "品牌ID")
    private List<Long> brandIds;
    @ApiModelProperty(value = "单品Id")
    private List<Long> itemIds;
    @ApiModelProperty(value = "单品名称")
    private String itemName;
    @ApiModelProperty(value = "质量等级")
    private String qualityGradeType;
    @ApiModelProperty(value = "编辑开始时间")
    private Date updTimeFrom;
    @ApiModelProperty(value = "编辑截止时间")
    private Date updTimeTo;

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

    public List<Long> getCommodityIds() {
        return commodityIds;
    }

    public void setCommodityIds(List<Long> commodityIds) {
        this.commodityIds = commodityIds;
    }

    public List<Long> getSaleStatusIds() {
        return saleStatusIds;
    }

    public void setSaleStatusIds(List<Long> saleStatusIds) {
        this.saleStatusIds = saleStatusIds;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getIsOpenToAgent() {
        return isOpenToAgent;
    }

    public void setIsOpenToAgent(Boolean openToAgent) {
        isOpenToAgent = openToAgent;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public List<Long> getClassesIds() {
        return classesIds;
    }

    public void setClassesIds(List<Long> classesIds) {
        this.classesIds = classesIds;
    }

    public List<Long> getMachiningIds() {
        return machiningIds;
    }

    public void setMachiningIds(List<Long> machiningIds) {
        this.machiningIds = machiningIds;
    }

    public List<Long> getBreedIds() {
        return breedIds;
    }

    public void setBreedIds(List<Long> breedIds) {
        this.breedIds = breedIds;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public Date getUpdTimeFrom() {
        return updTimeFrom;
    }

    public void setUpdTimeFrom(Date updTimeFrom) {
        this.updTimeFrom = updTimeFrom;
    }

    public Date getUpdTimeTo() {
        return updTimeTo;
    }

    public void setUpdTimeTo(Date updTimeTo) {
        this.updTimeTo = updTimeTo;
    }
}
