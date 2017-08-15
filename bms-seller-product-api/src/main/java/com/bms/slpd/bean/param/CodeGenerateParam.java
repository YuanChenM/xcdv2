package com.bms.slpd.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by memorykai on 2017/3/20.
 */
public class CodeGenerateParam implements Serializable {
    private static final Long serialVersionUId = 1L;

    //一级分类Ids
    private List<Long> classesIds;

    //二级分类Ids
    private List<Long> machiningIds;

    //品种Ids
    private List<Long> breedIds;

    //单品Ids
    private List<Long> itemIds;

    //品牌Ids
    private List<Long> brandIds;

    //单品品牌Ids
    private List<Long> brandItemIds;

    //单品品牌规格Ids
    private List<Long> brandItemPropertyIds;

    //净重code所需param
    private List<NetWeightCodeParam> netWeightCodeParams;

    //单品品牌规格生产商Ids
    private List<Long> producerProductIds;

    //实体卖家Ids
    private List<Long> entitySellerIds;

    //制造商产品Ids
    private List<Long> manufacturerProductIds;

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

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    public List<Long> getBrandItemIds() {
        return brandItemIds;
    }

    public void setBrandItemIds(List<Long> brandItemIds) {
        this.brandItemIds = brandItemIds;
    }

    public List<Long> getBrandItemPropertyIds() {
        return brandItemPropertyIds;
    }

    public void setBrandItemPropertyIds(List<Long> brandItemPropertyIds) {
        this.brandItemPropertyIds = brandItemPropertyIds;
    }

    public List<NetWeightCodeParam> getNetWeightCodeParams() {
        return netWeightCodeParams;
    }

    public void setNetWeightCodeParams(List<NetWeightCodeParam> netWeightCodeParams) {
        this.netWeightCodeParams = netWeightCodeParams;
    }

    public List<Long> getProducerProductIds() {
        return producerProductIds;
    }

    public void setProducerProductIds(List<Long> producerProductIds) {
        this.producerProductIds = producerProductIds;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    public List<Long> getManufacturerProductIds() {
        return manufacturerProductIds;
    }

    public void setManufacturerProductIds(List<Long> manufacturerProductIds) {
        this.manufacturerProductIds = manufacturerProductIds;
    }
}
