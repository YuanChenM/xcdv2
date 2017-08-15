package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0238IParam",
        description = "查询生产商检测设备接口入参")
public class SLIM0238IParam extends BaseRestPaginationParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商检测设备Id集合")
    private List<Long> testEqpIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    @ApiModelProperty(value = "设备名称")
    private String testEqpName;
    @ApiModelProperty(value = "设备主要用途")
    private String testEqpUse;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getTestEqpIds() {
        return testEqpIds;
    }

    public void setTestEqpIds(List<Long> testEqpIds) {
        this.testEqpIds = testEqpIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    public String getTestEqpName() {
        return testEqpName;
    }

    public void setTestEqpName(String testEqpName) {
        this.testEqpName = testEqpName;
    }

    public String getTestEqpUse() {
        return testEqpUse;
    }

    public void setTestEqpUse(String testEqpUse) {
        this.testEqpUse = testEqpUse;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
