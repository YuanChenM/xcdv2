package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0202IParam",
        description = "查询卖家生产商接口入参")
public class SLIM0202IParam extends BaseRestPaginationParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商Id集合")
    private List<Long> producerIds;
    @ApiModelProperty(value = "实体卖家Id集合")
    private List<Long> entitySellerIds;
    @ApiModelProperty(value = "卖家Id集合")
    private List<Long> sellerIds;
    @ApiModelProperty(value = "生产商编码")
    private String producerCode;
    @ApiModelProperty(value = "生产商名称")
    private String fullName;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getProducerIds() {
        return producerIds;
    }

    public void setProducerIds(List<Long> producerIds) {
        this.producerIds = producerIds;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    public List<Long> getSellerIds() {
        return sellerIds;
    }

    public void setSellerIds(List<Long> sellerIds) {
        this.sellerIds = sellerIds;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
