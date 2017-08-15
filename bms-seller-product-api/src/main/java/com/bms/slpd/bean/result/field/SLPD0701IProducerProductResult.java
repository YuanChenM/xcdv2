package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "SLPD0701IProducerProductResult", description = "单品品牌(规格)生产商")
public class SLPD0701IProducerProductResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品品牌(规格)生产商ID")
    private Long producerProductId;
    @ApiModelProperty(value = "单品品牌(规格)生产商SKU")
    private String producerProductSku;
    @ApiModelProperty(value = "审核状态，0：待审核，1：审核中，2：准入，3：禁止准入，4 ：黑名单")
    private String auditStu;
    @ApiModelProperty(value = "审核状态")
    private String auditStuStr;
    @ApiModelProperty(value = "审核备注")
    private String auditRemark;
    @ApiModelProperty(value = "审核履历，格式：0,未注册,admin,2017-01-25;")
    private String auditHistory;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

    @ApiModelProperty(value = "生产商ID")
    private Long producerId;
    @ApiModelProperty(value = "生产商编码")
    private String producerCode;
    @ApiModelProperty(value = "生产商名称")
    private String producerName;

    @ApiModelProperty(value = "产品")
    private SLPD0501IProductResult product;

    public Long getProducerProductId() {
        return producerProductId;
    }

    public void setProducerProductId(Long producerProductId) {
        this.producerProductId = producerProductId;
    }

    public String getProducerProductSku() {
        return producerProductSku;
    }

    public void setProducerProductSku(String producerProductSku) {
        this.producerProductSku = producerProductSku;
    }

    public String getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }

    public String getAuditStuStr() {
        return auditStuStr;
    }

    public void setAuditStuStr(String auditStuStr) {
        this.auditStuStr = auditStuStr;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public String getAuditHistory() {
        return auditHistory;
    }

    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
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

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public SLPD0501IProductResult getProduct() {
        return product;
    }

    public void setProduct(SLPD0501IProductResult product) {
        this.product = product;
    }
}
