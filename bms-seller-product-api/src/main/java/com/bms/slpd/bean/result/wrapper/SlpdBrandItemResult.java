package com.bms.slpd.bean.result.wrapper;

import com.bms.slpd.bean.entity.SlpdBrandOwner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SlpdBrandItemResult",
        description = "单品品牌信息")
public class SlpdBrandItemResult implements Serializable {

    private static final long serialVersionUID = -7076263256043121833L;


    @ApiModelProperty(value = "品种名")
    private String breedSalesName;
    @ApiModelProperty(value = "单品名")
    private String itemName;
    @ApiModelProperty(value = "品牌类型")
    private String brandType;
    @ApiModelProperty(value = "品牌所有人信息列表")
    List<SlpdBrandOwner> slpdBrandOwnerList;



    @ApiModelProperty(value = "单品品牌ID")
    private Long brandItemId;
    @ApiModelProperty(value = "单品品牌SKU")
    private String brandItemSku;
    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "单品SKU")
    private String itemSku;
    @ApiModelProperty(value = "单品审核状态")
    private Boolean itemAuditStu;
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "品牌Code")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品牌审核状态")
    private Boolean brandAuditStu;
    @ApiModelProperty(value = "单品品牌审核状态")
    private Boolean itemBrandAuditStu;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getBrandItemId() {
        return brandItemId;
    }

    public void setBrandItemId(Long brandItemId) {
        this.brandItemId = brandItemId;
    }

    public String getBrandItemSku() {
        return brandItemSku;
    }

    public void setBrandItemSku(String brandItemSku) {
        this.brandItemSku = brandItemSku;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
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

    public Boolean getItemAuditStu() {
        return itemAuditStu;
    }

    public void setItemAuditStu(Boolean itemAuditStu) {
        this.itemAuditStu = itemAuditStu;
    }

    public Boolean getBrandAuditStu() {
        return brandAuditStu;
    }

    public void setBrandAuditStu(Boolean brandAuditStu) {
        this.brandAuditStu = brandAuditStu;
    }

    public Boolean getItemBrandAuditStu() {
        return itemBrandAuditStu;
    }

    public void setItemBrandAuditStu(Boolean itemBrandAuditStu) {
        this.itemBrandAuditStu = itemBrandAuditStu;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public List<SlpdBrandOwner> getSlpdBrandOwnerList() {
        return slpdBrandOwnerList;
    }

    public void setSlpdBrandOwnerList(List<SlpdBrandOwner> slpdBrandOwnerList) {
        this.slpdBrandOwnerList = slpdBrandOwnerList;
    }
}
