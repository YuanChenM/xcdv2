package com.bms.slpd.bean.result;

import com.bms.slpd.bean.result.field.SLPD0624IDifPkgStdResult;
import com.bms.slpd.bean.result.field.SLPD0624IPkgStdResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel(value = "SLPD0621IResult",description = "查询包装标准指标接口出参")
public class SLPD0624IResult implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "包装指标档案卡集合")
    private Map<Long,List<SLPD0624IPkgStdResult>> slpdStds ;
    @ApiModelProperty(value = "包装指标差异卡集合")
    private Map<Object,List<SLPD0624IDifPkgStdResult>> slpdDifStds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public Map<Long, List<SLPD0624IPkgStdResult>> getSlpdStds() {
        return slpdStds;
    }

    public void setSlpdStds(Map<Long, List<SLPD0624IPkgStdResult>> slpdStds) {
        this.slpdStds = slpdStds;
    }

    public Map<Object, List<SLPD0624IDifPkgStdResult>> getSlpdDifStds() {
        return slpdDifStds;
    }

    public void setSlpdDifStds(Map<Object, List<SLPD0624IDifPkgStdResult>> slpdDifStds) {
        this.slpdDifStds = slpdDifStds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
