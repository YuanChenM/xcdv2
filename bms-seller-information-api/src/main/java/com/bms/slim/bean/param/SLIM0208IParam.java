package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0208IParam", description = "批量查询生产商生产资质-定点屠宰许可证接口入参")
public class SLIM0208IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-定点屠宰许可证Id集合")
    private List<Long> dspIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    /*@ApiModelProperty(value = "批准号")
    private String approvalNo;
    @ApiModelProperty(value = "定点屠宰代码")
    private String dsgtSlgtPrmtCode;
    @ApiModelProperty(value = "定点屠宰许可证URL")
    private String dsgtSlgtPrmtUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getDspIds() {
        return dspIds;
    }

    public void setDspIds(List<Long> dspIds) {
        this.dspIds = dspIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    /*public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    public String getDsgtSlgtPrmtCode() {
        return dsgtSlgtPrmtCode;
    }

    public void setDsgtSlgtPrmtCode(String dsgtSlgtPrmtCode) {
        this.dsgtSlgtPrmtCode = dsgtSlgtPrmtCode;
    }

    public String getDsgtSlgtPrmtUrl() {
        return dsgtSlgtPrmtUrl;
    }

    public void setDsgtSlgtPrmtUrl(String dsgtSlgtPrmtUrl) {
        this.dsgtSlgtPrmtUrl = dsgtSlgtPrmtUrl;
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
