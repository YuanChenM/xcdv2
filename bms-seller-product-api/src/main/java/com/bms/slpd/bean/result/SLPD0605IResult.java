package com.bms.slpd.bean.result;


import com.bms.slpd.bean.result.field.SLPD0605IDifFedStdResult;
import com.bms.slpd.bean.result.field.SLPD0605IFedStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0605IResult",description = "查询饲养指标标准接口出参")
public class SLPD0605IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "查询饲养指标标准卡集合")
    private Map<Long,List<SLPD0605IFedStdResult>> slpdStds;
    @ApiModelProperty(value = "查询饲养指标差异卡集合")
    private Map<Object,List<SLPD0605IDifFedStdResult>> slpdDifStds;

    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public Map<Long, List<SLPD0605IFedStdResult>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Long, List<SLPD0605IFedStdResult>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, List<SLPD0605IDifFedStdResult>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, List<SLPD0605IDifFedStdResult>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
