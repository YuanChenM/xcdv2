package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0506IParam",
        description = "查询品牌单品关系接口入参")
public class SLPD0506IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "是否读缓存：true：读取缓存，false：SQL查询")
    private boolean localCache;
    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;

    @ApiModelProperty(value = "品牌单品Id集合")
    private List<Long> brandItemIds;
    @ApiModelProperty(value = "品牌单品Sku集合")
    private List<String> brandItemSkus;
    @ApiModelProperty(value = "品牌Id集合")
    private List<Long> brandIds;
    @ApiModelProperty(value = "品牌Code集合")
    private List<String> brandCodes;
    @ApiModelProperty(value = "单品Id集合")
    private List<Long> itemIds;
    @ApiModelProperty(value = "单品Sku集合")
    private List<String> itemSkus;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "一级分类ID")
    private String classesId;
    @ApiModelProperty(value = "二级分类ID")
    private String machiningId;
    @ApiModelProperty(value = "品种ID")
    private String breedId;
    @ApiModelProperty(value = "单品名")
    private String itemName;
    @ApiModelProperty(value = "品种名")
    private String breedSalesName;

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    public boolean isLocalCache() {
        return localCache;
    }

    public void setLocalCache(boolean localCache) {
        this.localCache = localCache;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public List<Long> getBrandItemIds() {
        return brandItemIds;
    }

    public void setBrandItemIds(List<Long> brandItemIds) {
        this.brandItemIds = brandItemIds;
    }

    public List<String> getBrandItemSkus() {
        return brandItemSkus;
    }

    public void setBrandItemSkus(List<String> brandItemSkus) {
        this.brandItemSkus = brandItemSkus;
    }

    public List<String> getBrandCodes() {
        return brandCodes;
    }

    public void setBrandCodes(List<String> brandCodes) {
        this.brandCodes = brandCodes;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public List<String> getItemSkus() {
        return itemSkus;
    }

    public void setItemSkus(List<String> itemSkus) {
        this.itemSkus = itemSkus;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }
}
