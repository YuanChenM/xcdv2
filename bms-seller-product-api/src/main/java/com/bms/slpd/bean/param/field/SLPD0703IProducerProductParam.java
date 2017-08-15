package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0703IProducerProductParam", description = "修改单品品牌(规格)生产商接口入参")
public class SLPD0703IProducerProductParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "单品品牌(规格)生产商ID")
    private Long producerProductId;
    @ApiModelProperty(value = "生产商名称")
    private String producerName;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getProducerProductId() {
        return producerProductId;
    }

    public void setProducerProductId(Long producerProductId) {
        this.producerProductId = producerProductId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
