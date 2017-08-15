package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0703IProducerProductParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0703IParam",
        description = "修改单品品牌(规格)生产商接口入参")
public class SLPD0703IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "单品品牌(规格)生产商集合")
    private List<SLPD0703IProducerProductParam> producerProductParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLPD0703IProducerProductParam> getProducerProductParams() {
        return producerProductParams;
    }

    public void setProducerProductParams(List<SLPD0703IProducerProductParam> producerProductParams) {
        this.producerProductParams = producerProductParams;
    }
}
