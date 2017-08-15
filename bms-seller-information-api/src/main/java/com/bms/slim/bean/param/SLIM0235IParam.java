package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0235IParam",
        description = "查询生产商实验室接口入参")
public class SLIM0235IParam extends BaseRestPaginationParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商实验室Id集合")
    private List<Long> laboratoryIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getLaboratoryIds() {
        return laboratoryIds;
    }

    public void setLaboratoryIds(List<Long> laboratoryIds) {
        this.laboratoryIds = laboratoryIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
