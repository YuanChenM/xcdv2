package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0611IDifTncStdResult;
import com.bms.slpd.bean.result.field.SLPD0611ITncStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0611IResult",description = "查询加工质量标准接口出参")
public class SLPD0611IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加工质量标准指标档案卡集合")
    private Map<Long, List<SLPD0611ITncStdResult>> slpdStds;
    @ApiModelProperty(value = "加工质量标准指标差异卡集合")
    private Map<Object, List<SLPD0611IDifTncStdResult>> slpdDifStds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public Map<Long, List<SLPD0611ITncStdResult>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Long, List<SLPD0611ITncStdResult>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, List<SLPD0611IDifTncStdResult>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, List<SLPD0611IDifTncStdResult>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
