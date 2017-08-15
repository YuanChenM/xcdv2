package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0621IDifTspStdResult;
import com.bms.slpd.bean.result.field.SLPD0621ITspStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0621IResult",
        description = "查询储存运输标准指标接口出参")
public class SLPD0621IResult implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "储存运输指标档案卡集合")
    private Map<Long, LinkedHashMap<String,List<SLPD0621ITspStdResult>>> slpdStds;
    @ApiModelProperty(value = "储存运输指标差异卡集合")
    private Map<Object, Map<Object,List<SLPD0621IDifTspStdResult>>> slpdDifStds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;


    public Map<Long, LinkedHashMap<String, List<SLPD0621ITspStdResult>>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Long, LinkedHashMap<String, List<SLPD0621ITspStdResult>>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, Map<Object, List<SLPD0621IDifTspStdResult>>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, Map<Object, List<SLPD0621IDifTspStdResult>>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
