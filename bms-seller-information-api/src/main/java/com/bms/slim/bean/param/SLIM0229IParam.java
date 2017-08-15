package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0229IParam",
        description = "查询生产商车间接口入参")
public class SLIM0229IParam extends BaseRestPaginationParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商车间ID集合")
    private List<Long> workshopIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    @ApiModelProperty(value = "车间名")
    private String workshopName;
    @ApiModelProperty(value = "生产产品")
    private String productionProduct;
    @ApiModelProperty(value = "工艺流程特点")
    private String proccessFlowCharacter;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getWorkshopIds() {
        return workshopIds;
    }

    public void setWorkshopIds(List<Long> workshopIds) {
        this.workshopIds = workshopIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
