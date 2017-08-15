package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD1815IParam", description = "查询单品规格API的入参")
public class SLPD1815IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "单品规格ID集合")
    private List<Long> itemPropertyIds;
    @ApiModelProperty(value = "单品规格编码集合")
    private List<String> itemPropertyCodes;
    @ApiModelProperty(value = "审核状态集合")
    private List<String> auditStus;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    @ApiModelProperty(value = "产品ID")
    private List<String> productIds;

    @ApiModelProperty(value = "单品ID集合")
    private List<Long> itemIds;
    @ApiModelProperty(value = "单品编码集合")
    private List<String> itemCodes;
    @ApiModelProperty(value = "单品SKU集合")
    private List<String> itemSkus;
    @ApiModelProperty(value = "单品名称")
    private String itemName;

    @ApiModelProperty(value = "品种ID集合")
    private List<Long> breedIds;

    @ApiModelProperty(value = "二级分类ID集合")
    private List<Long> machiningIds;

    @ApiModelProperty(value = "一级分类ID集合")
    private List<Long> classesIds;

    public List<Long> getItemPropertyIds() {
        return itemPropertyIds;
    }

    public void setItemPropertyIds(List<Long> itemPropertyIds) {
        this.itemPropertyIds = itemPropertyIds;
    }

    public List<String> getItemPropertyCodes() {
        return itemPropertyCodes;
    }

    public void setItemPropertyCodes(List<String> itemPropertyCodes) {
        this.itemPropertyCodes = itemPropertyCodes;
    }

    public List<String> getAuditStus() {
        return auditStus;
    }

    public void setAuditStus(List<String> auditStus) {
        this.auditStus = auditStus;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public List<String> getItemCodes() {
        return itemCodes;
    }

    public void setItemCodes(List<String> itemCodes) {
        this.itemCodes = itemCodes;
    }

    public List<String> getItemSkus() {
        return itemSkus;
    }

    public void setItemSkus(List<String> itemSkus) {
        this.itemSkus = itemSkus;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Long> getBreedIds() {
        return breedIds;
    }

    public void setBreedIds(List<Long> breedIds) {
        this.breedIds = breedIds;
    }

    public List<Long> getMachiningIds() {
        return machiningIds;
    }

    public void setMachiningIds(List<Long> machiningIds) {
        this.machiningIds = machiningIds;
    }

    public List<Long> getClassesIds() {
        return classesIds;
    }

    public void setClassesIds(List<Long> classesIds) {
        this.classesIds = classesIds;
    }
}
