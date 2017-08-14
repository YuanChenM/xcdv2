package com.bms.como.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class ProductInfoRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "产品主键ID")
    private List<Long> productPids;
    @ApiModelProperty(value = "产品ID")
    private List<String> productIds;
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


    public List<Long> getProductPids() {
        return productPids;
    }

    public void setProductPids(List<Long> productPids) {
        this.productPids = productPids;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
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
}
