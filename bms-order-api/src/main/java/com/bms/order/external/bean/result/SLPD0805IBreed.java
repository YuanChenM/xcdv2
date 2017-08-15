package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/23.
 */ // 品种
public class SLPD0805IBreed implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1841169168640886828L;
    // 品种ID
    private Long breedId;
    // 品种编码
    private String breedCode;
    // 品种SKU
    private String breedSku;
    // 品种标准市场销售名
    private String breedSalesName;
    // 品种学名
    private String breedScientificName;
    // 品种俗名
    private String breedLocalName;
    // 二级分类ID
    private Long machiningId;
    // 二级分类编码
    private String machiningCode;
    // 二级分类名称
    private String machiningName;
    // 一级分类ID
    private Long classesId;
    // 一级分类编码
    private String classesCode;
    // 一级分类名称
    private String classesName;

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedSku() {
        return breedSku;
    }

    public void setBreedSku(String breedSku) {
        this.breedSku = breedSku;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public String getBreedScientificName() {
        return breedScientificName;
    }

    public void setBreedScientificName(String breedScientificName) {
        this.breedScientificName = breedScientificName;
    }

    public String getBreedLocalName() {
        return breedLocalName;
    }

    public void setBreedLocalName(String breedLocalName) {
        this.breedLocalName = breedLocalName;
    }

    public Long getMachiningId() {
        return machiningId;
    }

    public void setMachiningId(Long machiningId) {
        this.machiningId = machiningId;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }
}
