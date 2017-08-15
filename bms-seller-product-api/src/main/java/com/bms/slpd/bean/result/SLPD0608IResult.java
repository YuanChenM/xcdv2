package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0608IDifMctStdResult;
import com.bms.slpd.bean.result.field.SLPD0608IMctStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0608IResult",description = "查询加工技术标准指标接口出参")
public class SLPD0608IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工技术标准指标档案卡集合")
    private Map<Long, List<SLPD0608IMctStdResult>> slpdStds;
    @ApiModelProperty(value = "加工技术标准指标差异卡集合")
    private Map<Object, List<SLPD0608IDifMctStdResult>> slpdDifStds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;


    public Map<Long, List<SLPD0608IMctStdResult>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Long, List<SLPD0608IMctStdResult>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, List<SLPD0608IDifMctStdResult>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, List<SLPD0608IDifMctStdResult>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
