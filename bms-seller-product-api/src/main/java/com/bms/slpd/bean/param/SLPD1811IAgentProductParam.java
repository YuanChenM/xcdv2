package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD1811IAgentProductParam", description = "删除代理商单品品牌规格生产商")
public class SLPD1811IAgentProductParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "代理商产品ID")
    private Long asProductId;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getAsProductId() {
        return asProductId;
    }

    public void setAsProductId(Long asProductId) {
        this.asProductId = asProductId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
