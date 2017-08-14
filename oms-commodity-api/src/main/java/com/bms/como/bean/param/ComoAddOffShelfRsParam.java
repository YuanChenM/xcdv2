package com.bms.como.bean.param;

//import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_jian4 on 2017/3/30.
 */
@ApiModel(value = "ComoAddOffShelfRsParam", description = "商品销售上下架管理接口入参")
public class ComoAddOffShelfRsParam implements Serializable {
    @ApiModelProperty(value = "商品ID")
    private List<Long> commodityId;
    @ApiModelProperty(value = "销售状态ID")
    private List<Long> saleStatusId;
    @ApiModelProperty(value = "库存状态")
    private String inventoryStu;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "一级分类ID")
    private List<Long> classesId;
    @ApiModelProperty(value = "二级分类ID")
    private List<Long> machiningId;
    @ApiModelProperty(value = "品种ID")
    private List<Long> breedId;
    @ApiModelProperty(value = "品种名称，模糊搜索")
    private String breedName;
    @ApiModelProperty(value = "品牌ID")
    private List<Long> brandId;
    @ApiModelProperty(value = "单品Id")
    private List<Long> itemId;
    @ApiModelProperty(value = "单品名称，模糊搜索")
    private String itemName;
    @ApiModelProperty(value = "质量等级")
    private String qualityGradeType;
    @ApiModelProperty(value = "物流区ID")
    private List<Long> lgcsAreaId;
    @ApiModelProperty(value = "上架有效期开始")
    private String onShelfStart;
    @ApiModelProperty(value = "上架有效期截止")
    private String onShelfEnd;
    @ApiModelProperty(value = "上下架处理类型，001-上架，002-下架")
    private String handleType;
    @ApiModelProperty(value = "处理备注")
    private String handleRemark;
    @ApiModelProperty(value = "销售上架日时")
    private String addShelfTime;
    @ApiModelProperty(value = "销售下架日时")
    private String offShelfTime;

    public List<Long> getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(List<Long> commodityId) {
        this.commodityId = commodityId;
    }

    public List<Long> getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(List<Long> saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public String getInventoryStu() {
        return inventoryStu;
    }

    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public List<Long> getClassesId() {
        return classesId;
    }

    public void setClassesId(List<Long> classesId) {
        this.classesId = classesId;
    }

    public List<Long> getMachiningId() {
        return machiningId;
    }

    public void setMachiningId(List<Long> machiningId) {
        this.machiningId = machiningId;
    }

    public List<Long> getBreedId() {
        return breedId;
    }

    public void setBreedId(List<Long> breedId) {
        this.breedId = breedId;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public List<Long> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<Long> brandId) {
        this.brandId = brandId;
    }

    public List<Long> getItemId() {
        return itemId;
    }

    public void setItemId(List<Long> itemId) {
        this.itemId = itemId;
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

    public List<Long> getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(List<Long> lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getOnShelfStart() {
        return onShelfStart;
    }

    public void setOnShelfStart(String onShelfStart) {
        this.onShelfStart = onShelfStart;
    }

    public String getOnShelfEnd() {
        return onShelfEnd;
    }

    public void setOnShelfEnd(String onShelfEnd) {
        this.onShelfEnd = onShelfEnd;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getHandleRemark() {
        return handleRemark;
    }

    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark;
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
}
