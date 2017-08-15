package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0205IParam", description = "批量查询生产商生产资质-动物防疫条件合格证接口入参")
public class SLIM0205IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商生产资质-动物防疫条件合格证Id集合")
    private List<Long> aepccIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    /*@ApiModelProperty(value = "证号")
    private String certNo;
    @ApiModelProperty(value = "有效期")
    private String validPeriod;
    @ApiModelProperty(value = "动物防疫条件合格证URL")
    private String aniEpiPrevContCertUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getAepccIds() {
        return aepccIds;
    }

    public void setAepccIds(List<Long> aepccIds) {
        this.aepccIds = aepccIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    /*public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getAniEpiPrevContCertUrl() {
        return aniEpiPrevContCertUrl;
    }

    public void setAniEpiPrevContCertUrl(String aniEpiPrevContCertUrl) {
        this.aniEpiPrevContCertUrl = aniEpiPrevContCertUrl;
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
