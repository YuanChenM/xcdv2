package com.bms.slim.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0229ProducerWorkShopResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商车间ID")
    private Long workshopId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "车间名")
    private String workshopName;
    @ApiModelProperty(value = "生产产品")
    private String productionProduct;
    @ApiModelProperty(value = "工艺流程特点")
    private String proccessFlowCharacter;
    @ApiModelProperty(value = "车间照")
    private String workshopPicUrl;
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
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

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getProductionProduct() {
        return productionProduct;
    }

    public void setProductionProduct(String productionProduct) {
        this.productionProduct = productionProduct;
    }

    public String getProccessFlowCharacter() {
        return proccessFlowCharacter;
    }

    public void setProccessFlowCharacter(String proccessFlowCharacter) {
        this.proccessFlowCharacter = proccessFlowCharacter;
    }

    public String getWorkshopPicUrl() {
        return workshopPicUrl;
    }

    public void setWorkshopPicUrl(String workshopPicUrl) {
        this.workshopPicUrl = workshopPicUrl;
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
}
