package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD1808IManufacturerParam", description = "删除制造商单品品牌规格生产商")
public class SLPD1808IManufacturerParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "制造商产品ID")
    private Long manufacturerProductId;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getManufacturerProductId() {
        return manufacturerProductId;
    }

    public void setManufacturerProductId(Long manufacturerProductId) {
        this.manufacturerProductId = manufacturerProductId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
