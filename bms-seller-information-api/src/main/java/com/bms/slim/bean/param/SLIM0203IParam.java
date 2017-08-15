package com.bms.slim.bean.param;

import com.bms.slim.bean.param.wrapper.SlimSellerProducerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0203IParam",description = "修改卖家生产商接口入参")
public class SLIM0203IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "修改字段标识集合")
    private String[] targets;
    @ApiModelProperty(value = "卖家生产商集合")
    private List<SlimSellerProducerParam> beans;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SlimSellerProducerParam> getBeans() {
        return beans;
    }

    public void setBeans(List<SlimSellerProducerParam> beans) {
        this.beans = beans;
    }

}
