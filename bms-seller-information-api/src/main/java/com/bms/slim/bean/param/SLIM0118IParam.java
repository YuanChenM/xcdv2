package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0118ISellerContractPermissionParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0118IParam", description = "卖家合同信息")
public class SLIM0118IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "targets")
    private String[] targets;

    @ApiModelProperty(value = "修改卖家合同信息集合")
    private List<SLIM0118ISellerContractPermissionParam> sellerContractPermissionParams;

    public List<SLIM0118ISellerContractPermissionParam> getSellerContractPermissionParams() {
        return sellerContractPermissionParams;
    }

    public void setSellerContractPermissionParams(List<SLIM0118ISellerContractPermissionParam> sellerContractPermissionParams) {
        this.sellerContractPermissionParams = sellerContractPermissionParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
