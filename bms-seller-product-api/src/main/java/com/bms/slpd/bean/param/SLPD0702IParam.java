package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.wrapper.SlpdProductProducerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0702IParam", description = "新增单品品牌(规格)生产商接口入参")
public class SLPD0702IParam implements Serializable {
    private static final long serialVersionUID = 5431703251202848672L;
    @ApiModelProperty(value = "单品品牌(规格)生产商集合")
    private List<SlpdProductProducerParam> productProducerList;

    public List<SlpdProductProducerParam> getProductProducerList() {
        return productProducerList;
    }

    public void setProductProducerList(List<SlpdProductProducerParam> productProducerList) {
        this.productProducerList = productProducerList;
    }
}
