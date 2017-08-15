package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0228ProducerWorkShopParam implements Serializable {
    private static final long serialVersionUID = 1L;

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
}
