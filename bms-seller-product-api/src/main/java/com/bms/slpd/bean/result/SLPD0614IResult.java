package com.bms.slpd.bean.result;


import com.bms.slpd.bean.result.field.SLPD0614IDifGnqStdResult;
import com.bms.slpd.bean.result.field.SLPD0614IGnqStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0614IResult",
        description = "查询通用质量标准卡接口出参")
public class SLPD0614IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "查询通用质量标准卡集合")
    private Map<Object, LinkedHashMap<Object,List<SLPD0614IGnqStdResult>>> slpdStds;
    @ApiModelProperty(value = "查询通用质量差异卡集合")
    private Map<Object, Map<Object,List<SLPD0614IDifGnqStdResult>>> slpdDifStds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;


    public Map<Object, LinkedHashMap<Object, List<SLPD0614IGnqStdResult>>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Object, LinkedHashMap<Object, List<SLPD0614IGnqStdResult>>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, Map<Object, List<SLPD0614IDifGnqStdResult>>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, Map<Object, List<SLPD0614IDifGnqStdResult>>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
