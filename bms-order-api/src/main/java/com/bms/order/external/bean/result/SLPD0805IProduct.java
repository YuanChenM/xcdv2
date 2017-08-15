package com.bms.order.external.bean.result;

import java.io.Serializable;
import java.util.List;

/**
 * 产品信息 Created by Administrator on 2017/2/23.
 */
public class SLPD0805IProduct implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1347962710424498932L;
    // 产品ID
    private String productId;
    // 质量等级，1：A1，2：A2，3：A3
    private String qualityGradeType;
    private String qualityGradeTypeStr;
    // 单品品牌规格
    private SLPD0805IBrandItemProperty brandItemProperty;
    // 产品生产商集合
    private List<SLPD0805IProducerProduct> producerProduct;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public String getQualityGradeTypeStr() {
        return qualityGradeTypeStr;
    }

    public void setQualityGradeTypeStr(String qualityGradeTypeStr) {
        this.qualityGradeTypeStr = qualityGradeTypeStr;
    }

    public SLPD0805IBrandItemProperty getBrandItemProperty() {
        return brandItemProperty;
    }

    public void setBrandItemProperty(SLPD0805IBrandItemProperty brandItemProperty) {
        this.brandItemProperty = brandItemProperty;
    }

    public List<SLPD0805IProducerProduct> getProducerProduct() {
        return producerProduct;
    }

    public void setProducerProduct(List<SLPD0805IProducerProduct> producerProduct) {
        this.producerProduct = producerProduct;
    }
}
