package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0116ISellerContractPermissionParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0116IParam", description = "卖家合同信息")
public class SLIM0116IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增卖家合同信息集合")
    private List<SLIM0116ISellerContractPermissionParam> sellerContractPermissionParams;

    public List<SLIM0116ISellerContractPermissionParam> getSellerContractPermissionParams() {
        return sellerContractPermissionParams;
    }

    public void setSellerContractPermissionParams(List<SLIM0116ISellerContractPermissionParam> sellerContractPermissionParams) {
        this.sellerContractPermissionParams = sellerContractPermissionParams;
    }
}
