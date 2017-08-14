package com.bms.como.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by zhang_jian4 on 2017/3/30.
 */
@ApiModel(value = "SaleListRsParam", description = "批量查询销售商品数据接口入参")
public class SaleListRsParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID集合")
    private List<Long> commodityId;
    @ApiModelProperty(value = "销售状态ID集合")
    private List<Long> saleStatusId;
    @ApiModelProperty(value = "是否开发给买手")
    private Boolean isOpenToAgent;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "商品编码")
    private String commodityCode;
    @ApiModelProperty(value = "一级分类ID集合")
    private List<Long> classesId;
    @ApiModelProperty(value = "二级分类ID集合")
    private List<Long> machiningId;
    @ApiModelProperty(value = "品种ID集合")
    private List<Long> breedId;
    @ApiModelProperty(value = "品种名称")
    private String breedName;
    @ApiModelProperty(value = "品牌ID集合")
    private List<Long> brandId;
    @ApiModelProperty(value = "单品Id集合")
    private List<Long> itemId;
    @ApiModelProperty(value = "单品名称")
    private List<Long> productPid;
    @ApiModelProperty(value = "产品主键ID")
    private List<String> productId;
    @ApiModelProperty(value = "产品ID")
    private String itemName;
//    @ApiModelProperty(value = "质量等级编码")
//    private String qualityGradeTypeCode;
    @ApiModelProperty(value = "质量等级")
    private String qualityGradeType;
    @ApiModelProperty(value = "物流区ID集合")
    private List<Long> lgcsAreaId;
    @ApiModelProperty(value = "销售有效期开始")
    private String onShelfStart;
    @ApiModelProperty(value = "销售有效期截止")
    private String onShelfEnd;
    /** 数据库不存在该字段 **/
    @ApiModelProperty(value = "上架状态")
    private String shelfStu;
    /** **/
    @ApiModelProperty(value = "是否为默认商品")
    private Boolean isDefault;
    @ApiModelProperty(value = "货权人类型")
    private String ownerTypeId;
    @ApiModelProperty(value = "货权人ID（卖家ID或买手ID等）集合")
    private List<Long> ownerId;
    @ApiModelProperty(value = "生产商ID集合")
    private List<Long> producerId;
    @ApiModelProperty(value = "库存状态")
    private String inventoryStu;

    @ApiModelProperty(value = "当前时间，只做查询使用，防止服务器时间与本地时间不同步")
    private Date currentDateTime;
    @ApiModelProperty(value = "制造商产品SKU")
    private String manufacturerProductSku;

    public Date getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public Boolean getIsOpenToAgent() {
        return isOpenToAgent;
    }

    public void setIsOpenToAgent(Boolean isOpenToAgent) {
        this.isOpenToAgent = isOpenToAgent;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<Long> getProductPid() {
        return productPid;
    }

    public void setProductPid(List<Long> productPid) {
        this.productPid = productPid;
    }

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(List<String> productId) {
        this.productId = productId;
    }

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

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
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

//    public String getQualityGradeTypeCode() {
//        return qualityGradeTypeCode;
//    }
//
//    public void setQualityGradeTypeCode(String qualityGradeTypeCode) {
//        this.qualityGradeTypeCode = qualityGradeTypeCode;
//    }

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

    public String getShelfStu() {
        return shelfStu;
    }

    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }

    public String getOwnerTypeId() {
        return ownerTypeId;
    }

    public void setOwnerTypeId(String ownerTypeId) {
        this.ownerTypeId = ownerTypeId;
    }

    public List<Long> getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(List<Long> ownerId) {
        this.ownerId = ownerId;
    }

    public List<Long> getProducerId() {
        return producerId;
    }

    public void setProducerId(List<Long> producerId) {
        this.producerId = producerId;
    }

    public String getInventoryStu() {
        return inventoryStu;
    }

    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }

    public String getManufacturerProductSku() {
        return manufacturerProductSku;
    }

    public void setManufacturerProductSku(String manufacturerProductSku) {
        this.manufacturerProductSku = manufacturerProductSku;
    }
}
