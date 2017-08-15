package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "SLIM0214IParam", description = "批量查询生产商生产资质-进沪(京、津)登记信息接口入参")
public class SLIM0214IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-进沪(京、津)登记信息Id集合")
    private List<Long> sbtRegIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    /*@ApiModelProperty(value = "单位名称")
    private String workunitName;
    @ApiModelProperty(value = "产品品类名称")
    private String productCategoryName;
    @ApiModelProperty(value = "登记日期")
    private Date regDate;
    @ApiModelProperty(value = "进沪(京、津)登记URL")
    private String sbtRegUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getSbtRegIds() {
        return sbtRegIds;
    }

    public void setSbtRegIds(List<Long> sbtRegIds) {
        this.sbtRegIds = sbtRegIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    /*public String getWorkunitName() {
        return workunitName;
    }

    public void setWorkunitName(String workunitName) {
        this.workunitName = workunitName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getSbtRegUrl() {
        return sbtRegUrl;
    }

    public void setSbtRegUrl(String sbtRegUrl) {
        this.sbtRegUrl = sbtRegUrl;
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
