package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0617IDifSftStdResult;
import com.bms.slpd.bean.result.field.SLPD0617ISftStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0617IResult",
        description = "查询安全标准指标接口出参")
public class SLPD0617IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "安全标准指标档案卡集合")
    private Map<Long, LinkedHashMap<String,List<SLPD0617ISftStdResult>>> slpdStds;
    @ApiModelProperty(value = "安全标准指标差异卡集合")
    private Map<Object, Map<Object,List<SLPD0617IDifSftStdResult>>> slpdDifStds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;


    public Map<Long, LinkedHashMap<String, List<SLPD0617ISftStdResult>>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Long, LinkedHashMap<String, List<SLPD0617ISftStdResult>>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, Map<Object, List<SLPD0617IDifSftStdResult>>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, Map<Object, List<SLPD0617IDifSftStdResult>>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
