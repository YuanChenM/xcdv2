package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1807IParam", description = "批量新增制造商单品品牌规格生产商API的入参")
public class SLPD1807IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增制造商单品品牌规格生产商集合")
    private List<SLPD1807IManufacturerParam> manufacturerParams;

    public List<SLPD1807IManufacturerParam> getManufacturerParams() {

        return manufacturerParams;
    }

    public void setManufacturerParams(List<SLPD1807IManufacturerParam> manufacturerParams) {
        this.manufacturerParams = manufacturerParams;
    }
}
