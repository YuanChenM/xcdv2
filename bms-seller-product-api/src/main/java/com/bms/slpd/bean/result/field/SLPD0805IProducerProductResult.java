package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0805IProducerProductResult", description = "产品生产商")
public class SLPD0805IProducerProductResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品品牌(规格)生产商ID")
    private Long producerProductId;
    @ApiModelProperty(value = "单品品牌(规格)生产商SKU")
    private String producerProductSku;

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

    @ApiModelProperty(value = "卖家集合")
    private List<SLPD0805ISellerResult> sellerList;

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

    public List<SLPD0805ISellerResult> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<SLPD0805ISellerResult> sellerList) {
        this.sellerList = sellerList;
    }
}
