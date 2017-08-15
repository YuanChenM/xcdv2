package com.bms.slpd.bean.param.wrapper;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by li_kai1 on 2017/2/3.
 */
public class SLPD0302IItemParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "一级分类ID")
    private Long classesId;
    @ApiModelProperty(value = "二级分类ID")
    private Long machiningId;
    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "单品特征名称")
    private String itemName;
    @ApiModelProperty(value = "规格")
    private String specification;
    @ApiModelProperty(value = "加工方式")
    private String processingMethod;
    @ApiModelProperty(value = "口味")
    private String taste;

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public Long getMachiningId() {
        return machiningId;
    }

    public void setMachiningId(Long machiningId) {
        this.machiningId = machiningId;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
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

}
