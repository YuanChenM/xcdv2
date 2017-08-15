package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0230ProducerWorkShopParam implements Serializable {
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
    @ApiModelProperty(value = "版本")
    private Integer version;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
