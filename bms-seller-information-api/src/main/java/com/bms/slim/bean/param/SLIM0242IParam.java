package com.bms.slim.bean.param;

import com.bms.slim.bean.param.wrapper.SlimProducerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0242IParam",description = "修改平台生产商接口入参")
public class SLIM0242IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "修改字段标识集合")
    private String[] targets;
    @ApiModelProperty(value = "平台生产商集合")
    private List<SlimProducerParam> beans;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SlimProducerParam> getBeans() {
        return beans;
    }

    public void setBeans(List<SlimProducerParam> beans) {
        this.beans = beans;
    }

}
