package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0501IItemResult", description = "单品")
public class SLPD0501IItemResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品Id")
    private Long itemId;
    @ApiModelProperty(value = "单品编码")
    private String itemCode;
    @ApiModelProperty(value = "单品SKU")
    private String itemSku;
    @ApiModelProperty(value = "单品名称")
    private String itemName;
    @ApiModelProperty(value = "规格")
    private String specification;
    @ApiModelProperty(value = "加工方式")
    private String processingMethod;
    @ApiModelProperty(value = "口味")
    private String taste;

    @ApiModelProperty(value = "品种")
    private SLPD0501IBreedResult breed;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProcessingMethod() {
        return processingMethod;
    }

    public void setProcessingMethod(String processingMethod) {
        this.processingMethod = processingMethod;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public SLPD0501IBreedResult getBreed() {
        return breed;
    }

    public void setBreed(SLPD0501IBreedResult breed) {
        this.breed = breed;
    }
}
