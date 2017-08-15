package com.bms.slpd.bean.result.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "SLPD1901INetWeightResult", description = "净重")
public class SLPD1901INetWeightResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品ID")
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
    @ApiModelProperty(value = "单品审核状态")
    private Boolean auditStu;

    @ApiModelProperty(value = "净重编码")
    private BigDecimal netWeightCode;
    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "创建Id")
    private String crtId;
    @ApiModelProperty(value = "创建时间")
    private Date crtTime;
    @ApiModelProperty(value = "更新Id")
    private String updId;
    @ApiModelProperty(value = "更新时间")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "品种ID")
    private Long breedId;
    @ApiModelProperty(value = "品种编码")
    private String breedCode;
    @ApiModelProperty(value = "品种SKU")
    private String breedSku;
    @ApiModelProperty(value = "品种标准市场销售名")
    private String breedSalesName;
    @ApiModelProperty(value = "品种学名")
    private String breedScientificName;
    @ApiModelProperty(value = "品种俗名")
    private String breedLocalName;

    @ApiModelProperty(value = "二级分类ID")
    private Long machiningId;
    @ApiModelProperty(value = "二级分类编码")
    private String machiningCode;
    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;

    @ApiModelProperty(value = "一级分类ID")
    private Long classesId;
    @ApiModelProperty(value = "一级分类编码")
    private String classesCode;
    @ApiModelProperty(value = "一级分类名称")
    private String classesName;

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

    public Boolean getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
    }

    public BigDecimal getNetWeightCode() {
        return netWeightCode;
    }

    public void setNetWeightCode(BigDecimal netWeightCode) {
        this.netWeightCode = netWeightCode;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

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
