package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0117IParam", description = "卖家合同信息")
public class SLIM0117IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "卖家合同信息ID集合")
    private List<Long> scpIds;
    @ApiModelProperty(value = "卖家实体ID集合")
    private List<Long> entitySellerIds;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    public List<Long> getScpIds() {
        return scpIds;
    }

    public void setScpIds(List<Long> scpIds) {
        this.scpIds = scpIds;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
