package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD1202IParam", description = "批量查询物流区产品接口入参")
public class SLPD1202IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "物流区产品Id集合")
    private List<Long> lacIds;
    @ApiModelProperty(value = "物流区ID集合")
    private List<Long> lgcsAreaIds;
    @ApiModelProperty(value = "物流区编码集合")
    private List<String> lgcsAreaCodes;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "产品Id集合")
    private List<String> productIds;
    @ApiModelProperty(value = "产品需求等级集合")
    private List<String> productDemandGrades;
    @ApiModelProperty(value = "上下架状态，1：上架，2：下架")
    private String shelfStu;
    @ApiModelProperty(value = "单品品牌规格Sku")
    private String brandItemPropertySku;

    @ApiModelProperty(value = "一级分类Id集合")
    private List<Long> classesIds;
    @ApiModelProperty(value = "一级分类名称")
    private String classesName;

    @ApiModelProperty(value = "二级分类Id集合")
    private List<Long> machiningIds;
    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;

    @ApiModelProperty(value = "品种Id集合")
    private List<Long> breedIds;
    @ApiModelProperty(value = "品种名称")
    private String breedSalesName;

    @ApiModelProperty(value = "单品Id集合")
    private List<Long> itemIds;
    @ApiModelProperty(value = "单品名称")
    private String itemName;

    @ApiModelProperty(value = "品牌Id集合")
    private List<Long> brandIds;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    public List<Long> getLacIds() {
        return lacIds;
    }

    public void setLacIds(List<Long> lacIds) {
        this.lacIds = lacIds;
    }

    public List<String> getLgcsAreaCodes() {
        return lgcsAreaCodes;
    }

    public void setLgcsAreaCodes(List<String> lgcsAreaCodes) {
        this.lgcsAreaCodes = lgcsAreaCodes;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getShelfStu() {
        return shelfStu;
    }

    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }

    public List<Long> getClassesIds() {
        return classesIds;
    }

    public void setClassesIds(List<Long> classesIds) {
        this.classesIds = classesIds;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public List<Long> getMachiningIds() {
        return machiningIds;
    }

    public void setMachiningIds(List<Long> machiningIds) {
        this.machiningIds = machiningIds;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public List<Long> getBreedIds() {
        return breedIds;
    }

    public void setBreedIds(List<Long> breedIds) {
        this.breedIds = breedIds;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
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

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Long> getLgcsAreaIds() {
        return lgcsAreaIds;
    }

    public void setLgcsAreaIds(List<Long> lgcsAreaIds) {
        this.lgcsAreaIds = lgcsAreaIds;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public List<String> getProductDemandGrades() {
        return productDemandGrades;
    }

    public void setProductDemandGrades(List<String> productDemandGrades) {
        this.productDemandGrades = productDemandGrades;
    }

    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }
}
